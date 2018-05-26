package modelo;

import java.io.Serializable;

public class Registro implements Serializable {
    private String nomeAcao;
    private String tipoDeOperacao;
    private int quantidade;
    private Double valorNaHoraDoRegistro;
    private String situacao;

    public Registro(String nomeAcao, int quantidade, Double valorNaHoraDoRegistro, String tipoDeOperacao) {
        this.nomeAcao = nomeAcao;
        this.quantidade = quantidade;
        this.valorNaHoraDoRegistro = valorNaHoraDoRegistro;
        this.tipoDeOperacao = tipoDeOperacao;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorNaHoraDoRegistro() {
        return valorNaHoraDoRegistro;
    }

    public void setValorNaHoraDoRegistro(Double valorNaHoraDoRegistro) {
        this.valorNaHoraDoRegistro = valorNaHoraDoRegistro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipoDeOperacao() {
        return tipoDeOperacao;
    }

    public void setTipoDeOperacao(String tipoDeOperacao) {
        this.tipoDeOperacao = tipoDeOperacao;
    }
}
