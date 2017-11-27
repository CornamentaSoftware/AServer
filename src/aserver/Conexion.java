
package aserver;

import java.sql.*;

public class Conexion {
    private Connection con = null;
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VENUS", "root","n0m3l0");
        } catch (InstantiationException | IllegalAccessException
            | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion(){
        return con;
    }

    public void cerrarConexion(){
        try {
        con.close();
        } catch (SQLException e) {
        e.printStackTrace();
            }
        }
}
