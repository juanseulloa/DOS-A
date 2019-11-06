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
@Table(name = "tipocuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocuenta.findAll", query = "SELECT t FROM Tipocuenta t")
    , @NamedQuery(name = "Tipocuenta.findByIdtipocuenta", query = "SELECT t FROM Tipocuenta t WHERE t.idtipocuenta = :idtipocuenta")
    , @NamedQuery(name = "Tipocuenta.findByNombretipocuenta", query = "SELECT t FROM Tipocuenta t WHERE t.nombretipocuenta = :nombretipocuenta")})
public class Tipocuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipocuenta")
    private Integer idtipocuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombretipocuenta")
    private String nombretipocuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipocuenta")
    private Collection<Cuenta> cuentaCollection;

    public Tipocuenta() {
    }

    public Tipocuenta(Integer idtipocuenta) {
        this.idtipocuenta = idtipocuenta;
    }

    public Tipocuenta(Integer idtipocuenta, String nombretipocuenta) {
        this.idtipocuenta = idtipocuenta;
        this.nombretipocuenta = nombretipocuenta;
    }

    public Integer getIdtipocuenta() {
        return idtipocuenta;
    }

    public void setIdtipocuenta(Integer idtipocuenta) {
        this.idtipocuenta = idtipocuenta;
    }

    public String getNombretipocuenta() {
        return nombretipocuenta;
    }

    public void setNombretipocuenta(String nombretipocuenta) {
        this.nombretipocuenta = nombretipocuenta;
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
        hash += (idtipocuenta != null ? idtipocuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocuenta)) {
            return false;
        }
        Tipocuenta other = (Tipocuenta) object;
        if ((this.idtipocuenta == null && other.idtipocuenta != null) || (this.idtipocuenta != null && !this.idtipocuenta.equals(other.idtipocuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.Tipocuenta[ idtipocuenta=" + idtipocuenta + " ]";
    }
    
}
