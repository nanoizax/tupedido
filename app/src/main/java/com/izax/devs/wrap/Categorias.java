package com.izax.devs.wrap;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Link;
import com.izax.devs.wrap.Estructura.Objetos;
import com.izax.devs.wrap.Estructura.Variables;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        OBJETOS();

        BOTONES();

        BUSQUEDA_CATEGORIA();

    }

    Objetos objetos = new Objetos();

    Funciones funciones = new Funciones();

    Variables variables = new Variables();

    Link link = new Link();

    private void OBJETOS(){

        objetos.img_back = findViewById(R.id.img_back);

        objetos.myrv = findViewById(R.id.recycle_populares);

    }

    private void BOTONES(){

        objetos.img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                funciones.go(Categorias.this, Home.class);

            }
        });

    }

    private void BUSQUEDA_CATEGORIA() {


        variables.categoria = "17";

        funciones.JSONLOGIN(link.GET_Principales + variables.id_principal);

        Log.d("CATEGORIAS", link.GET_Principales + variables.id_principal );

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                if (variables.error.equals("1")) {

                    objetos.myrv_populares.setVisibility(View.VISIBLE);

                    objetos.scroll_home.setVisibility(View.GONE);

                    funciones.cargarPopulares(Categorias.this, objetos.myrv, variables.array_productos_foto, variables.array_productos_titulo,variables.array_productos_id, variables.array_productos_precio, variables.array_productos_descripcion, variables.array_productos_cantidad, variables.array_productos_lat, variables.array_productos_lon);

                } else {

                    Log.d("JSON", "Carga Fallida contenido");

                    funciones.mensaje(Categorias.this, "No hay elementos.");

                }

            }
        }.start();

    }


}
