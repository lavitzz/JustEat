/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.Restaurante;
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
public class RestauranteFacade extends AbstractFacade<Restaurante> {
    @PersistenceContext(unitName = "JustEat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RestauranteFacade() {
        super(Restaurante.class);
    }
    
    public List<Restaurante> buscarPorCP(String codpostal) {
        Query q;
        
        q = em.createNamedQuery("Restaurante.findByCodpostal");
        q.setParameter("codpostal", codpostal);
        return q.getResultList();
    }    
}
