package com.constructor_de_tinieblas.ficha.vampiro;

import java.util.Random;

/**
 * Enumerado de los distintos clanes de vampiros.
 */
public enum Clan
{
    ASSAMITA(Disciplina.CELERIDAD, Disciplina.EXTINCION, Disciplina.OFUSCACION),
    BRUJAH(Disciplina.CELERIDAD, Disciplina.POTENCIA, Disciplina.PRESENCIA),
    CAITIFF(Disciplina.aleatoria(), Disciplina
            .aleatoria(), Disciplina.aleatoria()),
    GANGREL(Disciplina.ANIMALISMO, Disciplina.FORTALEZA, Disciplina.PRESENCIA),
    GIOVANNI(Disciplina.DOMINACION, Disciplina.NECROMANCIA, Disciplina.POTENCIA),
    LASOMBRA(Disciplina.DOMINACION, Disciplina.OBTENEBRACION, Disciplina.POTENCIA),
    MALKAVIAN(Disciplina.AUSPEX, Disciplina.DEMENTACION, Disciplina.OFUSCACION),
    NOSFERATU(Disciplina.ANIMALISMO, Disciplina.OFUSCACION, Disciplina.POTENCIA),
    RAVNOS(Disciplina.ANIMALISMO, Disciplina.FORTALEZA, Disciplina.QUIMERISMO),
    SEGUIDORES_DE_SET(Disciplina.OFUSCACION, Disciplina.PRESENCIA, Disciplina.PRESENCIA),
    TOREADOR(Disciplina.AUSPEX, Disciplina.CELERIDAD, Disciplina.PRESENCIA),
    TREMERE(Disciplina.AUSPEX, Disciplina.DOMINACION, Disciplina.TAUMATURGIA),
    TZIMISCE(Disciplina.ANIMALISMO, Disciplina.AUSPEX, Disciplina.VICISITUD),
    VENTRUE(Disciplina.DOMINACION, Disciplina.FORTALEZA, Disciplina.PRESENCIA);

     private Disciplina disciplina1;
     private Disciplina disciplina2;
     private Disciplina disciplina3;

    /**
     * Constructora para los Clanes (no Caitiff).
     *
     * @param _disciplina1: una disciplina.
     * @param _disciplina2: una disciplina.
     * @param _disciplina3: una disciplina.
     */
     Clan(Disciplina _disciplina1, Disciplina _disciplina2, Disciplina _disciplina3)
     {
         disciplina1 = _disciplina1;
         disciplina2 = _disciplina2;
         disciplina3 = _disciplina3;
     }

    /**
     * Obtiene la primera disciplina
     *
     * @return disciplina1
     */
    public Disciplina getDisciplina1()
    {
        return disciplina1;
    }

    /**
     * Obtiene la segunda disciplina
     *
     * @return disciplina2
     */
    public Disciplina getDisciplina2()
    {
        return disciplina2;
    }

    /**
     * Obtiene la tercera disciplina
     *
     * @return disciplina3
     */
    public Disciplina getDisciplina3()
    {
        return disciplina3;
    }

    /**
     * Devuelve un Clan al azar.
     *
     * @return Clan aleatorizar.
     */
    public static Clan aleatorio()
    {
        Random random = new Random();
        Clan[] clanes = Clan.values();
        int eleccion = random.nextInt(clanes.length);

        return clanes[eleccion];
    }
}
