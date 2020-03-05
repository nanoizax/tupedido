package com.izax.devs.wrap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.izax.devs.wrap.Config.Config;
import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Link;
import com.izax.devs.wrap.Estructura.Objetos;
import com.izax.devs.wrap.Estructura.Variables;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class carrito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        ActivarServicio();

        OBJETOS();

        BOTONES();

        CARGAR();

    }

    Funciones funciones = new Funciones();

    Objetos objetos = new Objetos();

    Variables variables = new Variables();

    Link link = new Link();

    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);

    private void OBJETOS() {

        objetos.img_back = findViewById(R.id.img_back);

        objetos.lista = findViewById(R.id.lista);

        objetos.fab = findViewById(R.id.fab);

        objetos.lbl_total = findViewById(R.id.lbl_total);

    }

    private void BOTONES(){

        objetos.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                processPayment("Total a Pagar:");

            }
        });


    }

    private void CARGAR(){

        funciones.cargarListaArticulos(carrito.this, objetos.lista, variables.array_carrito_id, variables.array_carrito_titulo, variables.array_carrito_precio, variables.array_carrito_cantidad, variables.array_carrito_total, variables.array_carrito_img);

        for (int i = 0; i < variables.array_carrito_titulo.size(); i++) {

            variables.productos = variables.productos + " - " + variables.array_carrito_titulo.get(i);
        }

        CALCULAR();

    }

    private void CALCULAR(){

        double calcular = 0;

        for (int i = 0; i < variables.array_carrito_total.size(); i++) {

            calcular = calcular + Double.valueOf(variables.array_carrito_total.get(i));
        }

        objetos.lbl_total.setText(String.valueOf(calcular));

        variables.amount = String.valueOf(calcular);

    }

    private void LIMPIAR(){

        variables.array_carrito_total.clear();

        variables.array_carrito_precio.clear();

        variables.array_carrito_cantidad.clear();

        variables.array_carrito_id.clear();

        variables.array_carrito_img.clear();

        variables.array_carrito_titulo.clear();

        variables.productos = "";

    }

    //------------------------------

    public void ActivarServicio(){

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);

    }

    @Override
    protected void onDestroy(){

        stopService(new Intent(this, PaymentActivity.class));

        /*if (bp != null) {
            bp.release();
        }*/

        super.onDestroy();

    }

    private void processPayment(String des) {

        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(variables.amount), "USD", des, PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, variables.PAYPAL_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

//        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
//            super.onActivityResult(requestCode, resultCode, data);
//        }

        if(requestCode == variables.PAYPAL_REQUEST_CODE){

            if(resultCode == RESULT_OK){

                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                if(confirmation != null){

                    try {

                        COMPRA();

                        String paymentDetails = confirmation.toJSONObject().toString(4);

                        variables.code_paypal = paymentDetails;

                        variables.compra_paypal = variables.amount;

                        funciones.mensaje(carrito.this, "Compra exitosa!");

                        //funciones.go(carrito.this, PaymentActivity.class);

                        startActivity(new Intent(this, PaypalDetails.class)
                                .putExtra("PaymentDetails", paymentDetails)
                                .putExtra("PaymentAmount", variables.amount)

                        );

                        LIMPIAR();

                    } catch (JSONException e) {
                        e.printStackTrace();
                        funciones.mensaje(carrito.this, e.toString());
                    }

                }

            }else if(resultCode == Activity.RESULT_CANCELED){

                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();

            }

        }else if(resultCode == PaymentActivity.RESULT_EXTRAS_INVALID){
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
        }
//

    }

    //-----------------------------------------

    private void COMPRA(){

        variables.opcion = "1";

        funciones.JSONEnviar(link.INSERT_Compra);

        variables.categoria = "6";

        funciones.JSONLOGIN(link.GET_Compras_ID + variables.id);

        //funciones.mensaje(carrito.this, "Compra Exitosa");

    }

}
