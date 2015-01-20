/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.facade;

import com.hatapp.comandas.entity.Funciones;
import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.entity.Usuarios;
import com.hatapp.comandas.entity.Vistas;
import java.util.List;

/**
 *
 * @author ideacentre
 */
public interface AdminFacade {

    public List<Usuarios> getAllUsuarios();

    public List<Roles> getAllRoles();

    public void crearUsuario(Usuarios elemento);

    public void editarUsuario(Usuarios elemento);

    public void borrarUsuario(Usuarios elemento);

    public List<Funciones> getAllFunciones();

    public List<Vistas> getAllVistas();

    public void crearRol(Roles elemento);

    public void editarRol(Roles elemento);

    public void borrarRol(Roles elemento);
    
}
