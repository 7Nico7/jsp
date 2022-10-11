package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection connection = null;
    String usuario = "root";
    String contrasena = "Nic@20017";
    String ruta = "jdbc:mysql://localhost:3306/registros?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(ruta, usuario, contrasena);
            System.out.println("Se Conecto Correctamente");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error getConexionSql()" + e.getMessage());
        }
        return connection;
    }
}
