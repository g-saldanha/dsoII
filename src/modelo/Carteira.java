package modelo;


public class Carteira {
    private String cpf;
    private String numeroDaCarteira;
    private Acoes[] acoes;
    private double saldo;
    private Transacao[] transacoes;
    //private Historico[] historicoAvaliacoes;

    public Carteira(String cpf) {
        this.cpf = cpf;
        this.numeroDaCarteira = Integer.toString(this.hashCode());
        this.acoes = null;
        this.saldo = 0;
        this.transacoes = null;
        //this.historicoAvaliacoes = null;
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

    public Acoes[] getAcoes() {
        return acoes;
    }

    public void setAcoes(Acoes[] acoes) {
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

    private void avaliarAcao(Acoes[] atuais) {
    }

}
