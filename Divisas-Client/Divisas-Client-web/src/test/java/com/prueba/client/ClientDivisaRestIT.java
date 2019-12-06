/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.client;

import com.prueba.modelo.TbTasacambio;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Armando Becerra Rodríguez
 */
public class ClientDivisaRestIT {
    
    public ClientDivisaRestIT() {
    }

    /**
     * Test of tasasCambio method, of class ClientTbDivisaRest.
     */
    @Test
    public void testTasasCambio() {
        System.out.println("tasasCambio");
        ClientTbDivisaRest instance = new ClientTbDivisaRest();
        List<TbTasacambio> expResult = null;
        List<TbTasacambio> result = instance.tasasCambio();
        assertNotEquals(expResult, result);
        System.out.println("result->"+result);
    }

    /**
     * Test of cotizarTbDivisa method, of class ClientTbDivisaRest.
     */
    @Test
    public void testCotizarTbDivisa() {
        System.out.println("cotizarTbDivisa");
        Integer idTasaCambio = 8;
        Double valorCotizar = 2356.89;
        ClientTbDivisaRest instance = new ClientTbDivisaRest();
        Double expResult = null;
        Double result = instance.cotizarTbDivisa(idTasaCambio, valorCotizar);
        assertNotEquals(expResult, result);
        
    }

    
    
}
