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
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByIdcargo", query = "SELECT c FROM Cargo c WHERE c.idcargo = :idcargo")
    , @NamedQuery(name = "Cargo.findByNombrecargo", query = "SELECT c FROM Cargo c WHERE c.nombrecargo = :nombrecargo")
    , @NamedQuery(name = "Cargo.findByIbc", query = "SELECT c FROM Cargo c WHERE c.ibc = :ibc")
    , @NamedQuery(name = "Cargo.findByHoraordinaria", query = "SELECT c FROM Cargo c WHERE c.horaordinaria = :horaordinaria")
    , @NamedQuery(name = "Cargo.findByDias", query = "SELECT c FROM Cargo c WHERE c.dias = :dias")
    , @NamedQuery(name = "Cargo.findBySalariobasico", query = "SELECT c FROM Cargo c WHERE c.salariobasico = :salariobasico")
    , @NamedQuery(name = "Cargo.findByAuxtransporte", query = "SELECT c FROM Cargo c WHERE c.auxtransporte = :auxtransporte")
    , @NamedQuery(name = "Cargo.findByHorasextras", query = "SELECT c FROM Cargo c WHERE c.horasextras = :horasextras")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcargo")
    private Integer idcargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrecargo")
    private String nombrecargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ibc")
    private int ibc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaordinaria")
    private int horaordinaria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias")
    private int dias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salariobasico")
    private int salariobasico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auxtransporte")
    private int auxtransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horasextras")
    private int horasextras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcargo")
    private Collection<CargoPersona> cargoPersonaCollection;

    public Cargo() {
    }

    public Cargo(Integer idcargo) {
        this.idcargo = idcargo;
    }

    public Cargo(Integer idcargo, String nombrecargo, int ibc, int horaordinaria, int dias, int salariobasico, int auxtransporte, int horasextras) {
        this.idcargo = idcargo;
        this.nombrecargo = nombrecargo;
        this.ibc = ibc;
        this.horaordinaria = horaordinaria;
        this.dias = dias;
        this.salariobasico = salariobasico;
        this.auxtransporte = auxtransporte;
        this.horasextras = horasextras;
    }

    public Integer getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Integer idcargo) {
        this.idcargo = idcargo;
    }

    public String getNombrecargo() {
        return nombrecargo;
    }

    public void setNombrecargo(String nombrecargo) {
        this.nombrecargo = nombrecargo;
    }

    public int getIbc() {
        return ibc;
    }

    public void setIbc(int ibc) {
        this.ibc = ibc;
    }

    public int getHoraordinaria() {
        return horaordinaria;
    }

    public void setHoraordinaria(int horaordinaria) {
        this.horaordinaria = horaordinaria;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getSalariobasico() {
        return salariobasico;
    }

    public void setSalariobasico(int salariobasico) {
        this.salariobasico = salariobasico;
    }

    public int getAuxtransporte() {
        return auxtransporte;
    }

    public void setAuxtransporte(int auxtransporte) {
        this.auxtransporte = auxtransporte;
    }

    public int getHorasextras() {
        return horasextras;
    }

    public void setHorasextras(int horasextras) {
        this.horasextras = horasextras;
    }

    @XmlTransient
    public Collection<CargoPersona> getCargoPersonaCollection() {
        return cargoPersonaCollection;
    }

    public void setCargoPersonaCollection(Collection<CargoPersona> cargoPersonaCollection) {
        this.cargoPersonaCollection = cargoPersonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcargo != null ? idcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idcargo == null && other.idcargo != null) || (this.idcargo != null && !this.idcargo.equals(other.idcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.Cargo[ idcargo=" + idcargo + " ]";
    }
    
}
