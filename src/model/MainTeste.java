package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import model.DAO.CSVUtils;

public class MainTeste {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CSVUtils csvUtils = new CSVUtils();
		try {
			csvUtils.alteraSetor("./persistences/Chamados.csv", "gregorio", "gerencia de processos juridicos digitais");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
