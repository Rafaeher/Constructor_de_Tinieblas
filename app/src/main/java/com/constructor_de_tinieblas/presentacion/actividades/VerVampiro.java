package com.constructor_de_tinieblas.presentacion.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.constructor_de_tinieblas.R;
import com.constructor_de_tinieblas.negocio.ficha.vampiro.Vampiro;
import com.constructor_de_tinieblas.negocio.gestor.GestorVampiros;

public class VerVampiro extends Activity {

    Vampiro vampiro;
    
    @Override
    protected void onCreate(Bundle savedInstance) {
        Log.v("VistaVerVampiro", "se crea la vista");
        super.onCreate(savedInstance);
        setContentView(R.layout.ver_vampiro);
        Long id = Long.parseLong(getIntent().getExtras().getString(String.valueOf(R.string.idVampiro)));
    
        GestorVampiros.actualizarInstancia(this);
        GestorVampiros gestorVampiros = GestorVampiros.getInstancia();
        vampiro = gestorVampiros.leerVampiro(id);
        
        TextView ficha = findViewById(R.id.ficha);
        ficha.setText(vampiro.toString());
        ficha.setMovementMethod(new ScrollingMovementMethod());
        
        crearBotonUbicacion();
    }
    
    private void crearBotonUbicacion() {
        Button refugio = findViewById(R.id.refugio);
        
        refugio.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Mapa.class);
            Bundle bundle = new Bundle();
            bundle.putDouble(String.valueOf(R.string.latitud), vampiro.getLatitud());
            bundle.putDouble(String.valueOf(R.string.longitud), vampiro.getLongitud());
            bundle.putP
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}
