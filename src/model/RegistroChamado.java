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

public class RegistroChamado {
	private String nomeSolicitante;
	private ArrayList<String> listNomeNaoEncontrado= new ArrayList<String>();

	public void escreveNomeSolicitante(String nome) throws IOException{
		try{
		OutputStream saida = new FileOutputStream("./solicitantes/nomesPortalMPSC.txt",true);    
		OutputStreamWriter saidaEscrita = new OutputStreamWriter(saida);  
		BufferedWriter escrita = new BufferedWriter(saidaEscrita);  
		  
		escrita.newLine();  
		escrita.write(nome);      
		escrita.close();  
		
		}catch(FileNotFoundException e) {
			 JOptionPane.showMessageDialog(null, "O arquivo está sendo executado em outro processo");
		}	
	}
	public boolean contemNomeSolicitante(String textoDescricao) throws IOException, URISyntaxException{
		boolean contem=false;
		try{
//		String d =System.getProperty("user.dir");
//		String nome= "\\"+"nomesPortalMPSC.txt";
		String caminho= "./solicitantes/nomesPortalMPSC.txt";

		File file = new File(caminho);
		
	
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String linha = null;
			
		while((linha = reader.readLine()) != null){
			//System.out.println(linha);
			if(textoDescricao.toLowerCase().contains(linha.toLowerCase())){
				setNomeSolicitante(linha);
				contem=true;
				break;
			}
				contem=false;
	}
		fileReader.close();
		reader.close();
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "Arquivo nomes  inexistente");
		}
		return contem;

	}
	public String getNomeSolicitante(){
		return this.nomeSolicitante;
		
	}
	public void setNomeSolicitante(String nome){
		this.nomeSolicitante=nome;
	}
	
	public void registraChamado(Chamado chamado){
		//salvar para portal
		// antes de chalvar pega
		
	}
	
	public void nomeNaoEncontrado(String nome){
		listNomeNaoEncontrado.add(nome);
		
	}
	
}
