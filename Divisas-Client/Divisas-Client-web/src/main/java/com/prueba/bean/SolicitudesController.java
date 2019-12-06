/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.bean;

import com.prueba.bean.util.JsfUtil;
import com.prueba.client.ClientTbDivisaRest;
import com.prueba.modelo.TbTasacambio;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Armando Becerra Rodríguez
 */
@Named("solicitudesController")
@SessionScoped
public class SolicitudesController implements Serializable {

    private ClientTbDivisaRest clientTbDivisaRest;

    private TbTasacambio tasacambio;

    private Double valorCotizar;

    private Double valorCotizado;

    public SolicitudesController() {

    }

    @PostConstruct
    public void init() {
        clientTbDivisaRest = new ClientTbDivisaRest();
        tasacambio = getClientTbDivisaRest()
                .tasasCambio().get(0);
    }

    public ClientTbDivisaRest getClientTbDivisaRest() {
        return clientTbDivisaRest;
    }

    public void calcularCotizacion() {
        try {
            if (null != tasacambio
                    || null != tasacambio.getIdTasacambio()
                    || null != valorCotizar) {
                valorCotizado = getClientTbDivisaRest()
                        .cotizarTbDivisa(tasacambio.getIdTasacambio(), valorCotizar);
            }
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("success"));
        } catch (Exception e) {
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ErrorCotizando"));
            valorCotizado = null;
        }
    }

    public SelectItem[] getItemsTasasCambio() {
        List<TbTasacambio> list = getClientTbDivisaRest()
                .tasasCambio();
        return JsfUtil
                .getSelectItems(list, true);
    }

    /**
     * @return the tasacambio
     */
    public TbTasacambio getTasacambio() {
        return tasacambio;
    }

    /**
     * @param tasacambio the tasacambio to set
     */
    public void setTasacambio(TbTasacambio tasacambio) {
        this.tasacambio = tasacambio;
    }

    /**
     * @return the valorCotizar
     */
    public Double getValorCotizar() {
        return valorCotizar;
    }

    /**
     * @param valorCotizar the valorCotizar to set
     */
    public void setValorCotizar(Double valorCotizar) {
        this.valorCotizar = valorCotizar;
    }

    /**
     * @return the valorCotizado
     */
    public Double getValorCotizado() {
        return valorCotizado;
    }

    /**
     * @param valorCotizado the valorCotizado to set
     */
    public void setValorCotizado(Double valorCotizado) {
        this.valorCotizado = valorCotizado;
    }

    public Object getTbTasacambio(Integer key) {
        return clientTbDivisaRest.findTasaCambio(key);
    }

}
