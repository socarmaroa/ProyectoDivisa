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
@Table(name = "tb_tasacambio", catalog = "divisadb", schema = "divisadb", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_divisa1", "id_divisa2"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTasacambio.findAll", query = "SELECT t FROM TbTasacambio t"),
    @NamedQuery(name = "TbTasacambio.findByIdTasacambio", query = "SELECT t FROM TbTasacambio t WHERE t.idTasacambio = :idTasacambio"),
    @NamedQuery(name = "TbTasacambio.findByFechaRegistro", query = "SELECT t FROM TbTasacambio t WHERE t.fechaRegistro = :fechaRegistro")})
public class TbTasacambio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tasacambio", nullable = false)
    private Integer idTasacambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTasacambio")
    private Collection<TbValortasacambio> tbValortasacambioCollection;
    @JoinColumn(name = "id_divisa1", referencedColumnName = "id_divisa", nullable = false)
    @ManyToOne(optional = false)
    private TbDivisa idDivisa1;
    @JoinColumn(name = "id_divisa2", referencedColumnName = "id_divisa", nullable = false)
    @ManyToOne(optional = false)
    private TbDivisa idDivisa2;

    public TbTasacambio() {
    }

    public TbTasacambio(Integer idTasacambio) {
        this.idTasacambio = idTasacambio;
    }

    public TbTasacambio(Integer idTasacambio, Date fechaRegistro) {
        this.idTasacambio = idTasacambio;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdTasacambio() {
        return idTasacambio;
    }

    public void setIdTasacambio(Integer idTasacambio) {
        this.idTasacambio = idTasacambio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<TbValortasacambio> getTbValortasacambioCollection() {
        return tbValortasacambioCollection;
    }

    public void setTbValortasacambioCollection(Collection<TbValortasacambio> tbValortasacambioCollection) {
        this.tbValortasacambioCollection = tbValortasacambioCollection;
    }

    public TbDivisa getIdDivisa1() {
        return idDivisa1;
    }

    public void setIdDivisa1(TbDivisa idDivisa1) {
        this.idDivisa1 = idDivisa1;
    }

    public TbDivisa getIdDivisa2() {
        return idDivisa2;
    }

    public void setIdDivisa2(TbDivisa idDivisa2) {
        this.idDivisa2 = idDivisa2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTasacambio != null ? idTasacambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTasacambio)) {
            return false;
        }
        TbTasacambio other = (TbTasacambio) object;
        if ((this.idTasacambio == null && other.idTasacambio != null) || (this.idTasacambio != null && !this.idTasacambio.equals(other.idTasacambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba.modelo.TbTasacambio[ idTasacambio=" + idTasacambio + " ]";
    }
    
}
