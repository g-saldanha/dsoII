package visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Carteira de A\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar jmenuPrincipal = new JMenuBar();
		contentPane.add(jmenuPrincipal, BorderLayout.NORTH);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		jmenuPrincipal.add(mnCadastrar);
		
		JMenuItem jMenuItemUsuario = new JMenuItem("Usu\u00E1rio");
		mnCadastrar.add(jMenuItemUsuario);
		
		JMenuItem jMenuItemTransacoes = new JMenuItem("Transa\u00E7\u00F5es");
		mnCadastrar.add(jMenuItemTransacoes);
		
		JMenu mnEditar = new JMenu("Editar");
		jmenuPrincipal.add(mnEditar);
		
		JMenuItem jMenuEditarUsuario = new JMenuItem("Usuario");
		mnEditar.add(jMenuEditarUsuario);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		jmenuPrincipal.add(mnRelatrios);
		
		JMenuItem jMenuRelGeral = new JMenuItem("Geral");
		mnRelatrios.add(jMenuRelGeral);
		
		JMenuItem jMenuRelPeriodo = new JMenuItem("Por Per\u00EDodo");
		mnRelatrios.add(jMenuRelPeriodo);
		
		JMenuItem mntmPorAo = new JMenuItem("Por A\u00E7\u00E3o");
		mnRelatrios.add(mntmPorAo);
	}

}
