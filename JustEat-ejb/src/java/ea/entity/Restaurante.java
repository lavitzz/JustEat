/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author lavitz
 */
@Entity
@Table(name = "RESTAURANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurante.findAll", query = "SELECT r FROM Restaurante r"),
    @NamedQuery(name = "Restaurante.findByCif", query = "SELECT r FROM Restaurante r WHERE r.cif = :cif"),
    @NamedQuery(name = "Restaurante.findByPassword", query = "SELECT r FROM Restaurante r WHERE r.password = :password"),
    @NamedQuery(name = "Restaurante.findByNombre", query = "SELECT r FROM Restaurante r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Restaurante.findByDireccion", query = "SELECT r FROM Restaurante r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "Restaurante.findByCodpostal", query = "SELECT r FROM Restaurante r WHERE r.codpostal = :codpostal"),
    @NamedQuery(name = "Restaurante.findByCiudad", query = "SELECT r FROM Restaurante r WHERE r.ciudad = :ciudad"),
    @NamedQuery(name = "Restaurante.findByTelefono", query = "SELECT r FROM Restaurante r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "Restaurante.findByEmail", query = "SELECT r FROM Restaurante r WHERE r.email = :email"),
    @NamedQuery(name = "Restaurante.findByLatitud", query = "SELECT r FROM Restaurante r WHERE r.latitud = :latitud"),
    @NamedQuery(name = "Restaurante.findByLongitud", query = "SELECT r FROM Restaurante r WHERE r.longitud = :longitud"),
    @NamedQuery(name = "Restaurante.findByGastosenvio", query = "SELECT r FROM Restaurante r WHERE r.gastosenvio = :gastosenvio")})
public class Restaurante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CIF")
    private String cif;
    @Size(max = 10)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 5)
    @Column(name = "CODPOSTAL")
    private String codpostal;
    @Size(max = 20)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Size(max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 25)
    @Column(name = "LATITUD")
    private String latitud;
    @Size(max = 25)
    @Column(name = "LONGITUD")
    private String longitud;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GASTOSENVIO")
    private BigDecimal gastosenvio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cif")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cif")
    private Collection<Menu> menuCollection;

    public Restaurante() {
    }

    public Restaurante(String cif) {
        this.cif = cif;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getGastosenvio() {
        return gastosenvio;
    }

    public void setGastosenvio(BigDecimal gastosenvio) {
        this.gastosenvio = gastosenvio;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cif != null ? cif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurante)) {
            return false;
        }
        Restaurante other = (Restaurante) object;
        if ((this.cif == null && other.cif != null) || (this.cif != null && !this.cif.equals(other.cif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ea.entity.Restaurante[ cif=" + cif + " ]";
    }
    
}
