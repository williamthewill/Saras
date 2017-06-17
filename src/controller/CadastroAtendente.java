package controller;


import model.Atendente;
import model.PersisteAtendente;

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
		System.out.println(atendente.getUsuario());
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
		 PersisteAtendente persiste = new PersisteAtendente(atendente);
		 return persiste.persiste();
	}
}