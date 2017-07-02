package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.DAO.AtendenteDAO;
import model.DAO.CSVUtils;

public class MainTeste {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Atendente atendente = new Atendente();
		atendente.setSenha("123");
		atendente.setUsuarioRede("will");
		AtendenteDAO atendenteDAO = new AtendenteDAO(atendente);
		atendenteDAO.persiste();
	}
}
