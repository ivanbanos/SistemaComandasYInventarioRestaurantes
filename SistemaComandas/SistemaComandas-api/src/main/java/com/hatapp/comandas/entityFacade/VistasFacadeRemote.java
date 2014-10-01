/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Vistas;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface VistasFacadeRemote {

    void create(Vistas vistas);

    void edit(Vistas vistas);

    void remove(Vistas vistas);

    Vistas find(Object id);

    List<Vistas> findAll();

    List<Vistas> findRange(int[] range);

    int count();
    
}
