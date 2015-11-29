/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.UsuarioRegistrado;
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
    
    public UsuarioRegistrado usuarioIsRegistrado(String email,String pass){
        Query q;
        List<UsuarioRegistrado> listaU;
        UsuarioRegistrado usuario;
        
        q = em.createQuery("SELECT u FROM UsuarioRegistrado u WHERE u.email = :email AND u.password = :pass");
        q.setParameter("email", email);
        q.setParameter("pass", pass);
        listaU = q.getResultList();
        if (!listaU.isEmpty()){
            usuario = listaU.get(0);
        }
        else{
            usuario = null;
        }
        return usuario;      
    }
    
    public List distintosCodPostales(){
         
        List lista = em.createNativeQuery("Select Distinct(CODPOSTAL) "
                + "from USUARIO_REGISTRADO order by CODPOSTAL").getResultList();
                 
        return lista;
    }
     
    public int usuariosPorCodPostal(String cPostal){
         
        List lista;
        lista = em.createQuery("Select u from UsuarioRegistrado u  where u.codpostal=:codPostal").setParameter("codPostal", cPostal).getResultList();
         
        return lista.size();
    }
}
