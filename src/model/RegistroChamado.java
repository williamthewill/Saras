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
	private boolean mants=false;
	private boolean erro = false;
	
	public void salvaLocalmente(Chamado chamado){
		chamadoController.insert(chamado);
	}
	public void conectaChamado ( Atendente atendente, boolean eSoft) {
		try {
			conecta.conecta();
			conecta.login(atendente, eSoft);
		} catch (InterruptedException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar login");
			e.printStackTrace();
		}
	}

	public void cadastraChamados(Atendente atendente) throws IOException, InterruptedException{
		conectaChamado(atendente, false);
		try {
			for (Chamado chamado : chamadoController.todosChamados()) {
				this.cadastraChamado(chamado, atendente);
				Thread.sleep(1000);
				chamadoController.alteraEstado(chamado.getNomeSolicitante(), 1);
				Thread.sleep(7000);
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
				conecta.clickLotacao();
				chamadoController.alteraSetor(chamado.getNomeSolicitante(), conecta.getLotacaoSolicitante());
				Thread.sleep(500);
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
				this.conectaChamado ( atendente, true);
				JOptionPane.showMessageDialog(null, "Por favor  efetue seu login,\n somente depois clique em  OK");
				Thread.sleep(1000);
				conecta.clickCadastrarOcorrencias();
				Thread.sleep(1000);
				conecta.clicKnomeSolicitante(chamado);
				Thread.sleep(1000);
				conecta.clickLotacao();
				chamadoController.alteraSetor(chamado.getNomeSolicitante(), conecta.getLotacaoSolicitante());
				Thread.sleep(500);
				conecta.clickContatoFeitoPor();
				conecta.clickTipoLocalChamado(chamado);
				Thread.sleep(1000);
				conecta.clickDescricaoSolicitante(chamado);
				// clica no checkbox salt do SOS
				conecta.clickESof();
				// carrega no campo do SOS o texto do mants
				conecta.clickDescricaoProblema(chamado);
				conecta.clickTerminoCadastro();
				this.mants=true;
				chamadoController.alteraEstado(chamado.getNomeSolicitante(), 1);
				Thread.sleep(6000);
				//escreve no arquivo que foi aberto o chamado
			}catch (NoSuchElementException | UnhandledAlertException e) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar Mantis, por favor tente novamente.");
			}
		}
	}
	
	public void notificaExito(){
		if(!erro){
			StringBuilder nomesErro =new  StringBuilder();
			if(chamadosNaoSalvos.size()!=0){
				for(int i=0; i<chamadosNaoSalvos.size(); i++){
					nomesErro.append("\n"+chamadosNaoSalvos.get(i));
				}
				conecta.close();
				JOptionPane.showMessageDialog(null, "Não consegui cadastrar as pessoas abaixo:"+"\n"+nomesErro.toString()+"\n"+"MOTIVO: O nome cadastro no JABBER não é igual ao do SOS."+"\n"+"Abra assua Planilha e cadastre Manualmente!");
				
				chamadosNaoSalvos.clear();
			}
			if(chamadosNaoSalvos.size()==0 && !mants){
				conecta.close();
				JOptionPane.showMessageDialog(null, "Chamado Cadastrados com sucesso");
			}
			if(this.mants){
				JOptionPane.showMessageDialog(null, "MANTIS ABERTO COM SUCESSO, agora anexe seus documentos se houver");
			}			
		}
	}
}
