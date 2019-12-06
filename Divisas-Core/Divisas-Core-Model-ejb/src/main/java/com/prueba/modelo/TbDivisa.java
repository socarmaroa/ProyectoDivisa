/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author so_ca
 */
@Entity
@Table(name = "tb_divisa", catalog = "divisadb", schema = "divisadb", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"abreviatura_divisa"}),
    @UniqueConstraint(columnNames = {"nombre_divisa"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDivisa.findAll", query = "SELECT t FROM TbDivisa t"),
    @NamedQuery(name = "TbDivisa.findByIdDivisa", query = "SELECT t FROM TbDivisa t WHERE t.idDivisa = :idDivisa"),
    @NamedQuery(name = "TbDivisa.findByNombreDivisa", query = "SELECT t FROM TbDivisa t WHERE t.nombreDivisa = :nombreDivisa"),
    @NamedQuery(name = "TbDivisa.findByAbreviaturaDivisa", query = "SELECT t FROM TbDivisa t WHERE t.abreviaturaDivisa = :abreviaturaDivisa"),
    @NamedQuery(name = "TbDivisa.findByActiva", query = "SELECT t FROM TbDivisa t WHERE t.activa = :activa"),
    @NamedQuery(name = "TbDivisa.findByFechaRegistro", query = "SELECT t FROM TbDivisa t WHERE t.fechaRegistro = :fechaRegistro")})
public class TbDivisa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_divisa", nullable = false)
    private Integer idDivisa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "nombre_divisa", nullable = false, length = 12)
    private String nombreDivisa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "abreviatura_divisa", nullable = false, length = 5)
    private String abreviaturaDivisa;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDivisa1")
    private Collection<TbTasacambio> tbTasacambioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDivisa2")
    private Collection<TbTasacambio> tbTasacambioCollection1;

    public TbDivisa() {
    }

    public TbDivisa(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public TbDivisa(Integer idDivisa, String nombreDivisa, String abreviaturaDivisa, boolean activa, Date fechaRegistro) {
        this.idDivisa = idDivisa;
        this.nombreDivisa = nombreDivisa;
        this.abreviaturaDivisa = abreviaturaDivisa;
        this.activa = activa;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public String getNombreDivisa() {
        return nombreDivisa;
    }

    public void setNombreDivisa(String nombreDivisa) {
        this.nombreDivisa = nombreDivisa;
    }

    public String getAbreviaturaDivisa() {
        return abreviaturaDivisa;
    }

    public void setAbreviaturaDivisa(String abreviaturaDivisa) {
        this.abreviaturaDivisa = abreviaturaDivisa;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<TbTasacambio> getTbTasacambioCollection() {
        return tbTasacambioCollection;
    }

    public void setTbTasacambioCollection(Collection<TbTasacambio> tbTasacambioCollection) {
        this.tbTasacambioCollection = tbTasacambioCollection;
    }

    @XmlTransient
    public Collection<TbTasacambio> getTbTasacambioCollection1() {
        return tbTasacambioCollection1;
    }

    public void setTbTasacambioCollection1(Collection<TbTasacambio> tbTasacambioCollection1) {
        this.tbTasacambioCollection1 = tbTasacambioCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivisa != null ? idDivisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDivisa)) {
            return false;
        }
        TbDivisa other = (TbDivisa) object;
        if ((this.idDivisa == null && other.idDivisa != null) || (this.idDivisa != null && !this.idDivisa.equals(other.idDivisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba.modelo.TbDivisa[ idDivisa=" + idDivisa + " ]";
    }
    
}
