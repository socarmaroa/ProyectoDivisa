/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author so_ca
 */
@Entity
@Table(name = "tb_cotizacion", catalog = "divisadb", schema = "divisadb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCotizacion.findAll", query = "SELECT t FROM TbCotizacion t"),
    @NamedQuery(name = "TbCotizacion.findByIdCotizacion", query = "SELECT t FROM TbCotizacion t WHERE t.idCotizacion = :idCotizacion"),
    @NamedQuery(name = "TbCotizacion.findByFechaRegistro", query = "SELECT t FROM TbCotizacion t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TbCotizacion.findByValor", query = "SELECT t FROM TbCotizacion t WHERE t.valor = :valor")})
public class TbCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cotizacion", nullable = false)
    private Integer idCotizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double valor;
    @JoinColumn(name = "id_valortasacambio", referencedColumnName = "id_valortasacambio", nullable = false)
    @ManyToOne(optional = false)
    private TbValortasacambio idValortasacambio;

    public TbCotizacion() {
    }

    public TbCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public TbCotizacion(Integer idCotizacion, Date fechaRegistro, double valor) {
        this.idCotizacion = idCotizacion;
        this.fechaRegistro = fechaRegistro;
        this.valor = valor;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TbValortasacambio getIdValortasacambio() {
        return idValortasacambio;
    }

    public void setIdValortasacambio(TbValortasacambio idValortasacambio) {
        this.idValortasacambio = idValortasacambio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizacion != null ? idCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCotizacion)) {
            return false;
        }
        TbCotizacion other = (TbCotizacion) object;
        if ((this.idCotizacion == null && other.idCotizacion != null) || (this.idCotizacion != null && !this.idCotizacion.equals(other.idCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba.modelo.TbCotizacion[ idCotizacion=" + idCotizacion + " ]";
    }
    
}
