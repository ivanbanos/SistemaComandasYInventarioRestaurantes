/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Ingredientes;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface IngredientesFacadeRemote {

    void create(Ingredientes ingredientes);

    void edit(Ingredientes ingredientes);

    void remove(Ingredientes ingredientes);

    Ingredientes find(Object id);

    List<Ingredientes> findAll();

    List<Ingredientes> findRange(int[] range);

    int count();
    
}
