package model;

public class LocaisDoSistemaCollection {
	private String[][] locaisDoSistema = {
			{"Acesso ao Sistema(instala��o/atualiza��o)", "instalar", "reinstalar", "acessar o sig"},			
			{"Acesso ao Sistema (lota��o de usu�rios)", "lota��o", "lotar", "liberar acesso", "Solicito acesso ", "Solicitar acesso", "lota��o", "liberar meu acesso", "substitui��o", "substituir"},
			{"Acesso ao Sistema (outras causas)", "fundo", "fundo de garantia", "acompanhamento de tac", "TAC", "boleto", "FRBL", "frbl"},
			{"Agenda"},
			{"AVA - Ambiente Virtual de Aprendizagem", "Banco de Pareceres", "Banco de Teses", "Cadastro Controlado de Pessoas", "Cadastro da Corregedoria", "Cadastro de Atendimentos", "Cadastro de Manifesta��es da Ouvidoria", "Cadastro de Modelos"},
			{"Cadastro de Not�cia de Fato", "noticia de fato", "not�cia de fato", "01.2016.", "01201600"},
			{"Cadastro de Not�cia de Fato Antiga"},
			{"Cadastro de Procedimento", "cadastro  de procedimento", "converter", "06.20", "09", "07", "01", "cadastro extra judicial", "procedimento administrativo", "processo preparat�rio", "not�cia de fatos", "inquerito c�vil", "tac"},
			{"Cadastro de Procedimento Administrativo", "Cadastro de Procedimento Administrativo Antigo", "Cadastro de Procedimento Antigo"},
			{"Cadastro de Processo (2� Grau)", "2� grau", "peticionamento em 2� grau |recurso", "agravo", "agravar", "recorrer", "segundo grau", "peticionamento em segundo grau", "contra recurso", "copij", "COPIJ", "suscita��o"},
			{"Cadastro de Processo Judicial",  "08.20", "fisico", "f�sico", "fisicos", "processos eletr�nicos", "processo eletr�nico"},
			{"Cadastro de Protocolo", "02.20", "0220", "protocolo", "Cadastro de Registros P�blicos", "Cadastro de Solicita��es de Apoio"},
			{"Carga, remessa e distribui��o", "Carga Importa��o ", "carga importa��o ", "carga", "recebimento", "recebimento de processos", "Importa��o", "receber processos", "remessa", "distribui��o"},
			{"Consulta"},
			{"Editor de Textos", "Editor de textos", "Editor de documentos", "editor de texto do sig", "editor sig", "fonte", "instalar fonte", "campo automaticos", "modelo", "campo automatico", "auto texto", "auto completar"},
			{"Elogio"},
			{"Emiss�o de Documentos"},
			{"Fluxo de Trabalho"},
			{"Gerenciador de Arquivos", "Gerenciador de Arquivos", "achar documento", "modelos", "modelo", "gerenciador", "lixeira"},
			{"Integra��o com o Poder Judici�rio"},
			{"Lentid�o ou Travamento"},
			{"Pasta Digital", "pasta digital", "pasta digital do sig"},
			{"Pasta Digital do TJ", "pasta digital do tj", "pasta tj", "documentos pasta", "tj est� fora", "tj inst�vel"},
			{"Pend�ncias e Prazos", "pend�ncias", "pend�ncia", "prazo", "gerar pend�ncia", "pendencia de processo", "pendencia"},
			{"Peticionamento Eletr�nico", "Peticionamento", "peticionar", "peticionamento bloqueado", "compet�ncia", "classe", "parte mpsc", "peticionamento", "assunto inexistente"},
			{"Portal do SIG - Internet"},
			{"Problema Alheio ao SIG/MPSC", "SAU", "sau"},
			{"Problema com Cadastros em Geral", "Processo Eletr�nico", "Taxonomia (Classes, Assuntos e Movimentos)"},
			{"Tela Principal do SIG", "acesso r�pido", "tela inicial", "links importantes", "atualiza��o de tela", "notifica��es"}
	};
	
	public String[][] getCollectionLocaisDoSistema(){
		return this.locaisDoSistema;
	}
	
	public String containsInCollection(String description){
		for(int i = 0; i < locaisDoSistema.length; i++){
			for(int j = 0; j < locaisDoSistema[i].length; j++){
				if(description.contains(locaisDoSistema[i][j])){
					return locaisDoSistema[i][0];
				}
			}
		}
		return null;
	}
}
