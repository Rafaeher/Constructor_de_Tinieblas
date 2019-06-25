package com.constructor_de_tinieblas.integracion;

import android.content.Context;
import android.content.res.Resources;

import com.constructor_de_tinieblas.R;

import java.util.Random;

public enum Lector {
    
    INSTANCIA;
    
    Resources recursos;
    String[] nombresMasculinos;
    String[] nombresFemeninos;
    String[] conceptos;
    
    Lector() {
        recursos = null;
        nombresMasculinos = null;
        nombresFemeninos = null;
        conceptos = null;
    }
    
    /**
     * Actualiza los recursos a través del contexto
     *
     * @param contexto el contexto
     */
    public void darContexto(Context contexto) {
        recursos = contexto.getResources();
    }
    
    /**
     * Obtiene un nombre masculino aleatorio
     *
     * @param random generador de números aleatorios
     * @return nombre masculino aleatorio
     */
    public String nombreMasculinoAleatorio(Random random) {
        if (nombresMasculinos == null) {
            nombresMasculinos = recursos.getString(R.string.nombres_masculinos).split(" ");
        }
        
        return nombresMasculinos[random.nextInt(nombresMasculinos.length)];
    }
    
    /**
     * Obtiene un nombre femenino aleatorio
     *
     * @param random generador de números aleatorios
     * @return nombre femenino aleatorio
     */
    public String nombreFemeninoAleatorio(Random random) {
        if (nombresFemeninos == null) {
            nombresFemeninos = recursos.getString(R.string.nombres_femeninos).split(" ");
        }
        
        return nombresFemeninos[random.nextInt(nombresFemeninos.length)];
    }
    
    /**
     * Obtiene un concepto aleatorio
     *
     * @param random generador de números aleatorios
     * @return concepto aleatorio
     */
    public String conceptoAleatorio(Random random) {
        if (conceptos == null) {
            conceptos = recursos.getString(R.string.conceptos).split(" ");
        }
        
        return conceptos[random.nextInt(conceptos.length)];
    }
}
