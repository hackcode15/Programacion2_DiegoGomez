package tarea.crudTiendaBD;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class Cliente {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    
}
