
package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDao {
    
    Conexion con;
    String sql;
    Cliente cl;
    public PreparedStatement prepare;
    public ResultSet res;
    
    
    public String inicioSesion(Usuario u){
        try {
            String cli = null;
            con = new Conexion();
            con.Conectar();
            sql = "Select *from usuario where usuario = '"+u.Usuario+"' and contrasena ='"+u.Contraseña+"'";
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            if(res!=null){
                while(res.next()){
                    String user = res.getString("usuario");
                    String pass = res.getString("contrasena");
                    cli = res.getString("nombres");
                    u.llave = 1;
                }
            }
            return cli;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            
        }
        return null;
        
    }
    
}
