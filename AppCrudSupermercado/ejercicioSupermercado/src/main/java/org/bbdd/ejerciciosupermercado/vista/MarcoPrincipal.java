package org.bbdd.ejerciciosupermercado.vista;

import lombok.*;
import javax.swing.*;

@Getter
public class MarcoPrincipal extends JFrame {

    private PanelPrincipal panel_principal;
    
    public MarcoPrincipal(){
        
        setTitle("Supermercado");
        setBounds(600, 600, 600, 600);
        setLocationRelativeTo(null);
        
        panel_principal = new PanelPrincipal();
        add(panel_principal);
        
    }
    
}


