package com.constructor_de_tinieblas.negocio.ficha.vampiro;

import java.util.Random;

/**
 * Enumerado de los distintos clanes de vampiros.
 */
public enum Clan {
    ASSAMITA(Disciplina.CELERIDAD, Disciplina.EXTINCION, Disciplina.OFUSCACION,
             "Recibe un nivel de daño letal por cada punto de Vitae consumido"),
    BRUJAH(Disciplina.CELERIDAD, Disciplina.POTENCIA, Disciplina.PRESENCIA,
           "+2 a la dificultad de todas las tiradaspara resistir o controlar el Frenesí"),
    CAITIFF(Disciplina.aleatoria(), Disciplina.aleatoria(), Disciplina.aleatoria(),
            "No puede comprar Estatus. +2 a la dificultad para tiradas Sociales con no Caitiff si no está"
            + " asentado en la comunidad. No transmite rasgos de Clan a sus chiquillos"),
    GANGREL(Disciplina.ANIMALISMO, Disciplina.FORTALEZA, Disciplina.PRESENCIA,
            "Gana un rasgo animal temporal con cada Frenesí.Excepcionalmente, puede ser permanente"),
    GIOVANNI(Disciplina.DOMINACION, Disciplina.NECROMANCIA, Disciplina.POTENCIA,
             "Su Beso no es placentero para quien lo recibe y causa el doble de daño"),
    LASOMBRA(Disciplina.DOMINACION, Disciplina.OBTENEBRACION, Disciplina.POTENCIA, "Sin reflejo"),
    MALKAVIAN(Disciplina.AUSPEX, Disciplina.DEMENTACION, Disciplina.OFUSCACION,
              "Sufre, como mínimo, un Trastorno incurable"),
    NOSFERATU(Disciplina.ANIMALISMO, Disciplina.OFUSCACION, Disciplina.POTENCIA,
              "0 en Apariencia, no mejorable por ningún medio"),
    RAVNOS(Disciplina.ANIMALISMO, Disciplina.FORTALEZA, Disciplina.QUIMERISMO,
           "Posee un vicio y tira Autocontrol / Instinto (dificultad 6) para no caer en él"),
    SEGUIDORES_DE_SET(Disciplina.OFUSCACION, Disciplina.PRESENCIA, Disciplina.PRESENCIA,
                      "+2 al daño por luz solar. –1 dado en lareserva para acciones bajo luces brillantes"),
    TOREADOR(Disciplina.AUSPEX, Disciplina.CELERIDAD, Disciplina.PRESENCIA,
             "Cae en trance ante una gran belleza. Tira Autocontrol / Instinto (dificultad 6) para no caer"),
    TREMERE(Disciplina.AUSPEX, Disciplina.DOMINACION, Disciplina.TAUMATURGIA,
            "Solo necesita beber dos veces para estar Vinculado a nivel 3."),
    TZIMISCE(Disciplina.ANIMALISMO, Disciplina.AUSPEX, Disciplina.VICISITUD,
             "Solo obtiene reposo si descansa sobre al menos dos puñados de su tierra natal"),
    VENTRUE(Disciplina.DOMINACION, Disciplina.FORTALEZA, Disciplina.PRESENCIA,
            "Solo obtiene sustento de su tipo de presa predilecta");
    
    private Disciplina disciplina1;
    private Disciplina disciplina2;
    private Disciplina disciplina3;
    private String debilidad;
    
    /**
     * Constructora para los Clanes (no Caitiff).
     *
     * @param _disciplina1: una disciplina.
     * @param _disciplina2: una disciplina.
     * @param _disciplina3: una disciplina.
     */
    Clan(Disciplina _disciplina1, Disciplina _disciplina2, Disciplina _disciplina3, String _debilidad) {
        disciplina1 = _disciplina1;
        disciplina2 = _disciplina2;
        disciplina3 = _disciplina3;
        debilidad = _debilidad;
    }
    
    /**
     * Obtiene la primera disciplina
     *
     * @return disciplina1
     */
    public Disciplina getDisciplina1() {
        return disciplina1;
    }
    
    /**
     * Obtiene la segunda disciplina
     *
     * @return disciplina2
     */
    public Disciplina getDisciplina2() {
        return disciplina2;
    }
    
    /**
     * Obtiene la tercera disciplina
     *
     * @return disciplina3
     */
    public Disciplina getDisciplina3() {
        return disciplina3;
    }
    
    public String getDebilidad() {
        return debilidad;
    }
    
    /**
     * Devuelve un Clan al azar.
     *
     * @return Clan aleatorizar.
     */
    public static Clan aleatorio() {
        Random random = new Random();
        Clan[] clanes = Clan.values();
        int eleccion = random.nextInt(clanes.length);
        
        return clanes[eleccion];
    }
    
    protected String nombre() {
        return this.toString().substring(0, 1) + this.toString().substring(1).toLowerCase().replace("_", " ");
    }}
