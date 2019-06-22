package com.constructor_de_tinieblas.integracion.DAO;

import com.constructor_de_tinieblas.ficha.vampiro.Vampiro;

public interface DAOVampiro {
    
    /**
     * Inserta un vampiro en la base de datos SQLite
     *
     * @param vampiro el vampiro que se quiere guardar
     * @return el id del vampiro en la base de datos
     */
    int insertarVampiro(Vampiro vampiro);
    
    /**
     * Busca un vampiro en la base de datos por su nombre
     *
     * @param nombre el nombre del vampiro
     * @return el vampiro (o null si no existe)
     */
    Vampiro leerVampiroNombre(String nombre);
}
