package com.constructor_de_tinieblas.presentacion.actividades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.constructor_de_tinieblas.R;

public class Menu extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Menu", "Se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        crearBotonCrearVampiro();
        crearBotonBuscarVampiro();
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
