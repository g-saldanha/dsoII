package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Recursos.Mensagens;
import javax.swing.JTable;
import javax.swing.JButton;

public class TelaRelatorios extends JFrame {

	private JPanel contentPane;
	private JTable jtableRelatorios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorios frame = new TelaRelatorios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRelatorios() {
		setTitle(Mensagens.RELATORIOS);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jtableRelatorios = new JTable();
		jtableRelatorios.setBounds(106, 223, 561, -160);
		contentPane.add(jtableRelatorios);
		
		JButton jbtVoltar = new JButton(Mensagens.VOLTAR);
		jbtVoltar.setBounds(334, 368, 97, 25);
		contentPane.add(jbtVoltar);
	}
}
