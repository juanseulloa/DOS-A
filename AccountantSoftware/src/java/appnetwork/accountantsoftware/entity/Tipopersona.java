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
@Table(name = "tipopersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopersona.findAll", query = "SELECT t FROM Tipopersona t")
    , @NamedQuery(name = "Tipopersona.findByIdtipopersona", query = "SELECT t FROM Tipopersona t WHERE t.idtipopersona = :idtipopersona")
    , @NamedQuery(name = "Tipopersona.findByNombretipopersona", query = "SELECT t FROM Tipopersona t WHERE t.nombretipopersona = :nombretipopersona")})
public class Tipopersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipopersona")
    private Integer idtipopersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombretipopersona")
    private String nombretipopersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipopersona")
    private Collection<PersonaTipopersona> personaTipopersonaCollection;

    public Tipopersona() {
    }

    public Tipopersona(Integer idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    public Tipopersona(Integer idtipopersona, String nombretipopersona) {
        this.idtipopersona = idtipopersona;
        this.nombretipopersona = nombretipopersona;
    }

    public Integer getIdtipopersona() {
        return idtipopersona;
    }

    public void setIdtipopersona(Integer idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    public String getNombretipopersona() {
        return nombretipopersona;
    }

    public void setNombretipopersona(String nombretipopersona) {
        this.nombretipopersona = nombretipopersona;
    }

    @XmlTransient
    public Collection<PersonaTipopersona> getPersonaTipopersonaCollection() {
        return personaTipopersonaCollection;
    }

    public void setPersonaTipopersonaCollection(Collection<PersonaTipopersona> personaTipopersonaCollection) {
        this.personaTipopersonaCollection = personaTipopersonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipopersona != null ? idtipopersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopersona)) {
            return false;
        }
        Tipopersona other = (Tipopersona) object;
        if ((this.idtipopersona == null && other.idtipopersona != null) || (this.idtipopersona != null && !this.idtipopersona.equals(other.idtipopersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.Tipopersona[ idtipopersona=" + idtipopersona + " ]";
    }
    
}
