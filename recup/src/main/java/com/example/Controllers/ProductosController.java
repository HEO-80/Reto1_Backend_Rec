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

            new Productos(1, "Camiseta1", 24, "https://img.icons8.com/emoji/96/000000/keyboard-emoji.png"),
            new Productos(2, "Camiseta2", 15, "https://img.icons8.com/office/80/000000/mouse.png"),
            new Productos(3, "Camiseta3", 210,
                    "https://img.icons8.com/external-vitaliy-gorbachev-lineal-color-vitaly-gorbachev/60/000000/external-screen-ecommerce-vitaliy-gorbachev-lineal-color-vitaly-gorbachev.png"),
            new Productos(4, "Pantalones1", 115, "https://img.icons8.com/color/96/000000/printer-door-open.png"),
            new Productos(5, "Pantalones2", 180, "https://img.icons8.com/office/80/000000/video-projector.png"),
            new Productos(6, "Abrigo corto", 300, "https://img.icons8.com/fluency/96/000000/widescreen-tv.png"),
            new Productos(7, "Abrigo Largo", 360.00,
                    "https://img.icons8.com/external-icongeek26-outline-gradient-icongeek26/64/000000/external-phone-essentials-icongeek26-outline-gradient-icongeek26.png"),
            new Productos(8, "Zapatos", 80.00, "https://img.icons8.com/color/96/000000/smartphone-tablet.png"),
            new Productos(9, "Zapatillas", 500.00, "https://img.icons8.com/fluency/96/000000/laptop.png")));

    public static ArrayList<Productos> productosMyList = new ArrayList(Arrays.asList());
    public static ArrayList<Productos> shoppingList = new ArrayList<>(Arrays.asList());

    @GetMapping("Productos")
    public List<Productos> GetAllProductos() {
        return productos;
    }

}