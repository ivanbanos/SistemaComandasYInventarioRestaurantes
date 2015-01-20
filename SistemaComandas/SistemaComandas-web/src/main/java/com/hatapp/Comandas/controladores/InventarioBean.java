/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Ingredientes;
import com.hatapp.comandas.entity.Unidadesmedidas;
import com.hatapp.comandas.facade.ManagerUserFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ivan
 */
@ManagedBean
@ViewScoped
public class InventarioBean {

    @EJB
    ManagerUserFacade managerUserFacade;
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;
    Ingredientes elemento;
    private List<Ingredientes> lista;
    private List<Unidadesmedidas> unidadesmedidas;

    public List<Unidadesmedidas> getUnidadesmedidas() {
        return unidadesmedidas;
    }

    public void setUnidadesmedidas(List<Unidadesmedidas> unidadesmedidas) {
        this.unidadesmedidas = unidadesmedidas;
    }

    public InventarioBean() {
    }

    @PostConstruct
    public void init() {
        sessionBean.checkUsuarioConectado();
        sessionBean.perfilMatch("Inventario");
        lista = managerUserFacade.getAllIngredientes();
        elemento = new Ingredientes();
        unidadesmedidas = managerUserFacade.getAllUnidadesDeMedida();
    }

    public ManagerUserFacade getManagerUserFacade() {
        return managerUserFacade;
    }

    public void setManagerUserFacade(ManagerUserFacade managerUserFacade) {
        this.managerUserFacade = managerUserFacade;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Ingredientes getElemento() {
        return elemento;
    }

    public void setElemento(Ingredientes elemento) {
        this.elemento = elemento;
    }

    public List<Ingredientes> getLista() {
        return lista;
    }

    public void setLista(List<Ingredientes> lista) {
        this.lista = lista;
    }

}
