package com.izax.devs.wrap.Estructura;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.izax.devs.wrap.Items.AdapterArticulos;
import com.izax.devs.wrap.Items.AdapterComentarios;
import com.izax.devs.wrap.Items.AdapterDatos;
import com.izax.devs.wrap.Items.Book;
import com.izax.devs.wrap.Items.Datos;
import com.izax.devs.wrap.Items.DatosArticulos;
import com.izax.devs.wrap.Items.RecyclerViewAdapter;
import com.izax.devs.wrap.Items.RecyclerViewAdapterCategorias;
import com.izax.devs.wrap.Items.RecyclerViewAdapterPopulares;
import com.izax.devs.wrap.Items.RecyclerViewAdapterSearch;
import com.izax.devs.wrap.Items.ViewPagerAdapter;
import com.izax.devs.wrap.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Funciones {

  NotificationCompat.Builder notificacion;

  Variables variables = new Variables();

  AdapterComentarios adapterComentarios;
  AdapterArticulos adapterArticulos;
  DatosArticulos datosArticulos;

  ViewPagerAdapter adapterView;

  RecyclerViewAdapterCategorias myAdapter;

  RecyclerViewAdapter myAdapterC;
  RecyclerViewAdapterSearch myAdapterSearch;
  RecyclerViewAdapterPopulares myAdapterPopulares;
  RecyclerViewAdapterCategorias myAdapterCPrincipal;

  AdapterDatos adapterDatos;
  Datos datos;

  Servicios.ObtenerRegistros JSONRegistros;

  Servicios.Insert JSONInsert;

  List<Book> lstBook;

  //Comunes ----------------------

  public void cargarCard(Activity activity, RecyclerView myrv){

    Integer van = variables.array_publicidad_foto.size();

    if(van == 0){

      for (int i = 0; i < variables.array_categorias.size(); i++) {

        variables.array_publicidad_foto.add("https://image.freepik.com/vector-gratis/noche-pelicula_1067-79.jpg");

      }

    }

    myAdapter = new RecyclerViewAdapterCategorias(activity, variables.array_publicidad_foto, variables.array_categorias, variables.array_categorias_id);
    myrv.setLayoutManager(new GridLayoutManager(activity,2));
    myrv.setAdapter(myAdapter);

  }

  public void cargarCararatulas(Activity activity, RecyclerView myrv, ArrayList array_foto, ArrayList array_titulo, ArrayList array_id, ArrayList array_precio, ArrayList array_descripcion, ArrayList array_cantidad, ArrayList latitud, ArrayList longitud){

    myAdapterC = new RecyclerViewAdapter(activity, array_foto, array_titulo,array_id, array_precio, array_descripcion, array_cantidad, latitud, longitud);
    myrv.setLayoutManager(new GridLayoutManager(activity,2));
    myrv.setAdapter(myAdapterC);

  }

  public void cargarSearch(Activity activity, RecyclerView myrv, ArrayList array_foto, ArrayList array_titulo, ArrayList array_id, ArrayList array_precio, ArrayList array_descripcion, ArrayList array_cantidad, ArrayList latitud, ArrayList longitud){

    myAdapterSearch = new RecyclerViewAdapterSearch(activity, array_foto, array_titulo,array_id, array_precio,
            array_descripcion, array_cantidad, latitud, longitud);
    myrv.setLayoutManager(new GridLayoutManager(activity,1));
    myrv.setAdapter(myAdapterSearch);

  }

  public void cargarPopulares(Activity activity, RecyclerView myrv, ArrayList array_foto, ArrayList array_titulo, ArrayList array_id, ArrayList array_precio, ArrayList array_descripcion, ArrayList array_cantidad, ArrayList latitud, ArrayList longitud){

    myAdapterPopulares = new RecyclerViewAdapterPopulares(activity, array_foto, array_titulo,array_id, array_precio,
            array_descripcion, array_cantidad, latitud, longitud);
    myrv.setLayoutManager(new GridLayoutManager(activity,1));
    myrv.setAdapter(myAdapterPopulares);

  }

  public void cargarCararatulasPrincipal(Activity activity, RecyclerView myrv, ArrayList array_foto, ArrayList array_titulo, ArrayList array_id){

    myAdapterCPrincipal = new RecyclerViewAdapterCategorias(activity, array_foto, array_titulo,array_id);
    myrv.setLayoutManager(new GridLayoutManager(activity,4));
    myrv.setAdapter(myAdapterCPrincipal);

  }

  public void cargarLista(ArrayList array_primero, ArrayList array_segundo_datos, Activity activity, ListView listView){

    variables.array_datos_categorias.clear();

    for (int i = 0; i < array_primero.size(); i++) {

      variables.item = (String) array_segundo_datos.get(i);

      datos = new Datos(variables.item);
      variables.array_datos_categorias.add(datos);

      //creo el adater personalizado
      adapterDatos = new AdapterDatos(activity, variables.array_datos_categorias);

    }

    listView.setAdapter(adapterDatos);

  }

  public void cargarListaArticulos(Activity activity, ListView listView, ArrayList array_id, ArrayList array_titulo,ArrayList array_precio,ArrayList array_cantidad,ArrayList array_total, ArrayList array_img){

    variables.array_datos_articulos.clear();

    for (int i = 0; i < array_id.size(); i++) {

      variables.item_titulo = array_titulo.get(i).toString();
      variables.item_precio = array_precio.get(i).toString();
      variables.item_cantidad = array_cantidad.get(i).toString();
      variables.item_total = array_total.get(i).toString();
      variables.item_img = array_img.get(i).toString();

      Log.d("CARGANDO", variables.item_titulo);

      datosArticulos = new DatosArticulos(variables.item_titulo, variables.item_precio, variables.item_cantidad, variables.item_total, variables.item_img);
      variables.array_datos_articulos.add(datosArticulos);

      //creo el adater personalizado
      adapterArticulos = new AdapterArticulos(activity, variables.array_datos_articulos);

    }

    listView.setAdapter(adapterArticulos);

  }

  public void cargarListaComentarios(Activity activity, ListView listView, ArrayList array_id, ArrayList array_titulo, ArrayList array_img){

        /*variables.array_datos_articulos.clear();

        for (int i = 0; i < array_id.size(); i++) {

            variables.item_titulo = array_titulo.get(i).toString();
            variables.item_img = array_img.get(i).toString();

            datosArticulos = new DatosArticulos(variables.item_titulo, variables.item_img);
            variables.array_datos_articulos.add(datosArticulos);

            //creo el adater personalizado
            adapterComentarios = new AdapterComentarios(activity, variables.array_datos_articulos);

        }

        listView.setAdapter(adapterComentarios);*/

  }

  public void cargarPager(Activity activity, ViewPager viewPager, ArrayList array_ruta){

    adapterView = new ViewPagerAdapter(activity, array_ruta, array_ruta);
    viewPager.setAdapter(adapterView);

  }

  public void mensaje(Activity activity, String texto){

    Toast.makeText(activity,
            texto, Toast.LENGTH_LONG).show();

  }

  public void go(Activity activity, Class activity_go){

    Intent intent = new Intent(activity,activity_go);
    activity.startActivity(intent);

  }

  public void calendario(final TextView textView, Activity activity){

    final Calendar c= Calendar.getInstance();
    variables.dia =c.get(Calendar.DAY_OF_MONTH);
    variables.mes =c.get(Calendar.MONTH);
    variables.ano =c.get(Calendar.YEAR);

    final DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
      @Override
      public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        variables.day = Integer.toString(dayOfMonth);
        variables.month = Integer.toString(monthOfYear+1);
        variables.year = Integer.toString(year);

        textView.setText(variables.day + "/" + variables.month + "/" + variables.year);

      }

    }
            ,variables.ano,variables.mes,variables.dia);

    datePickerDialog.show();

  }

  public void obtenerDiaMes(){

    final Calendar c= Calendar.getInstance();
    variables.dia =c.get(Calendar.DAY_OF_MONTH);
    variables.mes =c.get(Calendar.MONTH);
    variables.ano =c.get(Calendar.YEAR);

    //Log.d("FECHA", variables.dia + "/" + variables.mes + "/" + variables.ano);

    String  cadena = variables.dia + "/" + (variables.mes + 1) + "/" + variables.ano;
    int cantidad= 4; /* Total de elementos a Eliminar*/
    /* Total de elementos a Mostrar*/
    int m = Math.max(0, cadena.length() - cantidad);

    StringBuilder sb = new StringBuilder(cadena);
    sb.setLength(m);

    variables.hoy = sb.toString();

    //Log.d("FECHA", variables.hoy);

  }

  public void hora(final TextView textView, Activity activity){

    final Calendar d = Calendar.getInstance();
    variables.hora =d.get(Calendar.HOUR_OF_DAY);
    variables.minutos =d.get(Calendar.MINUTE);

    TimePickerDialog timePickerDialog = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
      @Override
      public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        textView.setText(hourOfDay+":"+minute);
      }
    },variables.hora,variables.minutos,false);
    timePickerDialog.show();

  }

  //Funcion para llamadas desde la app ------------
  public void makePhoneCall (Activity activity) {
    String number = variables.telefono;
    if (number.trim().length() > 0) {

      if (ContextCompat.checkSelfPermission(activity,
              Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.CALL_PHONE}, variables.REQUEST_CALL);
      } else {
        String dial = "tel:" + number;
        activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

      }

    } else {
      Toast.makeText(activity, "Enter Phone Number", Toast.LENGTH_SHORT).show();
    }
  }

  // Notificaciones -------------------------------
  public void notificaciones(Activity activity){

    //for (int i = 0; i < variables.array_notificaciones_id.size(); i++) {

    notificacion = new NotificationCompat.Builder(activity);
    notificacion.setAutoCancel(true);

    notificacion.setSmallIcon(R.mipmap.ic_launcher);
    notificacion.setTicker("Nuevas notificaciones");
    notificacion.setPriority(Notification.PRIORITY_HIGH);
    notificacion.setWhen(System.currentTimeMillis());
    notificacion.setContentTitle("KAPTA");
    //notificacion.setContentText(variables.array_notificaciones_mensaje.get(i));
    notificacion.setContentText("Tenemos nuevos juegos para ti!");

    //Intent intent = new Intent(activity, Splash.class);

    //PendingIntent pendingIntent = PendingIntent.getActivity(activity,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
    //notificacion.setContentIntent(pendingIntent);

    NotificationManager nm = (NotificationManager) activity.getSystemService(NOTIFICATION_SERVICE);
    nm.notify(variables.idUnica, notificacion.build());

    //}

  }

  //JSON-----------------------------------------

  public void JSONLOGIN(String link){

    JSONRegistros = new Servicios.ObtenerRegistros();
    JSONRegistros.execute(link ,"1", variables.categoria);

  }

  public void JSONEnviar(String link){

    JSONInsert = new Servicios.Insert();
    JSONInsert.execute(link ,"4");

  }

}
