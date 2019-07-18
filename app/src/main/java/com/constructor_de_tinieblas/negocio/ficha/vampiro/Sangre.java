package com.constructor_de_tinieblas.negocio.ficha.vampiro;

import java.util.Random;

/**
 * Representa la Sangre del personaje
 */
public class Sangre {
    private int maximaReserva; // El máximo número de puntos de Sangre que puede haber en la reserva
    private int maximoGasto; // El máximo de puntos de Sangre que pueden gastarse por turno
    private int reserva; // La reserva actual de Sangre del personaje
    
    /**
     * Constructora por defecto
     */
    public Sangre() {
    
    }
    
    /**
     * Constructora a partir de la generación de un Vampiro.
     *
     * @param generacion: la generación del Vampiro
     */
    public Sangre(int generacion) {
        switch (generacion) {
            case 1:
                maximaReserva = 200;
                break;
            case 2:
                maximaReserva = 125;
                break;
            case 3:
                maximaReserva = 75;
                break;
            case 4:
                maximaReserva = 50;
                break;
            case 5:
                maximaReserva = 40;
                break;
            case 6:
                maximaReserva = 30;
                break;
            case 7:
                maximaReserva = 20;
                break;
            case 8:
                maximaReserva = 15;
                break;
            case 9:
                maximaReserva = 14;
                break;
            case 10:
                maximaReserva = 13;
                break;
            case 11:
                maximaReserva = 12;
                break;
            case 12:
                maximaReserva = 11;
                break;
            
            default:
                maximaReserva = 10;
                break;
            
        }
        
        switch (generacion) {
            case 1:
                maximoGasto = 30;
                break;
            case 2:
                maximoGasto = 20;
                break;
            case 3:
                maximoGasto = 15;
                break;
            case 4:
                maximoGasto = 10;
                break;
            case 5:
                maximoGasto = 8;
                break;
            case 6:
                maximoGasto = 6;
                break;
            case 7:
                maximoGasto = 4;
                break;
            case 8:
                maximoGasto = 3;
                break;
            case 9:
                maximoGasto = 2;
                break;
            
            default:
                maximoGasto = 1;
                break;
        }
        
        reserva = new Random().nextInt(maximaReserva) + 1;
    }
    
    /**
     * Constructora a partir de la reserva máxima y el máximo gasto por turno.
     *
     * @param _maximaReserva: máxima reserva de entrada.
     * @param _maximoGasto:   máximo de puntos de Sangre por turno de entrada.
     */
    public Sangre(int _maximaReserva, int _maximoGasto) {
        maximaReserva = _maximaReserva;
        maximoGasto = _maximoGasto;
        reserva = new Random().nextInt(maximaReserva) + 1;
    }
    
    /**
     * Aumenta la reserva en el número de aumentos indicado.
     *
     * @param aumentos: el número en el que debe aumentar la reserva.
     *
     * @return desbordamiento: booleano que indica si se ha excedido el máximo de la reserva (true) o no (false).
     */
    public boolean aumentarReserva(int aumentos) {
        boolean desbordamiento;
        
        if (reserva + aumentos > maximaReserva) {
            reserva = maximaReserva;
            desbordamiento = true;
        } else {
            reserva += aumentos;
            desbordamiento = false;
        }
        
        return desbordamiento;
    }
    
    /**
     * Asigna una nueva reserva. Este método está pensado para instancias de Sangre previamente construidas
     *
     * @param _reserva la nueva reserva
     */
    void setReserva(int _reserva) {
        reserva = _reserva;
    }
    
    /**
     * Obtiene la máxima reserva de Sangre
     *
     * @return maximaReserva
     */
    public int getMaximaReserva() {
        return maximaReserva;
    }
    
    /**
     * Obtiene la reserva de Sangre actual
     *
     * @return reserva
     */
    public int getReserva() {
        return reserva;
    }
    
    /**
     * Obtiene el máximo de puntos de sangre que pueden gastarse
     *
     * @return maximoGasto
     */
    public int getMaximoGasto() {
        return maximoGasto;
    }
}
