package org.pootup.pootup2cuatri.practica;

// Clase 2 - 13/8/24

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Caja {

    @Setter @Getter private int nroCaja;
    //@Setter @Getter private String nombre;
    //@Setter @Getter private String apellido;
    @Setter @Getter private Cliente cliente;
    
}


