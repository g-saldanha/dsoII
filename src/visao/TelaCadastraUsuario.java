package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Recursos.Mensagens;
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
	private JTextField jtfSaldoInicial;


	/**
	 * Create the frame.
	 */
	public TelaCadastraUsuario() {
		//instanciando a Tela
		//this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		setBounds(100, 100, 508, 250);
		this.setTitle(Mensagens.CADASTRAR_USUARIO);
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
		
		JButton btnSalvar = new JButton(Mensagens.SALVAR);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPrincipal.getInstance().cadastraUsuario(jtfCpf.getText(), jtfSaldoInicial.getText());
			}
		});
		btnSalvar.setBounds(136, 165, 97, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton(Mensagens.CANCELAR);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				jtfCpf.setText("");
			}
		});
		btnCancelar.setBounds(245, 165, 97, 25);
		contentPane.add(btnCancelar);
		
		JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
		lblSaldoInicial.setBounds(34, 88, 89, 16);
		contentPane.add(lblSaldoInicial);
		
		jtfSaldoInicial = new JTextField();
		jtfSaldoInicial.setBounds(147, 85, 195, 22);
		contentPane.add(jtfSaldoInicial);
		jtfSaldoInicial.setColumns(10);
	}
}
