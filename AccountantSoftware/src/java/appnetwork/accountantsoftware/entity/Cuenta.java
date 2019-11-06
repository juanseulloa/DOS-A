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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DanielaC
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByIdcuenta", query = "SELECT c FROM Cuenta c WHERE c.idcuenta = :idcuenta")
    , @NamedQuery(name = "Cuenta.findByIdsubcuenta", query = "SELECT c FROM Cuenta c WHERE c.idsubcuenta = :idsubcuenta")
    , @NamedQuery(name = "Cuenta.findByValorcuenta", query = "SELECT c FROM Cuenta c WHERE c.valorcuenta = :valorcuenta")
    , @NamedQuery(name = "Cuenta.findByDetalle", query = "SELECT c FROM Cuenta c WHERE c.detalle = :detalle")
    , @NamedQuery(name = "Cuenta.findByNaturaleza", query = "SELECT c FROM Cuenta c WHERE c.naturaleza = :naturaleza")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuenta")
    private Integer idcuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsubcuenta")
    private int idsubcuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorcuenta")
    private int valorcuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naturaleza")
    private String naturaleza;
    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa idempresa;
    @JoinColumn(name = "idpersonatipopersona", referencedColumnName = "idpersonatipopersona")
    @ManyToOne(optional = false)
    private PersonaTipopersona idpersonatipopersona;
    @JoinColumn(name = "idpuc", referencedColumnName = "idpuc")
    @ManyToOne(optional = false)
    private Puc idpuc;
    @JoinColumn(name = "idtipocuenta", referencedColumnName = "idtipocuenta")
    @ManyToOne(optional = false)
    private Tipocuenta idtipocuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuenta")
    private Collection<Detallemovimiento> detallemovimientoCollection;

    public Cuenta() {
    }

    public Cuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Cuenta(Integer idcuenta, int idsubcuenta, int valorcuenta, String detalle, String naturaleza) {
        this.idcuenta = idcuenta;
        this.idsubcuenta = idsubcuenta;
        this.valorcuenta = valorcuenta;
        this.detalle = detalle;
        this.naturaleza = naturaleza;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public int getIdsubcuenta() {
        return idsubcuenta;
    }

    public void setIdsubcuenta(int idsubcuenta) {
        this.idsubcuenta = idsubcuenta;
    }

    public int getValorcuenta() {
        return valorcuenta;
    }

    public void setValorcuenta(int valorcuenta) {
        this.valorcuenta = valorcuenta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }

    public PersonaTipopersona getIdpersonatipopersona() {
        return idpersonatipopersona;
    }

    public void setIdpersonatipopersona(PersonaTipopersona idpersonatipopersona) {
        this.idpersonatipopersona = idpersonatipopersona;
    }

    public Puc getIdpuc() {
        return idpuc;
    }

    public void setIdpuc(Puc idpuc) {
        this.idpuc = idpuc;
    }

    public Tipocuenta getIdtipocuenta() {
        return idtipocuenta;
    }

    public void setIdtipocuenta(Tipocuenta idtipocuenta) {
        this.idtipocuenta = idtipocuenta;
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
        hash += (idcuenta != null ? idcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idcuenta == null && other.idcuenta != null) || (this.idcuenta != null && !this.idcuenta.equals(other.idcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.Cuenta[ idcuenta=" + idcuenta + " ]";
    }
    
}
