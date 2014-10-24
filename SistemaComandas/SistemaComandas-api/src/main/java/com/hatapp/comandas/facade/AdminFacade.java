/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.facade;

import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.entity.Usuarios;
import java.util.List;

/**
 *
 * @author ideacentre
 */
public interface AdminFacade {

    public List<Usuarios> getAllUsuarios();

    public List<Roles> getAllRoles();
    
}
