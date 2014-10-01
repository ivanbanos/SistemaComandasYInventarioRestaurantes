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
public class PedidosHasAcompanantesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Pedido")
    private int pedido;
    @Basic(optional = false)
    @Column(name = "Acompanante")
    private int acompanante;

    public PedidosHasAcompanantesPK() {
    }

    public PedidosHasAcompanantesPK(int pedido, int acompanante) {
        this.pedido = pedido;
        this.acompanante = acompanante;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getAcompanante() {
        return acompanante;
    }

    public void setAcompanante(int acompanante) {
        this.acompanante = acompanante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pedido;
        hash += (int) acompanante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidosHasAcompanantesPK)) {
            return false;
        }
        PedidosHasAcompanantesPK other = (PedidosHasAcompanantesPK) object;
        if (this.pedido != other.pedido) {
            return false;
        }
        if (this.acompanante != other.acompanante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.PedidosHasAcompanantesPK[ pedido=" + pedido + ", acompanante=" + acompanante + " ]";
    }
    
}
