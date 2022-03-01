package com.example.Models;

public class Productos {
    public int idProducto;
    public String NombreProducto;
    public double Precio;
    public String Img;

    public Productos() {
    }

    public Productos(int idProducto, String nombreProducto, double precio, String img) {
        this.NombreProducto = nombreProducto;
        this.Precio = precio;
        this.idProducto = idProducto;
        this.Img = img;
    }

    public Productos(String nombreProducto, double precio) {
        this.NombreProducto = nombreProducto;
        this.Precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        idProducto = idProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

}
