package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.Atendente;
import model.Conecta;
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
	
	public Boolean validaUsuarioPortal() throws IOException, InterruptedException{
		boolean returner = false;
		
		//returner = this.persisteAtendente();//remover quando implementar o codigo comentado abaixo
		
		Conecta conecta = new Conecta();
		boolean autenticado = conecta.conectaAutentica(atendente);
		
		if(autenticado){
			returner = this.persisteAtendente();
		}else{
			JOptionPane.showMessageDialog(null,("Login n�o encontrado no portal MPSC"));
		}
		
		return returner;
	}
	
	public Boolean persisteAtendente(){
		 AtendenteDAO persiste = new AtendenteDAO(atendente);
		 return persiste.persiste();
	}
}