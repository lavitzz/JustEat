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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
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
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private Pedido pedidoSeleccionado;
    private String cantidadSeleccionada;
    
    /**
     * Creates a new instance of PedidoBean
     */
    public PedidoBean() {
    }

    public String getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public void setCantidadSeleccionada(String cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
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

    public String doAddPedido(){
        Pedido p = new Pedido();
        
        p.setCif(menuSeleccionado.getCif());
        p.setDni(loginBean.getUser());
        p.setIdMenu(menuSeleccionado);
        p.setCantidadmenu(1);
        p.setPagado(0);
        
        pedidos.add(p);
        
        return "VistaMenus.xhtml";
    }
    
    public void doEliminarPedido(){
        
    }
    
    public void doPagar(){
        Iterator<Pedido> pedidosIterator = pedidos.iterator();
        while (pedidosIterator.hasNext()){
            Pedido p = new Pedido();
            p = pedidosIterator.next();
            p.setPagado(1);
            this.pedidoFacade.create(p);
            pedidosIterator.remove();
        }
    }
    
    @PostConstruct
    public void init(){
        //pedidos = this.pedidoFacade.buscarPedidoUsuario(loginBean.getUser().getDni());
    }
}
