/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.UsuarioRegistrado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lavitz
 */
@Stateless
public class UsuarioRegistradoFacade extends AbstractFacade<UsuarioRegistrado> {
    @PersistenceContext(unitName = "JustEat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRegistradoFacade() {
        super(UsuarioRegistrado.class);
    }
    
}
