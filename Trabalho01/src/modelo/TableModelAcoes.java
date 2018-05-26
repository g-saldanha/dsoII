package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Recursos.Mensagens;

public class TableModelAcoes extends AbstractTableModel {

	private static TableModelAcoes instance;
	private List<Acao> acoes;
    private String[] colunas;
    
    private TableModelAcoes() {
        this.colunas = new String[]{Mensagens.NOME, Mensagens.QTD, Mensagens.VALOR_UNITARIO, Mensagens.TOTAL};
        this.acoes = new ArrayList<>();
    }
    
    public static TableModelAcoes getInstance() {
		if(instance == null) {
			return instance = new TableModelAcoes();
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
        switch (coluna) {
            case 0:
                return acoes.get(linha).getNome();
            case 1:
                return acoes.get(linha).getQtd();
            case 2:
                return acoes.get(linha).getValorUnitario();
            case 3:
                return acoes.get(linha).getTotal();            
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                acoes.get(linha).setNome((String) valor);
                break;
            case 1:
                acoes.get(linha).setQtd((Integer) valor);
                break;
            case 2:
                try {
                	acoes.get(linha).setValorUnitario((Double) valor);
                } catch (NumberFormatException nfe) {
                    acoes.get(linha).setValorUnitario(0);
                }
                break;
            case 3:
                acoes.get(linha).setTotal((Double) valor);
                break;
        }
this.fireTableRowsUpdated(linha, linha);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void addRow(Acao acao) {
        this.acoes.add(acao);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.acoes.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<Acao> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<Acao> acoesSet) {
        this.acoes = acoesSet;
    }
    
    //public void alterarAlgo() {}


}
