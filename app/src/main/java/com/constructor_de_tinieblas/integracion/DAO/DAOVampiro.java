package com.constructor_de_tinieblas.integracion.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.JsonReader;
import android.util.Log;

import com.constructor_de_tinieblas.negocio.ficha.vampiro.Vampiro;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DAOVampiro {
    private static final String NOMBRE_BD = "tinieblas";
    private static final int VERSION_BD = 2;
    
    
    // TABLA Vampiro
    private static final String TABLA_VAMPIRO = "vampiro";
    
    private static final String VAMPIRO_ID = "id";
    private static final String VAMPIRO_NOMBRE = "nombre";
    private static final String VAMPIRO_FICHA = "ficha";
    
    
    private static final String BDLOG = "GestorBD";
    private static final String CREAR_BD =
            "CREATE TABLE IF NOT EXISTS " + TABLA_VAMPIRO + " ("
            + VAMPIRO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + VAMPIRO_NOMBRE + " TEXT NOT NULL, "
            + VAMPIRO_FICHA + " TEXT NOT NULL);";
    
    private SQLiteDatabase bdatos;
    private AuxiliarBD auxiliarBD;
    private static DAOVampiro instancia;
    
    /**
     * Constructora a través de un contexto
     * @param contexto el contexto
     */
    private DAOVampiro(Context contexto) {
        Log.v(BDLOG, "Se va a crear la AuxiliarBD");
        auxiliarBD = new AuxiliarBD(contexto);
        Log.v(BDLOG, "AuxiliarBD creada");
    }
    
    /**
     * Crea una nueva instancia del DAOVampiro a partir de un contexto
     *
     * @param contexto el contexto del que se debe crear el nuevo DAO
     */
    public static void actualizaInstancia(Context contexto) {
        instancia = new DAOVampiro(contexto);
    }
    
    public static DAOVampiro getInstancia() {
        return instancia;
    }
    
    /**
     * Abre la base de datos SQLite
     */
    public void abrir() {
        Log.v(BDLOG, "Se va a abrir la base de datos");
        bdatos = auxiliarBD.getReadableDatabase();
        Log.v(BDLOG, "Base de datos abierta");
    }
    
    /**
     * Cierra la base de datos SQLite
     */
    public void cerrar() {
        auxiliarBD.close();
    }
    
    public long insertarVampiro(Vampiro vampiro) {
        ContentValues valores = new ContentValues();
        String jsonFicha = vampiro.obtenerJSON();
        
        valores.put(VAMPIRO_NOMBRE, vampiro.getNombre());
        valores.put(VAMPIRO_FICHA, jsonFicha);
    
        Log.d(BDLOG, "Insertar vampiro de nombre " + vampiro.getNombre());
        Log.v(BDLOG,"JSON del vampiro >>> " + System.getProperty("line.separator") + jsonFicha);
        
        long id = bdatos.insert(TABLA_VAMPIRO, null, valores);
        
        if(id >= 0) {
            Log.d(BDLOG, "Se ha insertado correctamente con id " + id);
        } else {
            Log.d(BDLOG, "No se ha insertado correctamente");
        }
        
        return id;
    }
    
    public boolean eliminarVampiro(Integer id) {
        return bdatos.delete(TABLA_VAMPIRO, VAMPIRO_ID + "=" + id, null) > 0;
    }
    
    public boolean eliminarTodosVampiros() {
        return bdatos.delete(TABLA_VAMPIRO, null, null) > 0;
    }
    
    public List<Vampiro> leerVampiros(String nombre) {
        
        Log.d(BDLOG, "Se van a buscar vampiros de nombre " + nombre);
        
        Cursor cursor = bdatos.query(true,
                                     TABLA_VAMPIRO,
                                     new String[] {VAMPIRO_ID, VAMPIRO_NOMBRE, VAMPIRO_FICHA},
                                     VAMPIRO_NOMBRE + "='" + nombre + "'",
                                     null, null, null, null, null);
        
        Log.v(BDLOG, "Se ha realizado la query");
        
        List<Vampiro> vampiros = new ArrayList<>();
        
        if(cursor.getCount() > 0) {
            Log.v(BDLOG, "Se ha encontrado al menos un vampiro con ese nombre");
            
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                String idStr = cursor.getString(0), nombreStr = cursor.getString(1), fichaStr = cursor.getString(2);
                Vampiro vampiro = new Vampiro();
                JsonReader reader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(fichaStr.getBytes())));
    
                Log.v(BDLOG, "Leído vampiro con id "
                             + cursor.getString(0)
                             + " y JSON >>> "
                             + System.getProperty("line.separator")
                             + fichaStr);
                
                vampiro.leerJSON(reader);
                vampiro.setNombre(nombreStr);
                vampiro.setId(Long.parseLong(idStr));
                vampiros.add(vampiro);
                cursor.moveToNext();
            }
        } else {
            Log.v(BDLOG, "No se ha encontrado ningún vampiro con ese nombre");
        }
        
        cursor.close();
        
        return vampiros;
    }
    
    /**
     * Clase para crear la base de datos SQLite
     */
    private static class AuxiliarBD extends SQLiteOpenHelper {
    
        /**
         * Constructora a partir de un contexto
         *
         * @param contexto el contexto
         */
        AuxiliarBD(Context contexto) {
            super(contexto, NOMBRE_BD, null, VERSION_BD);
        }
        
        @Override
        public void onCreate(SQLiteDatabase bdSQLite) {
            try{
                bdSQLite.execSQL(CREAR_BD);
            } catch (SQLException e) {
                e.printStackTrace();
                Log.wtf(BDLOG, e.getMessage());
            }
        }
    
        @Override
        public void onUpgrade(SQLiteDatabase bdSQLite, int versionAntigua, int versionNueva) {
            Log.w(BDLOG, "Actualiza la versión " + versionAntigua + " de la BD con la versión " + versionNueva);
            bdSQLite.execSQL("DROP TABLE IF EXISTS " + TABLA_VAMPIRO);
            onCreate(bdSQLite);
        }
    }
}
