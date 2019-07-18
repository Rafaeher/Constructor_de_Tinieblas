package com.constructor_de_tinieblas.negocio.gestor;

import android.content.Context;

import com.constructor_de_tinieblas.integracion.DAO.DAOVampiro;
import com.constructor_de_tinieblas.integracion.Lector;
import com.constructor_de_tinieblas.negocio.ficha.vampiro.Vampiro;

import java.util.List;
import java.util.Random;

/**
 * Clase que se encarga de gestionar las peticiones de la vista acerca de las fichas de Vampiro
 */
public class GestorVampiros {
    
    private static GestorVampiros instancia;
    
    /**
     * Constructora a partir de un contexto
     *
     * @param _contexto contexto para actualizar el DAOVampiro y
     */
    private GestorVampiros(Context _contexto) {
        DAOVampiro.darContexto(_contexto);
        Lector.INSTANCIA.darContexto(_contexto);
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
     * @param cronica el nombre de la crónica
     * @param latitud latitud del centro del cuadrado en el que puede estar el hogar del vampiro
     * @param longitud longitud del centro del cuadrado en el que puede estar el hogar del vampiro
     *
     * @return vampiro aleatorio
     */
    public Vampiro vampiroAleatorio(String cronica, Double latitud, Double longitud) {
        Random random = new Random();
        String nombre = Lector.INSTANCIA.nombreMasculinoAleatorio(random);
        String concepto = Lector.INSTANCIA.conceptoAleatorio(random);
        String sire = Lector.INSTANCIA.nombreMasculinoAleatorio(random);
        
        // Esto hace que el vampiro
        Double  latitudRand = random.nextDouble() / 20, longitudRand = random.nextDouble() / 20,
                latitudVampiro = random.nextBoolean() ? latitud + latitudRand : latitud - latitudRand,
                longitudVampiro = random.nextBoolean() ? longitud + longitudRand : longitud - longitudRand;
        
        Vampiro vampiro = new Vampiro(nombre, cronica, concepto, sire, latitudVampiro, longitudVampiro);
        vampiro.aleatorizar(random);
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
    
    /**
     * Lee los vampiros guardados cuyo nombre coincida con uno dado
     *
     * @param nombre el nombre buscado
     * @return lista de vampiros
     */
    public List<Vampiro> leerVampiros(String nombre) {
        DAOVampiro dao = DAOVampiro.getInstancia();
        
        dao.abrir();
        List<Vampiro> vampiros = dao.leerVampiros(nombre);
        dao.cerrar();
        
        return vampiros;
    }
    
    /**
     * Lee un vampiro a través de su id único
     *
     * @param id el id del vampiro
     * @return vampiro o null si no existe
     */
    public Vampiro leerVampiro(Long id) {
        DAOVampiro dao = DAOVampiro.getInstancia();
        
        dao.abrir();
        Vampiro vampiro = dao.leerVampiro(id);
        dao.cerrar();
        
        return vampiro;
    }
}
