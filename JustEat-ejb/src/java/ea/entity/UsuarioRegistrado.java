/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.entity;

import java.io.Serializable;
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
@Table(name = "USUARIO_REGISTRADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRegistrado.findAll", query = "SELECT u FROM UsuarioRegistrado u"),
    @NamedQuery(name = "UsuarioRegistrado.findByDni", query = "SELECT u FROM UsuarioRegistrado u WHERE u.dni = :dni"),
    @NamedQuery(name = "UsuarioRegistrado.findByPassword", query = "SELECT u FROM UsuarioRegistrado u WHERE u.password = :password"),
    @NamedQuery(name = "UsuarioRegistrado.findByNombre", query = "SELECT u FROM UsuarioRegistrado u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "UsuarioRegistrado.findByApellido1", query = "SELECT u FROM UsuarioRegistrado u WHERE u.apellido1 = :apellido1"),
    @NamedQuery(name = "UsuarioRegistrado.findByApellido2", query = "SELECT u FROM UsuarioRegistrado u WHERE u.apellido2 = :apellido2"),
    @NamedQuery(name = "UsuarioRegistrado.findByDireccion", query = "SELECT u FROM UsuarioRegistrado u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "UsuarioRegistrado.findByCodpostal", query = "SELECT u FROM UsuarioRegistrado u WHERE u.codpostal = :codpostal"),
    @NamedQuery(name = "UsuarioRegistrado.findByCiudad", query = "SELECT u FROM UsuarioRegistrado u WHERE u.ciudad = :ciudad"),
    @NamedQuery(name = "UsuarioRegistrado.findByTelefono", query = "SELECT u FROM UsuarioRegistrado u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "UsuarioRegistrado.findByEmail", query = "SELECT u FROM UsuarioRegistrado u WHERE u.email = :email")})
public class UsuarioRegistrado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DNI")
    private String dni;
    @Size(max = 10)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 20)
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Size(max = 20)
    @Column(name = "APELLIDO2")
    private String apellido2;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dni")
    private Collection<Pedido> pedidoCollection;

    public UsuarioRegistrado() {
    }

    public UsuarioRegistrado(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRegistrado)) {
            return false;
        }
        UsuarioRegistrado other = (UsuarioRegistrado) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ea.entity.UsuarioRegistrado[ dni=" + dni + " ]";
    }
    
}
