/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "PASSAGENS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passagens.findAll", query = "SELECT p FROM Passagens p")
    , @NamedQuery(name = "Passagens.findByIdPassagem", query = "SELECT p FROM Passagens p WHERE p.idPassagem = :idPassagem")
    , @NamedQuery(name = "Passagens.findByData", query = "SELECT p FROM Passagens p WHERE p.data = :data")
    , @NamedQuery(name = "Passagens.findByCidadeOrigem", query = "SELECT p FROM Passagens p WHERE p.cidadeOrigem = :cidadeOrigem")
    , @NamedQuery(name = "Passagens.findByCidadeDestino", query = "SELECT p FROM Passagens p WHERE p.cidadeDestino = :cidadeDestino")
    , @NamedQuery(name = "Passagens.findByValor", query = "SELECT p FROM Passagens p WHERE p.valor = :valor")
    , @NamedQuery(name = "Passagens.findByAssento", query = "SELECT p FROM Passagens p WHERE p.assento = :assento")
    , @NamedQuery(name = "Passagens.findByDisponibilidadade", query = "SELECT p FROM Passagens p WHERE p.disponibilidadade = :disponibilidadade")
    , @NamedQuery(name = "Passagens.findByDisponibilidadadeTrue", query = "SELECT p FROM Passagens p WHERE p.disponibilidadade = 1")
    , @NamedQuery(name = "Passagens.findByHorario", query = "SELECT p FROM Passagens p WHERE p.horario = :horario")
    , @NamedQuery(name = "Passagens.findPassagensByCliente", query = "SELECT passagem FROM Passagens passagem JOIN passagem.fkidCliente clientes WHERE clientes.idCliente = :idCliente")})
    
public class Passagens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PASSAGEM")
    private Integer idPassagem;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 30)
    @Column(name = "CIDADE_ORIGEM")
    private String cidadeOrigem;
    @Size(max = 30)
    @Column(name = "CIDADE_DESTINO")
    private String cidadeDestino;
    @Column(name = "VALOR")
    private String valor;
    @Column(name = "ASSENTO")
    private Integer assento;
    @Column(name = "DISPONIBILIDADADE")
    private Integer disponibilidadade;
    @Column(name = "HORARIO")
    private String horario;
    @JoinColumn(name = "FKID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Clientes fkidCliente;

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

   
    public Clientes getFkidCliente() {
        return fkidCliente;
    }

    public void setFkidCliente(Clientes fkidCliente) {
        this.fkidCliente = fkidCliente;
    }    
    
    public Passagens() {
    }

    public Passagens(Integer idPassagem) {
        this.idPassagem = idPassagem;
    }

    public Integer getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(Integer idPassagem) {
        this.idPassagem = idPassagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getAssento() {
        return assento;
    }

    public void setAssento(Integer assento) {
        this.assento = assento;
    }

    public Integer getDisponibilidadade() {
        return disponibilidadade;
    }

    public void setDisponibilidadade(Integer disponibilidadade) {
        this.disponibilidadade = disponibilidadade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPassagem != null ? idPassagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passagens)) {
            return false;
        }
        Passagens other = (Passagens) object;
        if ((this.idPassagem == null && other.idPassagem != null) || (this.idPassagem != null && !this.idPassagem.equals(other.idPassagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Passagens[ idPassagem=" + idPassagem + " ]";
    }
    
}
