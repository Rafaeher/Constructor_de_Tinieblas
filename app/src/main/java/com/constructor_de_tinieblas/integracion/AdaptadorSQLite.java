package com.constructor_de_tinieblas.integracion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.JsonReader;
import android.util.Log;

import com.constructor_de_tinieblas.ficha.vampiro.Vampiro;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class AdaptadorSQLite{
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
    
    private final Context contexto;
    private SQLiteDatabase bdatos;
    private AuxiliarBD auxiliarBD;
    
    public AdaptadorSQLite(Context _contexto) {
        contexto = _contexto;
        auxiliarBD = new AuxiliarBD(contexto);
    }
    
    public AdaptadorSQLite abrir() throws SQLException {
        bdatos = auxiliarBD.getReadableDatabase();
        return this;
    }
    
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
        return bdatos.delete(NOMBRE_BD, VAMPIRO_ID + "=" + id, null) > 0;
    }
    
    public boolean eliminarTodosVampiros() {
        return bdatos.delete(TABLA_VAMPIRO, null, null) > 0;
    }
    
    public Vampiro leerVampiro(String nombre)  throws SQLException {
        
        Log.d(BDLOG, "Se va a leer el vampiro de nombre " + nombre);
        
        Cursor cursor = bdatos.query(true,
                                     TABLA_VAMPIRO,
                                     new String[] {VAMPIRO_ID, VAMPIRO_NOMBRE, VAMPIRO_FICHA},
                                     VAMPIRO_NOMBRE + "='" + nombre + "'",
                                     null, null, null, null, null);
        
        Log.v(BDLOG, "Se ha realizado la query");
        
        Vampiro vampiro = null;
        
        if(cursor.getCount() > 0) {
            Log.d(BDLOG, "Se ha encontrado el vampiro");
            
            cursor.moveToFirst();
            String nombreStr = cursor.getString(1), fichaStr = cursor.getString(2);
            
            vampiro = new Vampiro();
            JsonReader reader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(fichaStr.getBytes())));

            vampiro.leerJSON(reader);
            vampiro.setNombre(nombreStr);
            
            Log.v(BDLOG, "El vampiro de nombre " + nombre + " se ha leído con nombre " + nombreStr + " y "
                 + "JSON >>> " + System.getProperty("line.separator") + fichaStr);
        }
        
        cursor.close();
        
        Log.v(BDLOG, "Se ha cerrado el cursor");
        
        return vampiro;
    }
    
    private static class AuxiliarBD extends SQLiteOpenHelper {
    
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
