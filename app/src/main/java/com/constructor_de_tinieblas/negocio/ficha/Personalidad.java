package com.constructor_de_tinieblas.negocio.ficha;

import java.util.Random;

/**
 * Enumerado de los disintos arquetipos de naturaleza y conducta.
 */
public enum Personalidad
{
    ANSIOSO_DE_EMOCIONES,
    ARQUITECTO,
    AUTOCRATA,
    BRAVUCON,
    BELLACO,
    CAMALEON,
    CAPITALISTA,
    CELEBRANTE,
    CIENTIFICO,
    COMPETIDOR,
    CONFABULADOR,
    CONFORMISTA,
    DEPRAVADO,
    DILETANTE,
    DIRECTOR,
    ENIGMA,
    FANATICO,
    GALLARDO,
    GURU,
    HEDONISTA,
    HOSCO,
    IDEALISTA,
    JUEZ,
    MASOQUISTA,
    MARTIR,
    MONSTRUO,
    NINNO,
    OJO_DE_LA_TORMENTA,
    PEDAGOGO,
    PENITENTE,
    PERFECCIONISTA,
    PROTECTOR,
    REBELDE,
    REPULSIVO,
    SADICO,
    SOCIOPATA,
    SOLDADO,
    SOLITARIO,
    SUPERVIVIENTE,
    TRADICIONALISTA,
    TRUHAN,
    VISIONARIO;

    /**
     * Devuelve una personalidad aleatoria.
     *
     * @return personalidad aleatoria.
     */
    public static Personalidad aleatoria()
    {
        Personalidad[] personalidades = Personalidad.values();
        Random random = new Random();

        return personalidades[random.nextInt(personalidades.length)];
    }
}
