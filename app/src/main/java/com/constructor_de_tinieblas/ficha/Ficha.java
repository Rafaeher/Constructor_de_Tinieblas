package com.constructor_de_tinieblas.ficha;


import java.util.*;

/**
 * La clase para representar una ficha de personaje.
 */
public class Ficha
{
    protected String nombre; // El nombre del personaje
    protected String jugador; // El nombre del jugador
    protected String cronica; // El nombre de la crónica
    protected String concepto; // El concepto del personaje
    protected Sexo sexo; // El sexo del personaje

    protected Personalidad naturaleza; // La naturaleza del personaje
    protected Personalidad conducta; // La conducta del personaje

    protected int fuerzaVoluntad; // Los círculos en fuerza de voluntad

    // ATRIBUTOS
    protected TreeMap<Atributo, Integer> fisicos; // Atributo físicos del personaje (<nombre, puntuación>)
    protected TreeMap<Atributo, Integer> sociales; // Atributo sociales del personaje (<nombre, puntuación>)
    protected TreeMap<Atributo, Integer> mentales; // Atributo mentales del personaje (<nombre, puntuación>)

    // HABILIDADES
    protected TreeMap<String, Integer> talentos; // Los talentos del personaje (<nombre, puntuación>)
    protected TreeMap<String, Integer> tecnicas; // Las técnicas del personaje (<nombre, puntuación>)
    protected TreeMap<String, Integer> conocimientos; // Los conocimientos del Vampiro (<nombre, puntuación>)

    public static final int MAX_ATB = 5; // El máximo de círculos que puede tener un atributo
    public static final int MAX_HAB_INI = 3;
    // El máximo de círculos que puede tener una habilidad antes de repartir los puntos gratuitos

    public static final int MAX_HAB_FIN = 5;
    // El máximo de círculos que puede tener una habilidad al repartir los puntos gratuitos y en adelante



    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getJugador()
    {
        return jugador;
    }

    public void setJugador(String jugador)
    {
        this.jugador = jugador;
    }

    public String getCronica()
    {
        return cronica;
    }

    public void setCronica(String cronica)
    {
        this.cronica = cronica;
    }

    public String getConcepto()
    {
        return concepto;
    }

    public void setConcepto(String concepto)
    {
        this.concepto = concepto;
    }

    public Sexo getSexo()
    {
        return sexo;
    }

    public void setSexo(Sexo sexo)
    {
        this.sexo = sexo;
    }

    public Personalidad getNaturaleza()
    {
        return naturaleza;
    }

    public void setNaturaleza(Personalidad naturaleza)
    {
        this.naturaleza = naturaleza;
    }

    public Personalidad getConducta()
    {
        return conducta;
    }

    public void setConducta(Personalidad conducta)
    {
        this.conducta = conducta;
    }

    public int getFuerzaVoluntad()
    {
        return fuerzaVoluntad;
    }

    public void setFuerzaVoluntad(int fuerzaVoluntad)
    {
        this.fuerzaVoluntad = fuerzaVoluntad;
    }

    public TreeMap<Atributo, Integer> getFisicos()
    {
        return fisicos;
    }

    public void setFisicos(TreeMap<Atributo, Integer> fisicos)
    {
        this.fisicos = fisicos;
    }

    public TreeMap<Atributo, Integer> getSociales()
    {
        return sociales;
    }

    public void setSociales(TreeMap<Atributo, Integer> sociales)
    {
        this.sociales = sociales;
    }

    public TreeMap<Atributo, Integer> getMentales()
    {
        return mentales;
    }

    public void setMentales(TreeMap<Atributo, Integer> mentales)
    {
        this.mentales = mentales;
    }

    public TreeMap<String, Integer> getTalentos()
    {
        return talentos;
    }

    public void setTalentos(TreeMap<String, Integer> talentos)
    {
        this.talentos = talentos;
    }

    public TreeMap<String, Integer> getTecnicas()
    {
        return tecnicas;
    }

    public void setTecnicas(TreeMap<String, Integer> tecnicas)
    {
        this.tecnicas = tecnicas;
    }

    public TreeMap<String, Integer> getConocimientos()
    {
        return conocimientos;
    }

