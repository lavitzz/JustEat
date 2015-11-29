/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.Pedido;
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
public class PedidoFacade extends AbstractFacade<Pedido> {
    @PersistenceContext(unitName = "JustEat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
    public List<Pedido> buscarPedidoUsuario(String dni) {
        Query q;
        List<Pedido> listaPedidos;
        
        q = em.createQuery("SELECT p FROM Pedido p WHERE p.dni.dni = :dni AND p.pagado = 0");
        q.setParameter("dni", dni);
        listaPedidos = q.getResultList();
        
        return listaPedidos;
    }
}
