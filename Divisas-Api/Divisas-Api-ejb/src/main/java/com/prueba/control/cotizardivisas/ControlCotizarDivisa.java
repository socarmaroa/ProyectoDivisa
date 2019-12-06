/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.cotizardivisas;

import java.util.List;
import javax.ejb.Local;
import com.prueba.modelo.TbTasacambio;

/**
 * Clase para exponer todos los metodos de cotizar TbDivisa
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Local
public interface ControlCotizarDivisa {

    /**
     * Solicitar la busqueda de todas las tasas de cambio disponibles para
     * realizar peticiones.
     *
     * @return un listado de tasas de cambio
     */
    public List<TbTasacambio> findListaTasasCambio();

    /**
     * Solicita la cotización del valor y la tasa de cambio contenido en el
     * parámetro.
     *
     * @param idTasacambio - tasa de cambio
     * @param valorCotizar - valor a cotizar
     * @return una instancia Response con las acciones realizadas.
     */
    public Double cotizarTbDivisa(Integer idTasacambio, Double valorCotizar);

    /**
     * Solicita la busqueda de la tasa de cambio
     *
     * @param idTasaCambio id de la tas de cambio
     * @return un objeto tasa de cambio o null
     */
    public TbTasacambio findTasaCambio(Integer idTasaCambio);
}
