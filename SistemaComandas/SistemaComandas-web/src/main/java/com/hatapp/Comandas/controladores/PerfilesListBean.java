/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.Comandas.util.ObjectBoolean;
import com.hatapp.comandas.entity.Funciones;
import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.entity.Vistas;
import com.hatapp.comandas.facade.AdminFacade;
import java.util.ArrayList;
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
public class PerfilesListBean {

    @EJB
    AdminFacade adminFacade;
    private List<Roles> lista;
    private List<ObjectBoolean> funcionesBooleans;
    private List<ObjectBoolean> vistasBooleans;
    Roles elemento;
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    public PerfilesListBean() {
    }

    @PostConstruct
    public void init() {
        sessionBean.checkUsuarioConectado();
        sessionBean.perfilMatch("perfiles");
        lista = adminFacade.getAllRoles();
        elemento = new Roles();
        elemento.setFuncionesList(new ArrayList<Funciones>());
        elemento.setVistasList(new ArrayList<Vistas>());
        setFuncionesyVistasBoolean();
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    private void setFuncionesyVistasBoolean() {
        funcionesBooleans = new ArrayList<>();
        vistasBooleans = new ArrayList<>();
        List<Funciones> funciones = adminFacade.getAllFunciones();
        List<Vistas> vistas = adminFacade.getAllVistas();
        for (Vistas vista : vistas) {
            if(elemento.getVistasList().contains(vista)){
                vistasBooleans.add(new ObjectBoolean(vista, true, vista.getNombre()));
            } else {
                vistasBooleans.add(new ObjectBoolean(vista, false, vista.getNombre()));
            }
        }
        for (Funciones funcion : funciones) {
            if(elemento.getFuncionesList().contains(funcion)){
                funcionesBooleans.add(new ObjectBoolean(funcion, true, funcion.getNombre()));
            } else {
                funcionesBooleans.add(new ObjectBoolean(funcion, false, funcion.getNombre()));
            }
        }
    }

    public AdminFacade getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdminFacade adminFacade) {
        this.adminFacade = adminFacade;
    }

    public List<Roles> getLista() {
        return lista;
    }

    public void setLista(List<Roles> lista) {
        this.lista = lista;
    }

    public List<ObjectBoolean> getFuncionesBooleans() {
        return funcionesBooleans;
    }

    public void setFuncionesBooleans(List<ObjectBoolean> funcionesBooleans) {
        this.funcionesBooleans = funcionesBooleans;
    }

    public List<ObjectBoolean> getVistasBooleans() {
        return vistasBooleans;
    }

    public void setVistasBooleans(List<ObjectBoolean> vistasBooleans) {
        this.vistasBooleans = vistasBooleans;
    }

    public Roles getElemento() {
        return elemento;
    }

    public void setElemento(Roles elemento) {
        this.elemento = elemento;
        setFuncionesyVistasBoolean();
    }
    
    public void crear(){
        setToElementoFuncionesyVistasBoolean();
        adminFacade.crearRol(elemento);
        elemento = new Roles();
        elemento.setFuncionesList(new ArrayList<Funciones>());
        elemento.setVistasList(new ArrayList<Vistas>());
        setFuncionesyVistasBoolean();
    }
    
    public void editar(){
        setToElementoFuncionesyVistasBoolean();
        adminFacade.editarRol(elemento);
        elemento = new Roles();
        elemento.setFuncionesList(new ArrayList<Funciones>());
        elemento.setVistasList(new ArrayList<Vistas>());
        setFuncionesyVistasBoolean();
    }
    
    public void borrar(){
        adminFacade.borrarRol(elemento);
        elemento = new Roles();
        elemento.setFuncionesList(new ArrayList<Funciones>());
        elemento.setVistasList(new ArrayList<Vistas>());
        setFuncionesyVistasBoolean();
    }

    private void setToElementoFuncionesyVistasBoolean() {
        elemento.getFuncionesList().clear();
        elemento.getVistasList().clear();
        for (ObjectBoolean vista : vistasBooleans) {
            if(vista.isSelected()){
                 elemento.getVistasList().add(((Vistas)vista.getObject()));
            }
        }
        for (ObjectBoolean funcion : funcionesBooleans) {
            if(funcion.isSelected()){
                 elemento.getFuncionesList().add((Funciones)funcion.getObject());
            }
        }
    }
}
