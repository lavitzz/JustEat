/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.Menu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lavitz
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> {
    @PersistenceContext(unitName = "JustEat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }
    
    public List<Menu> findByRestaurante(String cif) {
        Query q;
        List<Menu> listaMenus;        
        
        q = em.createQuery("SELECT m FROM Restaurante r JOIN r.menuCollection m WHERE m.cif.cif = :cif");
        q.setParameter("cif", cif);
        listaMenus = q.getResultList();
        return listaMenus;
    }
}
