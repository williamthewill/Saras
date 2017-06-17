package view;

// Faturar Arthur



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JPasswordField passwordFieldSenha;
	private JLabel lbEntrarLb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("SARAS   Vers\u00E3o: 0.0.1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/Imagens/SarasIco_ne.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/novosHori.png")));
		lblNewLabel.setBounds(0, 0, 632, 164);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/mpsc1.png")));
		label.setBounds(2, 454, 63, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/Softplan poligra1.png")));
		label_1.setBounds(73, 454, 81, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/LogoUFSC.png")));
		label_2.setBounds(163, 440, 34, 40);
		contentPane.add(label_2);
		
		JLabel lblEntrar = new JLabel("");
		lblEntrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/entrar 26.PNG")));
		lbEntrarLb = new JLabel("");
		lblEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*Atendente atendente =new Atendente();
				atendente.setUsuarioRede(textFieldNome.getText());
				char[] chars = passwordFieldSenha.getPassword();  
	            String senhaTextField = String.valueOf(chars);
				atendente.setSenha(senhaTextField);
				
				PersisteAtendente recupera = new PersisteAtendente(atendente);
				Atendente atendentePer = recupera.recuperaAtendente();
				System.out.println("atendente: "+atendente.getUsuarioRede());
				System.out.println("atendentePer: "+atendentePer.getUsuarioRede());
				System.out.println("atendenteSenha: "+atendente.getSenha());
				System.out.println("atendentePerSenha: "+atendentePer.getSenha());
				if(atendente.getUsuarioRede().equals(atendentePer.getUsuarioRede()) && atendente.getSenha().equals(atendentePer.getSenha())){
					JOptionPane.showMessageDialog(null, "Tela de cadastro");*/
					
					
					
					//chama entra na tela de cadastro se bater usuario e senha
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								TelaChamado frame = new TelaChamado();
								frame.setLocationRelativeTo(null);		
								frame.setBounds(100, 100, 709, 585);
								frame.setLocationRelativeTo(null);
								frame.setResizable(false);
						
								frame.setSize(709, 585
										);
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
								frame.setResizable(false);
								dispose();
								
		
							} catch (Exception e) {          
								e.printStackTrace();
							}
						}
					});
					//---------------------------------------------------------------
				
				
				
				//}
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				lbEntrarLb.setText("Entrar");
				
			}
			public void mouseExited(MouseEvent e) {
				lbEntrarLb.setText("");
			}
		});
		lblEntrar.setForeground(SystemColor.textHighlight);
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEntrar.setBounds(502, 441, 40, 37);
		contentPane.add(lblEntrar);
		
		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/outArtur.PNG")));
		JLabel lblSairLbl = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane sair = new JOptionPane();
		        int Sair = sair.showConfirmDialog(null,"Realmente você deseja sair do SARAS?","Sair",JOptionPane.YES_NO_OPTION);
		        if(Sair == JOptionPane.YES_OPTION){
		           System.exit(0);
		           // this.dispose();
		     	}else{
		         if(Sair == JOptionPane.NO_OPTION){

		         }
		      }
			}
			
			public void mouseEntered(MouseEvent arg0) {
				lblSairLbl.setText("Sair");
				
			}
			public void mouseExited(MouseEvent e) {
				lblSairLbl.setText("");
			}
		});
		lblSair.setForeground(SystemColor.textHighlight);
		lblSair.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSair.setBounds(597, 440, 40, 40);
		contentPane.add(lblSair);
		
		JLabel lblCadastrar = new JLabel("");
		lblCadastrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/login26.png")));
		JLabel lblCadastrese = new JLabel("");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaAutoCadastro frame = new TelaAutoCadastro();
							frame.setLocationRelativeTo(null);		
							frame.setBounds(100, 100, 643, 510);
						
							frame.setSize(643, 510);
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
				lblCadastrese.setText("Cadastre-se");
				
			}
			public void mouseExited(MouseEvent e) {
				lblCadastrese.setText("");
			}
		});
		lblCadastrar.setForeground(SystemColor.textHighlight);
		lblCadastrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCadastrar.setBounds(552, 440, 35, 40);
		contentPane.add(lblCadastrar);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/Saras_menor.png")));
		label_3.setBounds(238, 162, 157, 99);
		contentPane.add(label_3);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNome.setBounds(259, 269, 190, 26);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(259, 316, 190, 26);
		contentPane.add(passwordFieldSenha);
		
		JLabel label_4 = new JLabel("Usu\u00E1rio:");
		label_4.setForeground(SystemColor.textHighlight);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(186, 269, 63, 20);
		contentPane.add(label_4);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(SystemColor.textHighlight);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(186, 317, 63, 20);
		contentPane.add(lblSenha);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(250, 262, 14, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(250, 307, 14, 14);
		contentPane.add(label_6);
		
		
		
		lbEntrarLb.setForeground(SystemColor.textHighlight);
		lbEntrarLb.setBackground(SystemColor.textHighlight);
		lbEntrarLb.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbEntrarLb.setBounds(496, 429, 46, 14);
		contentPane.add(lbEntrarLb);
		
	
		lblCadastrese.setForeground(SystemColor.textHighlight);
		lblCadastrese.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCadastrese.setBackground(SystemColor.textHighlight);
		lblCadastrese.setBounds(525, 429, 72, 14);
		contentPane.add(lblCadastrese);
		
	
		lblSairLbl.setForeground(SystemColor.textHighlight);
		lblSairLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSairLbl.setBackground(SystemColor.textHighlight);
		lblSairLbl.setBounds(597, 429, 34, 14);
		contentPane.add(lblSairLbl);
	}
}
