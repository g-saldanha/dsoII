/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Clientes;
import entidades.Dvds;
import entidades.Passagens;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gabri
 */
@Stateless
public class DvdsFacade extends AbstractFacade<Dvds>{
    @PersistenceContext(unitName = "Passagens-ejbPU")
    private EntityManager em;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DvdsFacade() {
        super(Dvds.class);
    }
    
    
    public void emprestarDvdParaCliente(Dvds dvd, Clientes cliente) {
        dvd.setEmprestado(cliente);
        // Definir na passagem existe que ela está reservada
        this.em.merge(dvd);
    }       
    
    public void devolverDvdParaCliente(Dvds dvd, Clientes cliente){
        dvd.setEmprestado(null);
        this.em.merge(dvd);
    }
    
    public List <Dvds> listarDvds(){
        Query query = em.createNamedQuery("DVDS.buscaTodos");
        return query.getResultList();
    }          
}
