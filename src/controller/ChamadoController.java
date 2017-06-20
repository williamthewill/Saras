package controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.Chamado;
import model.DAO.CSVUtils;
import model.DAO.FactoryDAO;

public class ChamadoController implements FactoryDAO<Chamado>{

	private CSVUtils csvUtils = new CSVUtils();
	
	@Override
	public void insert(Object obj) {
		Chamado chamado = (Chamado)obj;	
		try {
			csvUtils.salvar("./persistences/Chamados.csv", chamado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Chamado> findAll() {
		try {
			return csvUtils.load("./persistences/Chamado.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Chamado> todosChamados() throws FileNotFoundException, IOException{
		return this.findAll();
	}

	
	
	
}
