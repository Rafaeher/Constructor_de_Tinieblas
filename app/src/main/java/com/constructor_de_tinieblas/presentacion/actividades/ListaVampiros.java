package com.constructor_de_tinieblas.presentacion.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.constructor_de_tinieblas.R;
import com.constructor_de_tinieblas.negocio.ficha.vampiro.Vampiro;
import com.constructor_de_tinieblas.negocio.gestor.GestorVampiros;
import com.constructor_de_tinieblas.presentacion.utils.AdaptadorFicha;

import java.util.List;

public class ListaVampiros extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("VistaListaVampiros", "se crea la vista");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_vampiros);
    
        ListView listView = findViewById(R.id.listaVampiros);
        String nombreBuscado = getIntent().getExtras().getString(String.valueOf(R.string.nombreVampiro));
        GestorVampiros.actualizarInstancia(this);
        GestorVampiros gestorVampiros = GestorVampiros.getInstancia();
        
        List<Vampiro> fichas = gestorVampiros.leerVampiros(nombreBuscado);
        
        if (fichas.isEmpty()) {
            Toast.makeText(this, "No hay ningún vampiro llamado " + nombreBuscado, Toast.LENGTH_LONG).show();
        }
        
        listView.setAdapter(new AdaptadorFicha<>(this, fichas));
        colocarItemClickListener(listView);
    }
    
    private void colocarItemClickListener(ListView listView) {
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.v("Click", "se ha hecho click en la lista de vampiros");
            Intent intent = new Intent(getApplicationContext(), VerVampiro.class);
            Bundle bundle = new Bundle();
            String id = ((TextView) view.findViewById(R.id.idFicha)).getText().toString().replaceFirst("ID ", "");
            bundle.putString(String.valueOf(R.string.idVampiro), id);
            Log.d("Ver", "vampiro de id " + id);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}
