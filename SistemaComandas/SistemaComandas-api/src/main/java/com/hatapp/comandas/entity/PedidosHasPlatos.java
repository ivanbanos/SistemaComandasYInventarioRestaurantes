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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "pedidos_has_platos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosHasPlatos.findAll", query = "SELECT p FROM PedidosHasPlatos p"),
    @NamedQuery(name = "PedidosHasPlatos.findByPedido", query = "SELECT p FROM PedidosHasPlatos p WHERE p.pedidosHasPlatosPK.pedido = :pedido"),
    @NamedQuery(name = "PedidosHasPlatos.findByPlato", query = "SELECT p FROM PedidosHasPlatos p WHERE p.pedidosHasPlatosPK.plato = :plato"),
    @NamedQuery(name = "PedidosHasPlatos.findByCantidad", query = "SELECT p FROM PedidosHasPlatos p WHERE p.cantidad = :cantidad")})
public class PedidosHasPlatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidosHasPlatosPK pedidosHasPlatosPK;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "Plato", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Platos platos;
    @JoinColumn(name = "Pedido", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidos pedidos;

    public PedidosHasPlatos() {
    }

    public PedidosHasPlatos(PedidosHasPlatosPK pedidosHasPlatosPK) {
        this.pedidosHasPlatosPK = pedidosHasPlatosPK;
    }

    public PedidosHasPlatos(int pedido, int plato) {
        this.pedidosHasPlatosPK = new PedidosHasPlatosPK(pedido, plato);
    }

    public PedidosHasPlatosPK getPedidosHasPlatosPK() {
        return pedidosHasPlatosPK;
    }

    public void setPedidosHasPlatosPK(PedidosHasPlatosPK pedidosHasPlatosPK) {
        this.pedidosHasPlatosPK = pedidosHasPlatosPK;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Platos getPlatos() {
        return platos;
    }

    public void setPlatos(Platos platos) {
        this.platos = platos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidosHasPlatosPK != null ? pedidosHasPlatosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidosHasPlatos)) {
            return false;
        }
        PedidosHasPlatos other = (PedidosHasPlatos) object;
        if ((this.pedidosHasPlatosPK == null && other.pedidosHasPlatosPK != null) || (this.pedidosHasPlatosPK != null && !this.pedidosHasPlatosPK.equals(other.pedidosHasPlatosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.PedidosHasPlatos[ pedidosHasPlatosPK=" + pedidosHasPlatosPK + " ]";
    }
    
}
