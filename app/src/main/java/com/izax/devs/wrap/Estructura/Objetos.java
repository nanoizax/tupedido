package com.izax.devs.wrap.Estructura;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Objetos {

    public static EditText
            txt_email, txt_password, txt_password_rep, txt_search, txt_telefono, txt_edad, txt_nombre, txt_nueva, txt_actualizar, txt_sexo, txt_conjunto, txt_interior,
            txt_iglesia_nombre, txt_comentario, txt_direccion, txt_iglesia_email, txt_iglesia_telefono, txt_mensaje, txt_titulo, txt_contenido, txt_numero, txt_apto;

    public static TextView
            lbl_nombre, lbl_recetas, lbl_direccion, lbl_email, lbl_registrarse, lbl_olvido, lbl_telefono, lbl_iglesias, lbl_fecha, lbl_titulo,
            lbl_contenido, lbl_inicio, lbl_populares, lbl_categorias, lbl_español, lbl_ingles, lbl_salir, lbl_precio, lbl_cantidad, lbl_total;

    public static ImageView
            img_perfil, img_salir, img_articulo, img_back, img_menu, img_search, img_logo, img_enviar, img_share,
            img_idioma, img_mas, img_menos, img_carrito, img_mapa, img_recomendados, img_n_recomendados, img_populares, img_descubre;

    public static RecyclerView
            myrv, myrvP, myrv_search, myrv_populares;

    public static Button
            btn_login, btn_registrar, btn_llamar, btn_perfil, btn_regresar, btn_actualizar, btn_guardar, btn_calendario, btn_enviar,
            btn_aceptar, btn_cancelar, btn_opiniones, btn_opinar, btn_servicios, btn_preguntas, btn_preguntar, btn_trailer,
            btn_tv, btn_series, btn_cine, btn_comprar;

    public static FloatingActionButton
            fab, fab_camara;

    public static Switch sw_vehiculo, sw_mascota;

    public static ListView
            lista, lista_menu;

    public static ConstraintLayout
            layout_menu, c_login, c_cerrar, c_recetas, c_perfil, c_llamar, c_visitado, c_calificar, c_subir_foto;

    public static ViewPager
            viewPager;

    public static VideoView
            videoView;

    public static ScrollView
            scroll_home;


}
