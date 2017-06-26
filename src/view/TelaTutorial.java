package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.commons.io.IOUtils;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class TelaTutorial extends JDialog {

	private static final long serialVersionUID = 5222997766277344154L;
	private final JPanel contentPanel = new JPanel();
	
	public static void main(String[] args) {
		try {
			TelaTutorial dialog = new TelaTutorial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public TelaTutorial() {
		setBounds(100, 100, 563, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Seja bem vindo ao SARAS\r\n!");
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(149, 11, 268, 25);
			contentPanel.add(lblNewLabel);
		}
		
		JTextPane txtpnF = new JTextPane();
		txtpnF.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnF.setForeground(SystemColor.textHighlight);
		txtpnF.setText("O SARAS(Sistema de Automa\u00E7\u00E3o de Registro de Atendimento Simples), vai ajudar voc\u00EA a ganhar mais tempo no seu dia-a-dia, automatizando todo o processo de salvamento de atendimentos, gera\u00E7\u00E3o de rel\u00E1tario, gera\u00E7\u00E3o de backup, cadastro de chamados no portal do SOS e envio de chamado para Softplan.");
		txtpnF.setBounds(10, 43, 527, 91);
		contentPanel.add(txtpnF);
		
		JTextPane txtpnVamosComearPrimeiro = new JTextPane();
		txtpnVamosComearPrimeiro.setText("*Vamos come\u00E7ar, primeiro voc\u00EA deve se cadastrar, clique no bot\u00E3o \"Cadastre-se\", do sistema.");
		txtpnVamosComearPrimeiro.setForeground(new Color(0, 0, 102));
		txtpnVamosComearPrimeiro.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnVamosComearPrimeiro.setBounds(10, 137, 527, 41);
		contentPanel.add(txtpnVamosComearPrimeiro);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("./imagens/cadastre-se.png"));
		lblNewLabel_1.setBounds(229, 193, 116, 25);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.textHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Continuar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						txtpnF.setText("*Muito bem, agora na tela de Cadastro insira o mesmo usuario e senha do portal do SOS. Depois clique no botão SALVAR, do sistema.");
						txtpnF.setForeground(new Color(0, 0, 102));
						txtpnF.setFont(new Font("Tahoma", Font.BOLD, 17));
						
						txtpnVamosComearPrimeiro.setText("");
						
						lblNewLabel_1.setIcon(new ImageIcon("./imagens/Salvar.png"));
						
					}
				});
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Sair");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public String lerArqui() throws IOException{
		FileInputStream inputStream = new FileInputStream("sarasTuto.txt");
		String texto="";
	    try {
	    	texto = IOUtils.toString(inputStream);
	       System.out.println(texto);
	    } finally {
	        inputStream.close();
	    }
	    return texto;
	}
	public void escreveArqui(String valor) throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("sarasTuto.txt"));
        String linha = valor;
       
        buffWrite.append(linha + "\n");
        buffWrite.close();
	}	
}