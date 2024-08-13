package org.pootup.pootup2cuatri;

// Arbol binario, busqueda, arboles de decision

import org.pootup.pootup2cuatri.practica.Caja;
import org.pootup.pootup2cuatri.practica.Cliente;

// Grafos

public class App {
    
    // Clase 2 - 13/8/24
    
    public static void main(String[] args) {
        
        Cliente cajaDeDiego = new Cliente("Diego", "Gomez");
        
        //cajaDeDiego.setNroCaja(123);
        //cajaDeDiego.setNombre("Diego");
        //cajaDeDiego.setApellido("Gomez");
        
        System.out.println(cajaDeDiego);
        
        System.out.println("");
        
        Caja cajaDePedro = new Caja(236, cajaDeDiego);
        
        System.out.println(cajaDePedro);
        
    }
    
}

//import java.sql.*;
//import static org.pootup.pootup2cuatri.sqlconection.SqlConection.*;

/*public class App {

    public static void main(String[] args) {
        
        Connection conexion = null;
        Statement consulta = null;
        
        try {
        
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            
            consulta = conexion.createStatement();
            
            String sql = "SELECT * FROM clientes";
            
            ResultSet rs = consulta.executeQuery(sql);
            
            while(rs.next()){
                
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fecha = rs.getDate("fecha_nac");
                String telefono = rs.getString("telefono");
                
                System.out.println("Cliente(DNI: " + dni + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Fecha nacimiento: " + fecha + ", Telefono: " + telefono);
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
}*/
