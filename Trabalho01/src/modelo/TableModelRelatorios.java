package modelo;

import Recursos.Mensagens;
import controlador.ControladorAcoes;
import controlador.ControladorRelatorios;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelRelatorios extends AbstractTableModel {

    private static TableModelRelatorios instance;
    private List<Registro> acoes;
    private String[] colunas;

    private TableModelRelatorios() {
        this.colunas = new String[]{Mensagens.NOME, Mensagens.TIPO_DE_OPERACAO ,Mensagens.QTD, Mensagens.VALOR_COMPRADO, Mensagens.VALOR_ATUAL, Mensagens.SITUACAO};
        this.acoes = new ArrayList<>();
    }

    public static TableModelRelatorios getInstance() {
        if(instance == null) {
            return instance = new TableModelRelatorios();
        }
        return instance;
    }
    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    //Retorna o numero de linhas da Tabela
    @Override
    public int getRowCount() {
        return acoes.size();
    }

    //Retorna a quantidade de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna os valores das células
    @Override
    public Object getValueAt(int linha, int coluna) {
        int qtd = acoes.get(linha).getQuantidade();
        double valorNaCompra = acoes.get(linha).getValorNaHoraDoRegistro();;
        String nomeAcao  = acoes.get(linha).getNomeAcao();
        double valorAtual = ControladorAcoes.getInstanceAcoes().getValorAcao(nomeAcao, qtd);
        String tipoOperacao = acoes.get(linha).getTipoDeOperacao();
        switch (coluna) {
            case 0:
                return nomeAcao;
            case 1:
                return tipoOperacao;
            case 2:
                return qtd;
            case 3:
                return "RS" + valorNaCompra;
            case 4:
                return "R$" + valorAtual;
            case 5:
                return ControladorRelatorios.getInstanceOfRelatorios().getSituacao(valorNaCompra, valorAtual, tipoOperacao);
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                acoes.get(linha).setNomeAcao((String) valor);
                break;
            case 1:
                acoes.get(linha).setTipoDeOperacao((String) valor);
                break;
            case 2:
                acoes.get(linha).setQuantidade((int) valor);
            case 4:
                try {
                    acoes.get(linha).setValorNaHoraDoRegistro((double) valor);
                } catch (NumberFormatException nfe) {
                    acoes.get(linha).setValorNaHoraDoRegistro(0d);
                }
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void addRow(Registro acao) {
        this.acoes.add(acao);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.acoes.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<Registro> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<Registro> acoesSet) {
        this.acoes = acoesSet;
    }

    //public void alterarAlgo() {}


}
