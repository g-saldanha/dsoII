package controlador;

import Recursos.Mensagens;
import modelo.Acao;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.String.format;

public class ControladorAcoes {
    private static ControladorAcoes instanceAcoes;
    private ArrayList<Acao> listaDeAcoes;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public ControladorAcoes() {
        this.listaDeAcoes = new ArrayList<>();
        listaDeAcoes.add(new Acao(Mensagens.GOOGLE, (int) Math.random()*10 , Math.round((Math.random()*10)*100.0)/100.0  ,0.05));
        listaDeAcoes.add(new Acao(Mensagens.FACEBOOK, (int) Math.random()*10,  Math.round((Math.random()*10)*100.0)/100.0,0.05));
        listaDeAcoes.add(new Acao(Mensagens.YOUTUBE, (int) Math.random()*10,  Math.round((Math.random()*10)*100.0)/100.0 ,0.05));
    }

    public static ControladorAcoes getInstanceAcoes(){
        if (instanceAcoes == null) {
            return instanceAcoes = new ControladorAcoes();
        }
        return instanceAcoes;
    }

    public static void setInstanceAcoes(ControladorAcoes instanceAcoes) {
        ControladorAcoes.instanceAcoes = instanceAcoes;
    }

    public ArrayList<Acao> getListaDeAcoes() {
        return listaDeAcoes;
    }

    public void setListaDeAcoes(ArrayList<Acao> listaDeAcoes) {
        this.listaDeAcoes = listaDeAcoes;
    }

    public JComboBox getComboAcoes(){
        JComboBox jcbAcao = new JComboBox();
        jcbAcao.setBounds(5, 352, 864, 24);
        for (Acao acao : listaDeAcoes
             ) {
            jcbAcao.addItem(acao.getNome());
        }

        return jcbAcao;

    }

    public String getValorUnitario(Object selectedItem) {
        JLabel valorUnitarioValue = new JLabel();
        for (Acao acao : listaDeAcoes
             ) {
            if (acao.getNome().equals(selectedItem)){
                return "" + acao.getValorUnitario();
            }
        }
        return "Nenhuma ação foi selecionada";
    }

    public double getValorAcao(String nomeAcao, int qtd) {
        for (Acao acao : listaDeAcoes
             ) {
            if (acao.getNome().equals(nomeAcao)){
                return acao.getValorUnitario() * qtd;
            }
        }
        return 0;
    }
}
