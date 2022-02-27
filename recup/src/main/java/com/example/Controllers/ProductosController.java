package com.example.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.ElementNotFoundException;
import com.example.Models.Productos;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductosController {
        public static ArrayList<Productos> productos = new ArrayList(Arrays.asList(

                        new Productos(1, "Teclado", 24, "https://img.icons8.com/emoji/96/000000/keyboard-emoji.png"),
                        new Productos(2, "Mouse", 15, "https://img.icons8.com/office/80/000000/mouse.png"),
                        new Productos(3, "Monitor", 210,
                                        "https://img.icons8.com/external-vitaliy-gorbachev-lineal-color-vitaly-gorbachev/60/000000/external-screen-ecommerce-vitaliy-gorbachev-lineal-color-vitaly-gorbachev.png"),
                        new Productos(4, "Impresora", 115,
                                        "https://img.icons8.com/color/96/000000/printer-door-open.png"),
                        new Productos(5, "Proyector", 180,
                                        "https://img.icons8.com/office/80/000000/video-projector.png"),
                        new Productos(6, "Pantalla", 300, "https://img.icons8.com/fluency/96/000000/widescreen-tv.png"),
                        new Productos(7, "Móvil", 360.00,
                                        "https://img.icons8.com/external-icongeek26-outline-gradient-icongeek26/64/000000/external-phone-essentials-icongeek26-outline-gradient-icongeek26.png"),
                        new Productos(8, "Tablet", 80.00,
                                        "https://img.icons8.com/color/96/000000/smartphone-tablet.png"),
                        new Productos(9, "Laptop", 500.00, "https://img.icons8.com/fluency/96/000000/laptop.png")));

        public static ArrayList<Productos> productosMyList = new ArrayList(Arrays.asList());
        public static ArrayList<Productos> shoppingList = new ArrayList<>(Arrays.asList());

        @GetMapping("ProductosMyList")
        public List<Productos> GetProductosMyList() {
                return productosMyList;
        }

        @GetMapping("Productos")
        public List<Productos> GetAllProductos() {
                return productos;
        }

        @GetMapping("Productos/{NombreProducto}")
        public static Productos ProductoByNombre(@PathVariable("NombreProducto") String nombreProducto) {
                return FindProductoByNombreProducto(nombreProducto);
        }

        public static Productos FindProductoByNombreProducto(String nombreProducto) {
                for (Productos producto : productos) {
                        if (producto.getNombreProducto() == nombreProducto) {
                                return producto;
                        }
                }
                throw new ElementNotFoundException();
        }

        public static Productos FindProductoByPrecio(double precio) {
                for (Productos producto : productos) {
                        if (producto.getPrecio() == precio) {
                                return producto;
                        }
                }
                throw new ElementNotFoundException();
        }

        public static Productos FindProductoByIdProducto(int idProducto) {
                for (Productos producto : productos) {
                        if (producto.getIdProducto() == idProducto) {
                                return producto;
                        }
                }
                throw new ElementNotFoundException();
        }

        public static ArrayList<Productos> GetProductosByPedidoId(int idPedido) {
                ArrayList<Productos> result = productos;
                if (idPedido != 0) {
                        result = new ArrayList<Productos>();
                        for (Productos producto : productos) {
                                if (producto.idProducto == idPedido) {
                                        result.add(producto);
                                }
                        }

                }
                return result;
        }

        @PostMapping("/add/Productos")
        public Productos AddProducto(@RequestBody Productos newProducto) {
                productos.add(newProducto);
                return newProducto;
        }

        // @PutMapping("/Productos/{idProducto}")
        @PutMapping("/Productos/{idProducto}")
        public Productos updateProductos(@PathVariable("idProducto") int idProducto,
                        @RequestBody Productos updateProducto)
                        throws Exception {
                Productos m = FindProductoByIdProducto(idProducto);
                m.setPrecio(updateProducto.getPrecio());
                return m;
        }

        // @DeleteMapping("/Productos/{idProducto}")
        @DeleteMapping("/Productos/{idProducto}")
        public Productos DeleteProducto(@PathVariable("idProducto") int idProducto) {
                Productos producto = FindProductoByIdProducto(idProducto);
                productos.remove(idProducto);
                return producto;
        }

        @GetMapping("/admin/productos")
        public List<Productos> getAllProductos() {
                return productos;
        }

}