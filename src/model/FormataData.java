package model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class FormataData {
	
	
	static String formataData(){
		System.err.println("construtor");
		Date data = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(data);
	    // formata e exibe a data e hora
	    Format format = new SimpleDateFormat("dd-MM-yyyy"); //yyyy-MM-dd
	    String mes = format.format(c.getTime());
	    return mes;
	}
	
	static String formataHora(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
		String horaFormatada = sdf.format(hora);
	    return horaFormatada;
	}
	
	public static String data = formataData();
	public static String hora= formataHora();
}
