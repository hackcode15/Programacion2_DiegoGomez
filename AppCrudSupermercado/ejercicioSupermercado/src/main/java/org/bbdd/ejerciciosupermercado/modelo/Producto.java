package org.bbdd.ejerciciosupermercado.modelo;

import lombok.*;

@NoArgsConstructor
@Getter @Setter @ToString
public class Producto {

    private int id_producto;
    private String nombre;
    private double precio;
    private int stock;
    
    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
}
