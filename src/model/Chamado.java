package model;

public class Chamado {
	
	private String dataAbertura;
	private String nomeSolicitante;
	private String setor;//lotação
	private static String tipoAtendimento = "Solicitação";
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
	private String descricaoProblema;
	private int estado;
	
	public Chamado(String dataAbertura, String nomeSolicitante, String setor, 
			String descricaoSolicitante, String localChamado, int saltNum, String situacaoAtual, boolean situacaoSalt,
			String observacao, boolean eSoftplan, String descricaoProblema, int estado){
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataAbertura;
		this.setor = setor;
		this.descricaoSolicitante = descricaoSolicitante;
		this.localChamado = localChamado;
		this.saltNum = saltNum;
		this.situacaoAtual = situacaoAtual;
		this.situacaoSalt = situacaoSalt;
		this.nomeSolicitante = nomeSolicitante;
		this.observacao = observacao;
		this.eSoftplan = eSoftplan;
		this.descricaoProblema = descricaoProblema;
		this.estado = estado;
	}
	
	public Chamado(String nomeSolicitante,
			String descricaoSolicitante,boolean eSoftplan, boolean eRemoto, boolean eFone, String descricaoProblema){
		this.dataAbertura = FormataData.data;
		this.nomeSolicitante = nomeSolicitante;
		this.descricaoProblema = descricaoProblema;
		this.eSoftplan = eSoftplan;
		this.descricaoProblema = descricaoProblema;
		this.dataEncerramento = FormataData.data;
		this.estado = 0;
		if(eSoftplan){
			this.situacaoSalt = true;
		}
		this.setor = "";
		this.descricaoSolicitante = descricaoSolicitante;
		this.buscaLocalChamado();
	}
	
	public Chamado() {}
	
	private void buscaLocalChamado(){
		LocaisDoSistemaCollection locaisDoSistemaCollection = new LocaisDoSistemaCollection();
		this.localChamado = locaisDoSistemaCollection.containsInCollection(descricaoSolicitante);
	}
	
	public boolean eRemoto() {
		if(descricaoProblema.contains("Este atendimento teve interação via acesso remoto.")){
			return true;
		};
		return false;
	}
	
	public boolean eFone() {
		if(descricaoProblema.contains("Este atendimento teve interação via telefone, referente a: ")){
			return true;
		}
		return false;
	}
	
	public int getEstado(){
		return this.estado;
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

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public void setSetor(String setor) {
		this.setor = setor;
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

	public void setESoftplan(boolean eSoftplan) {
		this.eSoftplan = eSoftplan;
	}

	public boolean getESoftplan() {
		return eSoftplan;
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
}
