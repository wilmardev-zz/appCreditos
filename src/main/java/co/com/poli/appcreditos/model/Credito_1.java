/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wilmar.duque
 */
@Entity
@Table(name = "CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credito_1.findAll", query = "SELECT c FROM Credito_1 c"),
    @NamedQuery(name = "Credito_1.findById", query = "SELECT c FROM Credito_1 c WHERE c.id = :id"),
    @NamedQuery(name = "Credito_1.findByDocumentopersona", query = "SELECT c FROM Credito_1 c WHERE c.documentopersona = :documentopersona"),
    @NamedQuery(name = "Credito_1.findByNombrepersona", query = "SELECT c FROM Credito_1 c WHERE c.nombrepersona = :nombrepersona"),
    @NamedQuery(name = "Credito_1.findByApellidopersona", query = "SELECT c FROM Credito_1 c WHERE c.apellidopersona = :apellidopersona"),
    @NamedQuery(name = "Credito_1.findByMontocredito", query = "SELECT c FROM Credito_1 c WHERE c.montocredito = :montocredito"),
    @NamedQuery(name = "Credito_1.findByTrabajacompania", query = "SELECT c FROM Credito_1 c WHERE c.trabajacompania = :trabajacompania")})
public class Credito_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DOCUMENTOPERSONA")
    private String documentopersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREPERSONA")
    private String nombrepersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDOPERSONA")
    private String apellidopersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTOCREDITO")
    private double montocredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRABAJACOMPANIA")
    private Boolean trabajacompania;
    @JoinColumn(name = "TIPOCREDITO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tipocredito tipocredito;
    @JoinColumn(name = "TIPOTRABAJADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tipotrabajador tipotrabajador;

    public Credito_1() {
    }

    public Credito_1(Integer id) {
        this.id = id;
    }

    public Credito_1(Integer id, String documentopersona, String nombrepersona, String apellidopersona, double montocredito, Boolean trabajacompania) {
        this.id = id;
        this.documentopersona = documentopersona;
        this.nombrepersona = nombrepersona;
        this.apellidopersona = apellidopersona;
        this.montocredito = montocredito;
        this.trabajacompania = trabajacompania;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentopersona() {
        return documentopersona;
    }

    public void setDocumentopersona(String documentopersona) {
        this.documentopersona = documentopersona;
    }

    public String getNombrepersona() {
        return nombrepersona;
    }

    public void setNombrepersona(String nombrepersona) {
        this.nombrepersona = nombrepersona;
    }

    public String getApellidopersona() {
        return apellidopersona;
    }

    public void setApellidopersona(String apellidopersona) {
        this.apellidopersona = apellidopersona;
    }

    public double getMontocredito() {
        return montocredito;
    }

    public void setMontocredito(double montocredito) {
        this.montocredito = montocredito;
    }

    public Boolean getTrabajacompania() {
        return trabajacompania;
    }

    public void setTrabajacompania(Boolean trabajacompania) {
        this.trabajacompania = trabajacompania;
    }

    public Tipocredito getTipocredito() {
        return tipocredito;
    }

    public void setTipocredito(Tipocredito tipocredito) {
        this.tipocredito = tipocredito;
    }

    public Tipotrabajador getTipotrabajador() {
        return tipotrabajador;
    }

    public void setTipotrabajador(Tipotrabajador tipotrabajador) {
        this.tipotrabajador = tipotrabajador;
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
        if (!(object instanceof Credito_1)) {
            return false;
        }
        Credito_1 other = (Credito_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.poli.appcreditos.model.Credito_1[ id=" + id + " ]";
    }
    
}
