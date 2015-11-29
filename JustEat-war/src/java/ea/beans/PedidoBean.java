/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.beans;

import ea.ejb.PedidoFacade;
import ea.entity.Menu;
import ea.entity.Pedido;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    private Pedido pedidoSeleccionado;
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private String cantidadSeleccionada = "";
    private Integer[] cantidades = {1,2,3,4,5};
    /**
     * Creates a new instance of PedidoBean
     */
    public PedidoBean() {
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }

    public Integer[] getCantidades() {
        return cantidades;
    }

    public void setCantidades(Integer[] cantidades) {
        this.cantidades = cantidades;
    }

    public String getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public void setCantidadSeleccionada(String cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
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
        pedido = new Pedido();
        
        pedido.setCif(menuSeleccionado.getCif());
        pedido.setDni(loginBean.getUser());
        pedido.setIdMenu(menuSeleccionado);
        pedido.setPagado(0);
        pedido.setCantidadmenu(Integer.parseInt(cantidadSeleccionada));
        
        pedidos.add(pedido);
        
        return "VistaMenus.xhtml";
    }
    
    public void doEliminarPedido(){
        int i = pedidos.indexOf(pedidoSeleccionado);
        if (i!=-1){
            pedidos.remove(i);
        }
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
}