    public void setConocimientos(TreeMap<String, Integer> conocimientos)
    {
        this.conocimientos = conocimientos;
    }

    /**
     * Constructora por defecto
     */
    public Ficha()
    {
        nombre = "";
        jugador = "";
        cronica = "";
        concepto = "";

        fuerzaVoluntad = 0;

        fisicos = new TreeMap<>();
        sociales = new TreeMap<>();
        mentales = new TreeMap<>();

        talentos = new TreeMap<>();
        tecnicas = new TreeMap<>();
        conocimientos = new TreeMap<>();

        fisicos.put(Atributo.FUERZA, 1);
        fisicos.put(Atributo.DESTREZA, 1);
        fisicos.put(Atributo.RESISTENCIA, 1);

        sociales.put(Atributo.CARISMA, 1);
        sociales.put(Atributo.MANIPULACION, 1);
        sociales.put(Atributo.APARIENCIA, 1);

        mentales.put(Atributo.INTELIGENCIA, 1);
        mentales.put(Atributo.ASTUCIA, 1);
        mentales.put(Atributo.PERCEPCION, 1);
    }

    /**
     * Distribuye aleatoriamente los atributos según las normas de creación de un personaje de Mundo de Tinieblas.
     *
     * @param random: el generador de números aleatorios.
     */
    protected void distribuirCirculosAtributos(Random random)
    {
        ArrayList<Integer> circulos = new ArrayList<>();
        circulos.add(7);
        circulos.add(5);
        circulos.add(3);

        int circulosFisicos = circulos.remove(random.nextInt(3));
        int circulosSociales = circulos.remove(random.nextInt(2));
        int circulosMentales = circulos.remove(0);

        distribuirCirculos(fisicos, circulosFisicos, MAX_ATB, random);
        distribuirCirculos(sociales, circulosSociales, MAX_ATB, random);
        distribuirCirculos(mentales, circulosMentales, MAX_ATB, random);
    }

    /**
     * Distribuye aleatoriamente círculos entre las distintas habilidades. Se supone que se han introducido las
     * habilidades previamente.
     *
     * @param random: el generador de números aleatorios.
     */
    protected void distribuirCirculosHabilidades(Random random)
    {
        ArrayList<Integer> circulos = new ArrayList<>();
        circulos.add(13);
        circulos.add(9);
        circulos.add(5);

        int circulosTalentos = circulos.remove(random.nextInt(3));
        int circulosTecnicas = circulos.remove(random.nextInt(2));
        int circulosConocimientos = circulos.remove(0);

        distribuirCirculos(talentos, circulosTalentos, MAX_HAB_INI, random);
        distribuirCirculos(tecnicas, circulosTecnicas, MAX_HAB_INI,random);
        distribuirCirculos(conocimientos, circulosConocimientos, MAX_HAB_INI, random);
    }


    /**
     * Distribuye aleatoriamente los círculos dados, teniendo en cuenta el máximo que pueden alcanzar los rasgos y la
     * puntuación inicial de los mismos. Presupone que es posible asignar los círculos sin excederse.
     *
     * Este método tiene coste en tiempo O(4 * n), con n el tamaño del hashmap rasgos.
     *
     * @param rasgos: el conjunto de rasgos del personaje con sus respectivas puntuaciones.
     * @param circulos: el número de círculos a distribuir.
     * @param maximo: el máximo que pueden alcanzar los círculos de los rasgos.
     * @param random: el generador de números aleatorios.
     * @param <Rasgo>: el tipo de los rasgos.
     */
    protected<Rasgo> void distribuirCirculos(Map<Rasgo, Integer> rasgos, int circulos, int maximo, Random random)
    {
        int[] distribucion = obtenerDistribucionInicial(rasgos);

        // Para cada posición, el máximo número de círculos que se pueden asignar a los rasgos siguientes
        int[] maximosRestantes = calcularMaximosCirculosRestantes(distribucion, maximo);

        distribuirCirculos(distribucion, maximosRestantes, circulos, maximo, random);

        int i = 0;
        for(Rasgo rasgo : rasgos.keySet())
        {
            rasgos.replace(rasgo, distribucion[i]);
            i++;
        }

    }

