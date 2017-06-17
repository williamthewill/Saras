package controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.CSVUtils;
import model.Chamado;
import model.DAO.FactoryDAO;

public class ChamadoController implements FactoryDAO<Chamado>{

	private CSVUtils csvUtils = new CSVUtils();
	
	@Override
	public void insert(Object obj) {
		Chamado chamado = (Chamado)obj;	
	}

	@Override
	public void update(Object obj) {
		
	}

	@Override
	public List<Chamado> findAll() {
		try {
			return csvUtils.load("./persistences/Chamado.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Chamado> todosChamados() throws FileNotFoundException, IOException{
		return this.findAll();
	}

}
