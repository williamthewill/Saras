package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Chamado;

public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ';';

    private String followCVSformat(Chamado chamado) {
        String chamadoLine = chamado.getDescricaoProblema().replaceAll(";", "|").replaceAll("\n", "|n");
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getDescricaoSolicitante().replaceAll(";", "|").replaceAll("\n", "|n");
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getDescricaoProblema().replaceAll(";", "|").replaceAll("\n", "|n");
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getLotacaoSolicitante();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getNomeSolicitante();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getLocalChamado();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getERemoto();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getESoftplan();
        System.out.println("followCSVformat");	
        System.out.println(chamadoLine);
        return chamadoLine;
    }

    public void salvar(String arquivo, Chamado chamado) throws IOException {
    	File file = new File(arquivo);
		if (!file.exists()) {
			new FileWriter(arquivo);
		}
		FileWriter fw = new FileWriter(arquivo, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(this.followCVSformat(chamado));
		pw.flush();
		pw.close();
	}

	public String load(String arquivo) throws FileNotFoundException, IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			return null;
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		int currentLine = 1;
		while( line != null ){
			System.out.println(currentLine);
			System.out.println(line);
			currentLine++;			
			line = br.readLine();
		}
		br.close();
		return null;
	}
	
	public String load(String arquivo, int position) throws FileNotFoundException, IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			return null;
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		int currentLine = 1;
		while( line != null ){
			if(currentLine >= position){
				System.out.println(currentLine);
				System.out.println(line);				
			}
			currentLine++;
			line = br.readLine();
		}
		br.close();
		return null;
	}
	
	public String load(String arquivo, int beginPosition, int endPosition) throws FileNotFoundException, IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			return null;
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		int currentLine = 1;
		while( line != null ){
			if(currentLine >= beginPosition & currentLine <= endPosition){
				System.out.println(currentLine);
				System.out.println(line);				
			}
			currentLine++;
			line = br.readLine();
		}
		br.close();
		return null;
	}
}
