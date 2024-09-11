package tarea.crudTiendaBD;

import tarea.crudTiendaBD.Cliente;
import java.util.*;
import java.sql.*;

public class Tienda {

    private static final String sql_insert = "INSERT INTO clientes(id, nombre, correo, telefono) VALUES(?, ?, ?, ?)";
    private static final String sql_delete = "DELETE FROM clientes WHERE id = ?";
    private static final String sql_update = "UPDATE clientes SET correo = ?, telefono = ? WHERE id = ?";
    private static final String sql_select_listar = "SELECT * FROM clientes";
    private static final String sql_select_buscar = "SELECT * FROM clientes WHERE id = ";
    
    // Metodo para agregar clientes
    public boolean agregarCliente(int id, String nombre, String correo, String telefono){
        
        // Uso del try - catch - resources para el cierre automatico de recursos
        try(Connection miConexion = ConexionBBDD.traeConexion(); 
                PreparedStatement miSentencia = miConexion.prepareStatement(sql_insert)){
            
            miSentencia.setInt(1, id);
            miSentencia.setString(2, nombre);
            miSentencia.setString(3, correo);
            miSentencia.setString(4, telefono);
            
            /*int filasAfectadas = miSentencia.executeUpdate();
            
            if(filasAfectadas > 0){
                return true;
            }*/
            
            // Si la operacion fue exitosa returna true
            return miSentencia.executeUpdate() > 0;
            
        }catch(SQLException e){
            System.out.println("Error al agregar cliente");
            e.printStackTrace();
            e.getMessage();
        }
        
        
        return false;
        
    }
    
    public boolean eliminarCliente(int id){
        
        // Uso del try - catch - resources para el cierre automatico de recursos
        try(Connection miConexion = ConexionBBDD.traeConexion();
                PreparedStatement miSentencia = miConexion.prepareStatement(sql_delete)){
            
            miSentencia.setInt(1, id);
            
            // Si la operacion fue exitosa returna true
            return miSentencia.executeUpdate() > 0;
            
        }catch(SQLException e){
            System.out.println("Error al borrar el cliente");
        }
        
        return false;
        
    }
    
    public boolean actualizarCliente(int id_cliente, String correo, String telefono){
        
        // Uso del try - catch - resources para el cierre automatico de recursos
        try(Connection miConexion = ConexionBBDD.traeConexion();
                PreparedStatement miSentencia = miConexion.prepareStatement(sql_update)){
            
            miSentencia.setString(1, correo);
            miSentencia.setString(2, telefono);
            miSentencia.setInt(3, id_cliente);
            
            // Si la operacion fue exitosa returna true
            return miSentencia.executeUpdate() > 0;
            
        }catch(SQLException e){
            System.out.println("Error al actualizar el cliente");
        }
       
        return false;
        
    }
    
    public List<Cliente> listarClientes(){
        
        // Uso del try - catch - resources para el cierre automatico de recursos
        try(Connection miConexion = ConexionBBDD.traeConexion();
                Statement miSentencia = miConexion.createStatement()){
            
            List<Cliente> listaCliente = new ArrayList<>();
            
            ResultSet rs = miSentencia.executeQuery(sql_select_listar);
            
            while(rs.next()){
                
                Cliente nuevoCliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("correo"), rs.getString("telefono"));
                
                listaCliente.add(nuevoCliente);
                
            }
            
            return listaCliente;
            
        }catch(SQLException e){
            System.out.println("Error al listar clientes");
            return null;
        }
        
    }
    
    public Cliente buscarCliente(int id){
        
        try(Connection miConexion = ConexionBBDD.traeConexion();
                Statement miSentencia = miConexion.createStatement()){
            
            ResultSet rs = miSentencia.executeQuery(sql_select_buscar + id);
            
            Cliente clienteEncontrado = null;
            
            if(rs.next()){
                clienteEncontrado = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("correo"), rs.getString("telefono"));
            }
            
            return clienteEncontrado;
            
            
        }catch(SQLException e){
            System.out.println("Error al buscar cliente");
            return null;
        }
          
    }
    
}
