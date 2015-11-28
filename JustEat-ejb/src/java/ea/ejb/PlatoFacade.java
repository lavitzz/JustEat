/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.Plato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lavitz
 */
@Stateless
public class PlatoFacade extends AbstractFacade<Plato> {
    @PersistenceContext(unitName = "JustEat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlatoFacade() {
        super(Plato.class);
    }
    
}
