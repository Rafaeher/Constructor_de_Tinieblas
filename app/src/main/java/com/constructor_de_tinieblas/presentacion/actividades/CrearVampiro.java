package com.constructor_de_tinieblas.presentacion.actividades;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.constructor_de_tinieblas.R;
import com.constructor_de_tinieblas.negocio.ficha.vampiro.Vampiro;
import com.constructor_de_tinieblas.negocio.gestor.GestorVampiros;

public class CrearVampiro extends Activity {
    private TextView text;
    private Vampiro vampiro;
    private double longitud;
    private double latitud;
    
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("VistaCrearVampiro", "se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_vampiro);
        
        text = findViewById(R.id.ficha);
        
        if (vampiro != null) {
            text.setText(vampiro.toString(), TextView.BufferType.NORMAL);
            text.setMovementMethod(new ScrollingMovementMethod());
        }
        
        GestorVampiros.actualizarInstancia(this);
        crearBotonAleatorio();
        crearBotonGuadar();
    }
    
    @Override
    protected void onStart() {
        super.onStart();
    
        if (vampiro != null) {
            text.setText(vampiro.toString(), TextView.BufferType.NORMAL);
            text.setMovementMethod(new ScrollingMovementMethod());
        }
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
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void crearBotonAleatorio() {
        Button aleatorio = findViewById(R.id.crearVampiro);
    
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
    
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
        } else {
            Location myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
    
            longitud = myLocation.getLongitude();
            latitud = myLocation.getLatitude();
    
            Log.d("LocalizacionActual", "longitud >>> " + longitud + ", latitud >>> " + latitud);
    
    
            aleatorio.setOnClickListener(view -> {
                GestorVampiros gestor = GestorVampiros.getInstancia();
        
                vampiro = gestor.vampiroAleatorio("Crónica", latitud, longitud);
                text.setText(vampiro.toString(), TextView.BufferType.NORMAL);
                text.setMovementMethod(new ScrollingMovementMethod());
            });
        }

    }
}
