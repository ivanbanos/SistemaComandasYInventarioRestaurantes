/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.facadeImpl;

import com.hatapp.comandas.entity.MesasHasClientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ideacentre
 */
@Stateless
public class MesasHasClientesFacade extends AbstractFacade<MesasHasClientes> {
    @PersistenceContext(unitName = "SistemaComandasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MesasHasClientesFacade() {
        super(MesasHasClientes.class);
    }
    
}
