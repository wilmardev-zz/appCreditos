/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wilmar.duque
 */
@Entity
@Table(name = "TIPOTRABAJADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotrabajador.findAll", query = "SELECT t FROM Tipotrabajador t"),
    @NamedQuery(name = "Tipotrabajador.findById", query = "SELECT t FROM Tipotrabajador t WHERE t.id = :id"),
    @NamedQuery(name = "Tipotrabajador.findByTipotrabajador", query = "SELECT t FROM Tipotrabajador t WHERE t.tipotrabajador = :tipotrabajador")})
public class Tipotrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPOTRABAJADOR")
    private String tipotrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipotrabajador")
    private Collection<Credito_1> creditoCollection;

    public Tipotrabajador() {
    }

    public Tipotrabajador(Integer id) {
        this.id = id;
    }

    public Tipotrabajador(Integer id, String tipotrabajador) {
        this.id = id;
        this.tipotrabajador = tipotrabajador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipotrabajador() {
        return tipotrabajador;
    }

    public void setTipotrabajador(String tipotrabajador) {
        this.tipotrabajador = tipotrabajador;
    }

    @XmlTransient
    public Collection<Credito_1> getCreditoCollection() {
        return creditoCollection;
    }

    public void setCreditoCollection(Collection<Credito_1> creditoCollection) {
        this.creditoCollection = creditoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotrabajador)) {
            return false;
        }
        Tipotrabajador other = (Tipotrabajador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.poli.appcreditos.model.Tipotrabajador[ id=" + id + " ]";
    }
    
}
