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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    public void subirImagen(byte[] contents, String fileName) {
        try {
            System.out.println(new String(contents));
            File imagen = null;
            StringBuilder sb = new StringBuilder();
            sb.append(System.getProperty("APP_RESOURCES"))
                    .append(System.getProperty("file.separator"))
                    .append("imagenes").append(System.getProperty("file.separator"))
                    .append("restaurante").append(System.getProperty("file.separator")).append(fileName);
            imagen = new File(sb.toString());
            if (imagen.exists()) {
                imagen.delete();
            }
            OutputStream stream = null;
            stream = new FileOutputStream(sb.toString());
            if (contents != null) {
                stream.write(contents);
            }
            stream.close();
        } catch (FileNotFoundException ex) {
            
            System.out.println(ex);
        } catch (IOException ex) {
            
            System.out.println(ex);
        }
    }
}
