/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.tbdivisa;

import com.prueba.modelo.TbDivisa;
import com.prueba.control.general.ControlDaoImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Clase para implementar las acciones de sql en la entidad TbDivisa
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
class TbDivisaFacadeDao extends ControlDaoImpl<TbDivisa> {

    /**
     * Constructor de la gestión de datos de la entidad TbDivisa Se inicializa
     * el constructor padre, pasandole la clase con la que se va a trabajar
     */
    public TbDivisaFacadeDao() {
        super(TbDivisa.class);
    }

    /**
     * Busca en la base de datos el registro TbDivisa que cumpla con el
     * parámetro de llave primaria.
     *
     * @param id parámetro llave primaria.
     * @return un null o una instancia de la clase TbDivisa
     */
    @Override
    public TbDivisa find(Object id) {
        TbDivisa aux = null;
        try {
            String str = "SELECT t FROM TbDivisa t "
                    + "WHERE t.idTbDivisa = :idTbDivisa";
            Query query = getEntityManager().createQuery(str);
            query.setParameter("idTbDivisa", id);
            query.setMaxResults(1);
            query.setFirstResult(0);
            aux = (TbDivisa) query.getSingleResult();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

}

/**
 * Clase para implementar la lógica de negocio con la entidad TbDivisa
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Stateless
public class ControlTbDivisaImpl
        extends TbDivisaFacadeDao
        implements ControlTbDivisa {

}
