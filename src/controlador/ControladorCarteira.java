package controlador;

import Recursos.Mensagens;
import modelo.Acao;
import modelo.Carteira;
import modelo.TableModelAcoes;
import modelo.Transacao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

	public static JTable popularCamposDaTabela() {
//			TableModelAcoes.getInstance().setAcoes(carteiraEmUSo.getAcoes());
//			TableModelAcoes.getInstance().fireTableDataChanged();
		
		

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

	public static void cadAcao(String tipo, String nome, Integer qtd, Double imposto, Double valorUnitario, Double corretagem) {
//    	Se ao registrar a opção de COMPRA e apertar no Botão de Transação, essa condição vai cadastrar uma Ação de comprar na carteira do usuário atual.
		if (tipo.equals(Mensagens.COMPRAR)) {
//			Calcular o valor total quantidade + valor de unidad + imposto + corretagem
			double valorTotalAcao = qtd * valorUnitario;
			valorTotalAcao += corretagem;
//			Validação se existe saldo na carteira para comprar a ação
			if (carteiraEmUSo.getSaldo() >= valorTotalAcao){
//				Comprar a ação
				Acao acaoCompra = new Acao(nome, qtd, valorUnitario, corretagem, carteiraEmUSo.getCpf());
				carteiraEmUSo.getAcoes().add(acaoCompra);
				carteiraEmUSo.setSaldo(carteiraEmUSo.getSaldo()-valorTotalAcao);
				popularCamposDaTabela();
				JOptionPane.showMessageDialog(null, Mensagens.ACAO_COMPRADA_COM_SUCESSO);
			} else {
				JOptionPane.showMessageDialog(null, Mensagens.VOCE_NAO_TEM_SALDO);
			}

		}else {
			JOptionPane.showMessageDialog(null, Mensagens.ACAO_NAO_COMPRADA);
		}
    }

	public boolean cadastrarCarteira(String cpf){
    	if(!existeUsuario(cpf)) {
    		getListaDeCarteiras().add(new Carteira(cpf));
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
}
