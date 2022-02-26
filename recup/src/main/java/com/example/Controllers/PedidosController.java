package com.example.Controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.Models.Pedidos;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

    public static ArrayList<Pedidos> pedidos;

    // Devuelve el listado de pedidos con todos sus campos. No es necesario que se
    // devuelva el número de productos de cada pedido.

    public PedidosController() {
        pedidos = new ArrayList<Pedidos>();
    }

    @GetMapping("Pedidos")
    public List<Pedidos> GetAllPedidos() {
        return pedidos;
    }

    @GetMapping("/v2/pedidos")
    public static Pedidos getAllPedidos() {
        return PedidosController.getAllPedidos();
    }

}