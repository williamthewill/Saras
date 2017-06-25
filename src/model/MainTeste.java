package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import model.DAO.CSVUtils;

public class MainTeste {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CSVUtils csvUtils = new CSVUtils();
		Chamado chamado = new Chamado("thiago4", "Este atendimento teve interação via acesso remoto.", false, true, true, "maup");
		try {
			//csvUtils.alteraSetor("./persistences/Chamados.csv", "gregorio", "gerencia de processos juridicos digitais");
			csvUtils.salvar("./persistences/Chamado.csv", chamado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
