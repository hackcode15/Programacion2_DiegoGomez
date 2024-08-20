package org.bbdd.ejerciciosupermercado.vista;

import lombok.*;
import javax.swing.*;
import java.awt.*;

@Getter @Setter
public class MarcoAgregar extends JFrame {

    private JPanel panel_principal, panel_superior, panel_central, panel_inferior;
    
    private JLabel txt_texto, txt_nombre, txt_precio, txt_cantidad;
    private JTextField cmp_nombre, cmp_precio, cmp_cantidad;
    
    private JButton btn_cargar;
    
    public MarcoAgregar(){

        setTitle("Agregar productos");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        
        inicializarComponentes();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    private void inicializarComponentes(){
        
        
        panel_principal = new JPanel();
        panel_principal.setLayout(new BorderLayout());
        
        
        panel_superior = new JPanel();
        panel_superior.setLayout(new FlowLayout());
        txt_texto = new JLabel("AGREGAR PRODUCTO");
        txt_texto.setFont(new Font("Arial Black", Font.ITALIC, 18));
        panel_superior.add(txt_texto);
        
        
        panel_central = new JPanel();
        panel_central.setLayout(new MiLayout());
        txt_nombre = new JLabel("Nombre:");
        cmp_nombre = new JTextField(20);
        txt_precio = new JLabel("Precio:");
        cmp_precio = new JTextField(20);
        txt_cantidad = new JLabel("Cantidad:");
        cmp_cantidad = new JTextField(20);
        panel_central.add(txt_nombre);
        panel_central.add(cmp_nombre);
        panel_central.add(txt_precio);
        panel_central.add(cmp_precio);
        panel_central.add(txt_cantidad);
        panel_central.add(cmp_cantidad);
        
        
        panel_inferior = new JPanel();
        panel_inferior.setLayout(new FlowLayout());
        btn_cargar = new JButton("Cargar Producto");
        panel_inferior.add(btn_cargar);
        
        
        panel_principal.add(panel_superior, BorderLayout.NORTH);
        panel_principal.add(panel_central, BorderLayout.CENTER);
        panel_principal.add(panel_inferior, BorderLayout.SOUTH);
        
        
        add(panel_principal);
        
        
    }
    
}
