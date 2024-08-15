package tarea;

import lombok.*;

@NoArgsConstructor
@Getter @Setter @ToString
public class Producto {

    private String nombre;
    private double precio;
    private int stock;
    private int cantidad;
    
    
    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.cantidad = 0;
    }
    
}
