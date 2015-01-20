/*
 * To change this template, choose Tools | Templates
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
 * @author ideacentre
 */
@Entity
@Table(name = "platos_has_ingredientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlatosHasIngredientes.findAll", query = "SELECT p FROM PlatosHasIngredientes p"),
    @NamedQuery(name = "PlatosHasIngredientes.findByPlatosid", query = "SELECT p FROM PlatosHasIngredientes p WHERE p.platosHasIngredientesPK.platosid = :platosid"),
    @NamedQuery(name = "PlatosHasIngredientes.findByIngredientesid", query = "SELECT p FROM PlatosHasIngredientes p WHERE p.platosHasIngredientesPK.ingredientesid = :ingredientesid"),
    @NamedQuery(name = "PlatosHasIngredientes.findByCantidad", query = "SELECT p FROM PlatosHasIngredientes p WHERE p.cantidad = :cantidad")})
public class PlatosHasIngredientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlatosHasIngredientesPK platosHasIngredientesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Float cantidad;
    @JoinColumn(name = "Platos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Platos platos;
    @JoinColumn(name = "Ingredientes_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingredientes ingredientes;

    public PlatosHasIngredientes() {
    }

    public PlatosHasIngredientes(PlatosHasIngredientesPK platosHasIngredientesPK) {
        this.platosHasIngredientesPK = platosHasIngredientesPK;
    }

    public PlatosHasIngredientes(int platosid, int ingredientesid) {
        this.platosHasIngredientesPK = new PlatosHasIngredientesPK(platosid, ingredientesid);
    }

    public PlatosHasIngredientesPK getPlatosHasIngredientesPK() {
        return platosHasIngredientesPK;
    }

    public void setPlatosHasIngredientesPK(PlatosHasIngredientesPK platosHasIngredientesPK) {
        this.platosHasIngredientesPK = platosHasIngredientesPK;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Platos getPlatos() {
        return platos;
    }

    public void setPlatos(Platos platos) {
        this.platos = platos;
    }

    public Ingredientes getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platosHasIngredientesPK != null ? platosHasIngredientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatosHasIngredientes)) {
            return false;
        }
        PlatosHasIngredientes other = (PlatosHasIngredientes) object;
        if ((this.platosHasIngredientesPK == null && other.platosHasIngredientesPK != null) || (this.platosHasIngredientesPK != null && !this.platosHasIngredientesPK.equals(other.platosHasIngredientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.PlatosHasIngredientes[ platosHasIngredientesPK=" + platosHasIngredientesPK + " ]";
    }
    
}
