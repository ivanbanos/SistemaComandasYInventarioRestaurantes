/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Acompanantes;
import java.util.List;

/**
 *
 * @author ivan
 */
@javax.ejb.Remote
public interface AcompanantesFacadeRemote {

    void create(Acompanantes acompanantes);

    void edit(Acompanantes acompanantes);

    void remove(Acompanantes acompanantes);

    Acompanantes find(Object id);

    List<Acompanantes> findAll();

    List<Acompanantes> findRange(int[] range);

    int count();
    
}
