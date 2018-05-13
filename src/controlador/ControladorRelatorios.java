package controlador;

import Recursos.Mensagens;
import modelo.Registro;
import visao.TelaPrincipal;

import java.util.ArrayList;

public class ControladorRelatorios {
    private ArrayList<Registro> listaDeRegistros;
    private static ControladorRelatorios instanceOfRelatorios;
    public ControladorRelatorios() {
        this.listaDeRegistros = new ArrayList<>();
    }

    public static ControladorRelatorios getInstanceOfRelatorios(){
        if (instanceOfRelatorios == null) {
            return instanceOfRelatorios = new ControladorRelatorios();
        } else {
            return instanceOfRelatorios;
        }
    }


    public void cadastraRegistro(String tipo, String nome, Integer qtd, Double valorUnitario) {
        listaDeRegistros.add(new Registro(nome, qtd, valorUnitario, tipo));
    }

    public String getSituacao(double valorNaCompra, double valorAtual, String tipoOperacao) {
        if (tipoOperacao.equals(Mensagens.COMPRAR)) {
            return this.getSituacaoCompra(valorAtual, valorNaCompra);
        } else if (tipoOperacao.equals(Mensagens.VENDER)){
            return this.getSituacaoVenda(valorAtual,valorNaCompra);
        }
        return null;
    }

    private String getSituacaoVenda(double valorAtual, double valorNaCompra) {
        if (valorNaCompra < valorAtual){
            return Mensagens.PREJUIZO;
        } else if (valorNaCompra > valorAtual){
            return Mensagens.LUCRO;
        }
        return Mensagens.EMPATE;
    }

    private String getSituacaoCompra(double valorAtual, double valorNaCompra) {
        if (valorNaCompra < valorAtual){
            return Mensagens.LUCRO;
        } else if (valorNaCompra > valorAtual){
            return Mensagens.PREJUIZO;
        }
        return Mensagens.EMPATE;
    }

    public void abreTelaDeRelatorio(TelaPrincipal telaPrincipal) {
        telaPrincipal.setVisible(false);
        ControladorPrincipal.getInstance().getTelaRelatorios().setVisible(true);
    }
}
