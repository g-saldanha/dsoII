package Recursos;

import javax.swing.JOptionPane;

import controlador.ControladorPrincipal;

public class CalculaTotal extends Thread{
	
	private boolean inicia;
	
	@Override
	public void run() {
		boolean para;
		do {
			try {
				ControladorPrincipal.getInstance().atualizaTotal();
				para = true;
			}catch(NumberFormatException ex) {
				para = false;
			}
		}while(!para);
	}

}
