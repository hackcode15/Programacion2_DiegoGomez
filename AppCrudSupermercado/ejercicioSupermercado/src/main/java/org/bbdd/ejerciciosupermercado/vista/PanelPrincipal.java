package org.bbdd.ejerciciosupermercado.vista;

import lombok.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

@Getter @Setter
public class PanelPrincipal extends JPanel {
    
    private JButton limpiar;
    
    private JMenuBar miBarra;
    private JMenu menu;
    private JMenu crud;
    private JMenuItem agregar_producto;
    private JMenuItem actualizar_producto;
    private JMenuItem eliminar_producto;
    
    private JMenu listar_producto_filtrar;
    private JMenuItem ver_info;
    
    private JMenuItem filtrar_por_precio;
    
    private JPanel panel_inferior, panel_superior;
    
    private JLabel txt_titulo;
    
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    
    public PanelPrincipal(){
        
        // ---------------------------------------------------------------------------
        setLayout(new BorderLayout());
        
        // ---------------------------------------------------------------------------
        miBarra = new JMenuBar();
        
        // ---------------------------------------------------------------------------
        menu = new JMenu("Menu");

        // ---------------------------------------------------------------------------
        crud = new JMenu("CRUD");
        
        agregar_producto = new JMenuItem("Agregar Producto");
        actualizar_producto = new JMenuItem("Actualizar Producto");
        eliminar_producto = new JMenuItem("Eliminar Producto");
        
        listar_producto_filtrar = new JMenu("Listar / Filtrar Productos");
        
        ver_info = new JMenuItem("Ver toda la info");
        
        filtrar_por_precio = new JMenuItem("Filtrar por precio");
        
        listar_producto_filtrar.add(ver_info);
        
        listar_producto_filtrar.add(filtrar_por_precio);
        
        crud.add(agregar_producto);
        crud.add(actualizar_producto);
        crud.add(eliminar_producto);
        crud.add(listar_producto_filtrar);
        // ---------------------------------------------------------------------------

        menu.add(crud);
        
        miBarra.add(menu);
        
        // ---------------------------------------------------------------------------
        
        panel_superior = new JPanel();
        panel_superior.setLayout(new GridLayout(2, 1));
        
        txt_titulo = new JLabel("CRUD DE PRODUCTOS");
        txt_titulo.setFont(new Font("Arial Black", Font.PLAIN, 18));
        txt_titulo.setHorizontalAlignment(JLabel.CENTER);
        
        panel_superior.add(miBarra);
        panel_superior.add(txt_titulo);
        
        // ---------------------------------------------------------------------------
        
        // ---------------------------------------------------------------------------
        panel_inferior = new JPanel();
        panel_inferior.setLayout(new FlowLayout());
        
        limpiar = new JButton("Limpiar");
        
        limpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //miArea.setText("");
                modeloTabla.setRowCount(0); // limpiamos las filas de la tabla
            }
        });
        
        panel_inferior.add(limpiar);
        
        // -----------
        
        // Crear el modelo de tabla y definimos que no sean editables las filas y columnas
        modeloTabla = new DefaultTableModel(){
            // Sobreescribimos el metodo
            @Override
            public boolean isCellEditable(int filas, int columnas){
                return false;
            }
        };
        
        // Agregamos las columnas de manera manual
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Stock");
        
        // Crear la tabla y agregarla al panel
        tablaProductos = new JTable(modeloTabla);
        
        add(new JScrollPane(tablaProductos));
        
        // ---------------------------------------------------------------------------
        add(panel_superior, BorderLayout.NORTH);
        
        add(panel_inferior, BorderLayout.SOUTH);
        
        
        
    }
    
    
}
