/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.Comandas.util.FacesUtil;
import com.hatapp.comandas.entity.Funciones;
import com.hatapp.comandas.entity.Usuarios;
import com.hatapp.comandas.entity.Vistas;
import com.hatapp.comandas.exceptions.ClavesNoConcuerdanException;
import com.hatapp.comandas.exceptions.UsuarioNoConectadoException;
import com.hatapp.comandas.exceptions.UsuarioNoExisteException;
import com.hatapp.comandas.facade.SystemFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.log4j.Logger;

/**
 *
 * @author ideacentre
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private static final Logger LOGGER =
            Logger.getLogger(SessionBean.class);
    @EJB
    SystemFacade sessionFacade;
    private Usuarios usuario;//Almacena el objeto usuario de la session
    private HashMap<String, Object> Attributes;
    private String active;

    /**
     * Creates a new instance of SessionFlowumiUtil
     */
    public SessionBean() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuarios();
        Attributes = new HashMap<String, Object>();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String Conectar() {
        try {
            LOGGER.info("Conectando...");
            usuario = sessionFacade.iniciarSession(usuario);
            LOGGER.info("Conectado.");
            active = "inicio";
            return "/pages/index.xhtml";
        } catch (ClavesNoConcuerdanException | UsuarioNoExisteException | UsuarioNoConectadoException ex) {
            LOGGER.error(ex.getMessage());
            FacesUtil.addErrorMessage("Usuario no conectado", ex.getMessage());
            usuario = new Usuarios();
        }
        return "";
    }

    public String Desconectar() {
        LOGGER.info("Desconectando...");
        usuario = new Usuarios();
        return "/pages/InicioSession.xhtml";
    }

    public boolean perfilMatch(String vista) {
        if (usuario == null || usuario.getRol() == null || usuario.getRol().getVistasList() == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("InicioSession.xhtml");
            } catch (IOException ex) {
            }
        } else {
            for (Vistas v : usuario.getRol().getVistasList()) {
                if (v.getNombre().equals(vista)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean rolMatch(String funcion) {
        if (usuario == null || usuario.getRol() == null || usuario.getRol().getFuncionesList() == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("InicioSession.xhtml");
            } catch (IOException ex) {
            }
        } else {
            for (Funciones f : usuario.getRol().getFuncionesList()) {
                if (f.getNombre().equals(funcion)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void actualizarUsuario() {
        usuario = sessionFacade.actualizarUsuario(usuario);
    }

    public HashMap<String, Object> getAttributes() {
        return Attributes;
    }

    public void setAttributes(HashMap<String, Object> Attributes) {
        this.Attributes = Attributes;
    }

    public void checkUsuarioConectado() {
        if (usuario == null
                || usuario.getUsername() == null
                || usuario.getUsername().equals("")) {
            try {
                System.out.println("No lo coje");
                Desconectar();
                FacesUtil.addErrorMessage("Session finalizada", "No existe usuario conectado");
                FacesContext.getCurrentInstance().getExternalContext().redirect("InicioSession.xhtml");
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public boolean isActive(String pestaña) {
        if (active == null) {
            return false;
        }
        return active.equals(pestaña);
    }

    public boolean isNotActive(String pestaña) {
        if (active == null) {
            return true;
        }
        return !active.equals(pestaña);
    }

    public String go(String page) {
        switch (page) {
            case "inicio":
                return "/pages/index.xhtml";
            case "IndexGestionParametros":
                return "/pages/IndexGestionParametros.xhtml";
            case "IndexGestionUsuarios":
                return "/pages/IndexGestionUsuarios.xhtml";
            case "Inventario":
                return "/pages/Inventario.xhtml";
            case "Pedidos":
                return "/pages/Pedidos.xhtml";
            case "Reportes":
                return "/pages/Reportes.xhtml";
            case "usuarios":
                return "/pages/usuariosList.xhtml";
            case "perfiles":
                return "/pages/perfilesList.xhtml";
            default:
                return "";

        }
       
    }

    void obtenerUsuario(String idUsuario) {
        usuario = sessionFacade.getUsuario(idUsuario);
    }
}
