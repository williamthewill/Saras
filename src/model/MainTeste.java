package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import model.DAO.CSVUtils;

public class MainTeste {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*CSVUtils csvUtils = new CSVUtils();
		String data = FormataData.data;
		try {
			Chamado chamado = new Chamado("enge. arthur", "deveria ser local", "elogio", 0, "atenditdo", "nome at.", false, "");
			csvUtils.salvar("./persistences/Chamado.csv", chamado);
			//csvUtils.load("./persistences/Chamado.csv");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//csvUtils.load("./persistences/Chamado.csv");*/
		LocaisDoSistemaCollection locaisDoSistemaCollection = new LocaisDoSistemaCollection();
		
		System.out.println(locaisDoSistemaCollection.containsInCollection("pasTa diGital"));
		
	}
}
