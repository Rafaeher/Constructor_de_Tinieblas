package com.constructor_de_tinieblas.ficha.vampiro;

import java.util.Random;

public enum Disciplina
{
    ANIMALISMO,
    AUSPEX,
    CELERIDAD,
    DEMENTACION,
    DOMINACION,
    EXTINCION,
    FORTALEZA,
    NECROMANCIA, //TODO sendas necrománticas
    OBTENEBRACION,
    OFUSCACION,
    POTENCIA,
    PRESENCIA,
    PROTEAN,
    QUIMERISMO,
    SERPENTIS,
    TAUMATURGIA, //TODO sendas taumatúrgicas y rituales
    VICISITUD;

    /**
     * Elige una disciplina aleatoria y la devuelve.
     *
     * @return una disciplina aleatoria.
     */
    public static Disciplina aleatoria()
    {
        Disciplina[] disciplinas = Disciplina.values();
        int indice = new Random().nextInt(disciplinas.length);

        return disciplinas[indice];
    }
}
