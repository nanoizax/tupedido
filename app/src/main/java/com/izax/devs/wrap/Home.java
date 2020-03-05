package com.izax.devs.wrap;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.bumptech.glide.Glide;
import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Link;
import com.izax.devs.wrap.Estructura.Objetos;
import com.izax.devs.wrap.Estructura.Variables;
import com.izax.devs.wrap.Items.RecyclerViewAdapterHorizontal;
import com.izax.devs.wrap.Items.RecyclerViewAdapterHorizontal_recomendados;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements BillingProcessor.IBillingHandler{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        OBJETOS();

        BOTONES();

        PRODUCTOS();

        Lista();

        ESTADO();

        funciones.mensaje(Home.this, "Bienvenidos.");

    }

    Funciones funciones = new Funciones();

    Objetos objetos = new Objetos();

    Variables variables = new Variables();

    Link link = new Link();

    RecyclerView recyclerView_recomendados;

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();

    private ArrayList<String> mImageUrls = new ArrayList<>();

    //crea esta variable GLOBAL
    BillingProcessor bp;

    String KEY_LICEN = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyTI0r+kk9ZTlhveJFiac+Ou7XoZfWOlpzqAN9z9B/No5q0++fyqjRO9ksoJnh/ktyFxHzbgJw6CkrSwzjPQRFxt6VgmLGhgTmr53nMe3pqmBqUPQJT3N6pIC2WK2+hdH6PakQDFIjltAExeEsOFDJtkEHFgFG6wgih7D3DFZY4q4z7KgO7YVzXLKFifweFdXqt0VVy1JxIfPYT0ZGMVfT4cDgeZrjitpBDideFTPRvs8E+VTgFJZwFJyQbKfY3AoDsYnI2vrnMaBFC7bLQhnBiZABot3W8vv/ja4Zj3enfy+VFUILM+BmjS13tBpP5Xj/wPpefuodsxUqFC4q/s/JQIDAQAB";



    private void OBJETOS() {

        objetos.myrv = findViewById(R.id.recyclerview_id);

        objetos.myrvP = findViewById(R.id.recycle_p);

        objetos.c_perfil = findViewById(R.id.c_perfil);

        objetos.img_menu = findViewById(R.id.img_menu);

        objetos.img_search = findViewById(R.id.img_search);

        objetos.img_logo = findViewById(R.id.img_logo);

        objetos.img_back = findViewById(R.id.img_back);

        objetos.txt_search = findViewById(R.id.txt_search);

        objetos.layout_menu = findViewById(R.id.c_menu);

        objetos.c_login = findViewById(R.id.c_login);

        objetos.c_recetas = findViewById(R.id.c_recetas);

        objetos.lbl_inicio = findViewById(R.id.lbl_login);

        objetos.lbl_salir = findViewById(R.id.lbl_salir);

        objetos.lbl_recetas = findViewById(R.id.lbl_recetas);

        objetos.lista = findViewById(R.id.lista);

        objetos.img_share = findViewById(R.id.img_confi);

        objetos.viewPager = findViewById(R.id.pager);

        recyclerView_recomendados = findViewById(R.id.recicle_recomendados);

        objetos.img_recomendados = findViewById(R.id.img_recomendados);

        objetos.img_n_recomendados = findViewById(R.id.img_n_recomendados);

        objetos.img_populares = findViewById(R.id.img_populares);

        objetos.img_descubre = findViewById(R.id.img_descubre);

        objetos.myrv_search = findViewById(R.id.recycle_search);

        objetos.scroll_home = findViewById(R.id.scroll_home);

        objetos.myrv_populares = findViewById(R.id.recycle_populares);

        objetos.img_perfil = findViewById(R.id.img_perfil);

        objetos.lbl_nombre = findViewById(R.id.lbl_nombre);

    }

    /*private void PAGER(){

        variables.array_pager_img.add("https://www.devsizax.com/proyectos/agropecuaria/img/foto_inicio.png");
        variables.array_pager_img.add("https://www.devsizax.com/proyectos/agropecuaria/img/foto_inicio.png");
        variables.array_pager_img.add("https://www.devsizax.com/proyectos/agropecuaria/img/foto_inicio.png");
        variables.array_pager_img.add("https://www.devsizax.com/proyectos/agropecuaria/img/foto_inicio.png");

        funciones.cargarPager(Home.this, objetos.viewPager, variables.array_pager_img);

    }*/

    private void Lista() {

        objetos.lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Menu();

                Items(position);

            }
        });



    }

    private void Items(Integer i){

        if(i == 0){

            funciones.go(Home.this, Home.class);

        }else{

            String id = variables.array_categorias_id.get(i).toString();

            BUSQUEDA_CATEGORIA(id);

        }


    }

    private void BOTONES(){

        //IMG -----------------------------



        objetos.lbl_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                funciones.go(Home.this, Login.class);

            }
        });

        objetos.lbl_recetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                funciones.go(Home.this, Recetas.class);

            }
        });

        objetos.lbl_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        objetos.img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Menu();

            }
        });

        objetos.img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Buscar();

            }
        });

        objetos.img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Guardar();

            }
        });

        objetos.img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bp.purchase(Home.this, "descuento");
                //MODAL_DATOS();

            }
        });

        objetos.img_recomendados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FILTRO("12", link.GET_Recomendaciones);

            }
        });

        objetos.img_n_recomendados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FILTRO("13", link.GET_RecomendacionesNew);

            }
        });

        objetos.img_populares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FILTRO("11", link.GET_Productos);

            }
        });

        objetos.myrvP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //PRINCIPALES();

            }
        });

        /*objetos.img_descubre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FILTRO("14", link.GET_Ofertas);

            }
        });*/

        //Label ------------------------

    }

    private void Buscar(){

        if(variables.estado_search.equals("0")){

            objetos.img_logo.setVisibility(View.GONE);
            objetos.img_menu.setVisibility(View.GONE);

            objetos.img_back.setVisibility(View.VISIBLE);
            objetos.txt_search.setVisibility(View.VISIBLE);

            variables.estado_search = "1";

        }else{

            String bus = objetos.txt_search.getText().toString();

            objetos.txt_search.setText("");

            BUSQUEDA(bus);

        }
    }

    private void Guardar(){

            objetos.img_logo.setVisibility(View.VISIBLE);
            objetos.img_menu.setVisibility(View.VISIBLE);

            objetos.img_back.setVisibility(View.GONE);
            objetos.txt_search.setVisibility(View.GONE);

            objetos.myrv_populares.setVisibility(View.GONE);

            objetos.scroll_home.setVisibility(View.VISIBLE);

            variables.estado_search = "0";

    }

    private void Menu(){

        if(variables.estado_menu.equals("0")){

            objetos.layout_menu.setVisibility(View.VISIBLE);

            variables.estado_menu = "1";

        }else{

            objetos.layout_menu.setVisibility(View.GONE);

            variables.estado_menu = "0";

        }

    }

    private void FILTRO(String id, String link){

        objetos.scroll_home.setVisibility(View.GONE);

        objetos.myrv_populares.setVisibility(View.VISIBLE);

        variables.categoria = id;

        funciones.JSONLOGIN(link);

        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                if (variables.categoria.equals("12")){

                    funciones.cargarPopulares(Home.this, objetos.myrv_populares, variables.array_productos_foto_recomendados, variables.array_productos_titulo_recomendados,variables.array_productos_id_recomendados, variables.array_productos_precio_recomendados, variables.array_productos_descripcion_recomendados, variables.array_productos_cantidad_recomendados, variables.array_productos_lat, variables.array_productos_lon);

                }else if(variables.categoria.equals("13")){

                    funciones.cargarPopulares(Home.this, objetos.myrv_populares, variables.array_productos_foto_recomendados_new, variables.array_productos_titulo_recomendados_new,variables.array_productos_id_recomendados_new, variables.array_productos_precio_recomendados_new, variables.array_productos_descripcion_recomendados_new, variables.array_productos_cantidad_recomendados_new, variables.array_productos_lat, variables.array_productos_lon);

                }else if(variables.categoria.equals("11")){

                    funciones.cargarPopulares(Home.this, objetos.myrv_populares, variables.array_productos_foto, variables.array_productos_titulo,variables.array_productos_id, variables.array_productos_precio, variables.array_productos_descripcion, variables.array_productos_cantidad, variables.array_productos_lat, variables.array_productos_lon);

                }


            }
        }.start();

    }

    private void PRODUCTOS() {

        variables.visitado = "0";

        variables.categoria = "12";

        funciones.JSONLOGIN(link.GET_Recomendaciones);

        variables.categoria = "13";

        funciones.JSONLOGIN(link.GET_RecomendacionesNew);

        variables.categoria = "14";

        funciones.JSONLOGIN(link.GET_Ofertas);

        variables.categoria = "16";

        funciones.JSONLOGIN(link.GET_Categorias);

        variables.categoria = "10";

        funciones.JSONLOGIN(link.GET_Slider);

        variables.categoria = "11";

        funciones.JSONLOGIN(link.GET_Productos);


        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                //if (variables.error.equals("1")) {

                    funciones.cargarCararatulas(Home.this, recyclerView_recomendados, variables.array_productos_foto_recomendados, variables.array_productos_titulo_recomendados,variables.array_productos_id_recomendados, variables.array_productos_precio_recomendados, variables.array_productos_descripcion_recomendados, variables.array_productos_cantidad_recomendados, variables.array_productos_lat, variables.array_productos_lon);

                    funciones.cargarCararatulas(Home.this,  objetos.myrv, variables.array_productos_foto, variables.array_productos_titulo,variables.array_productos_id, variables.array_productos_precio, variables.array_productos_descripcion, variables.array_productos_cantidad, variables.array_productos_lat, variables.array_productos_lon);

                    funciones.cargarCararatulasPrincipal(Home.this,  objetos.myrvP, variables.array_categorias_img, variables.array_categorias,variables.array_categorias_id);

                    funciones.cargarLista(variables.array_categorias_id,  variables.array_categorias, Home.this, objetos.lista);

                    Log.d("JSON", "Carga Exitosa contenido");

                    funciones.cargarPager(Home.this, objetos.viewPager, variables.array_pager_img);

                    RecomendadosNew();

                    funciones.cargarPopulares(Home.this, objetos.myrv_populares, variables.array_productos_foto, variables.array_productos_titulo,variables.array_productos_id, variables.array_productos_precio, variables.array_productos_descripcion, variables.array_productos_cantidad, variables.array_productos_lat, variables.array_productos_lon);

                    Ofertas();

                /*} else {

                    Log.d("JSON", "Carga Fallida contenido");

                }*/

            }
        }.start();

    }

    private void BUSQUEDA(String bus) {

        variables.categoria = "15";

        funciones.JSONLOGIN(link.GET_Busqueda + bus);

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                if (variables.error.equals("1")) {

                    objetos.myrv_populares.setVisibility(View.VISIBLE);

                    objetos.scroll_home.setVisibility(View.GONE);

                    funciones.cargarPopulares(Home.this, objetos.myrv_populares, variables.array_productos_foto, variables.array_productos_titulo,variables.array_productos_id, variables.array_productos_precio, variables.array_productos_descripcion, variables.array_productos_cantidad, variables.array_productos_lat, variables.array_productos_lon);

                } else {

                    Log.d("JSON", "Carga Fallida contenido");

                    funciones.mensaje(Home.this, "Error en busqueda.");

                }

            }
        }.start();

    }

    private void BUSQUEDA_CATEGORIA(String bus) {

        variables.categoria = "17";

        funciones.JSONLOGIN(link.GET_Principales + bus);

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                if (variables.error.equals("1")) {

                    objetos.myrv_populares.setVisibility(View.VISIBLE);

                    objetos.scroll_home.setVisibility(View.GONE);

                    funciones.cargarPopulares(Home.this, objetos.myrv_populares, variables.array_productos_foto, variables.array_productos_titulo,variables.array_productos_id, variables.array_productos_precio, variables.array_productos_descripcion, variables.array_productos_cantidad, variables.array_productos_lat, variables.array_productos_lon);

                } else {

                    Log.d("JSON", "Carga Fallida contenido");

                    funciones.mensaje(Home.this, "No hay elementos.");

                }

            }
        }.start();

    }

    private void MODAL_CARRITO() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Home.this);
        View mView = getLayoutInflater().inflate(R.layout.modal_carrito, null);

        objetos.lista_menu = mView.findViewById(R.id.lista_carrito);

        objetos.btn_comprar = mView.findViewById(R.id.btn_comprar);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        objetos.btn_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                funciones.cargarListaArticulos(Home.this, objetos.lista_menu, variables.array_carrito_id, variables.array_carrito_titulo, variables.array_carrito_precio, variables.array_carrito_cantidad, variables.array_carrito_total, variables.array_carrito_img);

            }
        });

    }

    @Override
    public void onBackPressed(){

        objetos.myrv_search.setVisibility(View.GONE);

        objetos.scroll_home.setVisibility(View.VISIBLE);

        PRODUCTOS();

    }

    private void ESTADO(){

        if(variables.id.equals("0")){

            objetos.c_login.setVisibility(View.VISIBLE);
            objetos.c_perfil.setVisibility(View.GONE);
            //objetos.img_share.setVisibility(View.GONE);

        }else{

            objetos.c_login.setVisibility(View.GONE);
            objetos.c_perfil.setVisibility(View.VISIBLE);
            //objetos.img_share.setVisibility(View.VISIBLE);

            objetos.lbl_nombre.setText(variables.nombre);

            Glide.with(this).load(variables.imagen).into(objetos.img_perfil);

        }

    }

    private void MODAL_DATOS() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Home.this);
        View mView = getLayoutInflater().inflate(R.layout.modal_datos, null);

        objetos.txt_nombre = mView.findViewById(R.id.txt_nombre);
        objetos.txt_telefono = mView.findViewById(R.id.txt_telefono);
        objetos.txt_direccion = mView.findViewById(R.id.txt_direccion);
        objetos.txt_email = mView.findViewById(R.id.txt_pass);
        objetos.txt_password = mView.findViewById(R.id.txt_clave);

        objetos.btn_registrar = mView.findViewById(R.id.btn_registrar);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        objetos.txt_nombre.setText(variables.nombre);
        objetos.txt_telefono.setText(variables.telefono);
        objetos.txt_direccion.setText(variables.direccion);
        objetos.txt_email.setText(variables.email);
        objetos.txt_password.setText(variables.password);

        objetos.btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                variables.nombre = objetos.txt_nombre.getText().toString();
                variables.telefono = objetos.txt_telefono.getText().toString();
                variables.direccion = objetos.txt_direccion.getText().toString();
                variables.email = objetos.txt_email.getText().toString();
                variables.password = objetos.txt_password.getText().toString();

                if(variables.nombre.equals("")||variables.telefono.equals("")||variables.direccion.equals("")||variables.email.equals("")||variables.password.equals("")){

                    funciones.mensaje(Home.this, "Debe llenar todos los campos.");

                }else{

                    funciones.mensaje(Home.this, "Datos Guardadas");

                }

            }
        });



    }

    private void Ofertas(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterHorizontal adapter = new RecyclerViewAdapterHorizontal(this,
                variables.array_productos_titulo_oferta,
                variables.array_productos_foto_oferta,
                variables.array_productos_id,
                variables.array_productos_precio,
                variables.array_productos_descripcion,
                variables.array_productos_cantidad,
                variables.array_productos_lat,
                variables.array_productos_lon);
        recyclerView.setAdapter(adapter);



    }

    private void RecomendadosNew(){

        Log.d("RECOEMNDADOS", "CARGANDO");
        LinearLayoutManager layoutManager_recomendados = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView_recomendados = findViewById(R.id.recicle_n_recomendados);
        recyclerView_recomendados.setLayoutManager(layoutManager_recomendados);
        RecyclerViewAdapterHorizontal_recomendados adapter_recomendados = new RecyclerViewAdapterHorizontal_recomendados(this,
                variables.array_productos_titulo_recomendados_new,
                variables.array_productos_foto_recomendados_new,
                variables.array_productos_id,
                variables.array_productos_precio,
                variables.array_productos_descripcion,
                variables.array_productos_cantidad,
                variables.array_productos_lat,
                variables.array_productos_lon);
        recyclerView_recomendados.setAdapter(adapter_recomendados);

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

    /*private void PRINCIPALES(){

        variables.categoria = "17";

        funciones.JSONLOGIN(link.GET_Principales + variables.id_principal);

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                //resutlado.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {

                if (variables.error.equals("1")) {

                    objetos.scroll_home.setVisibility(View.GONE);

                    objetos.myrv_populares.setVisibility(View.VISIBLE);

                    funciones.cargarPopulares(Home.this, objetos.myrv_populares, variables.array_productos_foto, variables.array_productos_titulo,variables.array_productos_id, variables.array_productos_precio, variables.array_productos_descripcion, variables.array_productos_cantidad, variables.array_productos_lat, variables.array_productos_lon);

                } else {

                    Log.d("JSON", "Carga Fallida contenido");

                    funciones.mensaje(Home.this, "Error en busqueda.");

                }

            }
        }.start();

    }*/



}