package com.izax.devs.wrap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.izax.devs.wrap.Estructura.Funciones;
import com.izax.devs.wrap.Estructura.Link;
import com.izax.devs.wrap.Estructura.Objetos;
import com.izax.devs.wrap.Estructura.Variables;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class Recetas extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recetas);

    OBJETOS();

    BOTONES();

  }

  Funciones funciones = new Funciones();

  Objetos objetos = new Objetos();

  Variables variables = new Variables();

  Link link = new Link();

  Bitmap bitmap;

  private void OBJETOS(){

    objetos.img_articulo = findViewById(R.id.img);

    objetos.fab = findViewById(R.id.fab);

    objetos.fab_camara = findViewById(R.id.fab_camara);

  }

  private void BOTONES(){

    objetos.fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        uploadImage();

      }
    });

    objetos.fab_camara.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        showFileChooser();

      }
    });

  }

  public String getStringImagen(Bitmap bmp) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    byte[] imageBytes = baos.toByteArray();
    String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
    return encodedImage;
  }

  public void uploadImage() {
    final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor");
    StringRequest stringRequest = new StringRequest(Request.Method.POST, link.UPLOAD_URL,
            new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
                loading.dismiss();
                Toast.makeText(Recetas.this, response, Toast.LENGTH_LONG).show();
              }
            }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        loading.dismiss();
        //Log.d("IMAGENES", error.getMessage().toString());
        Toast.makeText(Recetas.this, "Envio exitoso", Toast.LENGTH_LONG).show();
        funciones.go(Recetas.this, Home.class);
      }
    }){
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        String imagen = getStringImagen(bitmap);
        double i = (Math.random() * 100000) + 1;
        String nombre = String.valueOf(i);

        Map<String, String> params = new Hashtable<String, String>();
        params.put(variables.KEY_IMAGE, imagen);
        params.put(variables.KEY_NOMBRE, nombre);
        params.put("id", variables.id);
        params.put("id_travel", variables.item_id);

        return params;
      }
    };

    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(stringRequest);
  }

  private void showFileChooser() {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, "Seleciona imagen"), variables.PICK_IMAGE_REQUEST);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == variables.PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
      Uri filePath = data.getData();
      try {
        //Cómo obtener el mapa de bits de la Galería
        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
        //Configuración del mapa de bits en ImageView
        objetos.img_articulo.setImageBitmap(bitmap);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}