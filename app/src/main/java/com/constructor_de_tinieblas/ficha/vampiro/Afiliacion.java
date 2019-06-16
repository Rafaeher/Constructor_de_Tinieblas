package com.constructor_de_tinieblas.ficha.vampiro;

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
    
    public String nombre() {
        switch(this) {
        
            case MOVIMIENTO_ANARQUISTA: return "Movimiento Anarquista";
            case CLAN_ASSAMITA: return "Clan Assamita";
            case CLAN_GIOVANNI: return "Clan Giovanni";
            case CLAN_SETITA: return "Clan Seguidores de Set";
            case CLAN_RAVNOS: return "Clan Ravnos";
            default: return this.toString().substring(0, 1) + this.toString().substring(1).toLowerCase();
        }
    }
}
