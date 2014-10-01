/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "fotos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotos.findAll", query = "SELECT f FROM Fotos f"),
    @NamedQuery(name = "Fotos.findById", query = "SELECT f FROM Fotos f WHERE f.id = :id"),
    @NamedQuery(name = "Fotos.findByMime", query = "SELECT f FROM Fotos f WHERE f.mime = :mime"),
    @NamedQuery(name = "Fotos.findByFormato", query = "SELECT f FROM Fotos f WHERE f.formato = :formato"),
    @NamedQuery(name = "Fotos.findByUrl", query = "SELECT f FROM Fotos f WHERE f.url = :url")})
public class Fotos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Column(name = "mime")
    private String mime;
    @Column(name = "formato")
    private String formato;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @OneToMany(mappedBy = "foto", fetch = FetchType.EAGER)
    private List<Platos> platosList;
    @OneToMany(mappedBy = "foto", fetch = FetchType.EAGER)
    private List<Acompanantes> acompanantesList;

    public Fotos() {
    }

    public Fotos(Integer id) {
        this.id = id;
    }

    public Fotos(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<Platos> getPlatosList() {
        return platosList;
    }

    public void setPlatosList(List<Platos> platosList) {
        this.platosList = platosList;
    }

    @XmlTransient
    public List<Acompanantes> getAcompanantesList() {
        return acompanantesList;
    }

    public void setAcompanantesList(List<Acompanantes> acompanantesList) {
        this.acompanantesList = acompanantesList;
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
        if (!(object instanceof Fotos)) {
            return false;
        }
        Fotos other = (Fotos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Fotos[ id=" + id + " ]";
    }
    
}