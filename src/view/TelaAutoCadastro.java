package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Toolkit;
import model.*;
import view.TelaLogin;
import controller.CadastroAtendente;

public class TelaAutoCadastro extends JFrame {

	private static final long serialVersionUID = 4804405991557711595L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldSenha;
	private Atendente atendente = new Atendente();
	private CadastroAtendente cadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAutoCadastro frame = new TelaAutoCadastro();
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
	public TelaAutoCadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagens/SarasIco_ne.png"));
		setBackground(SystemColor.textHighlight);
		setTitle("SARAS   Vers\u00E3o: 0.0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 519);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabelSOFTNovos = new JLabel("");
		lblNewLabelSOFTNovos.setIcon(new ImageIcon("./imagens/novosHori.png"));
		lblNewLabelSOFTNovos.setBounds(0, 0, 637, 202);
		contentPane.add(lblNewLabelSOFTNovos);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldUsuario.setBounds(257, 263, 180, 26);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		JLabel lblCadastreOMesmo = new JLabel("Cadastre o mesmo usu\u00E1rio e senha Iguais do SOS");
		lblCadastreOMesmo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCadastreOMesmo.setForeground(SystemColor.textHighlight);
		lblCadastreOMesmo.setBounds(111, 203, 434, 33);
		contentPane.add(lblCadastreOMesmo);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(184, 264, 63, 20);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(SystemColor.textHighlight);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(186, 312, 63, 20);
		contentPane.add(lblSenha);

		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(245, 298, 14, 14);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(245, 254, 14, 14);
		contentPane.add(label);

		textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(257, 311, 180, 26);
		contentPane.add(textFieldSenha);

		JLabel lblSalvar = new JLabel("");
		lblSalvar.setIcon(new ImageIcon("./imagens/salvar26.png"));
		JLabel lblSAlvarlbl = new JLabel("");

		lblSalvar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {

				if (textFieldUsuario.getText() != null && textFieldUsuario.getText().trim().length() > 0
						&& textFieldUsuario.getText() != null && textFieldSenha.getText().trim().length() > 0) {

					try {
						atendente.setUsuarioRede(textFieldUsuario.getText());
						char[] chars = textFieldSenha.getPassword();
						String senha = String.valueOf(chars);
						atendente.setSenha(senha);

						cadastro = new CadastroAtendente(atendente);
						cadastro.validaUsuarioPortal();

					} catch (IOException | InterruptedException e1) {
						JOptionPane.showMessageDialog(null, ("Login não encontrado no portal MPSC"));
					}

				} else {
					JOptionPane.showMessageDialog(null, "Existe algum campo em branco, por favor preencha");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				lblSAlvarlbl.setText("Salvar");
			}

			public void mouseExited(MouseEvent e) {
				lblSAlvarlbl.setText("");
			}
		});

		lblSalvar.setForeground(SystemColor.textHighlight);
		lblSalvar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSalvar.setBounds(510, 447, 34, 26);
		contentPane.add(lblSalvar);

		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon("./imagens/outArtur.PNG"));
		JLabel lblSair_1lbl = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int sair = JOptionPane.showConfirmDialog(null, "Realmente você deseja sair do SARAS?", "Sair",
						JOptionPane.YES_NO_OPTION);
				if (sair == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					if (sair == JOptionPane.NO_OPTION) {

					}
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				lblSair_1lbl.setText("Sair");

			}

			public void mouseExited(MouseEvent e) {
				lblSair_1lbl.setText("");
			}

		});
		lblSair.setForeground(SystemColor.textHighlight);
		lblSair.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSair.setBounds(593, 447, 34, 26);
		contentPane.add(lblSair);

		JLabel label_1 = new JLabel("!");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(537, 206, 14, 26);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("./imagens/mpsc1.png"));
		label_2.setBounds(2, 455, 63, 20);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("./imagens/Softplan poligra1.png"));
		label_3.setBounds(75, 455, 76, 20);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("./imagens/LogoUFSC.PNG"));
		label_4.setBounds(171, 447, 34, 33);
		contentPane.add(label_4);

		JLabel label_Voltar = new JLabel("");
		JLabel lblVoltarlbl = new JLabel("");
		label_Voltar.addMouseListener(new MouseAdapter() {
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
				lblVoltarlbl.setText("Voltar");
			}

			public void mouseExited(MouseEvent e) {
				lblVoltarlbl.setText("");
			}
		});
		label_Voltar.setIcon(new ImageIcon("./imagens/back-icon37.png"));
		label_Voltar.setForeground(SystemColor.textHighlight);
		label_Voltar.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_Voltar.setBounds(549, 447, 34, 26);
		contentPane.add(label_Voltar);

		lblSAlvarlbl.setForeground(SystemColor.textHighlight);
		lblSAlvarlbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSAlvarlbl.setBounds(500, 422, 45, 14);
		contentPane.add(lblSAlvarlbl);

		lblVoltarlbl.setForeground(SystemColor.textHighlight);
		lblVoltarlbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVoltarlbl.setBounds(548, 422, 45, 14);
		contentPane.add(lblVoltarlbl);

		lblSair_1lbl.setForeground(SystemColor.textHighlight);
		lblSair_1lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSair_1lbl.setBounds(593, 422, 34, 14);
		contentPane.add(lblSair_1lbl);
	}

	public static class SalvaAtendente {
		public SalvaAtendente(JTextField textFieldUsuario, JPasswordField textFieldSenha) {

		}
	}

}
