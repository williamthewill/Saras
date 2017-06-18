package model;

import java.util.ArrayList;

public class LocaisDoSistemaCollection {
	private ArrayList<String> locaisDoSistema = new ArrayList<>();
	
	public LocaisDoSistemaCollection() {
		locaisDoSistema.add("Acesso ao Sistema(instalação/atualização)");
		locaisDoSistema.add("Acesso ao Sistema (lotação de usuários)");
		locaisDoSistema.add("Acesso ao Sistema (outras causas)");
		locaisDoSistema.add("Agenda");
		locaisDoSistema.add("AVA - Ambiente Virtual de Aprendizagem");
		locaisDoSistema.add("Banco de Pareceres");
		locaisDoSistema.add("Banco de Teses");
		locaisDoSistema.add("Cadastro Controlado de Pessoas");
		locaisDoSistema.add("Cadastro da Corregedoria");
		locaisDoSistema.add("Cadastro de Atendimentos");
		locaisDoSistema.add("Cadastro de Manifestações da Ouvidoria");
		locaisDoSistema.add("Cadastro de Modelos");
		locaisDoSistema.add("Cadastro de Notícia de Fato");
		locaisDoSistema.add("Cadastro de Notícia de Fato Antiga");
		locaisDoSistema.add("Cadastro de Procedimento");
		locaisDoSistema.add("Cadastro de Procedimento Administrativo");
		locaisDoSistema.add("Cadastro de Procedimento Administrativo Antigo");
		locaisDoSistema.add("Cadastro de Procedimento Antigo");
		locaisDoSistema.add("Cadastro de Processo (2º Grau)");
		locaisDoSistema.add("Cadastro de Processo Judicial");
		locaisDoSistema.add("Cadastro de Protocolo");
		locaisDoSistema.add("Cadastro de Registros Públicos");
		locaisDoSistema.add("Cadastro de Solicitações de Apoio");
		locaisDoSistema.add("Carga, remessa e distribuição");
		locaisDoSistema.add("Consulta");
		locaisDoSistema.add("Editor de Textos");
		locaisDoSistema.add("Elogio");
		locaisDoSistema.add("Emissão de Documentos");
		locaisDoSistema.add("Fluxo de Trabalho");
		locaisDoSistema.add("Gerenciador de Arquivos");
		locaisDoSistema.add("Integração com o Poder Judiciário");
		locaisDoSistema.add("Lentidão ou Travamento");
		locaisDoSistema.add("Pasta Digital");
		locaisDoSistema.add("Pasta Digital do TJ");
		locaisDoSistema.add("Pendências e Prazos");
		locaisDoSistema.add("Peticionamento Eletrônico");
		locaisDoSistema.add("Portal do SIG - Internet");
		locaisDoSistema.add("Problema Alheio ao SIG/MPSC");
		locaisDoSistema.add("Problema com Cadastros em Geral");
		locaisDoSistema.add("Processo Eletrônico");
		locaisDoSistema.add("Taxonomia (Classes, Assuntos e Movimentos)");
		locaisDoSistema.add("Tela Principal do SIG");
	}
	
	public ArrayList<String> getCollectionLocaisDoSistema(){
		return this.locaisDoSistema;
	}
}
