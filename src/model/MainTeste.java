package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.DAO.CSVUtils;

public class MainTeste {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		CSVUtils csvUtils = new CSVUtils();
		Chamado chamado = new Chamado("thiago4", "Este atendimento teve interação via acesso remoto.", false, true, true, "maup");
		try {
			//csvUtils.alteraSetor("./persistences/Chamados.csv", "gregorio", "gerencia de processos juridicos digitais");
			//csvUtils.salvar("./persistences/Chamado.csv", chamado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
		df.setLenient (false); 
		Date dt = df.parse ("31-12-2018");
		
		Date data1 = df.parse ("01-07-2017");
		Date data2 = df.parse ("02-08-2017");
		System.out.println(data2.before(dt));
	}
}
