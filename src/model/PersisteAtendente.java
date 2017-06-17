package model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersisteAtendente{
	private Atendente atendente;
	
	public PersisteAtendente(Atendente atendente){
		this.atendente = atendente;
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