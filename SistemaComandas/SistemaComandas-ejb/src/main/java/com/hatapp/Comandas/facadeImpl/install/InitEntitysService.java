/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.facadeImpl.install;


import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
        
        
    }
}
