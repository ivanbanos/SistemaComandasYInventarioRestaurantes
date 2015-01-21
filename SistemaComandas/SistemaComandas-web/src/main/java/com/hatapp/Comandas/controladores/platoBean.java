/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Fotos;
import com.hatapp.comandas.entity.Ingredientes;
import com.hatapp.comandas.entity.Platos;
import com.hatapp.comandas.entity.PlatosHasIngredientes;
import com.hatapp.comandas.facade.ManagerUserFacade;
import com.hatapp.comandas.facade.SystemFacade;
import java.util.ArrayList;
import java.util.List;
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
    private Platos elemento;
    private List<Ingredientes> ingredientes;
    private List<Ingredientes> seleccionados;
    private List<PlatosHasIngredientes> ingreditenesPlato;

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
        ingredientes = managerUserFacade.getAllIngredientes();
        seleccionados = new ArrayList<>();
        if (elemento.getPlatosHasIngredientesList() != null) {
            ingreditenesPlato = elemento.getPlatosHasIngredientesList();
        } else {
            ingreditenesPlato = new ArrayList<>();
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
        sessionFacade.subirImagen(event.getFile().getContents(), event.getFile().getFileName());
        Fotos foto = new Fotos();
        foto.setUrl(event.getFile().getFileName());
        foto = managerUserFacade.crearFoto(foto);
        elemento.setFoto(foto);
    }

    public void guardar() {
        elemento.setPlatosHasIngredientesList(ingreditenesPlato);
        managerUserFacade.crearPlato(elemento);

    }

    public SystemFacade getSessionFacade() {
        return sessionFacade;
    }

    public void setSessionFacade(SystemFacade sessionFacade) {
        this.sessionFacade = sessionFacade;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Ingredientes> getSeleccionados() {
        return seleccionados;
    }

    public void setSeleccionados(List<Ingredientes> seleccionados) {
        this.seleccionados = seleccionados;
    }

    public void selectIngredientes() {
        System.out.println("Colocando Ingredientes");
        for (Ingredientes ingrediente : seleccionados) {
            System.out.println("Ingrediente: " + ingrediente.getNombre());
            PlatosHasIngredientes phi;
            if (elemento.getId() != null) {
                phi = new PlatosHasIngredientes(elemento.getId(), ingrediente.getId());
                
            } else {
                phi = new PlatosHasIngredientes(0, ingrediente.getId());
            }
            phi.setIngredientes(ingrediente);
            phi.setCantidad(0f);
            ingreditenesPlato.add(phi);
        }

        System.out.println("FIN");
    }

    public List<PlatosHasIngredientes> getIngreditenesPlato() {
        return ingreditenesPlato;
    }

    public void setIngreditenesPlato(List<PlatosHasIngredientes> ingreditenesPlato) {
        this.ingreditenesPlato = ingreditenesPlato;
    }

}
