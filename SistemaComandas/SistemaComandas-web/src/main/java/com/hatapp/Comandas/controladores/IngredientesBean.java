/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Ingredientes;
import com.hatapp.comandas.facade.ManagerUserFacade;
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
public class IngredientesBean {
    
    @EJB
    ManagerUserFacade managerUserFacade;
    private List<Ingredientes> lista;
    Ingredientes elemento;
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    public IngredientesBean() {
    }
    
    @PostConstruct
    public void init() {
        sessionBean.checkUsuarioConectado();
        sessionBean.perfilMatch("Ingredientes");
        lista = managerUserFacade.getAllIngredientes();
        elemento = new Ingredientes();
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public ManagerUserFacade getManagerUserFacade() {
        return managerUserFacade;
    }

    public void setManagerUserFacade(ManagerUserFacade managerUserFacade) {
        this.managerUserFacade = managerUserFacade;
    }

    public List<Ingredientes> getLista() {
        return lista;
    }

    public void setLista(List<Ingredientes> lista) {
        this.lista = lista;
    }

    public Ingredientes getElemento() {
        return elemento;
    }

    public void setElemento(Ingredientes elemento) {
        this.elemento = elemento;
    }
    
    public void crear(){
        managerUserFacade.crearIngredientes(elemento);
        lista = managerUserFacade.getAllIngredientes();
        elemento = new Ingredientes();
    }
    
    public void editar(){
        managerUserFacade.editarIngredientes(elemento);
        lista = managerUserFacade.getAllIngredientes();
        elemento = new Ingredientes();
    }
    
    public void borrar(){
        managerUserFacade.borrarIngredientes(elemento);
        lista = managerUserFacade.getAllIngredientes();
        elemento = new Ingredientes();
    }
}
