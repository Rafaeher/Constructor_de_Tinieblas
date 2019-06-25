package com.constructor_de_tinieblas.presentacion.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.constructor_de_tinieblas.R;
import com.constructor_de_tinieblas.negocio.ficha.Ficha;

import java.util.List;

public class AdaptadorFicha<Raza extends Ficha> extends BaseAdapter {
    
    protected Activity activity;
    protected List<Raza> fichas;
    
    /**
     * Constructora que guarda una lista de fichas de personaje de Mundo de Tinieblas
     *
     * @param _fichas la lista de fichas
     */
    public AdaptadorFicha(Activity _activity, List<Raza> _fichas) {
        activity = _activity;
        fichas = _fichas;
    }
    
    @Override
    public int getCount() {
        return fichas.size();
    }
    
    @Override
    public Raza getItem(int i) {
        return fichas.get(i);
    }
    
    @Override
    public long getItemId(int i) {
        return fichas.get(i).getId();
    }
    
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        
        View view = convertView;
        Ficha ficha = fichas.get(i);
        
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)  activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.ficha, null);
        }
    
        TextView nombre = view.findViewById(R.id.nombre), id = view.findViewById(R.id.idFicha);
        nombre.setText(ficha.getNombre());
        id.setText(Long.toString(ficha.getId()));
        
        return view;
    }
}
