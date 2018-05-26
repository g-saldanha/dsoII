/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Clientes;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import modelos.ClientesFacade;
import org.primefaces.context.RequestContext;

import org.apache.log4j.Logger;

/**
 *
 * @author Leonardo
 */
@Named(value = "loginControle")
@SessionScoped
public class LoginControle implements Serializable {
    
    private static Logger logger = Logger.getLogger(LoginControle.class);
    @EJB
    private ClientesFacade clientesFacade;
    private String login;
    private String senha;
    
    @ManagedProperty(value = "#{userBO}")
    private Clientes userBO;

    public LoginControle() {
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public String logar(){
        try{
        Clientes cliente = clientesFacade.verificaUsuario(login, senha);
        if(cliente == null){
            throw new Exception ("Erro no login");
        }else{
      
        SessionContext.getInstance().setUsuarioLogado(cliente);
        return "home.xhtml?faces-redirect=true";
       }    
       }catch(Exception e){
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário e/ou Senha inválido!"));
        }finally{
            zerarCampos();
        }
        
       return "";
    }        

    public String fazerLogout(){
        SessionContext.getInstance().encerrarSessao();
        return "index.xhtml";
    }        
            
    
    
    public Clientes getUserBO() {
        Clientes cliente = (Clientes) SessionContext.getInstance().getUsuarioLogado();
        return cliente;
    }
    
    public void setUserBO(Clientes cliente){
        this.userBO = cliente;
    }
    
    public void zerarCampos(){
        setLogin(null);
        setSenha(null);
    }
    

    
    
    
}       
    
