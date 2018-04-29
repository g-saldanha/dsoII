package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Recursos.Mensagens;
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
		
		setTitle(Mensagens.CARTEIRA_DE_ACOES);
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
		JMenu mnInicio = new JMenu(Mensagens.INICIO);
		jmenuPrincipal.add(mnInicio);
		
		JMenuItem jMenuAbrirCarteira = new JMenuItem(Mensagens.ABRIR_CARTEIRA);
		//Implementando a a��o de clique no menu Abrir Carteira
		jMenuAbrirCarteira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				ControladorPrincipal.getInstance().login();
			}
		});
		mnInicio.add(jMenuAbrirCarteira);
		
		JMenuItem jMenuItemUsuario = new JMenuItem(Mensagens.CADASTRAR_USUARIO);
		jMenuItemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPrincipal.getInstance().abreTelaCadastro();
			}
		});
		mnInicio.add(jMenuItemUsuario);
		
		JMenu mnRelatrios = new JMenu(Mensagens.RELATORIOS);
		jmenuPrincipal.add(mnRelatrios);
		
		JMenuItem jMenuRelGeral = new JMenuItem(Mensagens.GERAL);
		mnRelatrios.add(jMenuRelGeral);
		
		JMenuItem jMenuRelPeriodo = new JMenuItem(Mensagens.POR_PERIODO);
		mnRelatrios.add(jMenuRelPeriodo);
		
		JMenuItem mntmPorAo = new JMenuItem(Mensagens.POR_ACAO);
		mnRelatrios.add(mntmPorAo);
	}

}
