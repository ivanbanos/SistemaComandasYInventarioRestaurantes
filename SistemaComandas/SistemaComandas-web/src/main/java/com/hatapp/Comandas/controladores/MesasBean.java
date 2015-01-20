/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Mesas;
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
public class MesasBean {
    
    @EJB
    ManagerUserFacade managerUserFacade;
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;
    private List<Mesas> mesas;
    private Mesas elemento;

    public MesasBean() {
    }
    
    @PostConstruct
    public void init() {
        sessionBean.checkUsuarioConectado();
        sessionBean.perfilMatch("Mesas");
        mesas = managerUserFacade.getAllMesas();
        elemento = new Mesas();
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

    public List<Mesas> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesas> mesas) {
        this.mesas = mesas;
    }

    public Mesas getElemento() {
        return elemento;
    }

    public void setElemento(Mesas elemento) {
        this.elemento = elemento;
    }
    
    public void guardar(){
        managerUserFacade.guardarMesa(elemento);
        mesas = managerUserFacade.getAllMesas();
        elemento = new Mesas();
    }
    
    public void editar(Integer id){
        elemento = mesas.get(mesas.indexOf(new Mesas(id)));
        managerUserFacade.editarMesa(elemento);
        mesas = managerUserFacade.getAllMesas();
        elemento = new Mesas();
    }
    
    public void borrar(Integer id){
        elemento = mesas.get(mesas.indexOf(new Mesas(id)));
        managerUserFacade.borrarMesa(elemento);
        mesas = managerUserFacade.getAllMesas();
        elemento = new Mesas();
    }
}
