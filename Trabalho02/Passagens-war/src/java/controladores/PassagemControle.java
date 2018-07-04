/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Clientes;
import entidades.Passagens;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelos.PassagensFacade;


/**
 *
 * @author Gabriel
 */
@Named(value = "passagemControle")
@SessionScoped
public class PassagemControle implements Serializable {

 
    @EJB
    private PassagensFacade passagemFacade;
    private Passagens passagem = new Passagens();
    
    private LoginControle loginControle = new LoginControle();
    
    public PassagemControle() {
    }

    public Passagens getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagens passagem) {
        this.passagem = passagem;
    }
    
    public List <Passagens> getListaPassagens(){
        return this.passagemFacade.findAll();
    }
    
   
    
    public void reservar(Passagens passagem){
       try{
        passagemFacade.reservarPassagemParaCliente(passagem, this.loginControle.getUserBO());
       getPassagensDisponiveis();
       }catch(Exception e){
           
       }
    }
        
    
    public void cancelarReserva(Passagens passagem){
        passagemFacade.cancelarReservaDoCliente(passagem, this.loginControle.getUserBO());
    }
    
    public List <Passagens> getPassagensDisponiveis(){
        return passagemFacade.listarPassagensDisponiveis();
    }
    
    public List <Passagens> getReservas(){
        Clientes cliente = this.loginControle.getUserBO();   
        return passagemFacade.listarReservas(cliente);
    }
    
    
    
    
    
    
   
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
        
}
