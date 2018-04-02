package visão;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastraUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField jtfCpf;
	private JTextField jtfNome;


	/**
	 * Create the frame.
	 */
	public TelaCadastraUsuario() {
		//instanciando a Tela
		//this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Instanciando os elementos da tela e incluindo no Painel
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(34, 38, 56, 16);
		contentPane.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(34, 95, 56, 16);
		contentPane.add(lblNome);
		
		jtfCpf = new JTextField();
		jtfCpf.setBounds(147, 35, 195, 22);
		contentPane.add(jtfCpf);
		jtfCpf.setColumns(10);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(147, 92, 195, 22);
		contentPane.add(jtfNome);
		jtfNome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(68, 174, 97, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(244, 174, 97, 25);
		contentPane.add(btnCancelar);
	}
}
