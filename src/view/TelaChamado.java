package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ChamadoController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import model.RegistroChamado;

public class TelaChamado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSolicitante;
	private JTextArea textAreaDescricao;
	private JTextField textFieldLinha1;
	private JTextField textFieldLinha2;
	JCheckBox checkBoxFone;
	JCheckBox chckbxRemoto;
	JCheckBox chckbxSoftplan;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaChamado frame = new TelaChamado();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaChamado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 585);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPainel = new JPanel();
		panelPainel.setBounds(0, 0, 179, 556);
		panelPainel.setBackground(new Color(30, 144, 255));
		contentPane.add(panelPainel);
		panelPainel.setLayout(null);
		
		JLabel lblSalvar = new JLabel("Salvar");
	
		lblSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Artur Engenheiro");

				if (checkBoxFone.isSelected()){
					//a��o
				}
	
				if (chckbxRemoto.isSelected()){
					//a��o
				}
				
				if (chckbxSoftplan.isSelected()){
					//a��o
				}
								
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSalvar.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e) {
				lblSalvar.setForeground(Color.white);
			}
		});
		lblSalvar.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		lblSalvar.setForeground(SystemColor.window);
		lblSalvar.setBounds(74, 86, 57, 29);
		panelPainel.add(lblSalvar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/salvar.png")));
		lblNewLabel.setBounds(25, 68, 40, 40);
		panelPainel.add(lblNewLabel);
		
		JLabel lblLimpar = new JLabel("Limpar");
		lblLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textAreaDescricao.setText("");
				textFieldSolicitante.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLimpar.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e) {
				lblLimpar.setForeground(Color.white);
			}
		});
		lblLimpar.setForeground(Color.WHITE);
		lblLimpar.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		lblLimpar.setBounds(74, 157, 69, 21);
		panelPainel.add(lblLimpar);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			
		});
		label.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/Limpar.png")));
		label.setBounds(25, 133, 40, 47);
		panelPainel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
		});
		label_1.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/Execel.PNG")));
		label_1.setBounds(25, 202, 40, 47);
		panelPainel.add(label_1);
		
		JLabel lblPlanilha = new JLabel("Planilha");
		lblPlanilha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPlanilha.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e) {
				lblPlanilha.setForeground(Color.white);
			}
		});
		lblPlanilha.setForeground(Color.WHITE);
		lblPlanilha.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		lblPlanilha.setBounds(74, 220, 69, 21);
		panelPainel.add(lblPlanilha);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/cadastrar2.PNG")));
		label_2.setBounds(21, 318, 40, 47);
		panelPainel.add(label_2);
		
		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCadastrar.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e) {
				lblCadastrar.setForeground(Color.white);
			}
		});
		lblCadastrar.setForeground(Color.WHITE);
		lblCadastrar.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		lblCadastrar.setBounds(74, 336, 72, 21);
		panelPainel.add(lblCadastrar);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
		});
		label_7.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/relatorio.png")));
		label_7.setBounds(22, 260, 40, 47);
		panelPainel.add(label_7);
		
		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaRelatorio frame = new TelaRelatorio();
							frame.setLocationRelativeTo(null);		
							frame.setBounds(100, 100, 635, 468);
							frame.setLocationRelativeTo(null);
							frame.setResizable(false);
							frame.setSize(635, 468);
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
			
			
			
			public void mouseEntered(MouseEvent e) {
				lblRelatrio.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e) {
				lblRelatrio.setForeground(Color.white);
			}
		});
		lblRelatrio.setForeground(Color.WHITE);
		lblRelatrio.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		lblRelatrio.setBounds(74, 279, 72, 20);
		panelPainel.add(lblRelatrio);
		
		textFieldLinha1 = new JTextField();
		textFieldLinha1.setToolTipText("");
		textFieldLinha1.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digita��o do fieldNumero
            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada
            	textFieldLinha1.setText(textFieldLinha1.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que n�o(^) seja numero  por ""
		    }
		});
	
		textFieldLinha1.setVisible(false);
		
		textFieldLinha1.setForeground(Color.WHITE);
		textFieldLinha1.setBackground(new Color(0, 0, 51));
		textFieldLinha1.setBounds(6, 387, 24, 20);
		panelPainel.add(textFieldLinha1);
		textFieldLinha1.setColumns(10);
		
		textFieldLinha2 = new JTextField();
		textFieldLinha2.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digita��o do fieldNumero
            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada
            	textFieldLinha2.setText(textFieldLinha2.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que n�o(^) seja numero  por ""
		    }
		});
		
		
		
		textFieldLinha2.setVisible(false);
		textFieldLinha2.setForeground(Color.WHITE);
		textFieldLinha2.setBackground(new Color(0, 0, 51));
		textFieldLinha2.setColumns(10);
		textFieldLinha2.setBounds(32, 387, 24, 20);
		panelPainel.add(textFieldLinha2);
		
		JCheckBox chackBoxDefLinha = new JCheckBox("Def.Linha");
		chackBoxDefLinha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(chackBoxDefLinha.isSelected()){
					textFieldLinha1.setVisible(true);
					textFieldLinha2.setVisible(true);
					
				}else{
					textFieldLinha1.setVisible(false);
					textFieldLinha2.setVisible(false);
				}
			}
		});
		chackBoxDefLinha.setFont(new Font("Tahoma", Font.BOLD, 13));
		chackBoxDefLinha.setForeground(Color.WHITE);
		chackBoxDefLinha.setBackground(new Color(30, 144, 255));
		chackBoxDefLinha.setBounds(54, 385, 97, 23);
		panelPainel.add(chackBoxDefLinha);
	
		
		checkBoxFone = new JCheckBox("Fone");
		checkBoxFone.addMouseListener(new MouseAdapter() {
						@Override
			public void mouseClicked(MouseEvent e) {	
			}
						@Override
			public void mouseEntered(MouseEvent arg0) {
				checkBoxFone.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				checkBoxFone.setForeground(SystemColor.textHighlight);
			}
			

		});
		checkBoxFone.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBoxFone.setForeground(SystemColor.textHighlight);
		checkBoxFone.setBackground(Color.WHITE);
		checkBoxFone.setBounds(308, 19, 62, 23);
		contentPane.add(checkBoxFone);
		
		
		chckbxRemoto = new JCheckBox("Remoto");
		chckbxRemoto.addMouseListener(new MouseAdapter() {
					@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
					
					@Override
			public void mouseEntered(MouseEvent arg0) {
				chckbxRemoto.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				chckbxRemoto.setForeground(SystemColor.textHighlight);
			}
			
			
			
	
			
		});
		chckbxRemoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxRemoto.setForeground(SystemColor.textHighlight);
		chckbxRemoto.setBackground(Color.WHITE);
		chckbxRemoto.setBounds(390, 19, 88, 23);
		contentPane.add(chckbxRemoto);
		
		
		
		
		chckbxSoftplan = new JCheckBox("Softplan");
		chckbxSoftplan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				chckbxSoftplan.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				chckbxSoftplan.setForeground(SystemColor.textHighlight);
			}
		});
		chckbxSoftplan.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxSoftplan.setForeground(SystemColor.textHighlight);
		chckbxSoftplan.setBackground(Color.WHITE);
		chckbxSoftplan.setBounds(480, 19, 88, 23);
		contentPane.add(chckbxSoftplan);
		
		//aqui criava-se textAreaDescricao
		textAreaDescricao = new JTextArea();
		textAreaDescricao.addKeyListener(new java.awt.event.KeyAdapter() { // terminar metodo, ver no trelo?????????????????????????????????????????????????????????????w
            public void keyReleased(java.awt.event.KeyEvent evt) {
            if(!chckbxSoftplan.isSelected()){
            	RegistroChamado registroChamado= new RegistroChamado();
            	
            	try {
					if(registroChamado.contemNomeSolicitante(textAreaDescricao.getText())){
						textFieldSolicitante.setText(registroChamado.getNomeSolicitante());						
					}					
				} catch (IOException | URISyntaxException e ) {
					e.printStackTrace();
				} 
            	// Adirlana Teixeira da Silva
            	}
		    }
		});
		
		textAreaDescricao.setBackground(Color.WHITE);
		textAreaDescricao.setBounds(189, 60, 500, 361);
				//JScrollPane scroall = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scroall.setBounds(189, 57, 500, 361);
		//contentPane.add(scroall);
		contentPane.add(textAreaDescricao);
		//scroall.setViewportView(textAreaDescricao);
		
		
		textFieldSolicitante = new JTextField();
		String manual="-";
		textFieldSolicitante.setText(manual);
		textFieldSolicitante.setBounds(189, 445, 500, 28);
		contentPane.add(textFieldSolicitante);
		textFieldSolicitante.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setForeground(SystemColor.textHighlight);
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescrio.setBounds(189, 42, 62, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblSolicitante = new JLabel("Solicitante:");
		lblSolicitante.setForeground(SystemColor.textHighlight);
		lblSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSolicitante.setBounds(189, 431, 72, 14);
		contentPane.add(lblSolicitante);
		
		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(687, 46, 13, 10);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(687, 432, 13, 10);
		contentPane.add(label_3);
		JLabel lblVoltar = new JLabel("");
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaLogin frame = new TelaLogin();
							frame.setLocationRelativeTo(null);		
							frame.setBounds(100, 100, 638, 506);
							frame.setLocationRelativeTo(null);
							frame.setResizable(false);
							frame.setSize(638, 506);
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
				lblVoltar.setText("Voltar");
			}
			public void mouseExited(MouseEvent e) {
				lblVoltar.setText("");
			}
			
		});
		lblNewLabel_2.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/back-icon37.png")));
		lblNewLabel_2.setBounds(610, 526, 40, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblSair = new JLabel("");
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				JOptionPane sair = new JOptionPane();
		        int Sair = sair.showConfirmDialog(null,"Realmente voc� deseja sair do SARAS?","Sair",JOptionPane.YES_NO_OPTION);
		        if(Sair == JOptionPane.YES_OPTION){
		           System.exit(0);
		           // this.dispose();
		     	}else{
		         if(Sair == JOptionPane.NO_OPTION){

		         }
		      }
			}
			
			public void mouseEntered(MouseEvent arg0) {
				lblSair.setText("Sair");
			}
			public void mouseExited(MouseEvent e) {
				lblSair.setText("");
			}
		});
		label_4.setBackground(SystemColor.inactiveCaption);
		label_4.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/outArtur.PNG")));
		label_4.setBounds(660, 518, 40, 41);
		contentPane.add(label_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(189, 531, 65, 25);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/mpsc1.png")));
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(266, 531, 40, 25);
		contentPane.add(label_6);
		label_6.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/LogoUFSC.PNG")));
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(304, 531, 81, 25);
		contentPane.add(label_5);
		label_5.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/Softplan poligra1.png")));
		
		
		lblSair.setForeground(SystemColor.textHighlight);
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSair.setBounds(666, 502, 23, 14);
		contentPane.add(lblSair);
		
		
		lblVoltar.setForeground(SystemColor.textHighlight);
		lblVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVoltar.setBounds(610, 502, 34, 14);
		contentPane.add(lblVoltar);
		
		
	}
}
