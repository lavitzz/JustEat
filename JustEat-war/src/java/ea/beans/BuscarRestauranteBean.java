/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.beans;

import ea.ejb.MenuFacade;
import ea.ejb.RestauranteFacade;
import ea.entity.Menu;
import ea.entity.Restaurante;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author lavitz
 */
@ManagedBean
@SessionScoped
public class BuscarRestauranteBean {
    @EJB
    private MenuFacade menuFacade;
    @EJB
    private RestauranteFacade restauranteFacade;
    
    private String codigoPostal;
    private List<Restaurante> restaurantes;
    private Restaurante restauranteSeleccionado;
    private List<Menu> menus;
    /**
     * Creates a new instance of BuscarRestaurante
     */
    public BuscarRestauranteBean() {
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Restaurante getRestauranteSeleccionado() {
        return restauranteSeleccionado;
    }

    public void setRestauranteSeleccionado(Restaurante restauranteSeleccionado) {
        this.restauranteSeleccionado = restauranteSeleccionado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
    
    public String doBuscarRestaurantes(){
        restaurantes = this.restauranteFacade.buscarPorCP(this.codigoPostal);
        return "VistaRestaurantes.xhtml";
    }
    
    public String doBuscarMenus(){
        menus = this.menuFacade.findByRestaurante(restauranteSeleccionado.getCif());
        return "VistaMenus.xhtml";
    }
}
