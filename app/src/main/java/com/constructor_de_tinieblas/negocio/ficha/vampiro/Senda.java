package com.constructor_de_tinieblas.negocio.ficha.vampiro;

import java.util.Random;

public enum Senda
{
    ACUERDO_HONORABLE("Senda del Acuerdo Honorable", Virtud.CONCIENCIA, Virtud.AUTOCONTROL, Porte.DEVOCION),
    ARMONIA("Senda de la Armonía", Virtud.CONCIENCIA, Virtud.INSTINTO, Porte.AMENAZA),
    CAIN("Senda de Caín", Virtud.CONVICCION, Virtud.INSTINTO, Porte.FE),
    CATAROS("Senda de los Cátaros", Virtud.CONVICCION, Virtud.INSTINTO, Porte.SEDUCCION),
    CORAZON_SALVAJE("Senda del Corazón Salvaje", Virtud.CONVICCION, Virtud.INSTINTO, Porte.AMENAZA),
    HUESOS("Senda de los Huesos", Virtud.CONVICCION, Virtud.AUTOCONTROL, Porte.SILENCIO),
    HUMANIDAD("Humanidad", Virtud.CONCIENCIA, Virtud.AUTOCONTROL, Porte.NORMALIDAD),
    LILITH("Senda de Lilith", Virtud.CONVICCION, Virtud.INSTINTO, Porte.TRIBULACION),
    METAMORFOSIS("Senda de la Metamorfosis", Virtud.CONVICCION, Virtud.INSTINTO, Porte.INHUMANIDAD),
    MUERTE_Y_ALMA("Senda de la Muerte y el Alma", Virtud.CONVICCION, Virtud.AUTOCONTROL, Porte.SILENCIO),
    NOCHE("Senda de la Noche", Virtud.CONVICCION, Virtud.INSTINTO, Porte.OSCURIDAD),
    PARADOJA("Senda de la Paradoja", Virtud.CONVICCION, Virtud.AUTOCONTROL, Porte.CONFIANZA),
    PODER_Y_VOZ_INTERIOR("Senda del Poder y la Voz Interior", Virtud.CONVICCION, Virtud.INSTINTO, Porte.MANDATO),
    SANGRE("Senda de la Sangre", Virtud.CONVICCION, Virtud.AUTOCONTROL, Porte.RESOLUCION),
    TIFON("Senda del Tifón", Virtud.CONVICCION, Virtud.AUTOCONTROL, Porte.DEVOCION)
    ;

    private String nombre; // El nombre de la Senda
    private Virtud
            virtudSuperior; // Representa si la Senda tiene como virtud conciencia o conviccion
    private Virtud
            virtudIntermedia; // Representa si la Senda tiene como virtud autocontrol o instinto
    private Porte porte; // El porte de la Senda

    /**
     * Constructora del enumerado a partir de su nombre, sus virtudes y su porte
     *
     * @param _nombre: el nombre
     * @param _virtudSuperior: la virtud superior
     * @param _virtudIntermedia: la virtud intermedia
     * @param _porte: el porte
     */
    Senda(String _nombre, Virtud _virtudSuperior, Virtud _virtudIntermedia, Porte _porte) {
        nombre = _nombre;
        virtudSuperior = _virtudSuperior;
        virtudIntermedia = _virtudIntermedia;
        porte = _porte;
    }

    /**
     * Devuelve una senda aleatoria.
     *
     * @return senda aleatoria.
     */
    public static Senda aleatoria() {
        Senda[] sendas = Senda.values();
        int indice = new Random().nextInt(sendas.length);

        return sendas[indice];
    }

    /**
     * Obtiene el nombre de la Senda.
     *
     * @return nombre.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Obtiene la virtud superior de la Senda (conciencia o convicción).
     *
     * @return virtudSuperior.
     */
    public Virtud getVirtudSuperior()
    {
        return virtudSuperior;
    }

    /**
     * Obtiene la virtud intermedia de la Senda (autocontrol o instinto).
     *
     * @return virtudIntermedia.
     */
    public Virtud getVirtudIntermedia()
    {
        return  virtudIntermedia;
    }

    /**
     * Obtiene el porte de la Senda.
     *
     * @return porte.
     */
    public Porte getPorte()
    {
        return porte;
    }
}
