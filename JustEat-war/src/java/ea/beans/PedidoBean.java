/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.beans;

import ea.ejb.PedidoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author lavitz
 */
@ManagedBean
@RequestScoped
public class PedidoBean {
    @EJB
    private PedidoFacade pedidoFacade;
    
    /**
     * Creates a new instance of PedidoBean
     */
    public PedidoBean() {
    }
    
    public String doAddPedido(){
        this.pedidoFacade.create(null);
        return "";
    }
}
