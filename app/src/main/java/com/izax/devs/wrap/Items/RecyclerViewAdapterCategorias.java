package com.izax.devs.wrap.Items;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.izax.devs.wrap.Categorias;
import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Link;
import com.izax.devs.wrap.Estructura.Objetos;
import com.izax.devs.wrap.Estructura.Variables;
import com.izax.devs.wrap.Home;
import com.izax.devs.wrap.R;

import java.util.ArrayList;

/**
 * Created by Aws on 28/01/2018.
 */

public class RecyclerViewAdapterCategorias extends RecyclerView.Adapter<RecyclerViewAdapterCategorias.MyViewHolder> {

    Variables variables = new Variables();

    Objetos objetos = new Objetos();

    Link link = new Link();


    Funciones funciones = new Funciones();

    private Context mContext ;
    ArrayList<String> images = new ArrayList<String>();
    ArrayList<String> titulo = new ArrayList<String>();
    ArrayList<String> id = new ArrayList<String>();

    public RecyclerViewAdapterCategorias(Context mContext, ArrayList images, ArrayList titulo, ArrayList id) {
        this.mContext = mContext;
        this.images = images;
        this.titulo = titulo;
        this.id = id;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardveiw_item_book_categorias,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(titulo.get(position));

        Glide.with(mContext).load(images.get(position)).into(holder.img_book_thumbnail);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                variables.id_principal = id.get(position);

                Log.d("CATEGORIAS", variables.id_principal);

                if(variables.id_principal.equals("0")){

                    Intent intent = new Intent(mContext, Home.class);

                    mContext.startActivity(intent);

                }else{

                    Intent intent = new Intent(mContext, Categorias.class);

                    mContext.startActivity(intent);

                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title =  itemView.findViewById(R.id.book_title_id) ;
            img_book_thumbnail =  itemView.findViewById(R.id.book_img_id);
            cardView =  itemView.findViewById(R.id.cardview_id);

        }
    }

}
