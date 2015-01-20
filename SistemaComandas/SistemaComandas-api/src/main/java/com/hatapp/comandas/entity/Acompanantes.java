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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "acompanantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acompanantes.findAll", query = "SELECT a FROM Acompanantes a"),
    @NamedQuery(name = "Acompanantes.findById", query = "SELECT a FROM Acompanantes a WHERE a.id = :id"),
    @NamedQuery(name = "Acompanantes.findByNombre", query = "SELECT a FROM Acompanantes a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Acompanantes.findByPrecio", query = "SELECT a FROM Acompanantes a WHERE a.precio = :precio"),
    @NamedQuery(name = "Acompanantes.findByGrupo", query = "SELECT a FROM Acompanantes a WHERE a.grupo = :grupo"),
    @NamedQuery(name = "Acompanantes.findByTipo", query = "SELECT a FROM Acompanantes a WHERE a.tipo = :tipo")})
public class Acompanantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "precio")
    private String precio;
    @Size(max = 45)
    @Column(name = "grupo")
    private String grupo;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acompanantes")
    private List<AcompanantesHasIngredientes> acompanantesHasIngredientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acompanantes")
    private List<PedidosHasAcompanantes> pedidosHasAcompanantesList;
    @JoinColumn(name = "Foto", referencedColumnName = "id")
    @ManyToOne
    private Fotos foto;

    public Acompanantes() {
    }

    public Acompanantes(Integer id) {
        this.id = id;
    }

    public Acompanantes(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<AcompanantesHasIngredientes> getAcompanantesHasIngredientesList() {
        return acompanantesHasIngredientesList;
    }

    public void setAcompanantesHasIngredientesList(List<AcompanantesHasIngredientes> acompanantesHasIngredientesList) {
        this.acompanantesHasIngredientesList = acompanantesHasIngredientesList;
    }

    @XmlTransient
    public List<PedidosHasAcompanantes> getPedidosHasAcompanantesList() {
        return pedidosHasAcompanantesList;
    }

    public void setPedidosHasAcompanantesList(List<PedidosHasAcompanantes> pedidosHasAcompanantesList) {
        this.pedidosHasAcompanantesList = pedidosHasAcompanantesList;
    }

    public Fotos getFoto() {
        return foto;
    }

    public void setFoto(Fotos foto) {
        this.foto = foto;
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
        if (!(object instanceof Acompanantes)) {
            return false;
        }
        Acompanantes other = (Acompanantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Acompanantes[ id=" + id + " ]";
    }
    
}
