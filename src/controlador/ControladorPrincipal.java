package controlador;

import javax.naming.ldap.Control;
import javax.swing.*;

import com.sun.corba.se.spi.orbutil.fsm.State;

import Recursos.Mensagens;
import modelo.Carteira;
import sun.invoke.empty.Empty;
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
		this.centralizaTelas();
		
	}
	
	public static ControladorPrincipal getInstance() {
		if(instance == null) {
			return instance = new ControladorPrincipal();
		}else {
			return instance;
		}
		
	}

	public static Double calculaValorTotal(JTextField jtfQtd, JLabel lblVlUnitarioValue) {
		if (jtfQtd.getText().isEmpty()){
			return  Double.parseDouble(lblVlUnitarioValue.getText());
		} else {
			return Double.parseDouble(lblVlUnitarioValue.getText()) * Double.parseDouble(jtfQtd.getText());
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

	public void abreTelaCadastro() {
		telaCadastraUsuario.setVisible(true);		
	}
	
	public void carregaUsuario(String text) {
			if(ControladorCarteira.getInstanceCarteira().carregaUsuario(text)) {
				JOptionPane.showMessageDialog(null, Mensagens.USUARIO_CARREGADO);
				telaLogin.setVisible(false);
				this.telaCadastraTransacoes = new TelaCadastraTransacoes();
				telaCadastraTransacoes.setLocationRelativeTo(null);
				telaCadastraTransacoes.setVisible(true);

			}else {
				JOptionPane.showMessageDialog(null, Mensagens.USUARIO_NAO_ENCONTRADO);
			}				
	}

	public void cadastraUsuario(String text, String saldo) {
		if(ControladorCarteira.getInstanceCarteira().cadastrarCarteira(text, saldo)) {
			JOptionPane.showMessageDialog(null, Mensagens.USUARIO_CADASTRADO); 
			telaCadastraUsuario.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, Mensagens.USUARIO_EXISTENTE); 
		}	
		
	}

}
