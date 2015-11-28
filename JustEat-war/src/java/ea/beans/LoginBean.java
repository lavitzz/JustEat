/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.beans;

import ea.ejb.UsuarioRegistradoFacade;
import ea.entity.UsuarioRegistrado;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lavitz
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    @EJB
    private UsuarioRegistradoFacade usuarioRegistradoFacade;
    UsuarioRegistrado user;
    @NotNull
    @Size(min=6, max=60)
    private String email;
    @NotNull
    @Size(min=4, max=20)
    private String pwd;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        
    }

    public UsuarioRegistrado getUser() {
        return user;
    }

    public void setUser(UsuarioRegistrado user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public String doLogin(){
        this.user = this.usuarioRegistradoFacade.usuarioIsRegistrado(this.email, this.pwd);
        if (user!=null){
            return "VistaLogued";
        }
        else{
            return "VistaInicio";
        }
    }
    
    public String doLogout(){
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sesion.invalidate();
        return "VistaInicio";
    }
}
