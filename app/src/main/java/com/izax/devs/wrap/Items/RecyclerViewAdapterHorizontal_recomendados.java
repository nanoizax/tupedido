package com.izax.devs.wrap.Items;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Variables;
import com.izax.devs.wrap.Producto;
import com.izax.devs.wrap.R;

import java.util.ArrayList;

/**
 * Created by User on 2/12/2018.
 */

public class RecyclerViewAdapterHorizontal_recomendados extends RecyclerView.Adapter<RecyclerViewAdapterHorizontal_recomendados.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    Variables variables = new Variables();
    Funciones funciones = new Funciones();
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mid = new ArrayList<>();
    private ArrayList<String> mprecio = new ArrayList<>();
    private ArrayList<String> mlatitud = new ArrayList<>();
    private ArrayList<String> mlongitud = new ArrayList<>();
    private ArrayList<String> mdescripcion = new ArrayList<>();
    private ArrayList<String> mcantidad = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapterHorizontal_recomendados(Context context, ArrayList<String> names, ArrayList<String> imageUrls, ArrayList<String> id, ArrayList<String> precio, ArrayList<String> descripcion, ArrayList<String> cantidad, ArrayList<String> latitud, ArrayList<String> longitud) {
        mNames = names;
        mImageUrls = imageUrls;
        mid = id;
        mprecio = precio;
        mlatitud = latitud;
        mlongitud = longitud;
        mdescripcion = descripcion;
        mcantidad = cantidad;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem_n_recomendados, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.image);

        holder.name.setText(mNames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                variables.item_titulo = mNames.get(position);

                variables.item_precio = mprecio.get(position);

                variables.item_contenido = mdescripcion.get(position);

                variables.item_img = mImageUrls.get(position);

                variables.item_id = mid.get(position);


                Intent intent = new Intent(mContext, Producto.class);

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);
        }
    }
}
