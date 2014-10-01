/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Funciones;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface FuncionesFacadeRemote {

    void create(Funciones funciones);

    void edit(Funciones funciones);

    void remove(Funciones funciones);

    Funciones find(Object id);

    List<Funciones> findAll();

    List<Funciones> findRange(int[] range);

    int count();
    
}
