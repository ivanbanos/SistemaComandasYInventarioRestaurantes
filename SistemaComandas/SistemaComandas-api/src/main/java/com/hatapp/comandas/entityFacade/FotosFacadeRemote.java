/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entityFacade;

import com.hatapp.comandas.entity.Fotos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ivan
 */
@Remote
public interface FotosFacadeRemote {

    void create(Fotos fotos);

    void edit(Fotos fotos);

    void remove(Fotos fotos);

    Fotos find(Object id);

    List<Fotos> findAll();

    List<Fotos> findRange(int[] range);

    int count();
    
}
