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
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author lavitz
 */
@Entity
@Table(name = "PLATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p"),
    @NamedQuery(name = "Plato.findByIdPlato", query = "SELECT p FROM Plato p WHERE p.idPlato = :idPlato"),
    @NamedQuery(name = "Plato.findByNombre", query = "SELECT p FROM Plato p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Plato.findByPrecio", query = "SELECT p FROM Plato p WHERE p.precio = :precio"),
    @NamedQuery(name = "Plato.findByDescripcion", query = "SELECT p FROM Plato p WHERE p.descripcion = :descripcion")})
public class Plato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PLATO")
    private Integer idPlato;
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idPlato")
    private Collection<Pedido> pedidoCollection;
    @JoinColumn(name = "CIF", referencedColumnName = "CIF")
    @ManyToOne(optional = false)
    private Restaurante cif;

    public Plato() {
    }

    public Plato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public Restaurante getCif() {
        return cif;
    }

    public void setCif(Restaurante cif) {
        this.cif = cif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlato != null ? idPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idPlato == null && other.idPlato != null) || (this.idPlato != null && !this.idPlato.equals(other.idPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ea.entity.Plato[ idPlato=" + idPlato + " ]";
    }
    
}
