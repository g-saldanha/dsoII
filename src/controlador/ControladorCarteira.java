package controlador;

import Recursos.Mensagens;
import modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.util.ArrayList;

public class ControladorCarteira {
    private static ControladorCarteira instanceCarteira;
    private static ArrayList<Carteira> listaDeCarteiras;
    private static Carteira carteiraEmUSo;

    private ControladorCarteira() {
        listaDeCarteiras = new ArrayList();
    }

    public static ControladorCarteira getInstanceCarteira(){
        if (instanceCarteira == null) {
            return instanceCarteira = new ControladorCarteira();
        }
        return instanceCarteira;
    }

    public static ArrayList<Carteira> getListaDeCarteiras() {
        return listaDeCarteiras;
    }

    public static void setListaDeCarteiras(ArrayList<Carteira> listaDeCarteiras) {
        ControladorCarteira.listaDeCarteiras = listaDeCarteiras;
    }

	public static void popularCamposDaTabela() {
			TableModelAcoes.getInstance().setAcoes(carteiraEmUSo.getAcoes());
			TableModelAcoes.getInstance().fireTableDataChanged();
			 
	}

	public static void popularCamposDaTabelaRelatorios() {
    	if (carteiraEmUSo != null)
		TableModelRelatorios.getInstance().setAcoes(carteiraEmUSo.getRegistros());
		TableModelRelatorios.getInstance().fireTableDataChanged();
	}
		
/*
		JTable jtfCpf;
		if (carteiraEmUSo == null || carteiraEmUSo.getAcoes().size() == 0 ){
			jtfCpf =  new JTable() {
				public boolean getScrollableTracksViewportHeight() {
					if(getParent() instanceof JViewport)
						return(((JViewport)getParent()).getHeight() > getPreferredSize().height);

					return super.getScrollableTracksViewportHeight();
				}

				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					if(getRowCount() == 0) {
						Graphics2D g2d = (Graphics2D) g;
						g2d.setColor(Color.BLACK);
						g2d.drawString("Nenhuma Ação na foi comprada ou vendida para este usuário!",10,20);
					}
				}
			};
			
			return jtfCpf;
		} else {
			String[] colunas = {
					Mensagens.ACAO, Mensagens.VALOR_UNITARIO, Mensagens.QTD, Mensagens.CORRETAGEM
			};

			Object[][] dados = new Object[carteiraEmUSo.getAcoes().size()][4];
			int atual = 0;
			for (Acao acao : carteiraEmUSo.getAcoes()) {
				dados[atual][0] = acao.getNome();
				dados[atual][1] = "R$" + acao.getValorUnitario();
				dados[atual][2] = acao.getQtd();
				dados[atual][0] = acao.getCorretagem() * 100 + "%";
				atual++;
			}

			jtfCpf = new JTable(dados, colunas);
			return jtfCpf;
		}

    }
*/
	public static String  cadAcao(String tipo, String nome, Integer qtd, Double imposto, Double valorUnitario, Double corretagem) {
//    	Se ao registrar a opção de COMPRA e apertar no Botão de Transação, essa condição vai cadastrar uma Ação de comprar na carteira do usuário atual.
		if (tipo.equals(Mensagens.COMPRAR)) {
//			Calcular o valor total quantidade + valor de unidad + imposto + corretagem
			double valorTotalAcao = qtd * valorUnitario;
			valorTotalAcao += corretagem;
//			Validação se existe saldo na carteira para comprar a ação
			if (carteiraEmUSo.getSaldo() >= valorTotalAcao){
//				Comprar a ação
				Acao acaoCompra = new Acao(nome, qtd, valorUnitario, corretagem);
				acaoCompra.setCpf(carteiraEmUSo.getCpf());
				acrescentaAcao(acaoCompra);
				//carteiraEmUSo.getAcoes().add(acaoCompra);
				carteiraEmUSo.setSaldo(carteiraEmUSo.getSaldo()-valorTotalAcao);
				popularCamposDaTabela();
				carteiraEmUSo.getRegistros().add(new Registro(nome, qtd, qtd * valorUnitario, tipo));
				return Mensagens.ACAO_COMPRADA_COM_SUCESSO;
			} else {
				return Mensagens.VOCE_NAO_TEM_SALDO;
			}

		}else {
			return Mensagens.ACAO_NAO_COMPRADA;
		}
    }

	public static void acrescentaAcao(Acao compra) {
		boolean cadastrado = false;
			for(Acao acao : carteiraEmUSo.getAcoes()) {
				if(acao.getNome().equals(compra.getNome())) {
					acao.setQtd(acao.getQtd() + compra.getQtd());
					cadastrado = true;
				}
			}				
			if (cadastrado == false) {
				carteiraEmUSo.getAcoes().add(compra);
				
			}
							
	}



	public boolean cadastrarCarteira(String cpf, String saldo){
    	if(!existeUsuario(cpf)) {
    		getListaDeCarteiras().add(new Carteira(cpf, Double.parseDouble(saldo)));
    		return true;
    	}
		return false;
    }

	public boolean carregaUsuario(String text) {
		for(Carteira carteira: listaDeCarteiras) {
			if(carteira.getCpf().equals(text)) {
				carteiraEmUSo = carteira;
				return true;
			}			
		}
		return false;
		
	}
	
	public boolean existeUsuario(String text) {
		for(Carteira carteira: listaDeCarteiras) {
			if(carteira.getCpf().equals(text)) {
				return true;
			}			
		}
		return false;
	}

	public String getValorEmCaixaCateira() {
    	return "R$ " + carteiraEmUSo.getSaldo();
	}


	public void venderAcao(String tipo, String qtd, String nome, Double imposto, Double corretagem, Double valorUnitario) {
		if (tipo.equals(Mensagens.VENDER)) {

		} else {
			JOptionPane.showMessageDialog(null, Mensagens.ACAO_NAO_VENDIDA);
		}
    }

	public static Carteira getCarteiraEmUSo() {
		return carteiraEmUSo;
	}

	public static void setCarteiraEmUSo(Carteira carteiraEmUSo) {
		ControladorCarteira.carteiraEmUSo = carteiraEmUSo;
	}
}
