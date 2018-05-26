/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Clientes;
import entidades.Dvds;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelos.DvdsFacade;


/**
 *
 * @author Leonardo
 */
@Named(value = "passagemControle")
@SessionScoped
public class PassagemControle implements Serializable {

 
    @EJB
    private DvdsFacade passagemFacade;
    private Dvds passagem = new Dvds();
    
    private LoginControle loginControle = new LoginControle();
    
    public PassagemControle() {
    }

    public Dvds getPassagem() {
        return passagem;
    }

    public void setPassagem(Dvds passagem) {
        this.passagem = passagem;
    }
    
    public List <Dvds> getListaDvds(){
        return this.passagemFacade.findAll();
    }
    
   
    
    public void reservar(Dvds passagem){
       try{
        passagemFacade.reservarPassagemParaCliente(passagem, this.loginControle.getUserBO());
       getDvdsDisponiveis();
       }catch(Exception e){
           
       }
    }
        
    
    public void cancelarReserva(Dvds passagem){
        passagemFacade.cancelarReservaDoCliente(passagem, this.loginControle.getUserBO());
    }
    
    public List <Dvds> getDvdsDisponiveis(){
        return passagemFacade.listarDvdsDisponiveis();
    }
    
    public List <Dvds> getReservas(){
        Clientes cliente = this.loginControle.getUserBO();   
        return passagemFacade.listarReservas(cliente);
    }
    
    
    
    
    
    
   
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
        
}
