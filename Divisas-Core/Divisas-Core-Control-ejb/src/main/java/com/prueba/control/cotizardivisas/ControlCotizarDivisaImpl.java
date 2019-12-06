/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.cotizardivisas;

import javax.ejb.Stateless;
import com.prueba.modelo.TbCotizacion;
import java.util.List;
import javax.ejb.EJB;
import com.prueba.control.tbvalortasacambio.ControlTbValortasacambio;
import com.prueba.modelo.TbTasacambio;
import com.prueba.control.tbtasacambio.ControlTbTasacambio;
import com.prueba.modelo.TbValortasacambio;
import com.prueba.control.tbcotizacion.ControlTbCotizacion;
import java.util.Date;

/**
 * Clase para implementar la acción de negocio CotizaTbDivisa
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Stateless
public class ControlCotizarDivisaImpl
        implements ControlCotizarDivisa {

    /**
     * Variable para el llamado a las acciones de negocio de la entidad
     * TasaCambio.
     */
    @EJB
    private ControlTbTasacambio tbTasacambioControlEntity;
    /**
     * Variable para el llamado a las acciones de negocio de la entidad
     * ValorTasaCambio.
     */
    @EJB
    private ControlTbValortasacambio tbValortasacambioControlEntity;
    /**
     * Variable para el llamado a las acciones de negocio de la entidad
     * TbCotizacionControl.
     */
    @EJB
    private ControlTbCotizacion tbCotizacionControlEntity;

    /**
     * {@inheritDoc}
     *
     * @param idTasacambio {@inheritDoc}
     * @param valorCotizar {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Double cotizarTbDivisa(Integer idTasacambio, Double valorCotizar) {
        try {
            if (idTasacambio == null || valorCotizar == null) {
                return null;
            }
            TbTasacambio tbTasacambio
                    = tbTasacambioControlEntity.find(idTasacambio);
            if (tbTasacambio == null) {
                return null;
            }
            TbValortasacambio tbValortasacambio
                    = tbValortasacambioControlEntity.findFinishValue(tbTasacambio);
            if (tbValortasacambio == null) {
                return null;
            }
            Double valorCotizado
                    = tbValortasacambio
                            .getValortasacambio() * valorCotizar;
            TbCotizacion tbCotizacion = new TbCotizacion();
            tbCotizacion.setIdValortasacambio(tbValortasacambio);
            tbCotizacion.setValor(valorCotizar);
            tbCotizacion.setFechaRegistro(new Date());
            tbCotizacionControlEntity.create(tbCotizacion);
            return valorCotizado;
        } catch (Exception e) {
            System.out.println("Error en calculo..");
        }
        return null;
    }

    /**
     * Solicita la busqueda de todas las tasas de cambio disponibles para el
     * cambio.
     *
     * @return un listado de tasas de cambio disponibles para cotizar.
     */
    @Override
    public List<TbTasacambio> findListaTasasCambio() {
        try {
            return tbTasacambioControlEntity.findListaTasasCambio();
        } catch (Exception e) {
            return null;
        }
    }

}
