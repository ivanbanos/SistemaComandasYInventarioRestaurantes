/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.entity.Usuarios;
import com.hatapp.comandas.facade.AdminFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ideacentre
 */
@ManagedBean
@ViewScoped
public class UsuariosListBean {
    
    @EJB
    AdminFacade adminFacade;
    private List<Usuarios> lista;
    private List<Roles> perfiles;
    Usuarios elemento;
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    public UsuariosListBean() {
    }
    
    @PostConstruct
    public void init() {
        sessionBean.checkUsuarioConectado();
        sessionBean.perfilMatch("usuarios");
        perfiles = adminFacade.getAllRoles();
        lista = adminFacade.getAllUsuarios();
        elemento = new Usuarios();
        elemento.setRol(new Roles());
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public AdminFacade getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdminFacade adminFacade) {
        this.adminFacade = adminFacade;
    }

    public List<Usuarios> getLista() {
        return lista;
    }

    public void setLista(List<Usuarios> lista) {
        this.lista = lista;
    }

    public List<Roles> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Roles> perfiles) {
        this.perfiles = perfiles;
    }

    public Usuarios getElemento() {
        return elemento;
    }

    public void setElemento(Usuarios elemento) {
        this.elemento = elemento;
    }
    
    public void crear(){
        adminFacade.crearUsuario(elemento);
        lista = adminFacade.getAllUsuarios();
        elemento = new Usuarios();
        elemento.setRol(new Roles());
    }
    
    public void editar(){
        adminFacade.editarUsuario(elemento);
        lista = adminFacade.getAllUsuarios();
        elemento = new Usuarios();
        elemento.setRol(new Roles());
    }
    
    public void borrar(){
        adminFacade.borrarUsuario(elemento);
        lista = adminFacade.getAllUsuarios();
        elemento = new Usuarios();
        elemento.setRol(new Roles());
    }
    
}
