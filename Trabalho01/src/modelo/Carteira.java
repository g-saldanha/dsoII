package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carteira implements Serializable {
    private double caixa;
    private Integer cpf;
    private String numeroDaCarteira;
    private ArrayList<Acao> acoes;
    private double saldo;
    private Transacao[] transacoes;
    private ArrayList<Registro> registros;

    public Carteira(Integer cpf, Double saldo) {
        this.cpf = cpf;
        this.numeroDaCarteira = Integer.toString(this.hashCode());
        this.acoes = new ArrayList<>();
        this.registros = new ArrayList<>();
        this.saldo = saldo;
        this.transacoes = null;
    }

    

    public Integer getCpf() {
    return cpf;
	}



	public void setCpf(Integer cpf) {
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

    public void avaliarLucroOuPrejuizo(){

    }

    private void avaliarAcao(Acao[] atuais) {
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }
}
