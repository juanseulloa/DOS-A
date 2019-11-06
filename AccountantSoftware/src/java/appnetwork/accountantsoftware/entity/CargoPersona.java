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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DanielaC
 */
@Entity
@Table(name = "cargo_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoPersona.findAll", query = "SELECT c FROM CargoPersona c")
    , @NamedQuery(name = "CargoPersona.findByIdcargopersona", query = "SELECT c FROM CargoPersona c WHERE c.idcargopersona = :idcargopersona")})
public class CargoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcargopersona")
    private Integer idcargopersona;
    @JoinColumn(name = "idcargo", referencedColumnName = "idcargo")
    @ManyToOne(optional = false)
    private Cargo idcargo;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcargopersona")
    private Collection<Detallemovimiento> detallemovimientoCollection;

    public CargoPersona() {
    }

    public CargoPersona(Integer idcargopersona) {
        this.idcargopersona = idcargopersona;
    }

    public Integer getIdcargopersona() {
        return idcargopersona;
    }

    public void setIdcargopersona(Integer idcargopersona) {
        this.idcargopersona = idcargopersona;
    }

    public Cargo getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Cargo idcargo) {
        this.idcargo = idcargo;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    @XmlTransient
    public Collection<Detallemovimiento> getDetallemovimientoCollection() {
        return detallemovimientoCollection;
    }

    public void setDetallemovimientoCollection(Collection<Detallemovimiento> detallemovimientoCollection) {
        this.detallemovimientoCollection = detallemovimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcargopersona != null ? idcargopersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoPersona)) {
            return false;
        }
        CargoPersona other = (CargoPersona) object;
        if ((this.idcargopersona == null && other.idcargopersona != null) || (this.idcargopersona != null && !this.idcargopersona.equals(other.idcargopersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.CargoPersona[ idcargopersona=" + idcargopersona + " ]";
    }
    
}
