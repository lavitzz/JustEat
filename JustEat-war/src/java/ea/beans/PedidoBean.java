/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.beans;

import ea.ejb.PedidoFacade;
import ea.entity.Menu;
import ea.entity.Pedido;
import ea.entity.Restaurante;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author lavitz
 */
@ManagedBean
@SessionScoped
public class PedidoBean {
    @EJB
    private PedidoFacade pedidoFacade;
    
    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
    
    private Menu menuSeleccionado;
    private Pedido pedido;
    
    /**
     * Creates a new instance of PedidoBean
     */
    public PedidoBean() {
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Menu getMenuSeleccionado() {
        return menuSeleccionado;
    }

    public void setMenuSeleccionado(Menu menuSeleccionado) {
        this.menuSeleccionado = menuSeleccionado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void doAddPedido(){
        Restaurante res = menuSeleccionado.getCif();
        Pedido p = new Pedido();
        p.setCif(res);
        p.setDni(loginBean.getUser());
        p.setGastosenvio(new BigDecimal(0));
        p.setIdMenu(menuSeleccionado);
        //p.setIdPedido(15);
        p.setPreciototal(BigDecimal.ZERO);
        p.setCantidadmenu(1);
        this.pedidoFacade.create(p);
    }
}
