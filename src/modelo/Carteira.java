package modelo;


import java.util.ArrayList;

public class Carteira {
    private double caixa;
    private String cpf;
    private String numeroDaCarteira;
    private ArrayList<Acao> acoes;
    private double saldo;
    private Transacao[] transacoes;

    public Carteira(String cpf) {
        this.cpf = cpf;
        this.numeroDaCarteira = Integer.toString(this.hashCode());
        this.acoes = new ArrayList<>();
        this.saldo = 0;
        this.transacoes = null;
        this.caixa = 0;
    }

    

    public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNumeroDaCarteira() {
        return numeroDaCarteira;
    }

    public void setNumeroDaCarteira(String numeroDaCarteira) {
        this.numeroDaCarteira = numeroDaCarteira;
    }

    public ArrayList<Acao> getAcoes() {
        return acoes;
    }

    public void setAcoes(ArrayList<Acao> acoes) {
        this.acoes = acoes;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCaixa() {
        return caixa;
    }

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }

    public void avaliarLucroOuPrejuizo(){

    }

    private void avaliarAcao(Acao[] atuais) {
    }

}
