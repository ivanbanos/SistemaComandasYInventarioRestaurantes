/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Atributosusuario;
import java.util.List;

/**
 *
 * @author ivan
 */
@javax.ejb.Remote
public interface AtributosusuarioFacadeRemote {

    void create(Atributosusuario atributosusuario);

    void edit(Atributosusuario atributosusuario);

    void remove(Atributosusuario atributosusuario);

    Atributosusuario find(Object id);

    List<Atributosusuario> findAll();

    List<Atributosusuario> findRange(int[] range);

    int count();
    
}
