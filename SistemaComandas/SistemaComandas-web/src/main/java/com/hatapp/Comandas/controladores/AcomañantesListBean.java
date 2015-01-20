/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Acompanantes;
import com.hatapp.comandas.entity.Platos;
import com.hatapp.comandas.facade.ManagerUserFacade;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ideacentre
 */
@ManagedBean
@ViewScoped
public class AcomañantesListBean {

    @EJB
    ManagerUserFacade managerUserFacade;
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;
    private List<Acompanantes> lista;

    @PostConstruct
    public void init() {
        sessionBean.checkUsuarioConectado();
        sessionBean.perfilMatch("Acompañantes");
        lista = managerUserFacade.getAllAcompañantes();
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

    public List<Acompanantes> getLista() {
        return lista;
    }

    public void setLista(List<Acompanantes> lista) {
        this.lista = lista;
    }
    
    public void gotoElemento(Integer id){
        try {
            sessionBean.getAttributes().put("id", id);
            FacesContext.getCurrentInstance().getExternalContext().redirect("acompañante.xhtml");
        } catch (IOException ex) {
        }
    }
    
    public void borrar(Integer id){
        Acompanantes p = lista.get(lista.indexOf(new Platos(id)));
        managerUserFacade.borrarAcompañante(p);
        lista = managerUserFacade.getAllAcompañantes();
    }
}
