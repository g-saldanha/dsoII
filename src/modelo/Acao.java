package modelo;

import java.io.Serializable;

public class Acao implements Serializable {
    private String nome;
    private int qtd;
    private double valorUnitario;
    private double imposto;
    private double corretagem;
    private Integer cpf;
    private Double total;

    public Acao(String nome, int qtd, double valorUnitario, double corretagem) {
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.corretagem = corretagem;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getCorretagem() {
        return corretagem;
    }

    public void setCorretagem(double corretagem) {
        this.corretagem = corretagem;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
    
    
}
