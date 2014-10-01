/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Cuentas;
import java.util.List;

/**
 *
 * @author ivan
 */
@javax.ejb.Remote
public interface CuentasFacadeRemote {

    void create(Cuentas cuentas);

    void edit(Cuentas cuentas);

    void remove(Cuentas cuentas);

    Cuentas find(Object id);

    List<Cuentas> findAll();

    List<Cuentas> findRange(int[] range);

    int count();
    
}
