package controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import model.Chamado;
import model.DAO.CSVUtils;
import model.DAO.FactoryDAO;

public class ChamadoController implements FactoryDAO<Chamado>{

	private CSVUtils csvUtils = new CSVUtils();
	private static String path = "./persistences/Chamados.csv";
	@Override
	public void insert(Object obj) {
		Chamado chamado = (Chamado)obj;	
		try {
			csvUtils.salvar(path, chamado);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "O arquivo está sendo aberto em outra operação");
		}
	}

	@Override
	public List<Chamado> findAll() throws Exception {
		try {
			return csvUtils.load(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Chamado> todosChamados() throws Exception{
		return this.findAll();
	}
	
	public List<Chamado> chamadosData(String beginDate, String endDate) throws Exception{
		return csvUtils.loadFromDate(path, beginDate, endDate);
	}

	public void alteraEstado(String nomeSolicitante, int estado){
		try {
			csvUtils.alteraEstado(path, nomeSolicitante, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void alteraSetor(String nomeSolicitante, String setor){
		try {
			csvUtils.alteraSetor(path, nomeSolicitante, setor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
