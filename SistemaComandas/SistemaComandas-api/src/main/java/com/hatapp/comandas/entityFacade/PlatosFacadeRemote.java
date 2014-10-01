/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Platos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface PlatosFacadeRemote {

    void create(Platos platos);

    void edit(Platos platos);

    void remove(Platos platos);

    Platos find(Object id);

    List<Platos> findAll();

    List<Platos> findRange(int[] range);

    int count();
    
}
