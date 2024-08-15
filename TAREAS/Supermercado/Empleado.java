package tarea;

import lombok.*;

@NoArgsConstructor
@Getter @Setter
public class Empleado extends Humane {

    private double sueldo;
    
    public Empleado(String nombre, String apellido, int dni, double sueldo){
        super(nombre, apellido, dni);
        this.sueldo = sueldo;    
    }
    
    @Override
    public String toString(){
        return "\n" + super.toString() + "\nSueldo: $" + sueldo;
    }
    
}
