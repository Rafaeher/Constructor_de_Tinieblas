package com.constructor_de_tinieblas.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

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
    
        GestorVampiros.actualizarInstancia(this);
        GestorVampiros gestorVampiros = GestorVampiros.getInstancia();
        
        List<Vampiro> fichas = gestorVampiros.leerVampiros("PATATA");
        listView.setAdapter(new AdaptadorFicha<>(this, fichas));
    }
}
