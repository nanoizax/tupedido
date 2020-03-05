package com.izax.devs.wrap.Items;

public class Datos {

    //atributos
    protected String titulo;

    protected  long id;

    public Datos(String titulo) {

        this.titulo = titulo;

        this.id = id;

    }

    //Obtener datos con metodo get


    public String getTitulo() {
        return titulo;
    }
    //asignar datos
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }


    public long getId() {
        return id;
    }
    //asignar datos
    public void setId(long id){
        this.id = id;
    }


}
