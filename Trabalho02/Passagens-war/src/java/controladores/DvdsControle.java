/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Dvds;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Scope;
import javax.servlet.http.HttpServletRequest;
import modelos.DvdsFacade;

/**
 *
 * @author gabri
 */
@Named(value = "dvdsControle")
@SessionScoped
public class DvdsControle implements Serializable{
    
    @EJB
    private DvdsFacade dvdsFacade;
    private Dvds dvds = new Dvds();
    
    private LoginControle loginControle = new LoginControle();
    
    public DvdsControle() {
    
    }

    public Dvds getDvds() {
        return dvds;
    }

    public void setDvds(Dvds dvds) {
        this.dvds = dvds;
    }

    public List<Dvds> getListaDeDvds(){
        return this.dvdsFacade.listarDvds();
    }
    
    
    
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
    
}
