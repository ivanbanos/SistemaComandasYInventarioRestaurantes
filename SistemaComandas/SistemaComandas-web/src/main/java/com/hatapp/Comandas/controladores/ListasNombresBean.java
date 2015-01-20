/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.controladores;

import com.hatapp.comandas.entity.Roles;
import com.hatapp.comandas.entity.Unidadesmedidas;
import com.hatapp.comandas.facade.AdminFacade;
import com.hatapp.comandas.facade.ManagerUserFacade;
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
    @EJB
    ManagerUserFacade managerUserFacade;

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
    
    public List<String> getUnidadesMedida(){
        List<Unidadesmedidas> unidadesMedidas = managerUserFacade.getAllUnidadesDeMedida();
        List<String> nombres = new ArrayList<>();
        for (Unidadesmedidas r : unidadesMedidas) {
            nombres.add(r.getAbreviacion());
        }
        return nombres;
    }
    
}
enum EstadoMesas {
    ABILITADA, INABILIADA, UTILIZANDOSE
}