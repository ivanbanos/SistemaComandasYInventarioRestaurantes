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
public class AcompanantesHasIngredientesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Acompanantes_id")
    private int acompanantesid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ingredientes_id")
    private int ingredientesid;

    public AcompanantesHasIngredientesPK() {
    }

    public AcompanantesHasIngredientesPK(int acompanantesid, int ingredientesid) {
        this.acompanantesid = acompanantesid;
        this.ingredientesid = ingredientesid;
    }

    public int getAcompanantesid() {
        return acompanantesid;
    }

    public void setAcompanantesid(int acompanantesid) {
        this.acompanantesid = acompanantesid;
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
        hash += (int) acompanantesid;
        hash += (int) ingredientesid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcompanantesHasIngredientesPK)) {
            return false;
        }
        AcompanantesHasIngredientesPK other = (AcompanantesHasIngredientesPK) object;
        if (this.acompanantesid != other.acompanantesid) {
            return false;
        }
        if (this.ingredientesid != other.ingredientesid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.AcompanantesHasIngredientesPK[ acompanantesid=" + acompanantesid + ", ingredientesid=" + ingredientesid + " ]";
    }
    
}
