package org.bbdd.ejerciciosupermercado.modelo;

import java.sql.*;

public class ConectaBD {

    public static String DB_URL = "jdbc:mysql://localhost:3306/ej_supermercado";
    public static String USER = "root";
    public static String PASS = "Esteban7";
    
    public static Connection dameConexion() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
    
}
