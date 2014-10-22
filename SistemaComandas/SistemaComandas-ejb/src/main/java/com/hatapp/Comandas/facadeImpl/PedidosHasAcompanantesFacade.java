/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.facadeImpl;

import com.hatapp.comandas.entity.PedidosHasAcompanantes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ideacentre
 */
@Stateless
public class PedidosHasAcompanantesFacade extends AbstractFacade<PedidosHasAcompanantes> {
    @PersistenceContext(unitName = "SistemaComandasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidosHasAcompanantesFacade() {
        super(PedidosHasAcompanantes.class);
    }
    
}
