package com.constructor_de_tinieblas.negocio.ficha.vampiro;

public enum Afiliacion
{
    CAMARILLA,
    SABBAT,
    MOVIMIENTO_ANARQUISTA,
    INCONNOU,
    CLAN_GIOVANNI,
    CLAN_SETITA,
    CLAN_ASSAMITA,
    CLAN_RAVNOS,
    NINGUNA;
    
    /**
     * Obtiene el nombre correspondiente del enumerado
     *
     * @return nomrbe
     */
    public String nombre() {
        return this.toString().substring(0, 1) + this.toString().substring(1).toLowerCase().replace("_", " ");
    }
}
