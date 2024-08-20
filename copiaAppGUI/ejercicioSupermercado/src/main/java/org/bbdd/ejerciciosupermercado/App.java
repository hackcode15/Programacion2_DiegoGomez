package org.bbdd.ejerciciosupermercado;

import javax.swing.*;
import org.bbdd.ejerciciosupermercado.controlador.*;
import org.bbdd.ejerciciosupermercado.vista.*;

public class App {

    public static void main(String[] args) {
        
        MarcoPrincipal marco_principal = new MarcoPrincipal();
        
        ControladorProducto con = new ControladorProducto(marco_principal);
        
        marco_principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco_principal.setVisible(true);
        
    }
    
}
