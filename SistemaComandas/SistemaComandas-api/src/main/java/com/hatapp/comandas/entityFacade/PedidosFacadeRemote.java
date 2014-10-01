/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Pedidos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface PedidosFacadeRemote {

    void create(Pedidos pedidos);

    void edit(Pedidos pedidos);

    void remove(Pedidos pedidos);

    Pedidos find(Object id);

    List<Pedidos> findAll();

    List<Pedidos> findRange(int[] range);

    int count();
    
}
