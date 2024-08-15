package tarea;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Humane {

    private String nombre;
    private String apellido;
    private int dni;
    
    @Override
    public String toString(){
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", DNI: " + dni;
    }
    
}
