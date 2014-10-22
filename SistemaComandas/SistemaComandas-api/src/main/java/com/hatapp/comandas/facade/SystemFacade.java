/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.facade;

import com.hatapp.comandas.entity.Usuarios;
import com.hatapp.comandas.exceptions.ClavesNoConcuerdanException;
import com.hatapp.comandas.exceptions.UsuarioNoConectadoException;
import com.hatapp.comandas.exceptions.UsuarioNoExisteException;

/**
 *
 * @author ideacentre
 */
public interface SystemFacade {

    public Usuarios iniciarSession(Usuarios usuario)throws ClavesNoConcuerdanException, UsuarioNoExisteException, UsuarioNoConectadoException ;

    public Usuarios actualizarUsuario(Usuarios usuario);

    public Usuarios getUsuario(String idUsuario);

   
}
