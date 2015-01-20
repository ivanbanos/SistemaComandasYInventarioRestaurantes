/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Fotos;
import com.hatapp.comandas.entity.Platos;
import com.hatapp.comandas.facade.ManagerUserFacade;
import com.hatapp.comandas.facade.SystemFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author ideacentre
 */
@ManagedBean
@ViewScoped
public class platoBean {

    @EJB
    ManagerUserFacade managerUserFacade;
    @EJB
    SystemFacade sessionFacade;
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;
    Platos elemento;

    @PostConstruct
    public void init() {
        sessionBean.checkUsuarioConectado();
        sessionBean.perfilMatch("Platos");
        if ((Integer) sessionBean.getAttributes().get("id") == 0) {
            elemento = new Platos();
            elemento.setFoto(new Fotos());
        } else {
            elemento = managerUserFacade.findPlato((Integer) sessionBean.getAttributes().get("id"));
        }
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

    public Platos getElemento() {
        return elemento;
    }

    public void setElemento(Platos elemento) {
        this.elemento = elemento;
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        sessionFacade.subirImagen(event.getFile().getContents(),event.getFile().getFileName());
        Fotos foto = new Fotos();
        foto.setUrl(event.getFile().getFileName());
        foto = managerUserFacade.crearFoto(foto);
        elemento.setFoto(foto);
    }
    
    public void guardar(){
        managerUserFacade.crearPlato(elemento);
        
    }
}
