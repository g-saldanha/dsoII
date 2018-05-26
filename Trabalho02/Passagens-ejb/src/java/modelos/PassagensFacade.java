/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Clientes;
import entidades.Dvds;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gabriel e Jose Carlos Martins
 */
@Stateless
public class DvdsFacade extends AbstractFacade<Dvds> {

    @PersistenceContext(unitName = "Dvds-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DvdsFacade() {
        super(Dvds.class);
    }
    
    
    public void reservarPassagemParaCliente(Dvds passagem, Clientes cliente) {
        passagem.setFkidCliente(cliente);
        // Definir na passagem existe que ela está reservada
        passagem.setDisponibilidadade(0);
        this.em.merge(passagem);
    }
        
        
    
    public void cancelarReservaDoCliente(Dvds passagem, Clientes cliente){
        passagem.setFkidCliente(null);
        passagem.setDisponibilidadade(1);
        this.em.merge(passagem);
    }
    
    public List <Dvds> listarDvdsDisponiveis(){
        Query query = em.createNamedQuery("Dvds.findByDisponibilidadadeTrue");
        return query.getResultList();
    }
    
    public List <Dvds> listarReservas(Clientes cliente){
        Query query = em.createNamedQuery("Dvds.findDvdsByCliente");
        query.setParameter("idCliente", cliente.getIdCliente());
        return query.getResultList();
    }    
        
        
    
    
}
