/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.services;

import ea.ejb.PedidoFacade;
import ea.ejb.UsuarioRegistradoFacade;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author lavitz
 */
@Singleton
@LocalBean
public class EstadisticaSoapService {
    @EJB
    private UsuarioRegistradoFacade usuarioRegistradoFacade;
    @EJB
    private PedidoFacade pedidoFacade;
    
    //Devuelve el numero de usuarios del sistema.
    public int getNumUsuarios(){
        int num=-1;
        num = usuarioRegistradoFacade.count();
        return num;
    }
    
    
    public String[] getTopFiveMenus(){
        
        List lista = pedidoFacade.menusMasPedidos();
        
        String[] definitiva;
        int tamaño=10;
        if(lista.size()<5)
            tamaño=lista.size()*2;
        definitiva = new String[tamaño];
        for(int i=0;i<5;i++){
            if(i+1>lista.size()){
                break;
            }
            Object[] temp =  (Object[]) lista.get(i);
            int e = i*2;
            definitiva[e]= (String)temp[0];
            definitiva[e+1]= Integer.toString((Integer)temp[1]);
        }
        return definitiva;
    }
    
    public String[] getTopTenRestaurantes(){
        
        List lista = pedidoFacade.restaurantesPopulares();
        
        String[] definitiva;
        int tamaño=20;
        if(lista.size()<10)
            tamaño=lista.size()*2;
        
        definitiva = new String[tamaño];
        for(int i=0;i<10;i++){
            if(i+1>lista.size()){
                break;
            }
            Object[] temp =  (Object[]) lista.get(i);
            int e = i*2;
            definitiva[e]= (String)temp[0];
            definitiva[e+1]= Integer.toString((Integer)temp[1]);
        }
        return definitiva;
    }
    
    public String[] getTopFiveClientes(){
         
        List lista = pedidoFacade.ClientesConMasPedidos();
         
        String[] definitiva;
        int tamaño=20;
        if(lista.size()<5)
            tamaño=lista.size()*2;
        definitiva = new String[tamaño];
        for(int i=0;i<5;i++){
            if(i+1>lista.size()){
                break;
            }
            Object[] temp =  (Object[]) lista.get(i);
            int e = i*4;
            definitiva[e]= (String)temp[0];
            definitiva[e+1]= (String)temp[1];
            definitiva[e+2]= (String)temp[2];
            definitiva[e+3]= Integer.toString((Integer)temp[3]);
 
        }
        return definitiva;
    }
     
    public String[] getDistintosCodPostales(){
         
        List lista = usuarioRegistradoFacade.distintosCodPostales();
         
         
        int cont=0;
        Iterator it = lista.iterator();
        String[] definitiva= new String[lista.size()];
        while(it.hasNext()){
            definitiva[cont]=(String)it.next();
            cont++;
        }
        return definitiva;
    }
    
    public int getUsuariosbyCP(String cp){
        return usuarioRegistradoFacade.usuariosPorCodPostal(cp);
    }
}
