/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ivan
 */
@Embeddable
public class PlatosHasIngredientesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Platos_id")
    private int platosid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ingredientes_id")
    private int ingredientesid;

    public PlatosHasIngredientesPK() {
    }

    public PlatosHasIngredientesPK(int platosid, int ingredientesid) {
        this.platosid = platosid;
        this.ingredientesid = ingredientesid;
    }

    public int getPlatosid() {
        return platosid;
    }

    public void setPlatosid(int platosid) {
        this.platosid = platosid;
    }

    public int getIngredientesid() {
        return ingredientesid;
    }

    public void setIngredientesid(int ingredientesid) {
        this.ingredientesid = ingredientesid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) platosid;
        hash += (int) ingredientesid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatosHasIngredientesPK)) {
            return false;
        }
        PlatosHasIngredientesPK other = (PlatosHasIngredientesPK) object;
        if (this.platosid != other.platosid) {
            return false;
        }
        if (this.ingredientesid != other.ingredientesid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.PlatosHasIngredientesPK[ platosid=" + platosid + ", ingredientesid=" + ingredientesid + " ]";
    }
    
}
