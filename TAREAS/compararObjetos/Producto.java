package tarea.compararProductos;

import java.util.Objects;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString 
public class Producto {
    
    private int cod_producto;
    private String nombre;
    private int stock;
    
    @Override
    public int hashCode(){
        return Integer.hashCode(cod_producto);
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Producto producto = (Producto) obj;
        
        return this.cod_producto == producto.cod_producto;
        
    }
    
}
