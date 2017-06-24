package controller;

import java.util.List;

import model.Atendente;
import model.DAO.AtendenteDAO;
import model.DAO.FactoryDAO;

public class AtendenteController implements FactoryDAO<Atendente>{
	Atendente atendente;
	public AtendenteController(Atendente atendente) {
		this.atendente = atendente;
	} 
	
	public AtendenteController() {
	}
	
	AtendenteDAO atendenteDao = new AtendenteDAO(atendente);
			
	@Override
	public void insert(Object obj) {
		atendenteDao.persiste();
	}

	@Override
	public List<Atendente> findAll() {
		return null;
	}
	
	public Atendente recuperaAtendente(){
		return atendenteDao.recuperaAtendente();
	}
	
	
}
