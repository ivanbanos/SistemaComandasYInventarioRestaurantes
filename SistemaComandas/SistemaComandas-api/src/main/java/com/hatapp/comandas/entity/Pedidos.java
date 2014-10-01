/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p"),
    @NamedQuery(name = "Pedidos.findById", query = "SELECT p FROM Pedidos p WHERE p.id = :id")})
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidos", fetch = FetchType.EAGER)
    private List<PedidosHasPlatos> pedidosHasPlatosList;
    @JoinColumn(name = "Cuenta", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuentas cuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidos", fetch = FetchType.EAGER)
    private List<PedidosHasAcompanantes> pedidosHasAcompanantesList;

    public Pedidos() {
    }

    public Pedidos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<PedidosHasPlatos> getPedidosHasPlatosList() {
        return pedidosHasPlatosList;
    }

    public void setPedidosHasPlatosList(List<PedidosHasPlatos> pedidosHasPlatosList) {
        this.pedidosHasPlatosList = pedidosHasPlatosList;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    @XmlTransient
    public List<PedidosHasAcompanantes> getPedidosHasAcompanantesList() {
        return pedidosHasAcompanantesList;
    }

    public void setPedidosHasAcompanantesList(List<PedidosHasAcompanantes> pedidosHasAcompanantesList) {
        this.pedidosHasAcompanantesList = pedidosHasAcompanantesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Pedidos[ id=" + id + " ]";
    }
    
}
