package tarea;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Caja {
    
    private Empleado empleado;
    private int nroCaja;
    
    @Override
    public String toString(){
        return "\n" + empleado.toString() + "\nNro caja: " + nroCaja;
    }
    
}
