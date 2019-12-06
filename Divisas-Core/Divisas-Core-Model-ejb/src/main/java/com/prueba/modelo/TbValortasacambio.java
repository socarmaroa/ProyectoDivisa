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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author so_ca
 */
@Entity
@Table(name = "tb_valortasacambio", catalog = "divisadb", schema = "divisadb", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_tasacambio", "fecha_valortasacambio"}),
    @UniqueConstraint(columnNames = {"valortasacambio", "fecha_valortasacambio", "id_tasacambio"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbValortasacambio.findAll", query = "SELECT t FROM TbValortasacambio t"),
    @NamedQuery(name = "TbValortasacambio.findByIdValortasacambio", query = "SELECT t FROM TbValortasacambio t WHERE t.idValortasacambio = :idValortasacambio"),
    @NamedQuery(name = "TbValortasacambio.findByValortasacambio", query = "SELECT t FROM TbValortasacambio t WHERE t.valortasacambio = :valortasacambio"),
    @NamedQuery(name = "TbValortasacambio.findByFechaValortasacambio", query = "SELECT t FROM TbValortasacambio t WHERE t.fechaValortasacambio = :fechaValortasacambio")})
public class TbValortasacambio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valortasacambio", nullable = false)
    private Integer idValortasacambio;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double valortasacambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_valortasacambio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValortasacambio;
    @JoinColumn(name = "id_tasacambio", referencedColumnName = "id_tasacambio", nullable = false)
    @ManyToOne(optional = false)
    private TbTasacambio idTasacambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idValortasacambio")
    private Collection<TbCotizacion> tbCotizacionCollection;

    public TbValortasacambio() {
    }

    public TbValortasacambio(Integer idValortasacambio) {
        this.idValortasacambio = idValortasacambio;
    }

    public TbValortasacambio(Integer idValortasacambio, double valortasacambio, Date fechaValortasacambio) {
        this.idValortasacambio = idValortasacambio;
        this.valortasacambio = valortasacambio;
        this.fechaValortasacambio = fechaValortasacambio;
    }

    public Integer getIdValortasacambio() {
        return idValortasacambio;
    }

    public void setIdValortasacambio(Integer idValortasacambio) {
        this.idValortasacambio = idValortasacambio;
    }

    public double getValortasacambio() {
        return valortasacambio;
    }

    public void setValortasacambio(double valortasacambio) {
        this.valortasacambio = valortasacambio;
    }

    public Date getFechaValortasacambio() {
        return fechaValortasacambio;
    }

    public void setFechaValortasacambio(Date fechaValortasacambio) {
        this.fechaValortasacambio = fechaValortasacambio;
    }

    public TbTasacambio getIdTasacambio() {
        return idTasacambio;
    }

    public void setIdTasacambio(TbTasacambio idTasacambio) {
        this.idTasacambio = idTasacambio;
    }

    @XmlTransient
    public Collection<TbCotizacion> getTbCotizacionCollection() {
        return tbCotizacionCollection;
    }

    public void setTbCotizacionCollection(Collection<TbCotizacion> tbCotizacionCollection) {
        this.tbCotizacionCollection = tbCotizacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValortasacambio != null ? idValortasacambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbValortasacambio)) {
            return false;
        }
        TbValortasacambio other = (TbValortasacambio) object;
        if ((this.idValortasacambio == null && other.idValortasacambio != null) || (this.idValortasacambio != null && !this.idValortasacambio.equals(other.idValortasacambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba.modelo.TbValortasacambio[ idValortasacambio=" + idValortasacambio + " ]";
    }
    
}
