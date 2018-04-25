package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastraUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField jtfCpf;


	/**
	 * Create the frame.
	 */
	public TelaCadastraUsuario() {
		//instanciando a Tela
		//this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		setBounds(100, 100, 444, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Instanciando os elementos da tela e incluindo no Painel
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(34, 38, 56, 16);
		contentPane.add(lblCpf);
		
		jtfCpf = new JTextField();
		jtfCpf.setBounds(147, 35, 195, 22);
		contentPane.add(jtfCpf);
		jtfCpf.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPrincipal.getInstance().cadastraUsuario(jtfCpf.getText());
			}
		});
		btnSalvar.setBounds(68, 87, 97, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				jtfCpf.setText("");
			}
		});
		btnCancelar.setBounds(245, 87, 97, 25);
		contentPane.add(btnCancelar);
	}
	
	public void mensagemDeCadastro(Boolean cadastrou) {
		if(cadastrou) {
			JOptionPane.showMessageDialog(null, "Usu�rio Cadastrado com sucesso!");
			jtfCpf.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "Ja existe um usu�rio Cadastrado!");
		}
	}
}
