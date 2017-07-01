package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;

import model.Relatorio;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class TelaRelatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDateInicio;
	private JTextField textFieldDateFim;
	private Relatorio relatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRelatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 468);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 67, 637, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Filtros:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 11, 63, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("In\u00EDcio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 36, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblFim = new JLabel("Fim:");
		lblFim.setForeground(Color.WHITE);
		lblFim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFim.setBounds(10, 60, 46, 14);
		panel.add(lblFim);
		
		textFieldDateInicio = new JTextField("___/___/___");
	
		textFieldDateInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textFieldDateInicio.setForeground(Color.WHITE);
		textFieldDateInicio.setBackground(new Color(30, 144, 255));
		textFieldDateInicio.setBounds(56, 34, 88, 20);
		panel.add(textFieldDateInicio);
		textFieldDateInicio.setColumns(10);
		
		textFieldDateFim = new JTextField();
		textFieldDateFim.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldDateFim.setText("___/___/___");
		textFieldDateFim.setForeground(Color.WHITE);
		textFieldDateFim.setBackground(new Color(30, 144, 255));
		textFieldDateFim.setColumns(10);
		textFieldDateFim.setBounds(56, 58, 88, 20);
		panel.add(textFieldDateFim);
		
		JCheckBox chckbxFone = new JCheckBox(":Fone");
		chckbxFone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				chckbxFone.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				chckbxFone.setForeground(Color.WHITE);
			}
			
		});
		chckbxFone.setBackground(new Color(30, 144, 255));
		chckbxFone.setForeground(Color.WHITE);
		chckbxFone.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxFone.setBounds(150, 33, 81, 23);
		panel.add(chckbxFone);
		
		JCheckBox chckbxremoto = new JCheckBox(":Remoto");
		chckbxremoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				chckbxremoto.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				chckbxremoto.setForeground(Color.WHITE);
			}
			
		});
		chckbxremoto.setForeground(Color.WHITE);
		chckbxremoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxremoto.setBackground(new Color(30, 144, 255));
		chckbxremoto.setBounds(150, 57, 81, 23);
		panel.add(chckbxremoto);
		
		JCheckBox chckbxlocalSistema = new JCheckBox(":Local Sistema");
		chckbxlocalSistema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				chckbxlocalSistema.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				chckbxlocalSistema.setForeground(Color.WHITE);
			}
			
		});
		chckbxlocalSistema.setForeground(Color.WHITE);
		chckbxlocalSistema.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxlocalSistema.setBackground(new Color(30, 144, 255));
		chckbxlocalSistema.setBounds(243, 33, 119, 23);
		panel.add(chckbxlocalSistema);
		
		JCheckBox chckbxchamadosDoDia = new JCheckBox(":Chamados do dia");
		chckbxchamadosDoDia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				chckbxchamadosDoDia.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				chckbxchamadosDoDia.setForeground(Color.WHITE);
			}
			
		});
		chckbxchamadosDoDia.setForeground(Color.WHITE);
		chckbxchamadosDoDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxchamadosDoDia.setBackground(new Color(30, 144, 255));
		chckbxchamadosDoDia.setBounds(243, 57, 139, 23);
		panel.add(chckbxchamadosDoDia);
		
		JCheckBox chckbxusurioMaiorInterao = new JCheckBox(":+Usu\u00E1rio");
		chckbxusurioMaiorInterao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				chckbxusurioMaiorInterao.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				chckbxusurioMaiorInterao.setForeground(Color.WHITE);
			}
			
		});
		
		chckbxusurioMaiorInterao.setForeground(Color.WHITE);
		chckbxusurioMaiorInterao.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxusurioMaiorInterao.setBackground(new Color(30, 144, 255));
		chckbxusurioMaiorInterao.setBounds(375, 33, 119, 23);
		panel.add(chckbxusurioMaiorInterao);
		JLabel lblNewLabel_3 = new JLabel("");
		JLabel lblGerar = new JLabel("");
		JLabel labelTotal = new JLabel("");
		JLabel labelTotalRemoto = new JLabel();
		JLabel labelTotalFone = new JLabel("");
		JLabel labelTotalDodia = new JLabel("");
		JLabel lblLocalSistema = new JLabel("");
		JLabel labelUsuarioMaiorInter = new JLabel("");
		
		lblGerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				relatorio = new Relatorio();
				try {
					relatorio.listaChamado();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if((textFieldDateInicio.getText().equals("___/___/___")||textFieldDateInicio.getText().equals("") && 
						textFieldDateFim.getText().equals("___/___/___") ||textFieldDateInicio.getText().equals("")) && chckbxFone.isSelected( )==false &&
						chckbxremoto.isSelected()==false &&  chckbxlocalSistema.isSelected()==false &&  chckbxchamadosDoDia.isSelected()==false &&
						chckbxusurioMaiorInterao.isSelected()==false) {
							try {
								
								//JOptionPane.showMessageDialog(null, "Sem filtro");
								
								labelTotal.setText(Integer.toString(relatorio.total()));
								labelTotalRemoto.setText(Integer.toString(relatorio.quantAcessoRemoto()));
								labelTotalFone.setText(Integer.toString(relatorio.quantFone()));
								labelTotalDodia.setText(Integer.toString(relatorio.quantChamadoDia()));
								lblLocalSistema.setText(relatorio.quantLocalSistema()[0]+" "+relatorio.quantLocalSistema()[1]); 
								labelUsuarioMaiorInter.setText(relatorio.quantUsuarioMaiorInteracao()[0]+" "+relatorio.quantUsuarioMaiorInteracao()[1]);
								
							
								relatorio.geraRelatorioSemFiltro();
								
								
								
							} catch (DocumentException | IOException e) {
								JOptionPane.showMessageDialog(null, "Aconteceu algo, por gentileza tente novamente");
							}   
				
						}else{
						
							if(relatorio.validaData(textFieldDateInicio.getText(), textFieldDateFim.getText())){
								boolean fone=false;
								boolean remoto=false;
								boolean localSistema=false;
								boolean chamadoDia=false;
								boolean usuarioMaior=true;
								if(chckbxFone.isSelected()){
									fone=true;
								}
								if(chckbxremoto.isSelected()){
									remoto=true;
								}
								if(chckbxlocalSistema.isSelected()){
									localSistema=true;
								}
								if(chckbxchamadosDoDia.isSelected()){
									chamadoDia=true;
								}
								if(chckbxusurioMaiorInterao.isSelected()){
									usuarioMaior=true;
								}
								try {
									
									JOptionPane.showMessageDialog(null, "com filtro");
									
									relatorio.geraRelatorioComFiltro(textFieldDateInicio.getText(), textFieldDateFim.getText(), fone, remoto, localSistema, chamadoDia, usuarioMaior);
								
								
									chckbxFone.setSelected(false);
									chckbxremoto.setSelected(false);
									chckbxchamadosDoDia.setSelected(false);
									chckbxlocalSistema.setSelected(false);
									chckbxusurioMaiorInterao.setSelected(false);
									textFieldDateInicio.setText("___/___/___");
									textFieldDateFim.setText("___/___/___");
								
								} catch (DocumentException | IOException e) {
									JOptionPane.showMessageDialog(null, "Aconteceu algo, por gentileza tente novamente");
								}   
							
							}else{	
								JOptionPane.showMessageDialog(null, "Data inválida");
							}
						}
		
			}
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_3.setText("Gerar");
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setText("");
			}
		});
		lblGerar.setBackground(new Color(230, 230, 250));
		lblGerar.setIcon(new ImageIcon("./imagens/lupa.png"));
		lblGerar.setBounds(546, 22, 46, 50);
		panel.add(lblGerar);
		
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(546, 76, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./imagens/Saras_menor.png"));
		lblNewLabel.setBounds(0, 0, 163, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotalRemoto = new JLabel("Total Remoto:");
		lblTotalRemoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalRemoto.setBounds(10, 196, 91, 14);
		contentPane.add(lblTotalRemoto);
		
		JLabel lblTotalFone = new JLabel("Total Fone:");
		lblTotalFone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalFone.setBounds(10, 219, 71, 14);
		contentPane.add(lblTotalFone);
		
		JLabel lblTotalChamadosDo = new JLabel("Total Chamados do dia:");
		lblTotalChamadosDo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalChamadosDo.setBounds(10, 244, 153, 14);
		contentPane.add(lblTotalChamadosDo);
		
		JLabel lblLocalDoSistema = new JLabel("Local do Sistema:");
		lblLocalDoSistema.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocalDoSistema.setBounds(10, 269, 119, 14);
		contentPane.add(lblLocalDoSistema);
		
		JLabel lblUsurioMaiorInterao = new JLabel("Usu\u00E1rio maior intera\u00E7\u00E3o:");
		lblUsurioMaiorInterao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsurioMaiorInterao.setBounds(10, 294, 163, 14);
		contentPane.add(lblUsurioMaiorInterao);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(Color.RED);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(10, 330, 38, 14);
		contentPane.add(lblTotal);
		JLabel lblNewLabelImprimir = new JLabel("");
		JLabel lblImprimir = new JLabel("");
		lblImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					relatorio.abrePDF();
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao Gerar PDF");
				}
				
				
			}
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabelImprimir.setText("Imprimir");
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabelImprimir.setText("");
			}
			
		});
		lblImprimir.setIcon(new ImageIcon("./imagens/imprimir.PNG"));
		lblImprimir.setBounds(493, 403, 38, 35);
		contentPane.add(lblImprimir);
		JLabel lblVoltarlbl = new JLabel(" ");
		JLabel labelVoltar = new JLabel("");
		labelVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaChamado frame = new TelaChamado();
							frame.setLocationRelativeTo(null);		
							frame.setBounds(100, 100, 718, 585);
							frame.setLocationRelativeTo(null);
							frame.setResizable(false);
							frame.setSize(718, 585);
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							frame.setResizable(false);
							dispose();
							
	
						} catch (Exception e) {          
							e.printStackTrace();
						}
					}
				});
			}
			public void mouseEntered(MouseEvent arg0) {
				lblVoltarlbl.setText("Voltar");
			}
			public void mouseExited(MouseEvent e) {
				lblVoltarlbl.setText("");
			}
			
		});
		labelVoltar.setIcon(new ImageIcon("./imagens/back-icon37.png"));
		labelVoltar.setBounds(541, 403, 38, 35);
		contentPane.add(labelVoltar);
		JLabel lblSairlbl = new JLabel("");
		JLabel labelSair = new JLabel("");
		labelSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int sair = JOptionPane.showConfirmDialog(null,"Realmente você deseja sair do SARAS?","Sair",JOptionPane.YES_NO_OPTION);
		        if(sair == JOptionPane.YES_OPTION){
		           System.exit(0);
		     	}else{
		         if(sair == JOptionPane.NO_OPTION){

		         }
		      }
			}
			public void mouseEntered(MouseEvent arg0) {
				lblSairlbl.setText("Sair");
			}
			public void mouseExited(MouseEvent e) {
				lblSairlbl.setText("");
			}
		});
		labelSair.setIcon(new ImageIcon("./imagens/outXX.png"));
		labelSair.setBounds(589, 403, 38, 35);
		contentPane.add(labelSair);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("./imagens/mpsc1.png"));
		lblNewLabel_4.setBounds(2, 407, 66, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("./imagens/Softplan poligra1.png"));
		label_2.setBounds(70, 409, 81, 26);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("./imagens/LogoUFSC.PNG"));
		label_3.setBounds(162, 403, 38, 35);
		contentPane.add(label_3);
		
		
		labelTotalRemoto.setForeground(Color.RED);
		labelTotalRemoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTotalRemoto.setBounds(107, 197, 273, 14);
		contentPane.add(labelTotalRemoto);
		
		
		labelTotalFone.setForeground(Color.RED);
		labelTotalFone.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTotalFone.setBounds(85, 220, 163, 14);
		contentPane.add(labelTotalFone);
		
		
		labelTotalDodia.setForeground(Color.RED);
		labelTotalDodia.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTotalDodia.setBounds(162, 245, 236, 14);
		contentPane.add(labelTotalDodia);
		
		
		lblLocalSistema.setForeground(Color.RED);
		lblLocalSistema.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocalSistema.setBounds(128, 269, 153, 14);
		contentPane.add(lblLocalSistema);
		
		
		labelUsuarioMaiorInter.setForeground(Color.RED);
		labelUsuarioMaiorInter.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelUsuarioMaiorInter.setBounds(174, 295, 153, 14);
		contentPane.add(labelUsuarioMaiorInter);
		
		
		labelTotal.setForeground(Color.RED);
		labelTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTotal.setBounds(53, 330, 48, 14);
		contentPane.add(labelTotal);
		
		
		lblNewLabelImprimir.setForeground(SystemColor.textHighlight);
		lblNewLabelImprimir.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabelImprimir.setBounds(485, 385, 53, 14);
		contentPane.add(lblNewLabelImprimir);
		
		
		lblVoltarlbl.setForeground(SystemColor.textHighlight);
		lblVoltarlbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVoltarlbl.setBounds(535, 386, 53, 14);
		contentPane.add(lblVoltarlbl);
		
	
		lblSairlbl.setForeground(SystemColor.textHighlight);
		lblSairlbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSairlbl.setBounds(595, 386, 38, 14);
		contentPane.add(lblSairlbl);
	}
}
