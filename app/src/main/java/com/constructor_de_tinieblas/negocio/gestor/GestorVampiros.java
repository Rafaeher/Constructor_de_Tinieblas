package com.constructor_de_tinieblas.negocio.gestor;

import android.content.Context;

import com.constructor_de_tinieblas.integracion.DAO.DAOVampiro;
import com.constructor_de_tinieblas.negocio.ficha.vampiro.Vampiro;

import java.util.List;

public class GestorVampiros {
    
    private static GestorVampiros instancia;
    
    /**
     * Constructora a partir de un contexto
     *
     * @param contexto contexto para actualizar el DAOVampiro
     */
    private GestorVampiros(Context contexto) {
        DAOVampiro.actualizaInstancia(contexto);
    }
    
    /**
     * Crea una nueva instancia del GestorVampiros a partir de un contexto
     *
     * @param contexto el contexto
     */
    public static void actualizarInstancia(Context contexto) {
        instancia = new GestorVampiros(contexto);
    }
    
    public static GestorVampiros getInstancia() {
        return instancia;
    }
    
    /**
     * Crea un nuevo vampiro generado aleatoriamente
     *
     * @return vampiro aleatorio
     */
    public Vampiro vampiroAleatorio(String cronica) {
        Vampiro vampiro = new Vampiro();
        vampiro.aleatorizar(cronica);
        return vampiro;
    }
    
    /**
     * Guarda un vampiro en la base de datos
     *
     * @param vampiro vampiro que se debe guardar
     * @return true si se ha guardado exitosamente, false en otro caso
     */
    public boolean guardarVampiro(Vampiro vampiro) {
    
        DAOVampiro dao = DAOVampiro.getInstancia();
        
        dao.abrir();
        long id = dao.insertarVampiro(vampiro);
        dao.cerrar();
        
        return id >= 0;
    }
    
    public List<Vampiro> leerVampiros(String nombre) {
        DAOVampiro dao = DAOVampiro.getInstancia();
        
        dao.abrir();
        List<Vampiro> vampiros = dao.leerVampiros(nombre);
        dao.cerrar();
        
        return vampiros;
    }
}