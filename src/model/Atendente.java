package model;

import java.io.Serializable;

public class Atendente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String usuarioRede;
	private String senha;
	
	public Atendente(String nome, String usuario, String senha){
		this.nome = nome;
		this.usuarioRede = usuario;
		this.senha = senha;
	}
	public Atendente(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuarioRede() {
		return usuarioRede;
	}

	public void setUsuarioRede(String usuario) {
		this.usuarioRede = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
}