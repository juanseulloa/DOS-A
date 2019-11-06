/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnetwork.accountantsoftware.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author DanielaC
 */
@Entity
@Table(name = "puc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puc.findAll", query = "SELECT p FROM Puc p")
    , @NamedQuery(name = "Puc.findByIdpuc", query = "SELECT p FROM Puc p WHERE p.idpuc = :idpuc")
    , @NamedQuery(name = "Puc.findByCodpuc", query = "SELECT p FROM Puc p WHERE p.codpuc = :codpuc")
    , @NamedQuery(name = "Puc.findByNombrepuc", query = "SELECT p FROM Puc p WHERE p.nombrepuc = :nombrepuc")})
public class Puc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpuc")
    private Integer idpuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codpuc")
    private int codpuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrepuc")
    private String nombrepuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpuc")
    private Collection<Cuenta> cuentaCollection;

    public Puc() {
    }

    public Puc(Integer idpuc) {
        this.idpuc = idpuc;
    }

    public Puc(Integer idpuc, int codpuc, String nombrepuc) {
        this.idpuc = idpuc;
        this.codpuc = codpuc;
        this.nombrepuc = nombrepuc;
    }

    public Integer getIdpuc() {
        return idpuc;
    }

    public void setIdpuc(Integer idpuc) {
        this.idpuc = idpuc;
    }

    public int getCodpuc() {
        return codpuc;
    }

    public void setCodpuc(int codpuc) {
        this.codpuc = codpuc;
    }

    public String getNombrepuc() {
        return nombrepuc;
    }

    public void setNombrepuc(String nombrepuc) {
        this.nombrepuc = nombrepuc;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpuc != null ? idpuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puc)) {
            return false;
        }
        Puc other = (Puc) object;
        if ((this.idpuc == null && other.idpuc != null) || (this.idpuc != null && !this.idpuc.equals(other.idpuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.Puc[ idpuc=" + idpuc + " ]";
    }
    
}
