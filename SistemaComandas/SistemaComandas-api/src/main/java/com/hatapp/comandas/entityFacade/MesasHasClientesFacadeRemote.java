/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.MesasHasClientes;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface MesasHasClientesFacadeRemote {

    void create(MesasHasClientes mesasHasClientes);

    void edit(MesasHasClientes mesasHasClientes);

    void remove(MesasHasClientes mesasHasClientes);

    MesasHasClientes find(Object id);

    List<MesasHasClientes> findAll();

    List<MesasHasClientes> findRange(int[] range);

    int count();
    
}
