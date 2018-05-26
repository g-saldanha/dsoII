package visao;

import Recursos.Mensagens;
import controlador.ControladorCarteira;
import controlador.ControladorPrincipal;
import modelo.TableModelRelatorios;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
		setBounds(100, 100, 900, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jtableRelatorios = new JTable();
		this.popularCampos();
		jtableRelatorios.setModel(TableModelRelatorios.getInstance());
		JScrollPane jtableRelatoriosPane = new JScrollPane(this.jtableRelatorios);
		jtableRelatoriosPane.setBounds(5, 88, 864, 139);
		jtableRelatorios.setPreferredScrollableViewportSize(new Dimension(500,300));
		jtableRelatorios.setFillsViewportHeight(true);
		jtableRelatorios.setPreferredSize(new Dimension(500,300));
		contentPane.add(jtableRelatoriosPane);
		
		JButton jbtVoltar = new JButton(Mensagens.VOLTAR);
		jbtVoltar.setBounds(334, 368, 97, 25);
		contentPane.add(jbtVoltar);

		jbtVoltar.addActionListener(
				x -> {
					this.setVisible(false);
					ControladorPrincipal.getInstance().abreTelaPrincipal();
				}
		);
	}

	private void popularCampos() {
		ControladorCarteira.popularCamposDaTabelaRelatorios();
	}


}
