package controlador;

import Recursos.Mensagens;
import modelo.*;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;

import static Recursos.Mensagens.ACAO;

public class ControladorCarteira {
    private static ControladorCarteira instanceCarteira;
    private CarteiraDAO listaDeCarteiras;
    private static Carteira carteiraEmUSo;

    private ControladorCarteira() {
    	listaDeCarteiras = new CarteiraDAO();
    }

    public static ControladorCarteira getInstanceCarteira(){
        if (instanceCarteira == null) {
            return instanceCarteira = new ControladorCarteira();
        }
        return instanceCarteira;
    }

	public CarteiraDAO getListaDeCarteiras() {
		return listaDeCarteiras;
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
				getInstanceCarteira().listaDeCarteiras.put(carteiraEmUSo);
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

	public static void reduzAcao(Acao venda, Integer qtd) {
		if (venda.getQtd() == qtd){
			carteiraEmUSo.getAcoes().remove(venda);
		} else {
			venda.setQtd(venda.getQtd() - qtd);
		}
	}



	public boolean cadastrarCarteira(Integer cpf, String saldo){
    	if(!existeUsuario(cpf)) {
    		listaDeCarteiras.put(new Carteira(cpf, Double.parseDouble(saldo)));
    		return true;
    	}
		return false;
    }

	public boolean carregaUsuario(Integer text) {
		for(Carteira carteira: listaDeCarteiras.getCarteiras()) {
			if (carteira.getCpf().equals(text)) {
				carteiraEmUSo = carteira;
				return true;
			}
		}
		return false;
		
	}

	public boolean existeUsuario(Integer text) {
		for(Carteira carteira: listaDeCarteiras.getCarteiras()) {
			if(carteira.getCpf().equals(text)) {
				return true;
			}
		}
		return false;
	}

	public String getValorEmCaixaCateira() {
    	return "R$ " + carteiraEmUSo.getSaldo();
	}


	public static String venderAcao(String tipo, Integer qtd, String nome, Double imposto, Double corretagem, Double valorUnitario) {
		Acao acao = null;
//		Verifica acao
		for (Acao acaoNoFor : carteiraEmUSo.getAcoes()
			 ) {
			if (acaoNoFor.getNome().equals(nome)){
				acao = acaoNoFor;
			}

		}

		if (tipo.equals(Mensagens.VENDER)) {
//			Verifica nulo
			if (acao == null) {
				return Mensagens.VOCE_NAO_TEM_ESSA_ACAO;
			}
//			Verifica quantidade
			else if(acao.getQtd() < qtd){
				return Mensagens.VOCE_NAO_TEM_ESSA_QUANTIDADE_DE_ACOES;
			}
//			Faz a venda
			else {
//				Tira a acao a lista
				reduzAcao(acao, qtd);
//			faz a corretagem e cobra imposto e inclui saldo na carteira
				double valorDaVenda = qtd * valorUnitario;
				double valorTotalDaVenda = valorDaVenda - corretagem - imposto;
				carteiraEmUSo.setSaldo(carteiraEmUSo.getSaldo() + valorDaVenda);
				popularCamposDaTabela();
				carteiraEmUSo.getRegistros().add(new Registro(nome, qtd, valorDaVenda, tipo));
				getInstanceCarteira().listaDeCarteiras.put(carteiraEmUSo);
				return Mensagens.ACAO_VENDIDA_COM_SUCESSO;
			}
		}

		return Mensagens.ACAO_NAO_VENDIDA;

    }

	public static Carteira getCarteiraEmUSo() {
		return carteiraEmUSo;
	}

	public static void setCarteiraEmUSo(Carteira carteiraEmUSo) {
		ControladorCarteira.carteiraEmUSo = carteiraEmUSo;
	}
}
