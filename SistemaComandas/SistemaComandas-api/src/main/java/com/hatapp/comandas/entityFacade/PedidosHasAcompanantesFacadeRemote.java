/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.PedidosHasAcompanantes;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface PedidosHasAcompanantesFacadeRemote {

    void create(PedidosHasAcompanantes pedidosHasAcompanantes);

    void edit(PedidosHasAcompanantes pedidosHasAcompanantes);

    void remove(PedidosHasAcompanantes pedidosHasAcompanantes);

    PedidosHasAcompanantes find(Object id);

    List<PedidosHasAcompanantes> findAll();

    List<PedidosHasAcompanantes> findRange(int[] range);

    int count();
    
}
