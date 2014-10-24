/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.facadeImpl;

import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.entity.Usuarios;
import com.hatapp.comandas.facade.AdminFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ideacentre
 */
@Stateless
public class AdminFacadeImpl implements AdminFacade {
    
    @EJB
    UsuariosFacade usuariosFacade;
    @EJB
    RolesFacade rolesFacade;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuariosFacade.findAll();
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesFacade.findAll();
    }

    

}
