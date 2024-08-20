package org.bbdd.ejerciciosupermercado.vista;

import lombok.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.bbdd.ejerciciosupermercado.modelo.ProductoDAO;

@Getter @Setter
public class PanelPrincipal extends JPanel {
    
    private JTextArea miArea;
    private JButton limpiar;
    
    private JMenuBar miBarra;
    private JMenu menu;
    private JMenu crud;
    private JMenuItem agregar_producto;
    private JMenuItem actualizar_producto;
    private JMenuItem eliminar_producto;
    private JMenuItem listar_producto;
    
    public PanelPrincipal(){
        
        // ---------------------------------------------------------------------------
        setLayout(new BorderLayout());
        
        // ---------------------------------------------------------------------------
        miBarra = new JMenuBar();
        
        // ---------------------------------------------------------------------------
        menu = new JMenu("Menu");
        
        crud = new JMenu("CRUD");
        
        // ---------------------------------------------------------------------------
        agregar_producto = new JMenuItem("Agregar Producto");
        actualizar_producto = new JMenuItem("Actualizar Producto");
        eliminar_producto = new JMenuItem("Eliminar Producto");
        listar_producto = new JMenuItem("Listar Producto");
        
        // ---------------------------------------------------------------------------
        crud.add(agregar_producto);
        crud.add(actualizar_producto);
        crud.add(eliminar_producto);
        crud.add(listar_producto);
        
        // ---------------------------------------------------------------------------
        menu.add(crud);
        miBarra.add(menu);
        
        // ---------------------------------------------------------------------------
        miArea = new JTextArea();
        miArea.setEditable(false);
        
        // ---------------------------------------------------------------------------
        JPanel panel_inferior = new JPanel();
        panel_inferior.setLayout(new FlowLayout());
        
        limpiar = new JButton("Limpiar");
        
        limpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                miArea.setText("");
            }
        });
        
        panel_inferior.add(limpiar);
        
        // ---------------------------------------------------------------------------
        add(miBarra, BorderLayout.NORTH);
        //add(miArea, BorderLayout.CENTER);
        add(new JScrollPane(miArea), BorderLayout.CENTER);
        add(panel_inferior, BorderLayout.SOUTH);
        
        
        
    }
    
    
}
