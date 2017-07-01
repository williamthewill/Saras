package model.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Chamado;

public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ';';
    Chamado chamado;
    
    @SuppressWarnings("static-access")
	private String followCVSformat(Chamado chamado) {
        String chamadoLine = chamado.getDataAbertura();
        chamadoLine += DEFAULT_SEPARATOR;
        chamadoLine += chamado.getNomeSolicitante();
        chamadoLine += DEFAULT_SEPARATOR;
        //lotação
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
	
	public List<Chamado> load(String arquivo, int position) throws Exception {
		File file = new File(arquivo);
		if (!file.exists()) {
			throw new Exception("Sem chamados cadastrados");
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
	
	public List<Chamado> load(String arquivo, int beginPosition, int endPosition) throws Exception {
		File file = new File(arquivo);
		if (!file.exists()) {
			throw new Exception("Sem chamados cadastrados");
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
	
	public List<Chamado> load(String arquivo) throws Exception {
		File file = new File(arquivo);
		if (!file.exists()) {
			 throw new Exception("Sem chamados cadastrados");
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		List<Chamado> allChamados = new ArrayList<>();
		Chamado chamado;
		while( line != null ){
			chamado = createChamado(line);
			if(chamado.getEstado() == 0){
				allChamados.add(chamado);				
			}
			line = br.readLine();
		}
		br.close();
		return allChamados;
	}
	
	public List<Chamado> loadFromDate(String arquivo, String beginDate, String endDate) throws Exception{
		File file = new File(arquivo);
		if (!file.exists()) {
			 throw new Exception("Sem chamados cadastrados");
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		List<Chamado> chamados = new ArrayList<>();
		Chamado chamado;
		while( line != null ){
			chamado = createChamado(line);
			DateFormat prototype = new SimpleDateFormat ("dd-MM-yyyy");
			prototype.setLenient (false); 
			Date beginDt = prototype.parse (beginDate);
			Date endDt = prototype.parse (endDate);
			Date dateChamado = prototype.parse(chamado.getDataAbertura());
			if(dateChamado.after(beginDt) && dateChamado.before(endDt) || dateChamado.equals(beginDt) || dateChamado.equals(endDt)){
				chamados.add(chamado);				
			}
			line = br.readLine();
		}
		br.close();
		return chamados;
	}
	
	public boolean alteraSetor(String arquivo, String nomeSolicitante, String setor) throws Exception {
		File f = new File(arquivo);
		if(!f.exists()){
			throw new Exception("Arquivo não encontrado");
		}			
		File nf = new File("./persistences/temporario.tmp");
        FileWriter fw = null;
        Scanner s = null;
        try {
            fw = new FileWriter(nf);
            s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                if(line.contains(nomeSolicitante)){
                	chamado = createChamado(line);
                	chamado.setSetor(setor);
                	line = followCVSformat(chamado);
                }
                try {
                    fw.write(line + System.getProperty("line.separator"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        f.delete();
        nf.renameTo(f);
        return true;
	}
	
	public boolean alteraEstado(String arquivo, String nomeSolicitante, int estado) throws Exception {
		File f = new File(arquivo);
		if(!f.exists()){
			throw new Exception("Arquivo não encontrado");
		}			
		File nf = new File("./persistences/temporario.tmp");
        FileWriter fw = null;
        Scanner s = null;
        try {
            fw = new FileWriter(nf);
            s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                if(line.contains(nomeSolicitante)){
                	chamado = createChamado(line);
                	chamado.setEstado(estado);
                	line = followCVSformat(chamado);
                }
                try {
                    fw.write(line + System.getProperty("line.separator"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        f.delete();
        nf.renameTo(f);
        return true;
	}
}
