package com.constructor_de_tinieblas.utils;

import android.os.Environment;
import android.util.Log;

import java.io.*;
import java.util.Random;

public class LectorEjemplos
{
    public static String getNombreMasculinoEsp()
    {
        return getNombre("nombresMasculinosEsp.txt");
    }

    public static String getNombreFemeninoEsp()
    {
        return getNombre("nombresFemeninosEsp.txt");
    }

    public static String getConceptos()
    {
        return getNombre("conceptos.txt");
    }

    private static String getNombre(String fichero) {
        FileReader fileReader = null;
        String nombre = null;
        Log.v("ObtenerNombre", "se va a buscar un nombre");
        Log.d("ObtenerNombre", "directorio actual >>> " + System.getProperty("user.dir"));
        try {
            
            Log.v("ObtenerNombre", "Se ha entrado en el bloque try");
            
            fileReader = new FileReader (new File(Environment.getExternalStorageDirectory(), fichero));
            
            Log.v("ObtenerNombre","se ha creado el FileReader");

            BufferedReader bufferedReader = new BufferedReader(fileReader);
    
            Log.v("ObtenerNombre","se ha creado el BufferedReader");
            
            int i = 0, n = new Random().nextInt(Integer.parseInt(bufferedReader.readLine()));
    
            Log.v("ObtenerNombre", "hay " + n + " nombres");
            
            while(i != n) {
                nombre = bufferedReader.readLine();
                i++;
            }
        } catch(Exception exception) {
            exception.printStackTrace();
            Log.wtf("ObtenerNombre", "Se ha intentado obtener un nombre y algo ha salido mal >>> " + exception.getMessage());
        } finally {
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }

        return nombre;
    }
}
