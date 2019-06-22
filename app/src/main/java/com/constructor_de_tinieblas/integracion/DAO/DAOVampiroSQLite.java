package com.constructor_de_tinieblas.integracion.DAO;

import com.constructor_de_tinieblas.ficha.vampiro.Vampiro;
import com.constructor_de_tinieblas.integracion.DAO.DAOVampiro;

public class DAOVampiroSQLite implements DAOVampiro {
    @Override
    public int insertarVampiro(Vampiro vampiro) {
        return 0;
    }
    
    @Override
    public Vampiro leerVampiroNombre(String nombre) {
        return null;
    }
}
