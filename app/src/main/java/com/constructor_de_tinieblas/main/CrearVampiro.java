package com.constructor_de_tinieblas.main;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.constructor_de_tinieblas.R;
import com.constructor_de_tinieblas.ficha.vampiro.Clan;
import com.constructor_de_tinieblas.ficha.vampiro.Vampiro;
import com.constructor_de_tinieblas.integracion.AdaptadorSQLite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CrearVampiro extends Activity {
    private Vampiro vampiro;
    private AdaptadorSQLite adaptador;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("VistaCrearVampiro", "se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_vampiro);
    
        adaptador = new AdaptadorSQLite(this);
        
        crearBotonAleatorio();
        crearBotonGuadar();
    }
    
    private void crearBotonGuadar() {
        Button guardar = findViewById(R.id.guardarVampiro);
    
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                adaptador.abrir();
                long id = adaptador.insertarVampiro(vampiro);
                EditText text = findViewById(R.id.ficha);
                
                vampiro = adaptador.leerVampiro(vampiro.getNombre());
                text.setText(vampiro.toString(), TextView.BufferType.NORMAL);
                
                adaptador.cerrar();
            }
        });
    }
    
    private void crearBotonAleatorio() {
        Button aleatorio = findViewById(R.id.crearVampiro);
    
        aleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = findViewById(R.id.ficha);
                
                vampiro = new Vampiro();
                vampiro.aleatorizar("-", 15);
                text.setText(vampiro.toString(), TextView.BufferType.NORMAL);
            }
        });
    }
}
