//package model;
//
//import java.util.Date;
//
//import controller.CSVUtils;
//
//public class MainTeste {
//	public static void main(String[] args) {
//		CSVUtils csvUtils = new CSVUtils();
//		String data = FormataData.data;
//		try {
//			Chamado chamado = new Chamado(
//					"", 
//					"erro ao assinar \n na pasta digital", 
//					"carlos", 
//					true, 
//					false);
//			csvUtils.salvar("./persistences/Chamado.csv", chamado);
//			//csvUtils.load("./persistences/Chamado.csv");
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
//	}
//}
