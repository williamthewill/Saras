package controller;

import model.Atendente;
import model.DAO.AtendenteDAO;

public class CadastroAtendente{
	
	private Atendente atendente;
	
	public CadastroAtendente(Atendente atendente){
		this.atendente=atendente;
	}
	
	public void setAtendente(Atendente atendente){
		this.atendente = atendente;
	}
	
	public Atendente getAtendente(){
		return this.atendente;
	}
	
	public Boolean validaUsuarioPortal(){
		boolean returner = false;
		
		returner = this.persisteAtendente();//remover quando implementar o codigo comentado abaixo
		
		/*Conecta conecta = new Conecta();
		boolean autenticado = conecta.autenticaLogin(atendente);
		
		if(autenticado){
			returner = this.persisteAtendente();
		}else{
			throw new RuntimeException("Login não consta no portal MPSC");
		}*/
		
		return returner;
	}
	
	public Boolean persisteAtendente(){
		 AtendenteDAO persiste = new AtendenteDAO(atendente);
		 return persiste.persiste();
	}
}