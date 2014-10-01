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
public class MesasHasClientesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Mesa")
    private int mesa;
    @Basic(optional = false)
    @Column(name = "Cliente")
    private int cliente;

    public MesasHasClientesPK() {
    }

    public MesasHasClientesPK(int mesa, int cliente) {
        this.mesa = mesa;
        this.cliente = cliente;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) mesa;
        hash += (int) cliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesasHasClientesPK)) {
            return false;
        }
        MesasHasClientesPK other = (MesasHasClientesPK) object;
        if (this.mesa != other.mesa) {
            return false;
        }
        if (this.cliente != other.cliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.MesasHasClientesPK[ mesa=" + mesa + ", cliente=" + cliente + " ]";
    }
    
}
