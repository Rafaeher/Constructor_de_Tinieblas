package com.constructor_de_tinieblas.presentacion.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.constructor_de_tinieblas.R;
import com.constructor_de_tinieblas.negocio.ficha.Ficha;

import java.util.List;

public class AdaptadorFicha<Raza extends Ficha> extends Adapter<AdaptadorFicha.ViewHolder> {
    
    private List<Raza> fichas;
    
    /**
     * Constructora que guarda una lista de fichas de personaje de Mundo de Tinieblas
     *
     * @param _fichas la lista de fichas
     */
    public AdaptadorFicha(List<Raza> _fichas) {
        fichas = _fichas;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView
                view =
                (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha, parent, false);
        
        // Aquí se podrían definir tamaños, márgenes, etc...
        
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(Long.toString(fichas.get(position).getId()));
    }
    
    @Override
    public int getItemCount() {
        return fichas.size();
    }
    
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        
        private TextView textView;
        
        protected ViewHolder(@NonNull TextView _textView) {
            super(_textView);
            textView = _textView;
        }
        
        protected TextView getTextView() {
            return textView;
        }
    }
}
