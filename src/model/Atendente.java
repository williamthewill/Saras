package model;

import java.io.Serializable;

public class Atendente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String usuario;
	private String senha;
	
	public Atendente(String nome, String usuario, String senha){
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
}