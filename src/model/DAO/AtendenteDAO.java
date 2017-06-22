package model.DAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Atendente;
import model.Conecta;

public class AtendenteDAO {

	private Atendente atendente;
	public AtendenteDAO(Atendente atendente){
		this.atendente = atendente;
	}
	
	public Boolean validaUsuarioPortal() throws IOException, InterruptedException{
		boolean returner = false;
		Conecta conecta = new Conecta();
		boolean autenticado = conecta.conectaAutentica( this.atendente);
		
		if(autenticado){
			conecta.close();
			returner = this.persiste();
		}else{
			throw new RuntimeException("Login n�o consta no portal MPSC");
			
		}
		
		return returner;
	}
		
	public boolean persiste(){
		boolean returner = false;
		 try{
            FileOutputStream arquivoGrav = new FileOutputStream("./persistences/Atendente.ser");
            
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            
			objGravar.writeObject(atendente);
			
            objGravar.flush();
            objGravar.close();
            arquivoGrav.flush();
            arquivoGrav.close();
			
			returner = true;
        }catch( Exception e ){
			e.printStackTrace();
        }
		
		return returner;
	}
	
	public Atendente recuperaAtendente(){
		try{
			FileInputStream arquivoLeitura = new FileInputStream("./media/Atendente.ser");
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
			this.atendente = (Atendente) objLeitura.readObject();
            objLeitura.close();
            arquivoLeitura.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return atendente;
	}
	
}
