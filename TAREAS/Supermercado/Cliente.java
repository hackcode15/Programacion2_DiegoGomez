package tarea;

import lombok.*;
import java.util.*;

@NoArgsConstructor
@Getter @Setter
public class Cliente extends Humane {
    
    private boolean mayorista;
    private ArrayList<Producto> productosComprados;
    
    public Cliente(String nombre, String apellido, int dni, boolean mayorista){
        super(nombre, apellido, dni);
        this.mayorista = mayorista;
        productosComprados = new ArrayList<Producto>();
    }
    
    public void comprarProductos(Producto producto, int cantidad){
        if(producto.getStock() >= cantidad){
            productosComprados.add(producto);
            producto.setCantidad(cantidad);
            
            if(producto.getStock() == cantidad){
                producto.setStock(0);
            }else{
                producto.setStock(producto.getStock() - cantidad);
            }
            
        }else{
            System.out.println("El producto \"" + producto.getNombre() + "\" esta sin stock");
        } 
    }
    
    
    @Override
    public String toString(){
        return super.toString() + "\nMayorista: " + mayorista;
    }
    
}