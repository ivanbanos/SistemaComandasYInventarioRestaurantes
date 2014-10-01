/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Facturas;
import java.util.List;

/**
 *
 * @author ivan
 */
@javax.ejb.Remote
public interface FacturasFacadeRemote {

    void create(Facturas facturas);

    void edit(Facturas facturas);

    void remove(Facturas facturas);

    Facturas find(Object id);

    List<Facturas> findAll();

    List<Facturas> findRange(int[] range);

    int count();
    
}
