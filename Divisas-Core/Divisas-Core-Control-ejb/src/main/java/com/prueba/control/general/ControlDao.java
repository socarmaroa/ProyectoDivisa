/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.general;

import java.util.List;

/**
 * Clase para exponer todos los metodos generales persistentes.
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 * @param <T> entidad que representa la tabla de la base de datos.
 */
public interface ControlDao<T> {

    /**
     * Crea un registro de la tabla T en la base de datos
     *
     * @param entity entidad(registro) a registrar en la base de datos
     */
    public void create(T entity);

    /**
     * Actualiza un registro de la tabla T en la base de datos
     *
     * @param entity entidad(registro) a actualzar en la base de datos
     */
    public void edit(T entity);

    /**
     * Elimina un registro de la base de datos
     *
     * @param entity registro a eliminar de la base de datos
     */
    public void remove(T entity);

    /**
     * Busca un registro en la base de datos por su llave primaria
     *
     * @param id representación de la llave primaria
     * @return el registro encontrado.
     */
    public T find(Object id);

    /**
     * Busca todos los elementos de la base de datos de una tabla en particular
     *
     * @return un listado de registros
     */
    public List<T> findAll();

    /**
     * Busca elementos de la base de datos de una tabla en particular teniendo
     * en cuenta el rango de busqueda
     *
     * @param range rango de busqueda
     * @return un listado de registros
     */
    public List<T> findRange(int[] range);

    /**
     * Cuenta la cantidad de registros de una tabla de la base de datos
     *
     * @return un total.
     */
    public int count();

}
