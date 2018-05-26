/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Clientes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelos.ClientesFacade;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author Leonardo
 */

@Named(value = "clienteControle")
@SessionScoped
public class ClienteControle implements Serializable {

    @EJB
    private ClientesFacade clientesFacade;
    private Clientes cliente= new Clientes();
    

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
    
    public ClienteControle() {
    }
    
    public List <Clientes> getListaClientes(){
        return this.clientesFacade.findAll();
    }
        
    
    
    
    public String insert(){
        try{
        Clientes cliente = new Clientes();
        cliente.setNome(this.cliente.getNome());
        cliente.setEndereco(this.cliente.getEndereco());
        cliente.setCidade(this.cliente.getCidade());
        cliente.setUf(this.cliente.getUf());
        cliente.setTelefone(this.cliente.getTelefone());
        cliente.setEmail(this.cliente.getEmail());
        cliente.setSenha(this.cliente.getSenha());
        this.clientesFacade.create(cliente);
        }catch(Exception e){
            
        }finally{
            zerarCampos();
        }

        return "index";
    }
    
    public void delete(Clientes cliente){
        this.clientesFacade.remove(cliente);
    }
    
    public void confirmaCadastro(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro realizado com sucesso!"));
    }
    
    public void zerarCampos(){
        cliente.setNome(null);
        cliente.setEndereco(null);
        cliente.setCidade(null);
        cliente.setUf(null);
        cliente.setTelefone(null);
        cliente.setEmail(null);
    }
        
    
}
