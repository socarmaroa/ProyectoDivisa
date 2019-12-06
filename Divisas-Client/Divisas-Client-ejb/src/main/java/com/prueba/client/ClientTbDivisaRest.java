/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.client;

import com.prueba.modelo.TbTasacambio;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;

public class ClientTbDivisaRest {

    private Client client;

    private static final String API = "http://localhost:8080/Divisas-Api-web/api";

    private static final String RESOURCE = "divisa";

    public List<TbTasacambio> tasasCambio() {
        try {
            client = Client.create();
            WebResource webresources = client.resource(API).path(RESOURCE);
            GenericType<List<TbTasacambio>> genericType = new GenericType<List<TbTasacambio>>() {
            };
            List<TbTasacambio> list = webresources.get(genericType);
            System.out.println("result->" + list);
            return list;
        } catch (Exception e) {
            System.out.println("Error... " + e);
        }
        return null;
    }

    public Double cotizarTbDivisa(Integer idTasaCambio, Double valorCotizar) {
        try {
            client = Client.create();
            ClientResponse response = client.resource(API)
                    .path(RESOURCE)
                    .path(idTasaCambio.toString())
                    .path(valorCotizar.toString())
                    .get(ClientResponse.class);
            String output = response.getEntity(String.class);
            System.out.println("result->" + output);
            return Double.valueOf(output);
        } catch (Exception e) {
            System.out.println("Error... " + e);
        }
        return null;
    }

    public TbTasacambio findTasaCambio(Integer idTasaCambio) {
        try {
            client = Client.create();
            ClientResponse response = client.resource(API)
                    .path(RESOURCE)
                    .path(idTasaCambio.toString())
                    .get(ClientResponse.class);
            TbTasacambio output = response.getEntity(TbTasacambio.class);
            System.out.println("result->" + output);
            return output;
        } catch (Exception e) {
            System.out.println("Error... " + e);
        }
        return null;
    }

}
