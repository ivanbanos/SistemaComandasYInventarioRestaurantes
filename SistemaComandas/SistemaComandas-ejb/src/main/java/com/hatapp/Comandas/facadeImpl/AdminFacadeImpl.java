/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.facadeImpl;

import com.hatapp.comandas.entity.Funciones;
import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.entity.Usuarios;
import com.hatapp.comandas.entity.Vistas;
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
    @EJB
    FuncionesFacade funcionesFacade;
    @EJB
    VistasFacade vistasFacade;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuariosFacade.findAll();
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesFacade.findAll();
    }  

    @Override
    public void crearUsuario(Usuarios elemento) {
        usuariosFacade.create(elemento);
    }

    @Override
    public void editarUsuario(Usuarios elemento) {
        usuariosFacade.edit(elemento);
    }

    @Override
    public void borrarUsuario(Usuarios elemento) {
        usuariosFacade.remove(elemento);
    }

    @Override
    public List<Funciones> getAllFunciones() {
        return funcionesFacade.findAll();
    }

    @Override
    public List<Vistas> getAllVistas() {
        return vistasFacade.findAll();
    }

    @Override
    public void crearRol(Roles elemento) {
        rolesFacade.create(elemento);
    }

    @Override
    public void editarRol(Roles elemento) {
        rolesFacade.edit(elemento);
    }

    @Override
    public void borrarRol(Roles elemento) {
        rolesFacade.remove(elemento);
    }

    

}
