package org.bbdd.ejerciciosupermercado.controlador;

import java.awt.FlowLayout;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import org.bbdd.ejerciciosupermercado.modelo.*;
import org.bbdd.ejerciciosupermercado.vista.*;

public class ControladorProducto implements ActionListener {

    private MarcoPrincipal vista;
    private ProductoDAO productoDAO;
    private PanelPrincipal panel;
    
    public ControladorProducto(MarcoPrincipal vista){
        this.vista = vista;
        this.productoDAO = new ProductoDAO();
        this.panel = new PanelPrincipal();
        asignarOyentes();
    }
    
    private void asignarOyentes(){
        panel = vista.getPanel_principal();
        // Agregar los eventos a las items menu
        panel.getAgregar_producto().addActionListener(this);
        panel.getActualizar_producto().addActionListener(this);
        panel.getEliminar_producto().addActionListener(this);
        
        panel.getVer_info().addActionListener(this);
        panel.getFiltrar_por_precio().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        panel = vista.getPanel_principal();
        Object fuente_evento = e.getSource();
        
        
        if(fuente_evento == panel.getAgregar_producto()){
            
            System.out.println("Has seleccionado agregar");
            
            abrirMarcoAgregar();
            
        }else if(fuente_evento == panel.getActualizar_producto()){
            
            System.out.println("Has seleccionado actualizar");
            
            try{
                int id_buscar = Integer.parseInt(JOptionPane.showInputDialog(vista, "Digite el id del producto a actualizar:", "Entrada de datos"));

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
            
            try{
                int id_buscar = Integer.parseInt(JOptionPane.showInputDialog(vista, "Digite el id del producto a eliminar:", "Entrada de datos"));

                if(productoDAO.existeElProducto(id_buscar)){
                    
                    productoDAO.eliminarProducto(id_buscar);
                    
                    JOptionPane.showMessageDialog(vista, "Producto eliminado correctamente", "Borrado de producto", JOptionPane.INFORMATION_MESSAGE);
                    
                }else{
                    JOptionPane.showMessageDialog(vista, "Error: No existe un producto con id: \"" + id_buscar + "\"", "Error al buscar producto", JOptionPane.WARNING_MESSAGE);
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(vista, "Error: Debes ingresar un numero entero valido", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
                        
        } else if(fuente_evento == panel.getVer_info()) {
            
            System.out.println("Has seleccionado ver info");
            
            verTodaLaInformacion();
            
        } else if(fuente_evento == panel.getFiltrar_por_precio()){
            
            System.out.println("Has seleccionado filtrar por precio");
            
            abrirPanelFiltrar();
            
        }
        
    }
    
    // Metodo para llenar la tabla
    public void verTodaLaInformacion(){
        
        // Obtengo la lista de producto de la BBDD
        List<Producto> listaProductos = productoDAO.listarProductos();
        
        // Limpio la tabla antes de llenarla
        panel.getModeloTabla().setRowCount(0);
        
        // Agrego los datos al JTabel - Forma Normal
        /*for(Producto producto : listaProductos){
            
            Object fila[] = {
                producto.getId_producto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
            };
            
            panel.getModeloTabla().addRow(fila);
            
        }*/
        
        // Con expresion lambda
        listaProductos.stream()
                .forEach(p -> panel.getModeloTabla().addRow(new Object[]{
                    p.getId_producto(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getStock()
                }));
        
        
    }
    
    // Metodo para filtrar por precio y llenar los datos al JTable
    public void abrirPanelFiltrar(){
        
        JRadioButton mayorA = new JRadioButton("Mayor - Igual A");
        JRadioButton menorA = new JRadioButton("Menor - Igual A");
        
        ButtonGroup miGrupo = new ButtonGroup();
        
        miGrupo.add(mayorA);
        miGrupo.add(menorA);
        
        JPanel panel_entrada = new JPanel();
        panel_entrada.setLayout(new FlowLayout());
        
        JLabel txt_titulo = new JLabel("FILTRAR POR PRECIO");
        
        JLabel txt_precio = new JLabel("Precio: $");
        
        JTextField cmp_precio = new JTextField(20);
        
        panel_entrada.add(txt_precio);
        panel_entrada.add(cmp_precio);
        
        Object componentes[] = {txt_titulo, mayorA, menorA, panel_entrada};
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(vista, componentes, "Filtrar por precio", JOptionPane.OK_CANCEL_OPTION);
        
        if(opcionSeleccionada == JOptionPane.OK_OPTION){
            
            if(!cmp_precio.getText().isEmpty()){
            
                try{
                    
                    // Obtengo la los datos de la BBDD
                    List<Producto> listaProductos = productoDAO.listarProductos();
                
                    double precio_ingresado = Double.parseDouble(cmp_precio.getText());

                    if(mayorA.isSelected()){
                        System.out.println("Seleccionaste el mayor A");
                        
                        // Limpiamos las filas
                        panel.getModeloTabla().setRowCount(0);
                        
                        // Rellenar el JTable de forma normal
                        /*for(Producto producto : listaProductos){
                            if(producto.getPrecio() >= precio_ingresado){
                                
                                Object fila[] = {
                                    producto.getId_producto(),
                                    producto.getNombre(),
                                    producto.getPrecio(),
                                    producto.getStock()
                                };
                                
                                panel.getModeloTabla().addRow(fila);
                            }
                        }*/
                        
                        // Rellenar el JTable con lambda
                        listaProductos.stream()
                                .filter(p -> p.getPrecio() >= precio_ingresado)
                                .forEach(p -> panel.getModeloTabla().addRow(new Object[]{
                                    p.getId_producto(),
                                    p.getNombre(),
                                    p.getPrecio(),
                                    p.getStock()
                                }));
                        
                    }else if(menorA.isSelected()){
                        System.out.println("Seleccionaste el menor A");
                        
                        // Limpiamos el JTable
                        panel.getModeloTabla().setRowCount(0);
                        
                        // Rellenar el JTable de manera normal
                        
                        for(Producto p : listaProductos){
                            
                            if(p.getPrecio() <= precio_ingresado){
                                
                                Object fila[] = {
                                    p.getId_producto(),
                                    p.getNombre(),
                                    p.getPrecio(),
                                    p.getStock()
                                };
                                
                                panel.getModeloTabla().addRow(fila);
                                
                            }
                            
                        }
                        
                        // Rellenar el JTable con lambda
                        /*listaProductos.stream()
                                .filter(p -> p.getPrecio() <= precio_ingresado)
                                .forEach(p -> panel.getModeloTabla().addRow(new Object[]{
                                    p.getId_producto(),
                                    p.getNombre(),
                                    p.getPrecio(),
                                    p.getStock()
                                }));*/
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(vista, "Error: Debes seleccionar una opcion", "Error de seleccion", JOptionPane.ERROR_MESSAGE);
                    }
                
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(vista, "Error: Debes ingresar un numero entero valido", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
                
            }else {
                JOptionPane.showMessageDialog(vista, "Error: Debes completar el campo obligatorio", "Error de campo de texto vacio", JOptionPane.WARNING_MESSAGE);
            }
             
        }else{
            JOptionPane.showMessageDialog(vista, "Operacion Cancelada", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
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
