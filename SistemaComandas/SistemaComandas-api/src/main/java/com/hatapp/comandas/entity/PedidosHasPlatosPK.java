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

/**
 *
 * @author ivan
 */
@Embeddable
public class PedidosHasPlatosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Pedido")
    private int pedido;
    @Basic(optional = false)
    @Column(name = "Plato")
    private int plato;

    public PedidosHasPlatosPK() {
    }

    public PedidosHasPlatosPK(int pedido, int plato) {
        this.pedido = pedido;
        this.plato = plato;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getPlato() {
        return plato;
    }

    public void setPlato(int plato) {
        this.plato = plato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pedido;
        hash += (int) plato;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidosHasPlatosPK)) {
            return false;
        }
        PedidosHasPlatosPK other = (PedidosHasPlatosPK) object;
        if (this.pedido != other.pedido) {
            return false;
        }
        if (this.plato != other.plato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.PedidosHasPlatosPK[ pedido=" + pedido + ", plato=" + plato + " ]";
    }
    
}
