package com.izax.devs.wrap.Estructura;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Servicios {

    //GET -------------------------------------------

    public static class ObtenerRegistros extends AsyncTask<String,Void,String> {

        Variables variables = new Variables();

        JSONObject respuestaJSON;

        JSONObject respuestaJSON2;

        JSONObject respuestaJSON3;

        JSONObject respuestaJSON4;

        JSONArray contenidoJSON;

        private void Login() throws JSONException {

                variables.error_login = "1";

                variables.id = contenidoJSON.getJSONObject(0).getString("id");
                variables.email = contenidoJSON.getJSONObject(0).getString("email");
                variables.password = contenidoJSON.getJSONObject(0).getString("password");
                variables.nombre = contenidoJSON.getJSONObject(0).getString("nombre");
                variables.imagen = contenidoJSON.getJSONObject(0).getString("img");

                Log.d("LEANDRO", variables.id);

        }

        private void Publicidad() throws JSONException {

            variables.array_categorias.clear();
            variables.array_categorias_id.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_categorias_id.add(contenidoJSON.getJSONObject(i).getString("category_id"));

                Log.d("JSON ID CINE", contenidoJSON.getJSONObject(i).getString("category_id"));

                variables.array_categorias.add(contenidoJSON.getJSONObject(i).getString("category_name"));

            }

        }

        private void Servicios() throws JSONException {

            variables.array_servicios_id.clear();
            variables.array_servicios_foto.clear();
            variables.array_servicios_titulo.clear();
            variables.array_servicios_descripcion.clear();
            variables.array_servicios_titulo_ingles.clear();
            variables.array_servicios_descripcion_ingles.clear();
            variables.array_servicios_trailer.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_servicios_id.add(contenidoJSON.getJSONObject(i).getString("id"));

                variables.array_servicios_foto.add(contenidoJSON.getJSONObject(i).getString("foto"));

                variables.array_servicios_titulo.add(contenidoJSON.getJSONObject(i).getString("titulo"));

                variables.array_servicios_descripcion.add(contenidoJSON.getJSONObject(i).getString("descripcion"));

                variables.array_servicios_titulo_ingles.add(contenidoJSON.getJSONObject(i).getString("titulo_ingles"));

                variables.array_servicios_descripcion_ingles.add(contenidoJSON.getJSONObject(i).getString("descripcion_ingles"));

                variables.array_servicios_trailer.add(contenidoJSON.getJSONObject(i).getString("trailer"));

                Log.d("VICENT", contenidoJSON.getJSONObject(i).getString("titulo"));

            }

        }

        private void Categorias() throws JSONException {

            variables.array_categorias_id.clear();
            variables.array_categorias.clear();
            variables.array_categorias_img.clear();

            variables.array_categorias_id.add("0");
            variables.array_categorias.add("Home");
            variables.array_categorias_img.add("https://banner2.kisspng.com/20180411/ike/kisspng-computer-icons-home-house-home-5ace88fc2001a1.3041062815234849241311.jpg");

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_categorias_id.add(contenidoJSON.getJSONObject(i).getString("id"));

                variables.array_categorias.add(contenidoJSON.getJSONObject(i).getString("nombre"));

                variables.array_categorias_img.add(contenidoJSON.getJSONObject(i).getString("img"));

            }

        }

        private void SERIES() throws JSONException {

            variables.array_series_id.clear();
            variables.array_series_titulo.clear();
            variables.array_series_foto.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_series_id.add(contenidoJSON.getJSONObject(i).getString("series_id"));

                variables.array_series_titulo.add(contenidoJSON.getJSONObject(i).getString("name"));

                variables.array_series_foto.add(contenidoJSON.getJSONObject(i).getString("cover"));

            }

        }

        private void TEMPORADAS() throws JSONException {

            variables.array_categorias.clear();
            variables.array_categorias_id.clear();
            variables.array_publicidad_foto.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_categorias_id.add(contenidoJSON.getJSONObject(i).getString("season_number"));

                variables.array_categorias.add(contenidoJSON.getJSONObject(i).getString("name"));

                variables.array_publicidad_foto.add(contenidoJSON.getJSONObject(i).getString("cover"));

                Log.d("JSON", contenidoJSON.getJSONObject(i).getString("name"));

            }

        }

        private void IMAGENES() throws JSONException {

            variables.array_travel_img.clear();
            variables.array_travel_text.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_travel_text.add("");

                variables.array_travel_img.add(contenidoJSON.getJSONObject(i).getString("img"));

                Log.d("IMAGENES", contenidoJSON.getJSONObject(i).getString("id"));

            }

        }

        private void CAPITULOS() throws JSONException{

            variables.array_series_id.clear();
            variables.array_series_titulo.clear();
            variables.array_series_foto.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_series_id.add(contenidoJSON.getJSONObject(i).getString("id"));

                variables.array_series_titulo.add(contenidoJSON.getJSONObject(i).getString("title"));

                Log.d("JSON TITULO", contenidoJSON.getJSONObject(i).getString("title"));

                variables.array_series_foto.add(variables.img_serie);

            }

        }

        private void Slider() throws JSONException{


            variables.array_pager_img.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_pager_img.add(contenidoJSON.getJSONObject(i).getString("img"));


            }

        }

        private void Productos() throws JSONException{


            variables.array_productos_id.clear();
            variables.array_productos_titulo.clear();
            variables.array_productos_foto.clear();
            variables.array_productos_precio.clear();
            variables.array_productos_cantidad.clear();
            variables.array_productos_descripcion.clear();
            variables.array_productos_lat.clear();
            variables.array_productos_lon.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_productos_id.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_titulo.add(contenidoJSON.getJSONObject(i).getString("nombre"));
                variables.array_productos_foto.add(contenidoJSON.getJSONObject(i).getString("img"));
                variables.array_productos_precio.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_cantidad.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_descripcion.add(contenidoJSON.getJSONObject(i).getString("descripcion"));
                variables.array_productos_lat.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_lon.add(contenidoJSON.getJSONObject(i).getString("id"));


            }

        }

        private void PRINCIPALES() throws JSONException{


            variables.array_productos_id.clear();
            variables.array_productos_titulo.clear();
            variables.array_productos_foto.clear();
            variables.array_productos_precio.clear();
            variables.array_productos_cantidad.clear();
            variables.array_productos_descripcion.clear();
            variables.array_productos_lat.clear();
            variables.array_productos_lon.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_productos_id.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_titulo.add(contenidoJSON.getJSONObject(i).getString("nombre"));
                variables.array_productos_foto.add(contenidoJSON.getJSONObject(i).getString("img"));
                variables.array_productos_precio.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_cantidad.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_descripcion.add(contenidoJSON.getJSONObject(i).getString("descripcion"));
                variables.array_productos_lat.add(contenidoJSON.getJSONObject(i).getString("latitud"));
                variables.array_productos_lon.add(contenidoJSON.getJSONObject(i).getString("longitud"));

                Log.d("PRINCIPALES", contenidoJSON.getJSONObject(i).getString("nombre"));


            }

        }

        private void BUSQUEDA() throws JSONException{


            variables.array_productos_id.clear();
            variables.array_productos_titulo.clear();
            variables.array_productos_foto.clear();
            variables.array_productos_precio.clear();
            variables.array_productos_cantidad.clear();
            variables.array_productos_descripcion.clear();
            variables.array_productos_lat.clear();
            variables.array_productos_lon.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_productos_id.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_titulo.add(contenidoJSON.getJSONObject(i).getString("nombre"));
                variables.array_productos_foto.add(contenidoJSON.getJSONObject(i).getString("img"));
                variables.array_productos_precio.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_cantidad.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_descripcion.add(contenidoJSON.getJSONObject(i).getString("descripcion"));
                variables.array_productos_lat.add(contenidoJSON.getJSONObject(i).getString("latitud"));
                variables.array_productos_lon.add(contenidoJSON.getJSONObject(i).getString("longitud"));


            }

        }

        private void Recomendados() throws JSONException{


            variables.array_productos_id_recomendados.clear();
            variables.array_productos_titulo_recomendados.clear();
            variables.array_productos_foto_recomendados.clear();
            variables.array_productos_precio_recomendados.clear();
            variables.array_productos_cantidad_recomendados.clear();
            variables.array_productos_descripcion_recomendados.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_productos_id_recomendados.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_titulo_recomendados.add(contenidoJSON.getJSONObject(i).getString("nombre"));
                variables.array_productos_foto_recomendados.add(contenidoJSON.getJSONObject(i).getString("img"));
                variables.array_productos_precio_recomendados.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_cantidad_recomendados.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_descripcion_recomendados.add(contenidoJSON.getJSONObject(i).getString("id"));


            }

        }

        private void RecomendadosNew() throws JSONException{


            variables.array_productos_id_recomendados_new.clear();
            variables.array_productos_titulo_recomendados_new.clear();
            variables.array_productos_foto_recomendados_new.clear();
            variables.array_productos_precio_recomendados_new.clear();
            variables.array_productos_cantidad_recomendados_new.clear();
            variables.array_productos_descripcion_recomendados_new.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_productos_id_recomendados_new.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_titulo_recomendados_new.add(contenidoJSON.getJSONObject(i).getString("nombre"));
                variables.array_productos_foto_recomendados_new.add(contenidoJSON.getJSONObject(i).getString("img"));
                variables.array_productos_precio_recomendados_new.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_cantidad_recomendados_new.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_descripcion_recomendados_new.add(contenidoJSON.getJSONObject(i).getString("id"));

                Log.d("RECOEMNDADOS", contenidoJSON.getJSONObject(i).getString("nombre"));


            }

        }

        private void OFERTAS() throws JSONException{


            variables.array_productos_id_oferta.clear();
            variables.array_productos_titulo_oferta.clear();
            variables.array_productos_foto_oferta.clear();
            variables.array_productos_precio_oferta.clear();
            variables.array_productos_cantidad_oferta.clear();
            variables.array_productos_descripcion_oferta.clear();

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.array_productos_id_oferta.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_titulo_oferta.add(contenidoJSON.getJSONObject(i).getString("nombre"));
                variables.array_productos_foto_oferta.add(contenidoJSON.getJSONObject(i).getString("img"));
                variables.array_productos_precio_oferta.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_cantidad_oferta.add(contenidoJSON.getJSONObject(i).getString("id"));
                variables.array_productos_descripcion_oferta.add(contenidoJSON.getJSONObject(i).getString("id"));

                Log.d("OFERTAS", contenidoJSON.getJSONObject(i).getString("nombre"));


            }

        }

        private void ViISITADO() throws JSONException{

            for (int i = 0; i < contenidoJSON.length(); i++) {

                variables.visitado = contenidoJSON.getJSONObject(0).getString("id");

            }

        }

        private void Venta() throws JSONException {

             variables.id_venta =  contenidoJSON.getJSONObject(0).getString("id");

        }

        private void Marcador(String m) throws JSONException {

            if(m.equals("2")){

                Login();

            }else if(m.equals("3")){

                Publicidad();

            }else if(m.equals("4")){

                Servicios();

            }else if(m.equals("7")){

                SERIES();

            }else if(m.equals("6")){

                Venta();

            }else if(m.equals("10")){

                Slider();

            }else if(m.equals("11")){

                Productos();

            }else if(m.equals("12")){

                Recomendados();

            }else if(m.equals("13")){

                RecomendadosNew();

            }else if(m.equals("14")){

                OFERTAS();

            }else if(m.equals("15")){

                BUSQUEDA();

            }else if(m.equals("16")){

                Categorias();

            }else if(m.equals("17")){

                PRINCIPALES();

            }else if(m.equals("20")){

                IMAGENES();

            }else if(m.equals("18")){

                ViISITADO();

            }

        }

        @Override
        protected String doInBackground(String... params) {

            String cadena = params[0];

            URL url = null; // url de donde queremos obtener la informacion

            String devuelve = "";

            if(params[1]=="1"){  //consulta por id

                try {
                    url = new URL(cadena);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //abrir la coneccion
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0" +
                            "(Linux; Android 1.5; es-ES) Ejemplo HTTP");

                    int respuesta = connection.getResponseCode();
                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK){

                        InputStream in = new BufferedInputStream(connection.getInputStream());  //Preparo la cadena de entrada

                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));  //Le introdusco en un BufferReader

                        String line;
                        while ((line = reader.readLine()) != null){
                            result.append(line); //pasa toda la entrada al StringBuilder
                        }

                        //creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto
                        respuestaJSON = new JSONObject(result.toString()); //Creo un JSONObject apartir de un JSONObject

                        variables.resultJSON = respuestaJSON.getString("estado");//Estado es el nombre del campo en el JSON

                        Log.d("JSON", variables.resultJSON.toString());

                        if (variables.resultJSON.equals("1")){ //hay alumnos a mostrar

                            variables.error = "1";

                            contenidoJSON = respuestaJSON.getJSONArray("oficinas"); //estado es el nombre del campo en el JSON

                            Marcador(params[2]);

                        }
                        else if (variables.resultJSON.equals("2")){

                            variables.error = "0";
                        }


                    }

                }catch (MalformedURLException e){
                    devuelve = e.toString();
                    Log.d("JSON", e.toString());
                }catch (IOException e) {
                    devuelve = e.toString();
                    Log.d("JSON", e.toString());
                } catch (JSONException e) {
                    devuelve = e.toString();
                    Log.d("JSON", e.toString());
                }

                return devuelve;

            }

            return null;
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onPostExecute(String s) {


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }

    //POST -----------------------------------------

    public static class Insert extends AsyncTask<String,Void,String> {

        Variables variables = new Variables();

        JSONObject jsonparam = new JSONObject();

        private void ENVIO() throws JSONException {

            if (variables.opcion.equals("0")){

                jsonparam.put("nombre", variables.nombre);
                jsonparam.put("telefono", variables.telefono);
                jsonparam.put("direccion", variables.direccion);
                jsonparam.put("email", variables.email);
                jsonparam.put("password", variables.password);

            }

            if (variables.opcion.equals("1")){

                jsonparam.put("id_cliente", variables.id);
                jsonparam.put("pago", variables.amount);
                jsonparam.put("productos", variables.productos);

            }

            if (variables.opcion.equals("2")){

                jsonparam.put("id_compra", variables.id_venta);
                jsonparam.put("code", variables.code_paypal);

            }

            if (variables.opcion.equals("3")){

                jsonparam.put("id_usuario", variables.id);
                jsonparam.put("id_travel", variables.item_id);
                jsonparam.put("comentario",variables.item_comentario);

            }

            if (variables.opcion.equals("4")){

                jsonparam.put("id_usuario", variables.id);
                jsonparam.put("id_travel", variables.item_id);

            }

        }

        @Override
        protected String doInBackground(String... params) {

            String cadena = params[0];

            URL url = null; // url de donde queremos obtener la informacion

            String devuelve = "";

            if(params[1]=="4"){  //update

                try {
                    HttpURLConnection urlConn;

                    DataOutputStream printout;
                    DataInputStream input;
                    url = new URL(cadena);
                    urlConn = (HttpURLConnection) url.openConnection();
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    urlConn.setRequestProperty("Accept", "application/json");
                    urlConn.connect();
                    //creo el objeto json

                    ENVIO();

                    //envio los parametros post.
                    OutputStream os = urlConn.getOutputStream();
                    BufferedWriter write = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    write.write(jsonparam.toString());
                    write.flush();
                    write.close();

                    int respuesta = urlConn.getResponseCode();

                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK){
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                        while ((line = br.readLine()) != null){
                            result.append(line);
                        }

                        JSONObject respuestaJSON = new JSONObject(result.toString());

                        String resultJSON = respuestaJSON.getString("estado");

                        if (resultJSON == "1"){ //alumno actualizado correctamente
                            //variables.error = "1";
                        }else if(resultJSON == "2"){
                            //variables.error = "0";
                        }

                    }

                }catch (MalformedURLException e){
                    variables.error = e.toString();
                }catch (IOException e) {
                    variables.error = e.toString();
                } catch (JSONException e) {
                    variables.error = e.toString();
                }

                return devuelve;

            }

            return null;
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onPostExecute(String s) {

            Log.d("LEANDRO", variables.error);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }


}
