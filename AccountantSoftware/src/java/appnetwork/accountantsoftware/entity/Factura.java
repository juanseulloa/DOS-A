/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnetwork.accountantsoftware.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DanielaC
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.idfactura = :idfactura")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Factura.findByFechavencimiento", query = "SELECT f FROM Factura f WHERE f.fechavencimiento = :fechavencimiento")
    , @NamedQuery(name = "Factura.findByCliente", query = "SELECT f FROM Factura f WHERE f.cliente = :cliente")
    , @NamedQuery(name = "Factura.findByTipodocumento", query = "SELECT f FROM Factura f WHERE f.tipodocumento = :tipodocumento")
    , @NamedQuery(name = "Factura.findByNumerodocumento", query = "SELECT f FROM Factura f WHERE f.numerodocumento = :numerodocumento")
    , @NamedQuery(name = "Factura.findByDireccion", query = "SELECT f FROM Factura f WHERE f.direccion = :direccion")
    , @NamedQuery(name = "Factura.findByTelefono", query = "SELECT f FROM Factura f WHERE f.telefono = :telefono")
    , @NamedQuery(name = "Factura.findByCiudad", query = "SELECT f FROM Factura f WHERE f.ciudad = :ciudad")
    , @NamedQuery(name = "Factura.findByFormapago", query = "SELECT f FROM Factura f WHERE f.formapago = :formapago")
    , @NamedQuery(name = "Factura.findByOrdencompra", query = "SELECT f FROM Factura f WHERE f.ordencompra = :ordencompra")
    , @NamedQuery(name = "Factura.findByCantidad", query = "SELECT f FROM Factura f WHERE f.cantidad = :cantidad")
    , @NamedQuery(name = "Factura.findByDetalle", query = "SELECT f FROM Factura f WHERE f.detalle = :detalle")
    , @NamedQuery(name = "Factura.findByValorunitario", query = "SELECT f FROM Factura f WHERE f.valorunitario = :valorunitario")
    , @NamedQuery(name = "Factura.findByValortotal", query = "SELECT f FROM Factura f WHERE f.valortotal = :valortotal")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cliente")
    private String cliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipodocumento")
    private int tipodocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerodocumento")
    private int numerodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "formapago")
    private String formapago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ordencompra")
    private String ordencompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorunitario")
    private int valorunitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valortotal")
    private int valortotal;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfactura")
    private Collection<Detallemovimiento> detallemovimientoCollection;

    public Factura() {
    }

    public Factura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Factura(Integer idfactura, Date fecha, Date fechavencimiento, String cliente, int tipodocumento, int numerodocumento, String direccion, int telefono, String ciudad, String formapago, String ordencompra, int cantidad, String detalle, int valorunitario, int valortotal) {
        this.idfactura = idfactura;
        this.fecha = fecha;
        this.fechavencimiento = fechavencimiento;
        this.cliente = cliente;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.formapago = formapago;
        this.ordencompra = ordencompra;
        this.cantidad = cantidad;
        this.detalle = detalle;
        this.valorunitario = valorunitario;
        this.valortotal = valortotal;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public int getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(int numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getOrdencompra() {
        return ordencompra;
    }

    public void setOrdencompra(String ordencompra) {
        this.ordencompra = ordencompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(int valorunitario) {
        this.valorunitario = valorunitario;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
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
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appnetwork.accountantsoftware.entity.Factura[ idfactura=" + idfactura + " ]";
    }
    
}
