package com.example.Models;

import java.util.ArrayList;
import java.util.Calendar;

public class Pedidos {
    public int IdPedido;
    public String FechaCreacion;
    public String NombreUsuario;
    public OrderStatus Estado;
    public double PrecioTotal;
    public static int contadorIdPedido;

    public ArrayList<OrderProduct> listaProductos;
    public ArrayList<Productos> listaFavoritos;

    public Pedidos() { // el Id es auto incemental
        IdPedido = contadorIdPedido;
        contadorIdPedido++;
        listaProductos = new ArrayList<OrderProduct>();
        listaFavoritos = new ArrayList<Productos>();
        FechaCreacion = Calendar.getInstance().getTime().toString();
        NombreUsuario = "Default User";
        Estado = OrderStatus.PENDIENTE;
    }

    public Pedidos(String fechaCreacion, String nombreUsuario, OrderStatus Estado) {
        IdPedido = contadorIdPedido;
        contadorIdPedido++;
        FechaCreacion = fechaCreacion;
        NombreUsuario = nombreUsuario;
        Estado = OrderStatus.PENDIENTE;
        listaProductos = new ArrayList<OrderProduct>();
        listaFavoritos = new ArrayList<Productos>();
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public OrderStatus getEstado() {
        return Estado;
    }

    public void setEstado(OrderStatus estado) {
        Estado = estado;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int idPedido) {
        IdPedido = idPedido;
    }

    public ArrayList<OrderProduct> getListaProductos() {
        return listaProductos;
    }

    public void setProductitos(ArrayList<OrderProduct> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Productos> getListaFavoritos() {
        return listaFavoritos;
    }

    public void setListaFavoritos(ArrayList<Productos> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }

    public double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        PrecioTotal = precioTotal;
    }

    // Metodo agregar prodcuto en lista
    public void addCantidadOfProducto(Productos producto) {
        for (OrderProduct orderProduct : listaProductos) {
            if (orderProduct.getProductos().idProducto == producto.idProducto) {
                orderProduct.autoCantidad();
                PrecioTotal += producto.Precio;
                return;
            }
        }
        listaProductos.add(new OrderProduct(producto, 1));
        PrecioTotal += producto.Precio;
    }

    // Metodo restar prodcuto de la lista
    public void restarCantidadOfProducto(Productos producto) {
        for (OrderProduct orderProduct : listaProductos) {
            if (orderProduct.getProductos().idProducto == producto.idProducto && orderProduct.CantProductos > 0) {
                orderProduct.restaCantidad();
                PrecioTotal -= producto.Precio;
                return;
            }
        }
    }
}
