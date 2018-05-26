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
 * @author Gabriel e Jose Carlos Martins
 */
@Entity
@Table(name = "Dvds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvds.findAll", query = "SELECT p FROM Dvds p")
    , @NamedQuery(name = "Dvds.findByIdDVD", query = "SELECT p FROM Dvds p WHERE p.idDVD = :idDVD")
    , @NamedQuery(name = "Dvds.findByData", query = "SELECT p FROM Dvds p WHERE p.data = :data")
    , @NamedQuery(name = "Dvds.findByDataLancamento", query = "SELECT p FROM Dvds p WHERE p.DataLancamento = :DataLancamento")
    , @NamedQuery(name = "Dvds.findByGenero", query = "SELECT p FROM Dvds p WHERE p.Genero = :Genero")
    , @NamedQuery(name = "Dvds.findByValor", query = "SELECT p FROM Dvds p WHERE p.valor = :valor")
    , @NamedQuery(name = "Dvds.findByDisponibilidadade", query = "SELECT p FROM Dvds p WHERE p.disponibilidadade = :disponibilidadade")
    , @NamedQuery(name = "Dvds.findByDisponibilidadadeTrue", query = "SELECT p FROM Dvds p WHERE p.disponibilidadade = 1")
    , @NamedQuery(name = "Dvds.findDvdsByCliente", query = "SELECT DVD FROM Dvds DVD JOIN DVD.fkidCliente clientes WHERE clientes.idCliente = :idCliente")})
    
public class Dvds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DVD")
    private Integer idDVD;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 30)
    @Column(name = "DATA_LANCAMENTO")
    private String DataLancamento;
    @Size(max = 30)
    @Column(name = "GENERO")
    private String Genero;
    @Column(name = "VALOR")
    private String valor;
    @Column(name = "DISPONIBILIDADADE")
    private Integer disponibilidadade;
    @JoinColumn(name = "FKID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Clientes fkidCliente;
   
    public Clientes getFkidCliente() {
        return fkidCliente;
    }

    public void setFkidCliente(Clientes fkidCliente) {
        this.fkidCliente = fkidCliente;
    }    
    
    public Dvds() {
    }

    public Dvds(Integer idDVD) {
        this.idDVD = idDVD;
    }

    public Integer getIdDVD() {
        return idDVD;
    }

    public void setIdDVD(Integer idDVD) {
        this.idDVD = idDVD;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    

    public String getDataLancamento() {
        return DataLancamento;
    }

    public void setDataLancamento(String DataLancamento) {
        this.DataLancamento = DataLancamento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
        hash += (idDVD != null ? idDVD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dvds)) {
            return false;
        }
        Dvds other = (Dvds) object;
        if ((this.idDVD == null && other.idDVD != null) || (this.idDVD != null && !this.idDVD.equals(other.idDVD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Dvds[ idDVD=" + idDVD + " ]";
    }
    
}
