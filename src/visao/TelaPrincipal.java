package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrincipal;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		
		//instanciando a Tela Principal
		
		setTitle("Carteira de A\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		//Instanciando um painel e adicionando ele a tela
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setVisible(false);
		
		//Criando a barra de menu Principal
		JMenuBar jmenuPrincipal = new JMenuBar();
		contentPane.add(jmenuPrincipal, BorderLayout.NORTH);
		
		//Criando os itens de Menu
		JMenu mnInicio = new JMenu("Inicio");
		jmenuPrincipal.add(mnInicio);
		
		JMenuItem jMenuAbrirCarteira = new JMenuItem("Abrir Carteira");
		//Implementando a a��o de clique no menu Abrir Carteira
		jMenuAbrirCarteira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				ControladorPrincipal.getInstance().login();
			}
		});
		mnInicio.add(jMenuAbrirCarteira);
		
		JMenuItem jMenuItemUsuario = new JMenuItem("Cadastrar Usu\u00E1rio");
		jMenuItemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPrincipal.getInstance().abreTelaCadastro();
			}
		});
		mnInicio.add(jMenuItemUsuario);
		
		JMenuItem jMenuItemTransacoes = new JMenuItem("Registrar Transa\u00E7\u00F5es");
		jMenuItemTransacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPrincipal.getInstance().abreTelaCadastraTransacoes();
			}
		});
		mnInicio.add(jMenuItemTransacoes);
		
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
