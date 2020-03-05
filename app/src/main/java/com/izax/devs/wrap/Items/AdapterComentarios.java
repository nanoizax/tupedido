package com.izax.devs.wrap.Items;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.izax.devs.wrap.R;

import java.util.ArrayList;

public class AdapterComentarios extends BaseAdapter {

    protected Activity activity;
    //dentro del arraylist colocamos la clase datos
    protected ArrayList<DatosArticulos> items;

    public AdapterComentarios(Activity activity, ArrayList<DatosArticulos> items){
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_comentarios, null);
        }

        DatosArticulos datosArticulos = items.get(position);

        // llenamos las Etiquetas

        TextView comentario = v.findViewById(R.id.lbl_comentario);
        comentario.setText(datosArticulos.getTitulo());

        TextView fecha = v.findViewById(R.id.lbl_fecha);
        fecha.setText(datosArticulos.getImg());

        Animation animation = AnimationUtils.loadAnimation(activity, android.R.anim.slide_in_left);
        v.startAnimation(animation);
        return  v;
    }
}