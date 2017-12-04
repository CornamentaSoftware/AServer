package aserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Base {
    
    private String idUser;

    public String getIdUser() {
        return idUser;
    }
    
    public boolean buscarUsuario(String user){
        boolean existente=false;
                try{
                    Conexion c = new Conexion();
                    Connection con = c.getConexion();
                    
                    if (con!=null){
                        String sql = "SELECT * FROM usuario WHERE Username_Usuario='"+user+"';";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery(); 
                        
                        if (rs.next()){
                            existente=true;
                            idUser = rs.getString("Id_Usuario");
                        }
                        c.cerrarConexion();
                    }
                }
                catch(SQLException e){
                    existente=false;
                    e.printStackTrace();
                }
        return existente;
    }
    
    
}
