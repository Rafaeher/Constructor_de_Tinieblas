package com.constructor_de_tinieblas.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    
        RecyclerView rv = findViewById(R.id.rvListaVampiros);
        rv.setHasFixedSize(true);
        
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    
        GestorVampiros.actualizarInstancia(this);
        GestorVampiros gestorVampiros = GestorVampiros.getInstancia();
        
        List<Vampiro> fichas = gestorVampiros.leerVampiros("PATATA");
        rv.setAdapter(new AdaptadorFicha<>(fichas));
    }
}
