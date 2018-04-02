package controlador;

import visão.TelaCadastraUsuario;
import visão.TelaLogin;
import visão.TelaPrincipal;

public class ControladorPrincipal {
	
	private static ControladorPrincipal instance;
	private TelaPrincipal telaPrincipal;
	private TelaLogin telaLogin;
	private TelaCadastraUsuario telaCadastraUsuario;
	
	
	private ControladorPrincipal() {
		
		this.telaPrincipal = new TelaPrincipal();
		this.telaLogin = new TelaLogin();
		this.telaCadastraUsuario = new TelaCadastraUsuario();
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
	}
	//Abre a Tela Inicial
	public void abreTelaPrincipal() {		
		telaPrincipal.setVisible(true);
	}

	//Abre Tela de Login
	public void login() {
		telaLogin.setVisible(true);		
	}

	public void verificaUsuario(String text) {
		// TODO Auto-generated method stub
		
	}

	public void abreTelaCadastro() {
		telaCadastraUsuario.setVisible(true);		
	}

}
