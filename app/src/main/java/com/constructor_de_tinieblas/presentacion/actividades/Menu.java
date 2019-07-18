package com.constructor_de_tinieblas.presentacion.actividades;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.constructor_de_tinieblas.R;

/**
 * Actividad que es el menú principal de la app
 */
public class Menu extends Activity {
    
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Menu", "Se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        crearBotonCrearVampiro();
        crearBotonBuscarVampiro();
        crearBotonAcercaDe();
        pedirPermisosUbicacion();
    }
    
    private void crearBotonAcercaDe() {
        Button acercade = findViewById(R.id.acercade);
        acercade.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), AcercaDe.class)));
    }
    
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void pedirPermisosUbicacion() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
        }
    }
    
    private void crearBotonCrearVampiro() {
        Button crear = findViewById(R.id.vistaCrearVampiro);
        crear.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), CrearVampiro.class)));
    }
    
    private void crearBotonBuscarVampiro() {
        Button buscar = findViewById(R.id.vistaBuscarVampiro);
        buscar.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), BuscarVampiro.class)));
    }
}
