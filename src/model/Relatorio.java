package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controller.ChamadoController;

public class Relatorio {
	
	private int contFone;
	private int contRemoto;
	private int contChamadosDia;
	private int contUsuarioMInterecao;
	private int contLocalSistema;
	private String usuarioMInterecao;
	private String localSistema;
	
	ChamadoController chamadoController;
	
		public void geraPDF() throws DocumentException, IOException{
			Document doc = null;
			OutputStream os = null;
		try{	
				try {
				doc = new Document(PageSize.A4, 72, 72, 72, 72); ////cria o documento tamanho A4, margens de 2,54cm
				os = new FileOutputStream("./persistences/Relat�rio Consolidado Saras.pdf");////cria a stream de sa�da
				PdfWriter.getInstance(doc, os); //	//associa a stream de sa�da ao
				
				doc.open(); //	//abre o documento
				
				Paragraph emiss�o = new Paragraph("Emitido em:"+ FormataData.data +" - "+FormataData.hora);//	//adiciona o texto ao PDF
				emiss�o.setAlignment(Element.ALIGN_RIGHT);
				doc.add(emiss�o);
				
				Paragraph pagina = new Paragraph("P�gina: 1 de 1" );//	//adiciona o texto ao PDF
				pagina.setAlignment(Element.ALIGN_RIGHT);
				doc.add(pagina);
				
				

				Paragraph data = new Paragraph("___________________________________________________________________");//	//adiciona o texto ao PDF
				data.setAlignment(Element.ALIGN_CENTER);
				doc.add(data);
			
				Image img = Image.getInstance(Relatorio.class.getResource("/Imagens/Saras.png"));
				img.setAlignment(Element.ALIGN_CENTER);
				doc.add(img);
				//cria��o de paragrafo
	
				Paragraph p1 = new Paragraph("Sistema de Automa��o de Registro de Atendimento Simples",FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLDITALIC) );//	//adiciona o texto ao PDF
				p1.setAlignment(Element.ALIGN_CENTER);
				p1.setSpacingAfter(20);
				doc.add(p1);
				// cria��o de tabela
				PdfPTable table = new PdfPTable(2);
				PdfPCell header = new PdfPCell(new Paragraph("Relat�rio consolidado",FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD) ));
				header.setColspan(2);
				table.addCell(header);	
				Paragraph p3 =new Paragraph("TIPOS:",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)); 
				table.addCell(p3 );
				Paragraph p4 =new Paragraph("QUANTIDADE:",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD));
				table.addCell(p4);
				table.addCell("Telefone");
				table.addCell("null");
				table.addCell("Acesso Remoto");
				table.addCell("null");
				table.addCell("Chamados do dia");
				table.addCell("null");
				table.addCell("Loca do Sistema");
				table.addCell("null");
				table.addCell("Usu�rio de maior Intera��o");
				table.addCell("null");
				doc.add(table);
				} finally {
					if (doc != null) {
						//fechamento do documento
						doc.close();
					}if (os != null) {
						//fechamento da stream de sa�da
						 os.close();
					 }
			  }
		}catch (FileNotFoundException e) {
						 JOptionPane.showMessageDialog(null, "O arquivo est� sendo executado em outro processo");
					}
			}
			
			
			
			public String geraMes(){
				Date data = new Date();
			    Calendar c = Calendar.getInstance();
			    c.setTime(data);
			    // formata e exibe a data e hora
			    Format format = new SimpleDateFormat("dd-MM-yyyy"); //yyyy-MM-dd
			    String mes = format.format(c.getTime());
			    
			    return mes;
			}
			public String geraHora(){
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
				String dataFormatada = sdf.format(hora);
			    return dataFormatada;
			}
			public void abrePDF() throws IOException, InterruptedException{
				java.awt.Desktop.getDesktop().open( new File( "Relat�rio Consolidado Saras.pdf" ) );
			}
			
			
			public int getContFone() {
				return contFone;
			}

			public int getContRemoto() {
				return contRemoto;
			}

			public int getContChamadosDia() {
				return contChamadosDia;
			}

			public int getContUsuarioMInterecao() {
				return contUsuarioMInterecao;
			}

			public int getContLocalSistema() {
				return contLocalSistema;
			}

			public String getUsuarioMInterecao() {
				return usuarioMInterecao;
			}

			public String getLocalSistema() {
				return localSistema;
			}



		public void quantFone() throws FileNotFoundException, IOException{
			chamadoController =new ChamadoController();
			List<Chamado> listaChamado= chamadoController.todosChamados();
			for(int i=0; i<listaChamado.size();i++){
				if(listaChamado.get(i).eFone()){
					this.contFone++;
				}
			}
			
		}
		public void quantAcessoRemoto() throws FileNotFoundException, IOException{
			chamadoController = new ChamadoController();
			List<Chamado> listaChamado= chamadoController.todosChamados();
			for(int i=0; i<listaChamado.size();i++){
				if(listaChamado.get(i).eRemoto()){
					this.contRemoto++;
				}
			}
			
		}
		public void quantChamadoDia() throws FileNotFoundException, IOException{
			chamadoController = new ChamadoController();
			List<Chamado> listaChamado= chamadoController.todosChamados();
			for(int i=0; i<listaChamado.size();i++){
				if(listaChamado.get(i).getDataAbertura().equals(FormataData.data)){
					this.contChamadosDia++;
					
				}
			}
			
		}
		public void quantUsuarioMaiorInteracao(){
			//this.usuarioMInterecao= Coloca aqui o usuarui maior interacao;
			//this.contUsuarioMInterecao= Coloca aqui a quantidade de vezes que ele apareceu.
		}
		public void quantLocalSistema() throws FileNotFoundException, IOException{
			chamadoController = new ChamadoController();
			List<Chamado> listaChamado= chamadoController.todosChamados();
			List<String> localChamado = new ArrayList<>();
			for(int l = 0; l < listaChamado.size(); l++){
				localChamado.add(listaChamado.get(l).getLocalChamado());
			}
			String nome = "";
			int maior=0;
			for(int i=0; i<listaChamado.size(); i++){
				int count = Collections.frequency(localChamado, localChamado.get(i));
				if(count>maior){
					maior=count;
					nome= localChamado.get(i);					
					 
				}
				this.localSistema=nome;
				this.contLocalSistema=maior;				
			}
			System.out.println(nome);
		}
}



























