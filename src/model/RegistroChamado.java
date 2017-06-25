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
	public void conectaChamado ( Atendente atendente, boolean eSoft) throws IOException, InterruptedException{
		conecta.conecta();
		conecta.login(atendente, eSoft);
	}

	public void cadastraChamados(Atendente atendente) throws IOException, InterruptedException{
		conectaChamado(atendente, false);
		try {
			for (Chamado chamado : chamadoController.todosChamados()) {
				this.cadastraChamado(chamado, atendente);
				Thread.sleep(500);
				chamadoController.alteraEstado(chamado.getNomeSolicitante(), 1);
				Thread.sleep(8500);
			}
		} catch (Exception e) {
			JOptionPane.showInputDialog(null,e.getMessage());
		}
		for (String nomeSolicitante : chamadosNaoSalvos) {
			chamadoController.alteraEstado(nomeSolicitante, -1);
			Thread.sleep(100);
		}
	}
	
	public void cadastraChamado(Chamado chamado, Atendente atendente) throws IOException, InterruptedException {
		if(!chamado.getESoftplan()){
			try{				
				Thread.sleep(1000);
				conecta.clickCadastrarOcorrencias();
				Thread.sleep(1000);
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
				conectaChamado(atendente, chamado.getESoftplan());
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
				// clica no checkbox salt do SOS
				conecta.clickESof();
				// carrega no campo do SOS o texto do mants
				conecta.clicDescricaoProblema(chamado);
				conecta.clickTerminoCadastro();
				Thread.sleep(2000);
				//escreve no arquivo que foi aberto o chamado
			}catch (NoSuchElementException | UnhandledAlertException e) {
				JOptionPane.showMessageDialog(null, "Aconteceu algo, não foi possível abrir o Matins, por favor tente novamente");
			}
		}
	}
	
	public void notificaExito(){
		JOptionPane.showInputDialog("Chamado Cadastrados com sucesso");
	}
}
