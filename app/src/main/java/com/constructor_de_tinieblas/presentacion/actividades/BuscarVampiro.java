package com.constructor_de_tinieblas.presentacion.actividades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.constructor_de_tinieblas.R;

public class BuscarVampiro extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("VistaBuscarVampiro", "se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_vampiro);
        
        crearBotonBuscar();
    }
    
    /**
     * Crear botón para buscar un vampiro por su nombre
     */
    private void crearBotonBuscar() {
        Button buscar = findViewById(R.id.buscar);
        final String nombreVampiro = String.valueOf(R.string.nombreVampiro);
        final Context appContext = getApplicationContext();
        
        buscar.setOnClickListener(view -> {
            Log.v("Buscar", "vampiro");
            Intent intent = new Intent(getApplicationContext(), ListaVampiros.class);
            Bundle bundle = new Bundle();
            String nombreBuscado = ((TextView) findViewById(R.id.descripcion)).getText().toString();
            bundle.putString(nombreVampiro,  nombreBuscado);
            Log.d("Buscar", "vampiro de nombre " + nombreBuscado);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
    
}
