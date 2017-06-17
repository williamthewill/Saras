package model;

import java.util.Date;

public class Chamado {
	
	private String dataAbertura = FormataData.data;
	private String setor;
	private String tipoAtendimento;
	private int saltNum;
	private String situacaoAtual;
	private static String situacaoSalt = "Mantis Aberto";
	private String dataEncerramento = FormataData.data;
	private static String solucao = "Orientado";
	private String observacao; //Nome do atendente
	
	private String descricaoProblema;
	private String descricaoSolicitante;
	private String lotacaoSolicitante;
	private String nomeSolicitante;
	private String localChamado;
	private boolean eRemoto;
	private boolean eSoftplan;
	
	
	public Chamado(String descricaoProblema, String descricaoSlicitante, String lotacaoSolicitante, String nomeSolicitante, String localChamado, boolean eRemoto, boolean eSoftplan){
		this.descricaoProblema = descricaoProblema;
		this.descricaoSolicitante = descricaoSlicitante;
		this.lotacaoSolicitante = lotacaoSolicitante;
		this.nomeSolicitante = nomeSolicitante;
		this.localChamado = localChamado;
		this.eRemoto = eRemoto;
		this.eSoftplan = eSoftplan;
	}
	
	public Chamado(String descricaoProblema, String descricaoSolicitante, String nomeSolicitante, boolean eRemoto, boolean eSoftplan){
		this.descricaoProblema = descricaoProblema;
		this.descricaoSolicitante = descricaoSolicitante;
		this.nomeSolicitante = nomeSolicitante;
		this.eRemoto = eRemoto;
		this.eSoftplan = eSoftplan;
		this.localChamado = this.requestLocalChamado(this.descricaoProblema);
	}
	
	private String requestLocalChamado(String descricaiProblema){
		return null;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public String getDescricaoSolicitante() {
		return descricaoSolicitante;
	}

	public String getLotacaoSolicitante() {
		return lotacaoSolicitante;
	}

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public String getLocalChamado() {
		return localChamado;
	}

	public boolean getERemoto() {
		return eRemoto;
	}

	public boolean getESoftplan() {
		return eSoftplan;
	}

}
