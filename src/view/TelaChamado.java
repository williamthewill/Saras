package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import controller.AtendenteController;
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
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import model.Atendente;
import model.Chamado;
import model.NomesSolicitantes;
import model.RegistroChamado;

public class TelaChamado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldSolicitante;
	private JTextArea textAreaDescricao;
	private JTextField textFieldLinha1;
	private JTextField textFieldLinha2;
	private JCheckBox checkboxFone;
	private JCheckBox checkboxRemoto;
	private JCheckBox checkboxSoftplan;
	private static String descriProblema = "";
	private static String descricaoAtendimento = "";
	private RegistroChamado registroChamado = new RegistroChamado();
	private AtendenteController atendenteController = new AtendenteController();
	private Atendente atendente;

	public void frameTelaChamado(){
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

		JLabel alertaEsof = new JLabel("");
		JLabel lblSalvar = new JLabel("Salvar");

		lblSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (textAreaDescricao.getText() != null && textAreaDescricao.getText().trim().length() > 0
						&& textFieldSolicitante.getText() != null
						&& textFieldSolicitante.getText().trim().length() > 0) {
					boolean eFone = false;
					boolean eRemoto = false;
					if (checkboxFone.isSelected()) {
						eFone = true;
					}
					if (checkboxRemoto.isSelected()) {
						eRemoto = true;
					}
					
					String descricaoSolicitante = textAreaDescricao.getText().replaceAll("\n", " /# ");
					if(eRemoto){
						descricaoSolicitante += "/#"+"Este atendimento teve interação via acesso remoto.";
					}
					
					if(eFone){
						descricaoSolicitante = "Este atendimento teve interação via telefone, referente a: /#"+descricaoSolicitante;
					}
					
					if (!checkboxSoftplan.isSelected()) {
						Chamado chamado = new Chamado(textFieldSolicitante.getText(), descricaoSolicitante,
								false, eRemoto, eFone, descriProblema);
						registroChamado.salvaLocalmente(chamado);

						textAreaDescricao.setText("");
						textFieldSolicitante.setText("");
					}
					
					if (descriProblema != "") {

						descricaoSolicitante = textAreaDescricao.getText().replaceAll("\n", " /# ");
						if(eRemoto){
							descricaoSolicitante += "/#"+"Este atendimento teve interação via acesso remoto.";
						}
						
						if(eFone){
							descricaoSolicitante = "Este atendimento teve interação via telefone, referente a: /#"+descricaoSolicitante;
						}

						descriProblema = textAreaDescricao.getText();
						Chamado chamado = new Chamado(textFieldSolicitante.getText(), descricaoSolicitante, true,
								eRemoto, eFone, descriProblema.replaceAll("\n", " /# "));
						

						registroChamado.salvaLocalmente(chamado);
						try {
							atendente = new AtendenteController().recuperaAtendente();

							registroChamado.cadastraChamado(chamado, atendente);
							checkboxSoftplan.setSelected(false);
							registroChamado.notificaExito();
						} catch (IOException | InterruptedException e) {
							e.printStackTrace();
						}
						descriProblema = "";
						textAreaDescricao.setText("");
						textFieldSolicitante.setText("");

					}

					if (checkboxSoftplan.isSelected()) {
						descricaoAtendimento = textAreaDescricao.getText();
						descriProblema = "soft";
						JOptionPane.showMessageDialog(null,
								"Agora descreva o problema a ser enviado para Softplan \nATENÇÃO: após clicar em salva o seu chamado vai ser cadastrado.");
						alertaEsof.setText("");
						textAreaDescricao.setText(
								"Nº SIG:                        Nº SAJ: \n\nProblema: \n\nSegue evidências em anexo para melhor compreensão.\nSolicitação: \n");
					}

					checkboxFone.setSelected(false);
					checkboxRemoto.setSelected(false);
				} else {
					JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
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
		lblNewLabel.setIcon(new ImageIcon("./imagens/salvar.png"));
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
		label.setIcon(new ImageIcon("./imagens/Limpar.png"));
		label.setBounds(25, 133, 40, 47);
		panelPainel.add(label);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("./imagens/cadastrar2.PNG"));
		label_2.setBounds(25, 271, 40, 47);
		panelPainel.add(label_2);

		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					registroChamado.cadastraChamados(atendenteController.recuperaAtendente());
					registroChamado.notificaExito();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
		lblCadastrar.setBounds(71, 287, 72, 21);
		panelPainel.add(lblCadastrar);

		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
		});
		label_7.setIcon(new ImageIcon("./imagens/relatorio.png"));
		label_7.setBounds(25, 201, 40, 47);
		panelPainel.add(label_7);

		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaRelatorio frame = new TelaRelatorio();
							frame.frameTelaRelatório();
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
		lblRelatrio.setBounds(71, 228, 72, 20);
		panelPainel.add(lblRelatrio);

		textFieldLinha1 = new JTextField();
		textFieldLinha1.setToolTipText("");
		// cria um listener de ouvinte de digição do fieldNumero
		textFieldLinha1.addKeyListener(new java.awt.event.KeyAdapter() {
			// cri um ouvinte para cada tecla precionada
			public void keyReleased(java.awt.event.KeyEvent evt) {
				// faz com que pegue a cada tecla digitada, e substituir tudo
				// que não seja numero por ""
				textFieldLinha1.setText(textFieldLinha1.getText().replaceAll("[^0-9]", ""));
			}
		});

		textFieldLinha1.setVisible(false);
		textFieldLinha1.setForeground(Color.WHITE);
		textFieldLinha1.setBackground(new Color(0, 0, 51));
		textFieldLinha1.setBounds(4, 336, 24, 20);
		panelPainel.add(textFieldLinha1);
		textFieldLinha1.setColumns(10);
		textFieldLinha2 = new JTextField();
		// cria um listener de digitação do fieldNumero
		textFieldLinha2.addKeyListener(new java.awt.event.KeyAdapter() {
			// cria um ouvunte para cada tecla precionada
			public void keyReleased(java.awt.event.KeyEvent evt) {
				// faz com que pegue o texto a cada tecla digitada, e substituir
				// tudo que não seja numero por "" // com
				textFieldLinha2.setText(textFieldLinha2.getText().replaceAll("[^0-9]", ""));
			}
		});

		textFieldLinha2.setVisible(false);
		textFieldLinha2.setForeground(Color.WHITE);
		textFieldLinha2.setBackground(new Color(0, 0, 51));
		textFieldLinha2.setColumns(10);
		textFieldLinha2.setBounds(30, 336, 24, 20);
		panelPainel.add(textFieldLinha2);

		JCheckBox chackBoxDefLinha = new JCheckBox("Def.Linha");
		chackBoxDefLinha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chackBoxDefLinha.isSelected()) {
					textFieldLinha1.setVisible(true);
					textFieldLinha2.setVisible(true);

				} else {
					textFieldLinha1.setVisible(false);
					textFieldLinha2.setVisible(false);
				}
			}
		});
		chackBoxDefLinha.setFont(new Font("Tahoma", Font.BOLD, 13));
		chackBoxDefLinha.setForeground(Color.WHITE);
		chackBoxDefLinha.setBackground(new Color(30, 144, 255));
		chackBoxDefLinha.setBounds(55, 336, 97, 23);
		panelPainel.add(chackBoxDefLinha);

		checkboxFone = new JCheckBox("Fone");
		checkboxFone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				checkboxFone.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent e) {
				checkboxFone.setForeground(SystemColor.textHighlight);
			}
		});
		checkboxFone.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkboxFone.setForeground(SystemColor.textHighlight);
		checkboxFone.setBackground(Color.WHITE);
		checkboxFone.setBounds(308, 19, 62, 23);
		contentPane.add(checkboxFone);
		checkboxRemoto = new JCheckBox("Remoto");
		checkboxRemoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				checkboxRemoto.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent e) {
				checkboxRemoto.setForeground(SystemColor.textHighlight);
			}
		});
		checkboxRemoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkboxRemoto.setForeground(SystemColor.textHighlight);
		checkboxRemoto.setBackground(Color.WHITE);
		checkboxRemoto.setBounds(390, 19, 88, 23);
		contentPane.add(checkboxRemoto);

		checkboxSoftplan = new JCheckBox("Softplan");
		checkboxSoftplan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkboxSoftplan.isSelected()) {
					alertaEsof.setText("Cole ou descreva o seu atendimento!");
				} else {
					alertaEsof.setText("");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				checkboxSoftplan.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent e) {
				checkboxSoftplan.setForeground(SystemColor.textHighlight);
			}
		});
		checkboxSoftplan.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkboxSoftplan.setForeground(SystemColor.textHighlight);
		checkboxSoftplan.setBackground(Color.WHITE);
		checkboxSoftplan.setBounds(480, 19, 88, 23);
		contentPane.add(checkboxSoftplan);

		// aqui criava-se textAreaDescricao
		textAreaDescricao = new JTextArea();
		textAreaDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				if (!checkboxSoftplan.isSelected()) {
					NomesSolicitantes nomesSolicitantes = new NomesSolicitantes();
					try {
						textFieldSolicitante
								.setText(nomesSolicitantes.getNomePortalSolicitante(textAreaDescricao.getText()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		textAreaDescricao.setBackground(Color.WHITE);
		textAreaDescricao.setBounds(189, 60, 500, 361);
		JScrollPane scroall = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroall.setBounds(189, 57, 500, 361);
		contentPane.add(scroall);
		contentPane.add(textAreaDescricao);
		scroall.setViewportView(textAreaDescricao);

		textFieldSolicitante = new JTextField();
		String manual = "-";
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
		lblNewLabel_2.setIcon(new ImageIcon("./imagens/back-icon37.png"));
		lblNewLabel_2.setBounds(610, 526, 40, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblSair = new JLabel("");
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Você realmente deseja sair do SARAS?", "Sair",
						JOptionPane.YES_NO_OPTION);
				if (sair == JOptionPane.YES_OPTION) {
					System.exit(0);
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
		label_4.setIcon(new ImageIcon("./imagens/outArtur.PNG"));
		label_4.setBounds(660, 518, 40, 41);
		contentPane.add(label_4);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(189, 531, 65, 25);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("./imagens/mpsc1.png"));

		JLabel label_6 = new JLabel("");
		label_6.setBounds(266, 531, 40, 25);
		contentPane.add(label_6);
		label_6.setIcon(new ImageIcon("./imagens/LogoUFSC.PNG"));

		JLabel label_5 = new JLabel("");
		label_5.setBounds(304, 531, 81, 25);
		contentPane.add(label_5);
		label_5.setIcon(new ImageIcon("./imagens/Softplan poligra1.png"));

		lblSair.setForeground(SystemColor.textHighlight);
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSair.setBounds(666, 502, 23, 14);
		contentPane.add(lblSair);

		lblVoltar.setForeground(SystemColor.textHighlight);
		lblVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVoltar.setBounds(610, 502, 34, 14);
		contentPane.add(lblVoltar);

		alertaEsof.setFont(new Font("Tahoma", Font.BOLD, 15));
		alertaEsof.setForeground(Color.RED);
		alertaEsof.setBounds(293, 484, 284, 23);
		contentPane.add(alertaEsof);
	}
}
