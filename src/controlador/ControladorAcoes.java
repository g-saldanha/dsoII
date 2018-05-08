package controlador;

import Recursos.Mensagens;
import modelo.Acao;

import javax.swing.*;
import java.util.ArrayList;

public class ControladorAcoes {
    private static ControladorAcoes instanceAcoes;
    private ArrayList<Acao> listaDeAcoes;

    public ControladorAcoes() {
        this.listaDeAcoes = new ArrayList<>();
        listaDeAcoes.add(new Acao(Mensagens.GOOGLE, (int) Math.random()*10,1.0 ,0.05));
        listaDeAcoes.add(new Acao(Mensagens.FACEBOOK, (int) Math.random()*10, 2.0,0.05));
        listaDeAcoes.add(new Acao(Mensagens.YOUTUBE, (int) Math.random()*10, 3.0,0.05));
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
        jcbAcao.setBounds(432, 373, 116, 22);
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
}
