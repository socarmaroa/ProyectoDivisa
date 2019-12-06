/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.rest.service;

import com.prueba.control.cotizardivisas.ControlCotizarDivisa;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.prueba.modelo.TbTasacambio;

/**
 * REST Web Service
 *
 * @author Armando Becerra Rodríguez
 */
@Path("divisa")
@RequestScoped
public class TbDivisaServiceREST {

    @EJB
    private ControlCotizarDivisa cotizaTbDivisaFacadeLocal;

    /**
     * Creates a new instance of GenericResource
     */
    public TbDivisaServiceREST() {
    }

    @GET
    @Path("{idtasacambio}/{valorcotizar}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Double findRange(
            @PathParam("idtasacambio") Integer idTasaCambio,
            @PathParam("valorcotizar") Double valorCotizar) {
        Double valorCotizado
                = cotizaTbDivisaFacadeLocal.cotizarTbDivisa(idTasaCambio, valorCotizar);
        return valorCotizado;
    }

    @GET
    @Path("{idtasacambio}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TbTasacambio findTasaCambio(
            @PathParam("idtasacambio") Integer idTasaCambio) {
        TbTasacambio tasaCambio
                = cotizaTbDivisaFacadeLocal.findTasaCambio(idTasaCambio);
        return tasaCambio;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbTasacambio> findAll() {
        return cotizaTbDivisaFacadeLocal.findListaTasasCambio();
    }

}
