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
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("PATATA", "se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_vampiro);
    
        Button aleatorio = findViewById(R.id.crearVampiro);
        
        aleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vampiro vampiro = new Vampiro();
                
                Log.v("PATATA", "se ha inicializado el vampiro");
                
                vampiro.aleatorizar("-", 0);
    
                EditText text = findViewById(R.id.ficha);
                text.setText(vampiro.toString(), TextView.BufferType.NORMAL);
            }
        });
    }
}
