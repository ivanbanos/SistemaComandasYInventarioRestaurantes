/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.exceptions;

/**
 *
 * @author ideacentre
 */
public class UsuarioNoExisteException extends Exception{
    public UsuarioNoExisteException() {
        super("Usuario no existe");
    }
}
