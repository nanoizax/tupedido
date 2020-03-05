package com.izax.devs.wrap.Estructura;

public class Link {

    public static final String IP = "http://mexico.devsizax.com/Wrap/api/";

    //GET --------------------------------

    public static String GET_Login = IP + "query_login.php?texto=";

    public static String GET_Compras_ID = IP + "query_compras_id.php?id=";

    public static String GET_Productos = IP + "query_productos.php";

    public static String GET_Ofertas = IP + "query_all_productos_oferta.php";

    public static String GET_Recomendaciones = IP + "query_all_recomendados.php";

    public static String GET_RecomendacionesNew = IP + "query_all_recomendados_new.php";

    public static String GET_Slider = IP + "query_all.php";

    public static String GET_Categorias = IP + "query_all_categorias.php";

    public static String GET_Busqueda_id = IP + "query_search_id.php?texto=";

    public static String GET_Busqueda = IP + "query_productos_search.php?texto=";

    public static String GET_Comentarios = IP + "query_comentarios.php?texto=";

    public static String GET_Imagenes = IP + "query_imagenes.php?texto=";

    public static String GET_Principales = IP + "query_principales.php?texto=";

    public static String GET_Visito = IP + "query_visitados.php?texto=";

    public static String UPLOAD_URL = IP + "upload/upload.php";

    //INSERT ------------------------------

    public static String INSERT_Usuarios = IP + "query_registrar.php";

    public static String INSERT_Compra = IP + "insert_compra.php";

    public static String INSERT_Paypal = IP + "insert_paypal.php";

    public static String INSERT_Comentarios = IP + "query_insert_comentario.php";

    public static String INSERT_Visito = IP + "query_insert_visitados.php";

}
