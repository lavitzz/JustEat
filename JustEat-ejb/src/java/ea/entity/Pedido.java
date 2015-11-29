/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lavitz
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByCantidadmenu", query = "SELECT p FROM Pedido p WHERE p.cantidadmenu = :cantidadmenu"),
    @NamedQuery(name = "Pedido.findByPagado", query = "SELECT p FROM Pedido p WHERE p.pagado = :pagado")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PEDIDO")
    private Integer idPedido;
    @Column(name = "CANTIDADMENU")
    private Integer cantidadmenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGADO")
    private int pagado;
    @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU")
    @ManyToOne
    private Menu idMenu;
    @JoinColumn(name = "CIF", referencedColumnName = "CIF")
    @ManyToOne(optional = false)
    private Restaurante cif;
    @JoinColumn(name = "DNI", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private UsuarioRegistrado dni;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, int pagado) {
        this.idPedido = idPedido;
        this.pagado = pagado;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getCantidadmenu() {
        return cantidadmenu;
    }

    public void setCantidadmenu(Integer cantidadmenu) {
        this.cantidadmenu = cantidadmenu;
    }

    public int getPagado() {
        return pagado;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    public Restaurante getCif() {
        return cif;
    }

    public void setCif(Restaurante cif) {
        this.cif = cif;
    }

    public UsuarioRegistrado getDni() {
        return dni;
    }

    public void setDni(UsuarioRegistrado dni) {
        this.dni = dni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ea.entity.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
