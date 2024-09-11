package tarea.crudTiendaBD;

import java.sql.*;

public class ConexionBBDD {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_programacion2";
    public static final String USER = "root";
    public static final String PASS = "Esteban7";
    
    public static Connection traeConexion() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
    
}
