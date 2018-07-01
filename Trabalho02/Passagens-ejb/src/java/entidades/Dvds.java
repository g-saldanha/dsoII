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
 * @author gabri
 */
@Entity
@Table(name = "DVDS")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "DVDS.findAll", query = "SELECT p FROM DVDS p")
    , @NamedQuery(name = "DVDS.findByIdPassagem", query = "SELECT p FROM DVDS p WHERE p. = :idPassagem")
    , @NamedQuery(name = "DVDS.findByData", query = "SELECT p FROM DVDS p WHERE p.data = :data")
    , @NamedQuery(name = "DVDS.findByCidadeOrigem", query = "SELECT p FROM DVDS p WHERE p.cidadeOrigem = :cidadeOrigem")
    , @NamedQuery(name = "DVDS.findByCidadeDestino", query = "SELECT p FROM DVDS p WHERE p.cidadeDestino = :cidadeDestino")
    , @NamedQuery(name = "DVDS.findByValor", query = "SELECT p FROM DVDS p WHERE p.valor = :valor")
    , @NamedQuery(name = "DVDS.findByAssento", query = "SELECT p FROM DVDS p WHERE p.assento = :assento")
    , @NamedQuery(name = "DVDS.findByDisponibilidadade", query = "SELECT p FROM DVDS p WHERE p.disponibilidadade = :disponibilidadade")
    , @NamedQuery(name = "DVDS.findByDisponibilidadadeTrue", query = "SELECT p FROM DVDS p WHERE p.disponibilidadade = 1")
    , @NamedQuery(name = "DVDS.findByHorario", query = "SELECT p FROM DVDS p WHERE p.horario = :horario")
    , @NamedQuery(name = "DVDS.findDVDSByCliente", query = "SELECT passagem FROM DVDS passagem JOIN passagem.fkidCliente clientes WHERE clientes.idCliente = :idCliente")
})
public class Dvds implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DVD")
    private Integer idDvd;
    @Column(name = "TITULO")
    @Temporal(TemporalType.DATE)
    private Date titulo;
    @Size(max = 30)
    @Column(name = "GENERO")
    private String genero;
    @Size(max = 30)
    @Column(name = "ANO")
    private String ano;
    @JoinColumn(name = "FKID_CLIENTE_EMPRESTIMO", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Clientes emprestado;
    @JoinColumn(name = "FKID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Clientes fkidCliente;

    public Dvds() {
    }

    public Integer getIdDvd() {
        return idDvd;
    }

    public void setIdDvd(Integer idDvd) {
        this.idDvd = idDvd;
    }

    public Date getTitulo() {
        return titulo;
    }

    public void setTitulo(Date titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Clientes getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Clientes emprestado) {
        this.emprestado = emprestado;
    }

    public Clientes getFkidCliente() {
        return fkidCliente;
    }

    public void setFkidCliente(Clientes fkidCliente) {
        this.fkidCliente = fkidCliente;
    }
     
    
    
    
}
