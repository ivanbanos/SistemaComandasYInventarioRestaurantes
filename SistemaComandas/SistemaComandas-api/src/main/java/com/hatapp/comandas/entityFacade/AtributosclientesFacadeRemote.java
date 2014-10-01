/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Atributosclientes;
import java.util.List;

/**
 *
 * @author ivan
 */
@javax.ejb.Remote
public interface AtributosclientesFacadeRemote {

    void create(Atributosclientes atributosclientes);

    void edit(Atributosclientes atributosclientes);

    void remove(Atributosclientes atributosclientes);

    Atributosclientes find(Object id);

    List<Atributosclientes> findAll();

    List<Atributosclientes> findRange(int[] range);

    int count();
    
}
