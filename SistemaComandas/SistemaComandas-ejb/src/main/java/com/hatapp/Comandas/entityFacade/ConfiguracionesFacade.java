/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.entityFacade;

import com.hatapp.comandas.entity.Configuraciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ivan
 */
@Stateless
public class ConfiguracionesFacade extends AbstractFacade<Configuraciones> implements ConfiguracionesFacadeRemote {
    @PersistenceContext(unitName = "SistemaComandasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfiguracionesFacade() {
        super(Configuraciones.class);
    }
    
}