package org.pootup.pootup2cuatri.practica;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {
    
    @Setter @Getter private String nombre;
    @Setter @Getter private String apellido;
    
}