/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.services;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author lavitz
 */
@WebService(serviceName = "ServicesSoap")
public class ServicesSoap {
    @EJB
    private EstadisticaSoapService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getNumUsuarios")
    public int getNumUsuarios() {
        return ejbRef.getNumUsuarios();
    }

    @WebMethod(operationName = "getTopFiveMenus")
    public String[] getTopFiveMenus() {
        return ejbRef.getTopFiveMenus();
    }

    @WebMethod(operationName = "getTopTenRestaurantes")
    public String[] getTopTenRestaurantes() {
        return ejbRef.getTopTenRestaurantes();
    }

    @WebMethod(operationName = "getTopFiveClientes")
    public String[] getTopFiveClientes() {
        return ejbRef.getTopFiveClientes();
    }

    @WebMethod(operationName = "getDistintosCodPostales")
    public String[] getDistintosCodPostales() {
        return ejbRef.getDistintosCodPostales();
    }

    @WebMethod(operationName = "getUsuariosbyCP")
    public int getUsuariosbyCP(@WebParam(name = "cp") String cp) {
        return ejbRef.getUsuariosbyCP(cp);
    }
    
}
