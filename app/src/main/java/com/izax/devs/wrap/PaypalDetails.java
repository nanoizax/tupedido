package com.izax.devs.wrap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Link;
import com.izax.devs.wrap.Estructura.Objetos;
import com.izax.devs.wrap.Estructura.Variables;

import org.json.JSONException;
import org.json.JSONObject;

public class PaypalDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal_details);

        OBJETOS();

        BOTONES();

        DATOS();

    }

    Funciones funciones = new Funciones();

    Objetos objetos = new Objetos();

    Variables variables = new Variables();

    Link link = new Link();

    private void OBJETOS() {

        objetos.img_back = findViewById(R.id.img_back);

        objetos.lbl_titulo = findViewById(R.id.lbl_compra);

    }

    private void BOTONES(){

        objetos.img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                funciones.go(PaypalDetails.this, Home.class);

            }
        });

    }

    private void DATOS(){

        Intent intent = getIntent();

        try{

            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));

            JSONObject cadena =  jsonObject.getJSONObject("response");

            variables.code_paypal = cadena.getString("id");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        variables.compra_paypal = intent.getStringExtra("PaymentAmount");

        objetos.lbl_titulo.setText("Compra Exitosa!");

        variables.opcion = "2";

        funciones.JSONEnviar(link.INSERT_Paypal);

    }

}