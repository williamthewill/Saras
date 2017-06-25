package model;

import java.io.Serializable;

public class Atendente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String usuarioRede;
	private String senha;
	
	public Atendente(String usuario, String senha){
		this.usuarioRede = usuario;
		this.senha = senha;
	}
	public Atendente(){
		
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