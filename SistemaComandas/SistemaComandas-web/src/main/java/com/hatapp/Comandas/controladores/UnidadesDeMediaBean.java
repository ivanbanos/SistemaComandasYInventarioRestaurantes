/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Unidadesmedidas;
import com.hatapp.comandas.facade.AdminFacade;
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
public class UnidadesDeMediaBean {
    
    @EJB
    ManagerUserFacade managerUserFacade;
    @EJB
    AdminFacade adminFacade;
    private List<Unidadesmedidas> lista;
    Unidadesmedidas elemento;
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    public UnidadesDeMediaBean() {
    }
    
    @PostConstruct
    public void init() {
        System.out.println("viene");
        sessionBean.checkUsuarioConectado();
        sessionBean.perfilMatch("UnidadesMedida");
        elemento = new Unidadesmedidas();
        lista = managerUserFacade.getAllUnidadesDeMedida();
        System.out.println("y se crea");
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

    public List<Unidadesmedidas> getLista() {
        return lista;
    }

    public void setLista(List<Unidadesmedidas> lista) {
        this.lista = lista;
    }

    

    public Unidadesmedidas getElemento() {
        return elemento;
    }

    public void setElemento(Unidadesmedidas elemento) {
        this.elemento = elemento;
    }
    
    public void crear(){
        
        System.out.println("se crea?");
        adminFacade.crearUnidadesmedidas(elemento);
        lista = managerUserFacade.getAllUnidadesDeMedida();
        elemento = new Unidadesmedidas();
        
        System.out.println("nada paso");
    }
    
    public void editar(){
        adminFacade.editarUnidadesmedidas(elemento);
        lista = managerUserFacade.getAllUnidadesDeMedida();
        elemento = new Unidadesmedidas();
    }
    
    public void borrar(){
        adminFacade.borrarUnidadesmedidas(elemento);
        lista = managerUserFacade.getAllUnidadesDeMedida();
        elemento = new Unidadesmedidas();
    }

}
