
package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PedidoDao {

    Conexion con;
    String sql;
    public PreparedStatement prepare;
    public ResultSet res;
    
    public boolean guardarpedido(Pedido p){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into pedido(id_sim,id_factura) values("
                    + p.Id_sim + ","
                    + p.Id_factura + ");";
                    
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
}
