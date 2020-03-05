package com.izax.devs.wrap.Items;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.izax.devs.wrap.R;

import java.util.ArrayList;

public class AdapterDatos extends BaseAdapter {

    protected Activity activity;
    //dentro del arraylist colocamos la clase datos
    protected ArrayList<Datos> items;

    public AdapterDatos(Activity activity, ArrayList<Datos> items){
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
            v = inf.inflate(R.layout.item_categoria, null);
        }

        Datos datos = items.get(position);

        // llenamos las Etiquetas
        TextView titulo = (TextView)v.findViewById(R.id.lbl_titulo);
        titulo.setText(datos.getTitulo());

        return  v;
    }
}