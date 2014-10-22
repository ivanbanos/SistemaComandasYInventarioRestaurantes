/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.facadeImpl;

import com.hatapp.comandas.entity.Usuarios;
import com.hatapp.comandas.exceptions.ClavesNoConcuerdanException;
import com.hatapp.comandas.exceptions.UsuarioNoConectadoException;
import com.hatapp.comandas.exceptions.UsuarioNoExisteException;
import com.hatapp.comandas.facade.SystemFacade;
import com.hatapp.comandas.util.EncryptUtil;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ideacentre
 */
@Stateless
public class SystemFacadeImpl implements SystemFacade {
    
    @EJB
    UsuariosFacade usuariosFacadeRemote;

    @Override
    public Usuarios iniciarSession(Usuarios usuario) throws ClavesNoConcuerdanException, UsuarioNoExisteException, UsuarioNoConectadoException {
        try {
            Usuarios usuarios = usuariosFacadeRemote.find(usuario.getUsername());
            if (usuarios != null) {
                Usuarios usuarioConectado = usuarios;
                if (!EncryptUtil.comparePassword(usuario.getPassword(), usuarioConectado.getPassword())) {
                    throw new ClavesNoConcuerdanException();
                }
                return usuarioConectado;
            } else {
                throw new UsuarioNoExisteException();
            }
        } catch (NoSuchAlgorithmException ex) {
            throw new UsuarioNoConectadoException();
        }
    }

    @Override
    public Usuarios actualizarUsuario(Usuarios usuario) {
        return usuariosFacadeRemote.find(usuario.getUsername());
    }

    @Override
    public Usuarios getUsuario(String idUsuario) {
        return usuariosFacadeRemote.find(idUsuario);
    }

   
}
