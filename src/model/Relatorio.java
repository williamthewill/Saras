package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
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
	private List<Chamado> listaChamado;

	private ChamadoController chamadoController;

	// COLOCAR PARAMETROS NO METODO ABAIXO, VER NO DIAGRAMA DE CLASSES
	public void geraRelatorioSemFiltro() throws DocumentException, IOException {
		Document doc = null;
		OutputStream os = null;
		try {

			try {
				doc = new Document(PageSize.A4, 72, 72, 72, 72);
				os = new FileOutputStream("./persistences/Relatório Consolidado Saras.pdf");
				PdfWriter.getInstance(doc, os);
				doc.open();// abre o documento
				Paragraph emissao = new Paragraph("Emitido em:" + FormataData.data + " - " + FormataData.hora);
				emissao.setAlignment(Element.ALIGN_RIGHT);
				doc.add(emissao);
				Paragraph pagina = new Paragraph("Página: 1 de 1");
				pagina.setAlignment(Element.ALIGN_RIGHT);
				doc.add(pagina);
				Paragraph data = new Paragraph("___________________________________________________________________");
				data.setAlignment(Element.ALIGN_CENTER);
				doc.add(data);
				Image img = Image.getInstance("./imagens/Saras.png");
				img.setAlignment(Element.ALIGN_CENTER);
				doc.add(img);
				// criação de paragrafo

				Paragraph p1 = new Paragraph("Sistema de Automação de Registro de Atendimento Simples",
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLDITALIC));
				p1.setAlignment(Element.ALIGN_CENTER);
				p1.setSpacingAfter(20);
				doc.add(p1);
				// criação de tabela
				PdfPTable table = new PdfPTable(2);
				PdfPCell header = new PdfPCell(new Paragraph("Relatório consolidado",
						FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD)));
				header.setColspan(2);
				table.addCell(header);
				Paragraph p3 = new Paragraph("TIPOS:", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD));
				table.addCell(p3);
				Paragraph p4 = new Paragraph("QUANTIDADE:", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD));
				table.addCell(p4);
				table.addCell("Telefone");
				table.addCell(Integer.toString(this.quantFone(true)));
				table.addCell("Acesso Remoto");
				table.addCell(Integer.toString(this.quantAcessoRemoto(true)));
				table.addCell("Chamados do dia");
				table.addCell(Integer.toString(this.quantChamadoDia(true)));
				table.addCell("Loca do Sistema");
				table.addCell(this.quantLocalSistema()[0] + " " + this.quantLocalSistema()[1]);
				table.addCell("Usuário de maior Interação");
				table.addCell(this.quantUsuarioMaiorInteracao()[0] + " " + this.quantUsuarioMaiorInteracao()[1]);
				doc.add(table);
			} finally {
				if (doc != null) {
					doc.close();// fechamento do documento
				}
				if (os != null) {
					os.close(); // fechamento da stream de saída
				}
			}
		} catch (FileNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "O arquivo está sendo executado em outro processo");

		}
	}

	public void geraRelatorioComFiltro(boolean fone, boolean remoto, boolean localSistema, boolean chamadoDia,
			boolean usuarioMaior) throws DocumentException, IOException {
		Document doc = null;
		OutputStream os = null;
		try {

			try {
				doc = new Document(PageSize.A4, 72, 72, 72, 72);
				os = new FileOutputStream("./persistences/Relatório Consolidado Saras.pdf");
				PdfWriter.getInstance(doc, os);
				doc.open();// abre o documento
				Paragraph emissão = new Paragraph("Emitido em:" + FormataData.data + " - " + FormataData.hora);
				emissão.setAlignment(Element.ALIGN_RIGHT);
				doc.add(emissão);
				Paragraph pagina = new Paragraph("Página: 1 de 1");
				pagina.setAlignment(Element.ALIGN_RIGHT);
				doc.add(pagina);
				Paragraph data = new Paragraph("___________________________________________________________________");
				data.setAlignment(Element.ALIGN_CENTER);
				doc.add(data);
				Image img = Image.getInstance("./imagens/Saras.png");
				img.setAlignment(Element.ALIGN_CENTER);
				doc.add(img);
				// criação de paragrafo

				Paragraph p1 = new Paragraph("Sistema de Automação de Registro de Atendimento Simples",
						FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLDITALIC));
				p1.setAlignment(Element.ALIGN_CENTER);
				p1.setSpacingAfter(20);
				doc.add(p1);
				// criação de tabela
				PdfPTable table = new PdfPTable(2);
				PdfPCell header = new PdfPCell(new Paragraph("Relatório consolidado",
						FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD)));
				header.setColspan(2);
				table.addCell(header);
				Paragraph p3 = new Paragraph("TIPOS:", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD));
				table.addCell(p3);
				Paragraph p4 = new Paragraph("QUANTIDADE:", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD));
				table.addCell(p4);
				table.addCell("Telefone");
				if (fone) {
					table.addCell(Integer.toString(this.quantFone(true)));
				} else {
					table.addCell("");
				}
				table.addCell("Acesso Remoto");
				if (remoto) {
					table.addCell(Integer.toString(this.quantAcessoRemoto(true)));
				} else {
					table.addCell("");
				}
				table.addCell("Chamados do dia");
				if (chamadoDia) {
					table.addCell(Integer.toString(this.quantChamadoDia(true)));
				} else {
					table.addCell("");
				}
				table.addCell("Loca do Sistema");
				if (localSistema) {
					table.addCell(this.quantLocalSistema()[0] + " " + this.quantLocalSistema()[1]);
				} else {
					table.addCell("");
				}
				table.addCell("Usuário de maior Interação");
				if (usuarioMaior) {
					table.addCell(this.quantUsuarioMaiorInteracao()[0] + " " + this.quantUsuarioMaiorInteracao()[1]);
				} else {
					table.addCell("");
				}
				doc.add(table);
			} finally {
				if (doc != null) {
					// fechamento do documento
					doc.close();
				}
				if (os != null) {
					// fechamento da stream de saída
					os.close();
				}
			}
		} catch (FileNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "O arquivo está sendo executado em outro processo");
		}
	}

	public String geraMes() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		// formata e exibe a data e hora
		Format format = new SimpleDateFormat("dd-MM-yyyy");
		String mes = format.format(c.getTime());

		return mes;
	}

	public String geraHora() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(hora);
		return dataFormatada;
	}

	public void abrePDF() throws IOException, InterruptedException {
		java.awt.Desktop.getDesktop().open(new File("./persistences/Relatório Consolidado Saras.pdf"));
	}

	public void listaChamado() {
		chamadoController = new ChamadoController();
		try {
			this.listaChamado = chamadoController.todosChamados();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listaChamadoData(String data1, String data2) {
		chamadoController = new ChamadoController();
		try {
			this.listaChamado = chamadoController.chamadosData(data1, data2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int quantFone(boolean fone) {
		if (!fone) {
			return 0;
		}
		try {
			for (int i = 0; i < this.listaChamado.size(); i++) {
				if (listaChamado.get(i).eFone()) {
					this.contFone++;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return this.contFone;
	}

	public int quantAcessoRemoto(boolean remoto) {
		if (!remoto) {
			return 0;
		}

		try {
			for (int i = 0; i < this.listaChamado.size(); i++) {
				if (this.listaChamado.get(i).eRemoto()) {
					this.contRemoto++;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return this.contRemoto;
	}

	public int quantChamadoDia(boolean chamadoDia) {

		if (!chamadoDia) {
			return 0;
		}
		try {
			for (int i = 0; i < this.listaChamado.size(); i++) {
				if (this.listaChamado.get(i).getDataAbertura().equals(FormataData.data)) {
					this.contChamadosDia++;
				}
			}
			return this.contChamadosDia;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}

	public String[] quantUsuarioMaiorInteracao() {
		String[] retorno = new String[2];
		try {
			List<String> usuarioMInteracao = new ArrayList<>();
			for (int i = 0; i < this.listaChamado.size(); i++) {
				usuarioMInteracao.add(this.listaChamado.get(i).getNomeSolicitante());
			}
			String nome = "";
			int maior = 0;
			for (int j = 0; j < this.listaChamado.size(); j++) {
				int count = Collections.frequency(usuarioMInteracao, usuarioMInteracao.get(j));
				if (count > maior) {
					maior = count;
					nome = usuarioMInteracao.get(j);
				}
			}
			retorno[0] = nome;
			retorno[1] = maior + "";
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return retorno;
	}

	public String[] quantLocalSistema() {
		String[] retorno = new String[2];
		try {
			List<String> localChamado = new ArrayList<>();
			for (int i = 0; i < this.listaChamado.size(); i++) {
				localChamado.add(this.listaChamado.get(i).getLocalChamado());
			}
			String nome = "";
			int maior = 0;
			for (int j = 0; j < this.listaChamado.size(); j++) {
				int count = Collections.frequency(localChamado, localChamado.get(j));
				if (count > maior) {
					maior = count;
					nome = localChamado.get(j);
				}
			}
			retorno[0] = nome;
			retorno[1] = maior + "";
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return retorno;
	}

	public boolean validaData(String data1, String data2) {
		DateFormat prototype = new SimpleDateFormat("dd-MM-yyyy");
		prototype.setLenient(false);
		Date dataInici = null;
		Date dataFim = null;
		try {
			dataInici = prototype.parse(data1);
			dataFim = prototype.parse(data2);
		} catch (ParseException e) {
			return false;
		}
		return dataInici.before(dataFim);
	}

	public int total(boolean fone, boolean remoto, boolean localSistema, boolean chamadoDia, boolean usuarioMaior) {
		int total = 0;
		try {

			total = quantAcessoRemoto(remoto) + quantChamadoDia(chamadoDia) + quantFone(chamadoDia);

		} catch (NumberFormatException e) {
			total = -1;
			System.out.println("Erro classe relatorio" + e.getMessage());
			;
		}
		return total;
	}
}
