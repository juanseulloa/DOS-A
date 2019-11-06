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
@Table(name = "persona_tipopersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonaTipopersona.findAll", query = "SELECT p FROM PersonaTipopersona p")
    , @NamedQuery(name = "PersonaTipopersona.findByIdpersonatipopersona", query = "SELECT p FROM PersonaTipopersona p WHERE p.idpersonatipopersona = :idpersonatipopersona")})
public class PersonaTipopersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonatipopersona")
    private Integer idpersonatipopersona;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idtipopersona", referencedColumnName = "idtipopersona")
    @ManyToOne(optional = false)
    private Tipopersona idtipopersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonatipopersona")
    private Collection<Cuenta> cuentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonatipopersona")
    private Collection<Detallemovimiento> detallemovimientoCollection;

    public PersonaTipopersona() {
    }

    public PersonaTipopersona(Integer idpersonatipopersona) {
        this.idpersonatipopersona = idpersonatipopersona;
    }

    public Integer getIdpersonatipopersona() {
        return idpersonatipopersona;
    }

    public void setIdpersonatipopersona(Integer idpersonatipopersona) {
        this.idpersonatipopersona = idpersonatipopersona;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Tipopersona getIdtipopersona() {
        return idtipopersona;
    }

    public void setIdtipopersona(Tipopersona idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
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
        hash += (idpersonatipopersona != null ? idpersonatipopersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaTipopersona)) {
            return false;
        }
        PersonaTipopersona other = (PersonaTipopersona) object;
        if ((this.idpersonatipopersona == null && other.idpersonatipopersona != null) || (this.idpersonatipopersona != null && !this.idpersonatipopersona.equals(other.idpersonatipopersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.PersonaTipopersona[ idpersonatipopersona=" + idpersonatipopersona + " ]";
    }
    
}
