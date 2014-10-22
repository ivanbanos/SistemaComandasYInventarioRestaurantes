/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.facadeImpl.install;

import com.hatapp.Comandas.facadeImpl.RolesFacade;
import com.hatapp.Comandas.facadeImpl.UsuariosFacade;
import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.entity.Usuarios;
import com.hatapp.comandas.util.EncryptUtil;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author jssepulveda
 */
@Singleton
@Startup
public class InitEntitysService {

    @EJB
    UsuariosFacade usuariosFacade;
    @EJB
    RolesFacade rolesFacade;

    /**
     * 1. dependiendo de un parametro de configuracion el sistema debe
     * determinar que entidades debe crear (produccion=solo lo basico,
     * desarrollo=todo lo que se especifique como escenarios de prueba)
     */
    @PostConstruct
    public void init() {
        initEntitysHelper();
    }

    /**
     * metodo encargado de la inicializacion de las entidades que van a estar
     * disponibles en el sistema, para ello depende del valor que indique el
     * estado del proyecto (desarrollo, produccion)
     */
    private void initEntitysHelper() {
        if (usuariosFacade.count() == 0) {
            try {
                Usuarios nuevo = new Usuarios("root", EncryptUtil.encryptPassword("123456"), 1);
                Roles rol = createRol("administrador");
                rolesFacade.create(rol);
                nuevo.setRol(rol);
                usuariosFacade.create(nuevo);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(InitEntitysService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private Roles createRol(String nombre) {
        Roles rol = new Roles();
        rol.setNombre(nombre);
        return rol;
    }
}
