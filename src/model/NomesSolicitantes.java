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
import javax.swing.JOptionPane;

public class NomesSolicitantes {

	public String getNomePortalSolicitante(String textoDescricao ) throws IOException{
		try{
			String caminho= "./solicitantes/nomesPortalMPSC.txt";
	
			File file = new File(caminho);
				
			FileReader fileReader = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(fileReader);
			String linha;			
			while((linha = reader.readLine()) != null){
				if(textoDescricao.toLowerCase().contains(linha.toLowerCase())){
					return linha;
				}
			}
			fileReader.close();
			reader.close();
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "Arquivo nomes  inexistente");
		}
		return null;		
	}
	
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
}
