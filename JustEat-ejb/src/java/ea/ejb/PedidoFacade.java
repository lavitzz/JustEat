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
    
    public List menusMasPedidos(){
        
        List lista = em.createNativeQuery("Select m.DESCRIPCION,count(p.ID_MENU)"
                + " as numero from pedido p join menu m on p.ID_MENU=m.ID_MENU group"
                + " by p.ID_MENU, m.DESCRIPCION order by numero desc").getResultList();
                
        return lista;
    }

    public List restaurantesPopulares() {
    
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        List lista = em.createNativeQuery("Select r.NOMBRE,count(p.CIF) as "
                + "numero from pedido p join restaurante r on p.CIF=r.CIF "
                + "group by r.NOMBRE order by numero desc").getResultList();
                
        return lista;
    }
    
    public List ClientesConMasPedidos() {
        List lista = em.createNativeQuery("Select u.NOMBRE, u.APELLIDO1, u.APELLIDO2,count(p.DNI)"
                + " as numero from pedido p join USUARIO_REGISTRADO u on u.DNI=p.DNI group"
                + " by p.DNI, u.nombre, u.apellido1, u.apellido2 order by numero desc").getResultList();                
        return lista;
    }
}
