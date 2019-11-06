/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnetwork.accountantsoftware.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DanielaC
 */
@Entity
@Table(name = "detallemovimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallemovimiento.findAll", query = "SELECT d FROM Detallemovimiento d")
    , @NamedQuery(name = "Detallemovimiento.findByIddetallemovimiento", query = "SELECT d FROM Detallemovimiento d WHERE d.iddetallemovimiento = :iddetallemovimiento")
    , @NamedQuery(name = "Detallemovimiento.findByTipodocumento", query = "SELECT d FROM Detallemovimiento d WHERE d.tipodocumento = :tipodocumento")
    , @NamedQuery(name = "Detallemovimiento.findByFechainicio", query = "SELECT d FROM Detallemovimiento d WHERE d.fechainicio = :fechainicio")
    , @NamedQuery(name = "Detallemovimiento.findByFechafin", query = "SELECT d FROM Detallemovimiento d WHERE d.fechafin = :fechafin")})
public class Detallemovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallemovimiento")
    private Integer iddetallemovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipodocumento")
    private String tipodocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @JoinColumn(name = "idcargopersona", referencedColumnName = "idcargopersona")
    @ManyToOne(optional = false)
    private CargoPersona idcargopersona;
    @JoinColumn(name = "idcuenta", referencedColumnName = "idcuenta")
    @ManyToOne(optional = false)
    private Cuenta idcuenta;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne(optional = false)
    private Factura idfactura;
    @JoinColumn(name = "idpersonatipopersona", referencedColumnName = "idpersonatipopersona")
    @ManyToOne(optional = false)
    private PersonaTipopersona idpersonatipopersona;

    public Detallemovimiento() {
    }

    public Detallemovimiento(Integer iddetallemovimiento) {
        this.iddetallemovimiento = iddetallemovimiento;
    }

    public Detallemovimiento(Integer iddetallemovimiento, String tipodocumento, Date fechainicio, Date fechafin) {
        this.iddetallemovimiento = iddetallemovimiento;
        this.tipodocumento = tipodocumento;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Integer getIddetallemovimiento() {
        return iddetallemovimiento;
    }

    public void setIddetallemovimiento(Integer iddetallemovimiento) {
        this.iddetallemovimiento = iddetallemovimiento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public CargoPersona getIdcargopersona() {
        return idcargopersona;
    }

    public void setIdcargopersona(CargoPersona idcargopersona) {
        this.idcargopersona = idcargopersona;
    }

    public Cuenta getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Cuenta idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Factura getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Factura idfactura) {
        this.idfactura = idfactura;
    }

    public PersonaTipopersona getIdpersonatipopersona() {
        return idpersonatipopersona;
    }

    public void setIdpersonatipopersona(PersonaTipopersona idpersonatipopersona) {
        this.idpersonatipopersona = idpersonatipopersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallemovimiento != null ? iddetallemovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallemovimiento)) {
            return false;
        }
        Detallemovimiento other = (Detallemovimiento) object;
        if ((this.iddetallemovimiento == null && other.iddetallemovimiento != null) || (this.iddetallemovimiento != null && !this.iddetallemovimiento.equals(other.iddetallemovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.Detallemovimiento[ iddetallemovimiento=" + iddetallemovimiento + " ]";
    }
    
}
