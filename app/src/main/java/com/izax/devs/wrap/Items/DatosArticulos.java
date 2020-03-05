package com.izax.devs.wrap.Items;

public class DatosArticulos {

    //atributos
    protected String titulo, precio, cantidad, total;

    protected String img;

    protected  long id;

    public DatosArticulos(String titulo,String precio,String cantidad,String total, String img) {

        this.titulo = titulo;

        this.precio = precio;

        this.cantidad = cantidad;

        this.total = total;

        this.img = img;

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

    public String getPrecio() {
        return precio;
    }
    //asignar datos
    public void setPrecio(String precio){
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }
    //asignar datos
    public void setCantidad(String cantidad){
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }
    //asignar datos
    public void setTotal(String total){
        this.titulo = total;
    }

    public String getImg() {
        return img;
    }
    //asignar datos
    public void setImg(String img){
        this.img = img;
    }

    public long getId() {
        return id;
    }
    //asignar datos
    public void setId(long id){
        this.id = id;
    }


}
