package model.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Chamado;

public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ';';
    
    @SuppressWarnings("static-access")
	private String followCVSformat(Chamado chamado) {
        String chamadoLine = chamado.getDataAbertura();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getNomeSolicitante();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getSetor();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getTipoAtendimento();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getDescricaoSolicitante();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getLocalChamado();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getSaltNum();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getSituacaoAtual();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getSituacaoSalt();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getDataEncerramento();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getSolucao();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getObservacao();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getDiasTrabalho();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getESoftplan();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getDescricaoProblema();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getEstado();
        chamadoLine += DEFAULT_SEPARATOR;
        
        return chamadoLine;
    }

    private Chamado createChamado(String line){
    	String[] lineAttributes = line.split(";");
    	return new Chamado(lineAttributes[0], lineAttributes[1], 
				lineAttributes[2], lineAttributes[4], 
				lineAttributes[5], Integer.parseInt(lineAttributes[6]), 
				lineAttributes[7], Boolean.parseBoolean(lineAttributes[8]), lineAttributes[11], 
				Boolean.parseBoolean(lineAttributes[13]), lineAttributes[14], Integer.parseInt(lineAttributes[15]));
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
	
	public List<Chamado> load(String arquivo, int position) throws FileNotFoundException, IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			return null;
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		int currentLine = 1;
		List<Chamado> chamados = new ArrayList<>();
		while( line != null ){
			if(currentLine >= position){
				chamados.add(createChamado(line));		
			}
			currentLine++;
			line = br.readLine();
		}
		br.close();
		return chamados;
	}
	
	public List<Chamado> load(String arquivo, int beginPosition, int endPosition) throws FileNotFoundException, IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			return null;
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		int currentLine = 1;
		List<Chamado> chamados = new ArrayList<>();
		while( line != null ){
			if(currentLine >= beginPosition && currentLine <= endPosition){				
				chamados.add(createChamado(line));				
			}
			currentLine++;
			line = br.readLine();
		}
		br.close();
		return chamados;
	}
	
	public List<Chamado> load(String arquivo) throws FileNotFoundException, IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			return null;
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		List<Chamado> allChamados = new ArrayList<>();
		Chamado chamado;
		while( line != null ){
			chamado = createChamado(line);
			allChamados.add(chamado);
			line = br.readLine();
		}
		br.close();
		return allChamados;
	}
}
