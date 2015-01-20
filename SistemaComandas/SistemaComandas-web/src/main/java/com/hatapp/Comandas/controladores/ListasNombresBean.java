/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.facade.AdminFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ideacentre
 */
@ManagedBean
@RequestScoped
public class ListasNombresBean {
    @EJB
    AdminFacade adminFacade;

    public List<String> getRoles() {
        List<Roles> roles = adminFacade.getAllRoles();
        List<String> nombresRoles = new ArrayList<>();
        for (Roles r : roles) {
            nombresRoles.add(r.getNombre());
        }
        return nombresRoles;
    }
    
    public String[] getEstadoMesas(){
        return Arrays.toString(EstadoMesas.values()).replaceAll("^.|.$", "").split(", ");
    }
    
    public String[] getUnidadesMedida(){
        return Arrays.toString(UnidadesMedida.values()).replaceAll("^.|.$", "").split(", ");
    }
    
}
enum EstadoMesas {
    ABILITADA, INABILIADA, UTILIZANDOSE
}
enum UnidadesMedida {
    Kg, L
}