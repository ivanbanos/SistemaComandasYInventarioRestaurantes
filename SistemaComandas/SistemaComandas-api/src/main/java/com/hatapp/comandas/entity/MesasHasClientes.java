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
@Table(name = "mesas_has_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MesasHasClientes.findAll", query = "SELECT m FROM MesasHasClientes m"),
    @NamedQuery(name = "MesasHasClientes.findByMesa", query = "SELECT m FROM MesasHasClientes m WHERE m.mesasHasClientesPK.mesa = :mesa"),
    @NamedQuery(name = "MesasHasClientes.findByCliente", query = "SELECT m FROM MesasHasClientes m WHERE m.mesasHasClientesPK.cliente = :cliente"),
    @NamedQuery(name = "MesasHasClientes.findByFechaReserva", query = "SELECT m FROM MesasHasClientes m WHERE m.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "MesasHasClientes.findByEstado", query = "SELECT m FROM MesasHasClientes m WHERE m.estado = :estado")})
public class MesasHasClientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MesasHasClientesPK mesasHasClientesPK;
    @Size(max = 45)
    @Column(name = "fechaReserva")
    private String fechaReserva;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "Mesa", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Mesas mesas;
    @JoinColumn(name = "Cliente", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;

    public MesasHasClientes() {
    }

    public MesasHasClientes(MesasHasClientesPK mesasHasClientesPK) {
        this.mesasHasClientesPK = mesasHasClientesPK;
    }

    public MesasHasClientes(int mesa, int cliente) {
        this.mesasHasClientesPK = new MesasHasClientesPK(mesa, cliente);
    }

    public MesasHasClientesPK getMesasHasClientesPK() {
        return mesasHasClientesPK;
    }

    public void setMesasHasClientesPK(MesasHasClientesPK mesasHasClientesPK) {
        this.mesasHasClientesPK = mesasHasClientesPK;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Mesas getMesas() {
        return mesas;
    }

    public void setMesas(Mesas mesas) {
        this.mesas = mesas;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mesasHasClientesPK != null ? mesasHasClientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesasHasClientes)) {
            return false;
        }
        MesasHasClientes other = (MesasHasClientes) object;
        if ((this.mesasHasClientesPK == null && other.mesasHasClientesPK != null) || (this.mesasHasClientesPK != null && !this.mesasHasClientesPK.equals(other.mesasHasClientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.MesasHasClientes[ mesasHasClientesPK=" + mesasHasClientesPK + " ]";
    }
    
}
