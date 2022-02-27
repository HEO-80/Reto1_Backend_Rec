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

    @GetMapping("Pedidos/{idPedido}")
    public static Pedidos GetPedidosById(@PathVariable("idPedido") int idPedido) {
        // Error con los HttpServletRequest y HttpServletResponse
        var p = FindPedidosById(idPedido);
        return p;
    }

    public static Pedidos FindPedidosById(int idPedido) {
        for (Pedidos pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }

    @GetMapping("/v2/Pedidos/new")
    public static Pedidos addPedido() {
        pedidos.add(new Pedidos());
        return pedidos.get(pedidos.size() - 1); // devuelve el ultimo elemento de la lista (el que hemos añadido)
    }

    @DeleteMapping("/v2/Pedidos/{idPedido}")
    public void DeletePedidos(@PathVariable("idPedido") int idPedido) throws Exception {
        Pedidos p = FindPedidosById(idPedido);
        pedidos.remove(p);
    }

    @PutMapping("/v2/Pedidos/{idPedido}")
    public Pedidos UpdatePedidos(@RequestBody Pedidos updatePedidos,
            @PathVariable("idPedido") int idPedido) throws Exception {
        Pedidos p = FindPedidosById(idPedido);
        p.setIdPedido(updatePedidos.getIdPedido());
        return p;
    }

    public static ArrayList<Pedidos> getPedidosByIdPedido(int idPedido) {
        ArrayList<Pedidos> p = pedidos;
        if (idPedido != 0) {
            p = new ArrayList<Pedidos>();
            for (Pedidos pedido : pedidos) {
                if (pedido.getIdPedido() == idPedido)
                    p.add(pedido);
            }
        }
        return p;
    }

    @GetMapping("/v2/Pedidos/{idPedido}/new/{idProducto}")
    public static void addProductoToPedidos(@PathVariable("idPedido") int idPedido,
            @PathVariable("idProducto") int idProducto) {
        PedidosController.GetPedidosById(idPedido)
                .addCantidadOfProducto(ProductosController.FindProductoByIdProducto(idProducto));
    }

    @DeleteMapping("/v2/Pedidos/{idPedido}/delete/{idProducto}")
    public static void deleteProductoFromPedidos(@PathVariable("idPedido") int idPedido,
            @PathVariable("idProducto") int idProducto) {
        try {
            PedidosController.GetPedidosById(idPedido)
                    .restarCantidadOfProducto(ProductosController.FindProductoByIdProducto(idProducto));
        } catch (Exception e) {

        }
    }

}