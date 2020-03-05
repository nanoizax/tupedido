package com.izax.devs.wrap;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Link;
import com.izax.devs.wrap.Estructura.Objetos;
import com.izax.devs.wrap.Estructura.Variables;


public class Login extends AppCompatActivity {

    CallbackManager callbackManager;

    LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //---------------

        //-----------

        callbackManager = CallbackManager.Factory.create();

        OBJETOS();

        BOTONES();

        loginButton = findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        goMain();
                    }

                    @Override
                    public void onCancel() {
                        funciones.mensaje(Login.this,"se cancelo");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        funciones.mensaje(Login.this,"Error: " + exception);
                    }
                });


    }



    Funciones funciones = new Funciones();

    Objetos objetos = new Objetos();

    Variables variables = new Variables();

    Link link = new Link();

    private void OBJETOS(){

        objetos.txt_email = findViewById(R.id.txt_email);

        objetos.txt_password = findViewById(R.id.txt_pass);

        objetos.btn_login = findViewById(R.id.btn_login);

        objetos.btn_registrar = findViewById(R.id.btn_registrar);

    }

    private void BOTONES(){

        objetos.btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LOGIN();

            }
        });

        objetos.btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //funciones.go(Login.this, Registro.class);

            }
        });

    }

    //Funcion Login - Acceso y validación -----------

    private void LOGIN(){

        variables.email = objetos.txt_email.getText().toString();

        variables.password = objetos.txt_password.getText().toString();

        variables.categoria = "2";

        funciones.JSONLOGIN(link.GET_Login + variables.email + "&clave=" + variables.password);

        Log.d("JSON", link.GET_Login + variables.email + "&clave=" + variables.password);

        new CountDownTimer(3000, 3000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                if(variables.error_login.equals("1")){

                    funciones.mensaje(Login.this, variables.id);
                    funciones.go(Login.this, Home.class);

                }else{

                    funciones.mensaje(Login.this, "Usuario o clave invalida");

                }

            }
        }.start();

    }

    private void MODAL_REGISTRARSE() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Login.this);
        View mView = getLayoutInflater().inflate(R.layout.modal_registrar, null);

        objetos.txt_nombre = mView.findViewById(R.id.txt_nombre);
        objetos.txt_telefono = mView.findViewById(R.id.txt_telefono);
        objetos.txt_direccion = mView.findViewById(R.id.txt_direccion);
        objetos.txt_email = mView.findViewById(R.id.txt_pass);
        objetos.txt_password = mView.findViewById(R.id.txt_clave);
        objetos.txt_password_rep = mView.findViewById(R.id.txt_repetir);

        objetos.btn_registrar = mView.findViewById(R.id.btn_registrar);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        objetos.btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                variables.nombre = objetos.txt_nombre.getText().toString();
                variables.telefono = objetos.txt_telefono.getText().toString();
                variables.direccion = objetos.txt_direccion.getText().toString();
                variables.email = objetos.txt_email.getText().toString();
                variables.password = objetos.txt_password.getText().toString();
                variables.repetir = objetos.txt_password_rep.getText().toString();

                if(variables.nombre.equals("")||variables.telefono.equals("")||variables.direccion.equals("")||variables.email.equals("")||variables.password.equals("")||variables.repetir.equals("")){

                    funciones.mensaje(Login.this, "Debe llenar todos los campos.");

                }else{

                    if(variables.password.equals(variables.repetir)){

                        variables.opcion = "0";

                        funciones.JSONEnviar(link.INSERT_Usuarios);

                        funciones.mensaje(Login.this, "Registro Exitoso");

                        dialog.dismiss();

                    }else{
                        funciones.mensaje(Login.this, "La contraseña no coincide.");
                    }
                }

            }
        });



    }

    //Login facebook


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);



    }



    private void goMainScreen() {
        Intent intent = new Intent(this, Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void goMain(){
        Intent intent = new Intent(this, Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //Login Google


}
