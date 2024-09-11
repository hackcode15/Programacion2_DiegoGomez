package tarea.crudTienda_Collections;

import lombok.*;

/*
*   Generacion automatica de 
*   Constructores con y sin parametros
*   Metodos Getter, Setter y el ToString
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class Cliente {
    
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    
}
