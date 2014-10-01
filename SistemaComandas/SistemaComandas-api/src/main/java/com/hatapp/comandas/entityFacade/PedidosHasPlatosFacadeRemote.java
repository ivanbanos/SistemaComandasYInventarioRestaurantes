/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.PedidosHasPlatos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface PedidosHasPlatosFacadeRemote {

    void create(PedidosHasPlatos pedidosHasPlatos);

    void edit(PedidosHasPlatos pedidosHasPlatos);

    void remove(PedidosHasPlatos pedidosHasPlatos);

    PedidosHasPlatos find(Object id);

    List<PedidosHasPlatos> findAll();

    List<PedidosHasPlatos> findRange(int[] range);

    int count();
    
}
