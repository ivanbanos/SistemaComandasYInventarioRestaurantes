/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "acompanantes_has_ingredientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcompanantesHasIngredientes.findAll", query = "SELECT a FROM AcompanantesHasIngredientes a"),
    @NamedQuery(name = "AcompanantesHasIngredientes.findByAcompanantesid", query = "SELECT a FROM AcompanantesHasIngredientes a WHERE a.acompanantesHasIngredientesPK.acompanantesid = :acompanantesid"),
    @NamedQuery(name = "AcompanantesHasIngredientes.findByIngredientesid", query = "SELECT a FROM AcompanantesHasIngredientes a WHERE a.acompanantesHasIngredientesPK.ingredientesid = :ingredientesid"),
    @NamedQuery(name = "AcompanantesHasIngredientes.findByCantidad", query = "SELECT a FROM AcompanantesHasIngredientes a WHERE a.cantidad = :cantidad")})
public class AcompanantesHasIngredientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AcompanantesHasIngredientesPK acompanantesHasIngredientesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Float cantidad;
    @JoinColumn(name = "Ingredientes_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingredientes ingredientes;
    @JoinColumn(name = "Acompanantes_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Acompanantes acompanantes;

    public AcompanantesHasIngredientes() {
    }

    public AcompanantesHasIngredientes(AcompanantesHasIngredientesPK acompanantesHasIngredientesPK) {
        this.acompanantesHasIngredientesPK = acompanantesHasIngredientesPK;
    }

    public AcompanantesHasIngredientes(int acompanantesid, int ingredientesid) {
        this.acompanantesHasIngredientesPK = new AcompanantesHasIngredientesPK(acompanantesid, ingredientesid);
    }

    public AcompanantesHasIngredientesPK getAcompanantesHasIngredientesPK() {
        return acompanantesHasIngredientesPK;
    }

    public void setAcompanantesHasIngredientesPK(AcompanantesHasIngredientesPK acompanantesHasIngredientesPK) {
        this.acompanantesHasIngredientesPK = acompanantesHasIngredientesPK;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Ingredientes getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Acompanantes getAcompanantes() {
        return acompanantes;
    }

    public void setAcompanantes(Acompanantes acompanantes) {
        this.acompanantes = acompanantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acompanantesHasIngredientesPK != null ? acompanantesHasIngredientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcompanantesHasIngredientes)) {
            return false;
        }
        AcompanantesHasIngredientes other = (AcompanantesHasIngredientes) object;
        if ((this.acompanantesHasIngredientesPK == null && other.acompanantesHasIngredientesPK != null) || (this.acompanantesHasIngredientesPK != null && !this.acompanantesHasIngredientesPK.equals(other.acompanantesHasIngredientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.AcompanantesHasIngredientes[ acompanantesHasIngredientesPK=" + acompanantesHasIngredientesPK + " ]";
    }
    
}
