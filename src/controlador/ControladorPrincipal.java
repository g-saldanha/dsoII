package controlador;

import visao.TelaCadastraTransacoes;
import visao.TelaCadastraUsuario;
import visao.TelaLogin;
import visao.TelaPrincipal;

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
				telaLogin.mensagemDeLogin(true);
				telaLogin.setVisible(false);
			}else {
				telaLogin.mensagemDeLogin(false);
			}				
	}

	public void cadastraUsuario(String text) {
		if(ControladorCarteira.getInstanceCarteira().cadastrarCarteira(text)) {
			telaCadastraUsuario.mensagemDeCadastro(true);
			telaCadastraUsuario.setVisible(false);
		}else {
			telaCadastraUsuario.mensagemDeCadastro(false);
		}	
		
	}

	public void abreTelaCadastraTransacoes() {
		telaCadastraTransacoes.setVisible(true);
		
	}

}