    /**
     * Distribuye aleatoriamente los círculos dados, teniendo en cuenta el máximo que pueden alcanzar los rasgos y la
     * puntuación inicial de los mismos. Presupone que es posible asignar los círculos sin excederse.
     *
     * @param distribucion: la distribución de círculos de los rasgos.
     * @param maximosRestantes: array con los máximos círculos que se pueden distribuir tras cada componente.
     * @param circulos: la cantidad de círculos a distribuir.
     * @param maximo: el máximo de círculos que se puede asignar a un rasgo concreto.
     * @param random: el generador de números aleatorios.
     */
    private void distribuirCirculos(int[] distribucion, int[] maximosRestantes, int circulos, int maximo, Random random)
    {
        for(int i = 0; i < distribucion.length; i++)
        {
            if (circulos > maximosRestantes[i])
            {
                distribucion[i] += circulos - maximosRestantes[i];
                circulos -= circulos - maximosRestantes[i];
            }
            else
            {
                int asignacion = random.nextInt(Integer.min(circulos + 1, maximo + 1 - distribucion[i]));
                distribucion[i] += asignacion;
                circulos -= asignacion;
            }
        }
    }

    /**
     * Para cada componente, calcula cuántos círculos pueden distribuirse como máximo a todas las componentes tras ella.
     *
     * @param distribucion: la distribución de círculos de un conjunto de rasgos de un personaje.
     * @param maximo: el máximo que pueden alcanzar el conjunto de rasgos.
     * @return array con los máximos círculos que se pueden distribuir tras cada componente.
     */
    private int[] calcularMaximosCirculosRestantes(int[] distribucion, int maximo)
    {
        int[] maximosRestantes = new int[distribucion.length];

        maximosRestantes[distribucion.length - 1] = 0;

        for(int i = distribucion.length - 2; i >= 0; i--)
        {
            maximosRestantes[i] = maximosRestantes[i + 1] + (maximo - distribucion[i + 1]);
        }

        return maximosRestantes;
    }

    /**
     * Obtiene un array en el que se encuentran los círculos de partida asignados a cada rasgo del hashmap.
     *
     * @param rasgos: grupo de rasgos del personaje con su correspondiente puntuación.
     * @param <Rasgo>: el tipo de los rasgos.
     * @return array con los círculos iniciales de cada rasgo.
     */
    private <Rasgo> int[] obtenerDistribucionInicial(final Map<Rasgo,Integer> rasgos)
    {
        int[] distribucionInicial = new int[rasgos.keySet().size()];

        int i = 0;
        for(Rasgo rasgo : rasgos.keySet())
        {
                distribucionInicial[i] = rasgos.get(rasgo);
                i++;
        }

        return distribucionInicial;
    }


    /**
     * Elige el sexo del Vampiro al azar.
     *
     * @param random: el generador de números aleatorios.
     */
    protected void elegirSexo(Random random)
    {
        sexo = random.nextBoolean() ? Sexo.HOMBRE : Sexo.MUJER;
    }

    /**
     * Obtiene un string que representa un conjunto de rasgos con sus respectivas puntuaciones, separados por saltos de
     * línea.
     *
     * @param rasgos: el conjunto de rasgos.
     * @param <Rasgo>: el tipo de los rasgos.
     * @return un string que representa el conjunto de rasgos con sus respectivas puntuaciones.
     */
    protected <Rasgo> String getlistaRasgos(final Map<Rasgo, Integer> rasgos)
    {
        final String ls = System.getProperty("line.separator");
        StringBuilder strBuilder = new StringBuilder();

        for(Rasgo rasgo : rasgos.keySet())
        {
            strBuilder.append(rasgo.toString().toUpperCase(), 0, 1)
                    .append(rasgo.toString().toLowerCase().replaceAll("_", " ").substring(1))
                    .append(": ").append(getCirculos(rasgos.get(rasgo))).append(ls);
        }

        return strBuilder.toString();
    }

    /**
     * Dado un número de círculos, devuelve un string que los representa.
     *
     * @param n: el número de círculos.
     * @return string que representa n círculos.
     */
    protected String getCirculos(int n)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++)
        {
            if (i % 5 == 0)
            {
                stringBuilder.append("O ");
            }
            else
            {
                stringBuilder.append("O");
            }
        }

        return stringBuilder.toString();
    }
}
