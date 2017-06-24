package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;

public class RegistroChamado {
	
public void salvaLocalmente(Chamado chamado){
	
}
public void cadastraChamado(Chamado chamado, boolean eSoft){
	//LOOP?
	//chamado linha inicio e fim ?????
	
	Atendente atendente = new Atendente(nome, usuario, senha); // ?
	Conecta conecta = new Conecta();
	
	if(!eSoft){
		try{
		
		conecta.conecta();
		conecta.login(atendente, chamado);
		Thread.sleep(1000);
		conecta.clickCadastrarOcorrencias();
		conecta.clicKnomeSolicitante(chamado);
		Thread.sleep(1000);
		conecta.clicLotacao();
		chamado.salvaLotacao(conecta.getLotacaoSolicitante());
		conecta.clickContatoFeitoPor();
		conecta.clickTipoLocalChamado(chamado);
		Thread.sleep(1000);
		conecta.clickDescricaoSolicitante(chamado);
		conecta.clickTerminoCadastro();
		Thread.sleep(1000);
		}catch (NoSuchElementException | UnhandledAlertException e) {
			//nomesErro.add(pl.getNome((es.linhaAtual()-a)+i));
			continue;
		}
		
		// mensagem de erro para o usuario apresentando qual os nomes que deram erro
		
	}else{
		
		try{
		Thread.sleep(1000);
		conecta.conecta();
		conecta.login(atendente, chamado);
		Thread.sleep(1000);
		conecta.clickCadastrarOcorrencias();
		conecta.clicKnomeSolicitante(chamado);
		Thread.sleep(1000);
		conecta.clicLotacao();
		chamado.salvaLotacao(conecta.getLotacaoSolicitante());
		conecta.clickContatoFeitoPor();
		conecta.clickTipoLocalChamado(chamado);
		Thread.sleep(1000);
		conecta.clickDescricaoSolicitante(chamado);
		conecta.clickESof();// clica no chakbox salt do SOS
		
		conecta.clicDescricaoProblema(chamado); // carrega no campo do SOS o texto do mants
		conecta.clickTerminoCadastro();
		Thread.sleep(2000);
		//escreve no arquivo que foi aberto o chamado
		}catch (NoSuchElementException | UnhandledAlertException e) {
			JOptionPane.showMessageDialog(null, "Aconteceu algo, não coseguir abrir seu Matins, por favor tente novamente");
		}
	}
		
	
	
	
			
	
}
public void avaliaChamado(){//?????????????????????????????????????????????????????????????????????????????????????????????????w
	
}
public void getChamado(Chamado chamado){
	
}
public int lerChamado(Chamado chamado){//??????????????????????????????????????????????????????????????
	return 0;
}

public void notificaExito(){//??????????????????????????????????????????????????????????????
	
}

public String verificaLocalSistema(Chamado chamado){//
	return "";
}

	
}
