package com.constructor_de_tinieblas.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.constructor_de_tinieblas.R;
import com.constructor_de_tinieblas.ficha.vampiro.Vampiro;

public class CrearVampiro extends Activity {
    private Vampiro vampiro;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("PATATA", "se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_vampiro);
    
        crearBotonAleatorio();
        crearBotonGuadar();
    }
    
    private void crearBotonGuadar() {
        Button guardar = findViewById(R.id.guardarVampiro);
    
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            
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
