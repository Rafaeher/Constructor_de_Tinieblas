package com.constructor_de_tinieblas.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.constructor_de_tinieblas.R;
import com.constructor_de_tinieblas.negocio.ficha.vampiro.Vampiro;
import com.constructor_de_tinieblas.negocio.gestor.GestorVampiros;

public class CrearVampiro extends Activity {
    private Vampiro vampiro;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("VistaCrearVampiro", "se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_vampiro);
        
        GestorVampiros.actualizarInstancia(this);
        crearBotonAleatorio();
        crearBotonGuadar();
    }
    
    /**
     * Implementa la funcionalidad del botón para guardar un vampiro creado aleatoriamente
     */
    private void crearBotonGuadar() {
        Button guardar = findViewById(R.id.guardarVampiro);
    
        guardar.setOnClickListener(view -> {
            GestorVampiros gestor = GestorVampiros.getInstancia();
            if (vampiro != null) {
                if (gestor.guardarVampiro(vampiro)) {
                    Toast.makeText(this, "El vampiro se ha guardado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Algo ha salido mal y no se ha podido guardar el vampiro", Toast.LENGTH_LONG).show();
                }
                
                ((TextView) findViewById(R.id.ficha)).setText("", TextView.BufferType.NORMAL);
                vampiro = null;
            } else {
                Toast.makeText(this, "¡Primero tienes que crear un vampiro!", Toast.LENGTH_LONG).show();
            }
        });
    }
    
    /**
     * Implementa la funcionalidad del botón que crea un nuevo vampiro aleatorio
     */
    private void crearBotonAleatorio() {
        Button aleatorio = findViewById(R.id.crearVampiro);
    
        aleatorio.setOnClickListener(view -> {
            TextView text = findViewById(R.id.ficha);
            GestorVampiros gestor = GestorVampiros.getInstancia();
            
            vampiro = gestor.vampiroAleatorio("Crónica Patata");
            text.setText(vampiro.toString(), TextView.BufferType.NORMAL);
            text.setMovementMethod(new ScrollingMovementMethod());
        });
    }
}
