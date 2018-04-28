package controlador;

import javax.swing.JOptionPane;

import com.sun.corba.se.spi.orbutil.fsm.State;

import Recursos.Mensagens;
import visao.*;

public class ControladorPrincipal {
	
	private static ControladorPrincipal instance;
	private TelaPrincipal telaPrincipal;
	private TelaLogin telaLogin;
	private TelaCadastraUsuario telaCadastraUsuario;
	private TelaCadastraTransacoes telaCadastraTransacoes;
	
	
	private ControladorPrincipal() {
		
		this.telaPrincipal = new TelaPrincipal();
		this.telaLogin = new TelaLogin();
		this.telaCadastraUsuario = new TelaCadastraUsuario();
		this.telaCadastraTransacoes = new TelaCadastraTransacoes();
		this.centralizaTelas();
		
	}
	
	public static ControladorPrincipal getInstance() {
		if(instance == null) {
			return instance = new ControladorPrincipal();
		}else {
			return instance;
		}
		
	}
	
	//Centraliza as Telas
	private void centralizaTelas() {
		telaPrincipal.setLocationRelativeTo(null);
		telaLogin.setLocationRelativeTo(null);
		telaCadastraUsuario.setLocationRelativeTo(null);
		telaCadastraTransacoes.setLocationRelativeTo(null);
	}
	//Abre a Tela Inicial
	public void abreTelaPrincipal() {		
		telaPrincipal.setVisible(true);
	}

	//Abre Tela de Login
	public void login() {
		telaLogin.setVisible(true);		
	}

	public void abreTelaCadastro() {
		telaCadastraUsuario.setVisible(true);		
	}
	
	public void carregaUsuario(String text) {
			if(ControladorCarteira.getInstanceCarteira().carregaUsuario(text)) {
				JOptionPane.showMessageDialog(null, Mensagens.USUARIO_CARREGADO);
				telaLogin.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, Mensagens.USUARIO_NÃO_ENCONTRADO);
			}				
	}

	public void cadastraUsuario(String text) {
		if(ControladorCarteira.getInstanceCarteira().cadastrarCarteira(text)) {
			JOptionPane.showMessageDialog(null, Mensagens.USUARIO_CADASTRADO); 
			telaCadastraUsuario.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, Mensagens.USUARIO_EXISTENTE); 
		}	
		
	}

	public void abreTelaCadastraTransacoes() {
		telaCadastraTransacoes.setVisible(true);
		
	}

}
