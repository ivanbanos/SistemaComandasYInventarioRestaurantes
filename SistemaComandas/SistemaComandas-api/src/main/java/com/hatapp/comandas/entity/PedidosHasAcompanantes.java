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
import javax.persistence.FetchType;
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
@Table(name = "pedidos_has_acompanantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosHasAcompanantes.findAll", query = "SELECT p FROM PedidosHasAcompanantes p"),
    @NamedQuery(name = "PedidosHasAcompanantes.findByPedido", query = "SELECT p FROM PedidosHasAcompanantes p WHERE p.pedidosHasAcompanantesPK.pedido = :pedido"),
    @NamedQuery(name = "PedidosHasAcompanantes.findByAcompanante", query = "SELECT p FROM PedidosHasAcompanantes p WHERE p.pedidosHasAcompanantesPK.acompanante = :acompanante"),
    @NamedQuery(name = "PedidosHasAcompanantes.findByCantidad", query = "SELECT p FROM PedidosHasAcompanantes p WHERE p.cantidad = :cantidad")})
public class PedidosHasAcompanantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidosHasAcompanantesPK pedidosHasAcompanantesPK;
    @Column(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "Acompanante", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Acompanantes acompanantes;
    @JoinColumn(name = "Pedido", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedidos pedidos;

    public PedidosHasAcompanantes() {
    }

    public PedidosHasAcompanantes(PedidosHasAcompanantesPK pedidosHasAcompanantesPK) {
        this.pedidosHasAcompanantesPK = pedidosHasAcompanantesPK;
    }

    public PedidosHasAcompanantes(int pedido, int acompanante) {
        this.pedidosHasAcompanantesPK = new PedidosHasAcompanantesPK(pedido, acompanante);
    }

    public PedidosHasAcompanantesPK getPedidosHasAcompanantesPK() {
        return pedidosHasAcompanantesPK;
    }

    public void setPedidosHasAcompanantesPK(PedidosHasAcompanantesPK pedidosHasAcompanantesPK) {
        this.pedidosHasAcompanantesPK = pedidosHasAcompanantesPK;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Acompanantes getAcompanantes() {
        return acompanantes;
    }

    public void setAcompanantes(Acompanantes acompanantes) {
        this.acompanantes = acompanantes;
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
        hash += (pedidosHasAcompanantesPK != null ? pedidosHasAcompanantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidosHasAcompanantes)) {
            return false;
        }
        PedidosHasAcompanantes other = (PedidosHasAcompanantes) object;
        if ((this.pedidosHasAcompanantesPK == null && other.pedidosHasAcompanantesPK != null) || (this.pedidosHasAcompanantesPK != null && !this.pedidosHasAcompanantesPK.equals(other.pedidosHasAcompanantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.PedidosHasAcompanantes[ pedidosHasAcompanantesPK=" + pedidosHasAcompanantesPK + " ]";
    }
    
}
