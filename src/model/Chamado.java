package model;

import java.util.Date;

public class Chamado {
	
	private String dataAbertura;
	private String nomeSolicitante;
	private String setor;
	private String descricaoSolicitante;
	private String localChamado;
	private int saltNum;
	private String situacaoAtual;
	private boolean situacaoSalt;
	private String dataEncerramento;
	private static String solucao = "Orientado";
	private String observacao; //Nome do atendente
	private static int diasTrabalho = 0;
	private boolean eSoftplan;
	private static String tipoAtendimento = "Solicitação";
	private String descricaoProblema;
	private int estado;
	
	public Chamado(String dataAbertura, String nomeSolicitante, String setor, 
			String descricaoSlicitante, String localChamado, int saltNum, String situacaoAtual, boolean situacaoSalt,
			String observacao, boolean eSoftplan, String descricaoProblema, int estado){
		this.nomeSolicitante = nomeSolicitante;
		this.setor = setor;
		this.descricaoProblema = descricaoProblema;
		this.localChamado = localChamado;
		this.saltNum = saltNum;
		this.situacaoAtual = situacaoAtual;
		this.observacao = observacao;
		this.eSoftplan = eSoftplan;
		this.descricaoProblema = descricaoProblema;
		this.estado = estado;
		this.situacaoSalt = situacaoSalt;
	}
	
	public Chamado(String nomeSolicitante, String setor, 
			String descricaoSlicitante, String localChamado, int saltNum, String situacaoAtual,
			String observacao, boolean eSoftplan, String descricaoProblema){
		this.nomeSolicitante = nomeSolicitante;
		this.setor = setor;
		this.descricaoProblema = descricaoProblema;
		this.localChamado = localChamado;
		this.saltNum = saltNum;
		this.situacaoAtual = situacaoAtual;
		this.observacao = observacao;
		this.eSoftplan = eSoftplan;
		this.descricaoProblema = descricaoProblema;
		this.dataAbertura = FormataData.data;
		this.dataEncerramento = FormataData.data;
		this.estado = 0;
		if(eSoftplan){
			this.situacaoSalt = true;
		}
	}
	
	
	
	public int getDiasTrabalho() {
		return diasTrabalho;
	}
	
	public String getDataAbertura() {
		return dataAbertura;
	}


	public String getSetor() {
		return setor;
	}


	public String getTipoAtendimento() {
		return tipoAtendimento;
	}


	public int getSaltNum() {
		return saltNum;
	}


	public String getSituacaoAtual() {
		return situacaoAtual;
	}


	public boolean getSituacaoSalt() {
		return situacaoSalt;
	}


	public String getDataEncerramento() {
		return dataEncerramento;
	}


	public static String getSolucao() {
		return solucao;
	}


	public String getObservacao() {
		return observacao;
	}


	public boolean iseSoftplan() {
		return eSoftplan;
	}


	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}


	public void setSaltNum(int saltNum) {
		this.saltNum = saltNum;
	}


	public void setSituacaoAtual(String situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}


	public void setSituacaoSalt(boolean situacaoSalt) {
		this.situacaoSalt = situacaoSalt;
	}


	public void setDataEncerramento(String dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}


	public static void setSolucao(String solucao) {
		Chamado.solucao = solucao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}


	public void setDescricaoSolicitante(String descricaoSolicitante) {
		this.descricaoSolicitante = descricaoSolicitante;
	}


	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}


	public void setLocalChamado(String localChamado) {
		this.localChamado = localChamado;
	}


	public void seteSoftplan(boolean eSoftplan) {
		this.eSoftplan = eSoftplan;
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

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public String getLocalChamado() {
		return localChamado;
	}

	public boolean eRemoto() {
		if(descricaoProblema.contains("viadagem"));
		return true;
	}
	
	public boolean eFone() {
		if(descricaoProblema.contains("viadagem"));
		return true;
	}

	public boolean getESoftplan() {
		return eSoftplan;
	}

}
