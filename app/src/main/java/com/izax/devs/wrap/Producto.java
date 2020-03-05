package com.izax.devs.wrap;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.bumptech.glide.Glide;
import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Link;
import com.izax.devs.wrap.Estructura.Objetos;
import com.izax.devs.wrap.Estructura.Variables;

public class Producto extends AppCompatActivity implements BillingProcessor.IBillingHandler{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        OBJETOS();

        BOTONES();

        CARGAR();

        PAGER();

    }

    Funciones funciones = new Funciones();

    Objetos objetos = new Objetos();

    Variables variables = new Variables();

    Link link = new Link();

    //crea esta variable GLOBAL
    BillingProcessor bp;

    String KEY_LICEN = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyTI0r+kk9ZTlhveJFiac+Ou7XoZfWOlpzqAN9z9B/No5q0++fyqjRO9ksoJnh/ktyFxHzbgJw6CkrSwzjPQRFxt6VgmLGhgTmr53nMe3pqmBqUPQJT3N6pIC2WK2+hdH6PakQDFIjltAExeEsOFDJtkEHFgFG6wgih7D3DFZY4q4z7KgO7YVzXLKFifweFdXqt0VVy1JxIfPYT0ZGMVfT4cDgeZrjitpBDideFTPRvs8E+VTgFJZwFJyQbKfY3AoDsYnI2vrnMaBFC7bLQhnBiZABot3W8vv/ja4Zj3enfy+VFUILM+BmjS13tBpP5Xj/wPpefuodsxUqFC4q/s/JQIDAQAB";


    private void OBJETOS() {

        objetos.lbl_titulo = findViewById(R.id.lbl_travel);

        objetos.lbl_contenido = findViewById(R.id.lbl_descripcion);

        objetos.lbl_precio = findViewById(R.id.lbl_precio);

        objetos.img_articulo = findViewById(R.id.img);

        objetos.img_mas = findViewById(R.id.img_mas);

        objetos.img_menos = findViewById(R.id.img_menos);

        objetos.lbl_cantidad = findViewById(R.id.lbl_cantidad);

        objetos.lbl_total = findViewById(R.id.lbl_total);

        objetos.img_carrito = findViewById(R.id.img_carrito);

        objetos.img_back = findViewById(R.id.img_back);

        objetos.viewPager = findViewById(R.id.pager);

        objetos.btn_comprar = findViewById(R.id.btn_comprar);

        objetos.img_mapa = findViewById(R.id.img_mapa);

        objetos.c_subir_foto = findViewById(R.id.c_subir_foto);

        objetos.c_llamar = findViewById(R.id.c_llamar);

        objetos.c_calificar = findViewById(R.id.c_calificar);

        objetos.c_visitado = findViewById(R.id.c_visitado);

        objetos.txt_comentario = findViewById(R.id.txt_comentario);

        objetos.img_enviar = findViewById(R.id.img_enviar);

        objetos.img_share = findViewById(R.id.img_perfil);

    }

    private void BOTONES(){

        objetos.c_subir_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(variables.id.equals("0")){

                    funciones.mensaje(Producto.this, "Debe iniciar session primero");

                }else{

                    funciones.go(Producto.this, Recetas.class);

                }

            }
        });

        objetos.c_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(variables.id.equals("0")){

                    funciones.mensaje(Producto.this, "Debe iniciar session primero");

                }else{

                    funciones.makePhoneCall(Producto.this);

                }

            }
        });

        objetos.c_visitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(variables.id.equals("0")){

                    funciones.mensaje(Producto.this, "Debe iniciar session primero");

                }else{

                    enviarVisito();

                }

            }
        });

        objetos.c_calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(variables.id.equals("0")){

                    funciones.mensaje(Producto.this, "Debe iniciar session primero");

                }else{

                    Uri uri = Uri.parse("https://wa.me/5219934333987");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });

        objetos.img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        objetos.img_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarComentario();

            }
        });

        objetos.img_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                variables.item_cantidad = objetos.lbl_cantidad.getText().toString();

                variables.valor = Integer.valueOf(variables.item_cantidad);

                variables.precio = Double.valueOf(variables.item_precio);

                variables.valor = variables.valor + 1;

                    variables.item_cantidad = variables.valor.toString();

                    objetos.lbl_cantidad.setText(variables.item_cantidad);

                variables.total = variables.precio * variables.valor;

                    objetos.lbl_total.setText(String.valueOf(variables.total));


            }
        });

        objetos.img_menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(variables.item_cantidad.equals("0")){

                }else{

                    variables.valor = variables.valor - 1;

                    variables.item_cantidad = variables.valor.toString();

                    objetos.lbl_cantidad.setText(variables.item_cantidad);

                    variables.total = variables.total - variables.precio;

                    variables.item_total = String.valueOf(variables.total);

                    objetos.lbl_total.setText(String.valueOf(variables.total));

                }

            }
        });

        objetos.img_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(variables.item_cantidad.equals("0")){

                    funciones.mensaje(Producto.this, "Definir cantidad agregar.");

                }else {

                    variables.array_carrito_id.add(variables.item_id);

                    variables.array_carrito_titulo.add(variables.item_titulo);

                    variables.array_carrito_precio.add(variables.item_precio);

                    variables.array_carrito_cantidad.add(variables.item_cantidad);

                    variables.array_carrito_total.add(objetos.lbl_total.getText().toString());

                    variables.array_carrito_img.add(variables.item_img);

                    variables.total = 0;

                    variables.valor = 0;

                    objetos.lbl_total.setText("000");

                    objetos.lbl_cantidad.setText("0");

                    funciones.mensaje(Producto.this, "Agregado al carrito de compras");

                    funciones.go(Producto.this, Home.class);
                }

            }
        });

        objetos.img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                funciones.go(Producto.this, Home.class);

            }
        });

        /*objetos.btn_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                funciones.mensaje(Producto.this, "Pasarela de pago en construccion");
                funciones.go(Producto.this, PaypalDetails.class);

            }
        });*/

        objetos.img_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //funciones.go(Producto.this, MapsActivity.class);
                funciones.mensaje(Producto.this, "Mapa en construccion");

            }
        });

        objetos.btn_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //funciones.go(Producto.this, MapsActivity.class);
                funciones.mensaje(Producto.this, "Pasarela de pago en desarrollo");

            }
        });

    }

    private void enviarComentario(){

        variables.item_comentario = objetos.txt_comentario.getText().toString();

        objetos.txt_comentario.setText("");

        variables.opcion = "3";

        funciones.JSONEnviar(link.INSERT_Comentarios);

        funciones.mensaje(Producto.this, "Comentario enviado.");
    }

    private void enviarVisito(){

        variables.opcion = "4";

        funciones.JSONEnviar(link.INSERT_Visito);

        funciones.mensaje(Producto.this, "Visitado.");
    }


    private void CARGAR(){

        objetos.lbl_titulo.setText(variables.item_titulo);

        objetos.lbl_contenido.setText(variables.item_contenido);

        objetos.lbl_precio.setText(variables.item_precio);

        variables.categoria = "20";

        funciones.JSONLOGIN(link.GET_Imagenes + variables.item_id);

        variables.categoria = "18";

        funciones.JSONLOGIN(link.GET_Visito + variables.item_id + "&usuario=" + variables.id);

        Log.d("VISITADO", link.GET_Visito + variables.item_id);

        Glide.with(this).load(variables.item_img).into(objetos.img_articulo);

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                //RecomendadosNew();

                VISITADO();

            }
        }.start();

    }

    private void VISITADO(){


            if(variables.visitado.equals("0")){

            }else{

                funciones.mensaje(Producto.this, "Visitado");

                objetos.c_visitado.setBackgroundColor(Color.parseColor("#008577"));

            }



    }

    private void PAGER(){

        variables.array_pager_Producto_img.clear();

        variables.array_pager_Producto_img.add(variables.item_img);

        funciones.cargarPager(Producto.this, objetos.viewPager, variables.array_pager_Producto_img);

    }

    private void RecomendadosNew(){

        /*Log.d("RECOEMNDADOS", "CARGANDO");
        LinearLayoutManager layoutManager_recomendados = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView_recomendados = findViewById(R.id.recyclerView);
        recyclerView_recomendados.setLayoutManager(layoutManager_recomendados);
        RecyclerViewAdapterHorizontal_recomendados adapter_recomendados = new RecyclerViewAdapterHorizontal_recomendados(this, variables.array_travel_text, variables.array_travel_img);
        recyclerView_recomendados.setAdapter(adapter_recomendados);*/

    }


    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {

    }

    @Override
    public void onBillingInitialized() {

    }
}
