/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Configuraciones;
import java.util.List;

/**
 *
 * @author ivan
 */
@javax.ejb.Remote
public interface ConfiguracionesFacadeRemote {

    void create(Configuraciones configuraciones);

    void edit(Configuraciones configuraciones);

    void remove(Configuraciones configuraciones);

    Configuraciones find(Object id);

    List<Configuraciones> findAll();

    List<Configuraciones> findRange(int[] range);

    int count();
    
}
