package org.bbdd.ejerciciosupermercado.modelo;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.sql.*;
import org.bbdd.ejerciciosupermercado.vista.*;

public class ProductoDAO { // DAO -> "Data Access Object" (Objeto de Acceso a Datos).

    public ProductoDAO(){
        
    }
    
    public List<Producto> listarProductos(){
        
        Connection conexion = null;
        CallableStatement procedimiento = null;
        
        List<Producto> productos = new ArrayList<>();
        
        try{
            
            conexion = ConectaBD.dameConexion();
            
            String sql = "{CALL listar_todos_los_productos}";
            
            procedimiento = conexion.prepareCall(sql);
            
            ResultSet rs = procedimiento.executeQuery();
            
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                productos.add(producto);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(procedimiento != null){
                    procedimiento.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return productos;
        
    }
    
    
    public int agregarProducto(String nombre, double precio, int stock) {
        
        Connection conexion = null;
        CallableStatement sentencia = null;
        
        try{
            
            conexion = ConectaBD.dameConexion();
            
            String sql = "{CALL agregar_productos(?, ?, ?)}";
            
            sentencia = conexion.prepareCall(sql);
            
            sentencia.setString(1, nombre);
            sentencia.setDouble(2, precio);
            sentencia.setInt(3, stock);
            
            int filasAfectadas = sentencia.executeUpdate();
            
            return filasAfectadas;
            
        }catch(SQLException e){
            //e.printStackTrace();
            e.getMessage();
        }finally{
            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(sentencia != null){
                    sentencia.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return 0;
        
    }
    
    public int actualizarProducto(int id, double precio, int cantidad){
        
        Connection conexion = null;
        CallableStatement sentencia = null;
        
        try{
            
            conexion = ConectaBD.dameConexion();
            
            String sql = "{CALL actualizar_producto(?, ?, ?)}";
            
            sentencia = conexion.prepareCall(sql);
            
            sentencia.setInt(1, id);
            sentencia.setDouble(2, precio);
            sentencia.setInt(3, cantidad);
            
            int filasAfectadas = sentencia.executeUpdate();
            
            return filasAfectadas;
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(sentencia != null){
                    sentencia.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return 0;
        
    }
    
    public int eliminarProducto(int id){
        
        Connection conexion = null;
        CallableStatement sentencia = null;
        
        try{
            
            conexion = ConectaBD.dameConexion();
            
            String sql = "{CALL eliminar_producto(?)}";
            
            sentencia = conexion.prepareCall(sql);
            
            sentencia.setInt(1, id);
            
            int filasAfectadas = sentencia.executeUpdate();
            
            return filasAfectadas;
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(sentencia != null){
                    sentencia.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return 0;
        
    }
    
    public boolean existeElProducto(int id){
        
        Connection conexion = null;
        CallableStatement sentencia = null;
        
        try{
            
            conexion = ConectaBD.dameConexion();
            
            String sql = "{CALL existe_producto(?)}";
            
            sentencia = conexion.prepareCall(sql);
            
            sentencia.setInt(1, id);
            
            ResultSet resultado = sentencia.executeQuery();
            
            if(resultado.next()){
                return resultado.getBoolean("producto_existe"); // AS alias del procedimiento almacenado
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(sentencia != null){
                    sentencia.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return false;
        
    }
    
}
