package org.bbdd.ejerciciosupermercado.controlador;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import org.bbdd.ejerciciosupermercado.modelo.*;
import org.bbdd.ejerciciosupermercado.vista.*;

public class ControladorProducto implements ActionListener {

    private MarcoPrincipal vista;
    private ProductoDAO productoDAO;
    
    public ControladorProducto(MarcoPrincipal vista){
        this.vista = vista;
        this.productoDAO = new ProductoDAO();
        asignarOyentes();
    }
    
    private void asignarOyentes(){
        PanelPrincipal panel = vista.getPanel_principal();
        // Agregar los eventos a las items menu
        panel.getAgregar_producto().addActionListener(this);
        panel.getActualizar_producto().addActionListener(this);
        panel.getEliminar_producto().addActionListener(this);
        panel.getListar_producto().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        PanelPrincipal panel = vista.getPanel_principal();
        Object fuente_evento = e.getSource();
        
        
        if(fuente_evento == panel.getAgregar_producto()){
            System.out.println("Has seleccionado agregar");
            //panel.getMiArea().append("Has seleccionado agregar\n");
            
            /*String nombreProducto = JOptionPane.showInputDialog(panel, "Ingrese el nombre del producto:");
            double precioProducto = Double.parseDouble(JOptionPane.showInputDialog(panel, "Ingrese el precio del producto:"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog(panel, "Ingrese la cantidad a cargar:"));
            
            int filasAfectadas = productoDAO.agregarProducto(nombreProducto, precioProducto, stock);
            
            if(filasAfectadas != 0){
                JOptionPane.showMessageDialog(panel, "Producto \"" + nombreProducto + "\" agregado con exito");
            }else{
                JOptionPane.showMessageDialog(panel, "Error al agregar producto");
            }*/
            
            //MarcoAgregar marcoAdd = new MarcoAgregar();
            //marcoAdd.setVisible(true);
            
            //panel.getMiArea().append("Has seleccionado agregar\n");
            
            abrirMarcoAgregar();
            
        }else if(fuente_evento == panel.getActualizar_producto()){
            System.out.println("Has seleccionado actualizar");
            
            /*int id = Integer.parseInt(JOptionPane.showInputDialog(panel, "Ingrese el id del producto a actualizar"));
            String nombreProducto = JOptionPane.showInputDialog(panel, "Ingrese el nuevo nombre del producto:");
            double precioProducto = Double.parseDouble(JOptionPane.showInputDialog(panel, "Ingrese el nuevo precio del producto:"));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(panel, "Ingrese la cantidad a cargar:"));
            
            int filasAfectadas = productoDAO.actualizarProducto(nombreProducto, precioProducto, cantidad, id);
            
            if(filasAfectadas != 0){
                JOptionPane.showMessageDialog(panel, "Producto actualizado correctamente");
            }else{
                JOptionPane.showMessageDialog(panel, "Error al actualizar producto");
            }*/
            
            //panel.getMiArea().append("Has seleccionado actualizar\n");
            try{
                int id_buscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el id del producto a actualizar:"));

                if(productoDAO.existeElProducto(id_buscar)){
                    abrirMarcoActualizar(id_buscar);
                }else{
                    JOptionPane.showMessageDialog(vista, "Error: No existe un producto con id: \"" + id_buscar + "\"", "Error al buscar producto", JOptionPane.WARNING_MESSAGE);
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(vista, "Error: Debes ingresar un numero entero valido", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(fuente_evento == panel.getEliminar_producto()){
            
            System.out.println("Has seleccionado eliminar");
            
            /*int id = Integer.parseInt(JOptionPane.showInputDialog(panel, "Ingrese el id del producto a eliminar"));
            
            int filasAfectadas = productoDAO.eliminarProducto(id);
            
            if(filasAfectadas != 0){
                JOptionPane.showMessageDialog(panel, "Producto eliminado correctamente");
            }else{
                JOptionPane.showMessageDialog(panel, "Error al eliminar producto");
            }*/
            
            //panel.getMiArea().append("Has seleccionado eliminar\n");
            
            try{
                int id_buscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el id del producto a eliminar:"));

                if(productoDAO.existeElProducto(id_buscar)){
                    
                    productoDAO.eliminarProducto(id_buscar);
                    
                    JOptionPane.showMessageDialog(vista, "Producto eliminado correctamente", "Borrado de producto", JOptionPane.INFORMATION_MESSAGE);
                    
                }else{
                    JOptionPane.showMessageDialog(vista, "Error: No existe un producto con id: \"" + id_buscar + "\"", "Error al buscar producto", JOptionPane.WARNING_MESSAGE);
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(vista, "Error: Debes ingresar un numero entero valido", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
                        
        } else if(fuente_evento == panel.getListar_producto()){
            //System.out.println("Has seleccionado listar");
            
            panel.getMiArea().append("Lista de Productos\n");
            
            productoDAO.listarProductos()
                    .stream()
                    .map(p -> "Nombre: " + p.getNombre() + ", Precio: $" + p.getPrecio())
                    .forEach(p -> panel.getMiArea().append(p + "\n"));
            
            //productoDAO.listarProductos().stream().forEach(p -> panel.getMiArea().append(p.toString() + "\n"));
            
        }
        
    }
    
    // Metodo establecer la carga de productos a la BBDD
    public void configuraMarcoAgregar(MarcoAgregar marco){
        
        // Agregamos un evento al boton cargar productos
        marco.getBtn_cargar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Has presionado el boton cargar");
                
                String nombreProducto = marco.getCmp_nombre().getText();
                
                double precioProducto;
                
                int cantidad;
                
                int filasAfectadas = 0;
                
                // Manejo de excepcion, de posible campos de textos vacios
                if(!marco.getCmp_precio().getText().isEmpty() && !marco.getCmp_cantidad().getText().isEmpty()){
                    
                    // Manejo de excepcion, de posible entrada de datos incorrecto
                    try{
                        
                        precioProducto = Double.parseDouble(marco.getCmp_precio().getText());
                        cantidad = Integer.parseInt(marco.getCmp_cantidad().getText());
                        
                        filasAfectadas = productoDAO.agregarProducto(nombreProducto, precioProducto, cantidad);

                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(vista, "Error: Debes ingresar un número entero válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(vista, "Error: Debes completar todos campos obligatorios", "Campos vacios", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // Si el agregado de productos fue correcto
                if(filasAfectadas != 0){
                    marco.dispose(); // Cerramos el marco agregar
                    JOptionPane.showMessageDialog(vista, "Producto cargado correctamente", "Carga de Producto", JOptionPane.INFORMATION_MESSAGE);
                }else{ // Si no limpiamos todos los campos y se vuelve a ingresar
                    //JOptionPane.showMessageDialog(vista, "Error al cargar producto \nIntentelo nuevamente");
                    //marco.getCmp_nombre().setText("");
                    marco.getCmp_precio().setText("");
                    marco.getCmp_cantidad().setText("");
                }
                
            }
        });
        
    }
    
    // Metodo para abrir el marco agregar
    public void abrirMarcoAgregar(){
        
        MarcoAgregar nuevoMarcoAgregar = new MarcoAgregar();
        nuevoMarcoAgregar.setVisible(true);
        configuraMarcoAgregar(nuevoMarcoAgregar);
        
        
    }
    
    public void configuraMarcoActualizar(MarcoActualizar marco, int id_buscar) {
        
        marco.getBtn_actualizar().addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                // tomo los valores de los JTextField
                double precioProducto;
                int cantidad;
                int filasAfectadas = 0;
                
                // Manejo de error por campos vacios
                if(!marco.getCmp_precio().getText().isEmpty() && !marco.getCmp_cantidad().getText().isEmpty()){
                    
                    // Manejo de error por errores de entrada de datos
                    try{
                        
                        precioProducto = Double.parseDouble(marco.getCmp_precio().getText());
                        cantidad = Integer.parseInt(marco.getCmp_cantidad().getText());
                        
                        filasAfectadas = productoDAO.actualizarProducto(id_buscar, precioProducto, cantidad);
                          
                    }catch(NumberFormatException ex){
                        // Error por dato incorrecto
                        JOptionPane.showMessageDialog(vista, "Error: Debes ingresar numeros enteros validos", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    
                }else{
                    // Error por campos vacios
                    JOptionPane.showMessageDialog(vista, "Error: Debes completar todos los campos obligatorios", "Error de Campos Vacios", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if(filasAfectadas != 0){
                    marco.dispose();
                    JOptionPane.showMessageDialog(vista, "Producto actualiazado correctamente", "Actualizacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    marco.getCmp_precio().setText("");
                    marco.getCmp_cantidad().setText("");
                }
                
            }
            
            
            
        });
        
    }
    
    // Metodo para abrir el marco actualizar
    public void abrirMarcoActualizar(int id_buscar){
        
        MarcoActualizar nuevoMarcoActualizar = new MarcoActualizar();
        nuevoMarcoActualizar.setVisible(true);
        configuraMarcoActualizar(nuevoMarcoActualizar, id_buscar);
        
    }

}
