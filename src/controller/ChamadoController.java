package controller;

import java.awt.List;

import model.Chamado;
import model.DAO.FactoryDAO;

import model.Chamado;
import model.DAO.FactoryDAO;

public class ChamadoController implements FactoryDAO<Chamado>{

	@Override
	public void insert(Object obj) {
		Chamado chamado = (Chamado)obj;	
	}

	@Override
	public void update(Object obj) {
		
	}

	@Override
	public List findAll(Class classe) {
		return null;
	}

	public String getMensagemFone(){
		return "Este chamado teve entrada via Fone. ";
	}
	
	public String getMensagemRemoto(){
		return "Este chamado teve entrada via Remoto. ";
	}
	
	
}
