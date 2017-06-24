package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;

import controller.ChamadoController;

public class RegistroChamado {
	
	private ChamadoController chamadoController = new ChamadoController();
	private List<String> chamadosNaoSalvos = new ArrayList<>();
	private Conecta conecta = new Conecta();
	
	public void salvaLocalmente(Chamado chamado){
		chamadoController.insert(chamado);
	}

	public void cadastraChamados(List<Chamado> chamados, Atendente atendente) throws IOException, InterruptedException{
		for (Chamado chamado : chamados) {
			this.cadastraChamado(chamado, atendente);
		}
	}
	
	public void cadastraChamado(Chamado chamado, Atendente atendente) throws IOException, InterruptedException {
		if(!chamado.getESoftplan()){
			try{
				conecta.conecta();
				conecta.login(atendente, chamado);
				Thread.sleep(1000);
				conecta.clickCadastrarOcorrencias();
				conecta.clicKnomeSolicitante(chamado);
				Thread.sleep(1000);
				conecta.clicLotacao();
				chamado.setSetor(conecta.getLotacaoSolicitante());
				conecta.clickContatoFeitoPor();
				conecta.clickTipoLocalChamado(chamado);
				Thread.sleep(1000);
				conecta.clickDescricaoSolicitante(chamado);
				conecta.clickTerminoCadastro();
				Thread.sleep(1000);
			}catch (NoSuchElementException | UnhandledAlertException e) {
				chamadosNaoSalvos.add(chamado.getNomeSolicitante());
			}			
		} else {
			try{
				Thread.sleep(1000);
				conecta.conecta();
				conecta.login(atendente, chamado);
				Thread.sleep(1000);
				conecta.clickCadastrarOcorrencias();
				conecta.clicKnomeSolicitante(chamado);
				Thread.sleep(1000);
				conecta.clicLotacao();
				chamado.setSetor(conecta.getLotacaoSolicitante());
				conecta.clickContatoFeitoPor();
				conecta.clickTipoLocalChamado(chamado);
				Thread.sleep(1000);
				conecta.clickDescricaoSolicitante(chamado);
				conecta.clickESof();// clica no checkbox salt do SOS
				
				conecta.clicDescricaoProblema(chamado); // carrega no campo do SOS o texto do mants
				conecta.clickTerminoCadastro();
				Thread.sleep(2000);
				//escreve no arquivo que foi aberto o chamado
			}catch (NoSuchElementException | UnhandledAlertException e) {
				JOptionPane.showMessageDialog(null, "Aconteceu algo, não foi possível abrir o Matins, por favor tente novamente");
			}
		}
	}
	
	public void notificaExito(){
		
	}	
}
