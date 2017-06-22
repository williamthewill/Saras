package model;

public class LocaisDoSistemaCollection {
	private String[][] locaisDoSistema = {
			{"Acesso ao Sistema(instalação/atualização)", "instalar", "reinstalar", "acessar o sig"},			
			{"Acesso ao Sistema (lotação de usuários)", "lotação", "lotar", "liberar acesso", "Solicito acesso ", "Solicitar acesso", "lotação", "liberar meu acesso", "substituição", "substituir"},
			{"Acesso ao Sistema (outras causas)", "fundo", "fundo de garantia", "acompanhamento de tac", "TAC", "boleto", "FRBL", "frbl"},
			{"Agenda"},
			{"AVA - Ambiente Virtual de Aprendizagem", "Banco de Pareceres", "Banco de Teses", "Cadastro Controlado de Pessoas", "Cadastro da Corregedoria", "Cadastro de Atendimentos", "Cadastro de Manifestações da Ouvidoria", "Cadastro de Modelos"},
			{"Cadastro de Notícia de Fato", "noticia de fato", "notícia de fato", "01.2016.", "01201600"},
			{"Cadastro de Notícia de Fato Antiga"},
			{"Cadastro de Procedimento", "cadastro  de procedimento", "converter", "06.20", "09", "07", "01", "cadastro extra judicial", "procedimento administrativo", "processo preparatório", "notícia de fatos", "inquerito cívil", "tac"},
			{"Cadastro de Procedimento Administrativo", "Cadastro de Procedimento Administrativo Antigo", "Cadastro de Procedimento Antigo"},
			{"Cadastro de Processo (2º Grau)", "2º grau", "peticionamento em 2º grau |recurso", "agravo", "agravar", "recorrer", "segundo grau", "peticionamento em segundo grau", "contra recurso", "copij", "COPIJ", "suscitação"},
			{"Cadastro de Processo Judicial",  "08.20", "fisico", "físico", "fisicos", "processos eletrônicos", "processo eletrônico"},
			{"Cadastro de Protocolo", "02.20", "0220", "protocolo", "Cadastro de Registros Públicos", "Cadastro de Solicitações de Apoio"},
			{"Carga, remessa e distribuição", "Carga Importação ", "carga importação ", "carga", "recebimento", "recebimento de processos", "Importação", "receber processos", "remessa", "distribuição"},
			{"Consulta"},
			{"Editor de Textos", "Editor de textos", "Editor de documentos", "editor de texto do sig", "editor sig", "fonte", "instalar fonte", "campo automaticos", "modelo", "campo automatico", "auto texto", "auto completar"},
			{"Elogio"},
			{"Emissão de Documentos"},
			{"Fluxo de Trabalho"},
			{"Gerenciador de Arquivos", "Gerenciador de Arquivos", "achar documento", "modelos", "modelo", "gerenciador", "lixeira"},
			{"Integração com o Poder Judiciário"},
			{"Lentidão ou Travamento"},
			{"Pasta Digital", "pasta digital", "pasta digital do sig"},
			{"Pasta Digital do TJ", "pasta digital do tj", "pasta tj", "documentos pasta", "tj está fora", "tj instável"},
			{"Pendências e Prazos", "pendências", "pendência", "prazo", "gerar pendência", "pendencia de processo", "pendencia"},
			{"Peticionamento Eletrônico", "Peticionamento", "peticionar", "peticionamento bloqueado", "competência", "classe", "parte mpsc", "peticionamento", "assunto inexistente"},
			{"Portal do SIG - Internet"},
			{"Problema Alheio ao SIG/MPSC", "SAU", "sau"},
			{"Problema com Cadastros em Geral", "Processo Eletrônico", "Taxonomia (Classes, Assuntos e Movimentos)"},
			{"Tela Principal do SIG", "acesso rápido", "tela inicial", "links importantes", "atualização de tela", "notificações"}
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
