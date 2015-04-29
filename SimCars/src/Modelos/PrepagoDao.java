
package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PrepagoDao {
    
    Conexion con;
    String sql;
    Prepago pr;
    public PreparedStatement prepare;
    public ResultSet res;
    
    public boolean modificadatos(Prepago d,String cc){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Update prepago set numero='"+d.Numero+"',valor="+d.Valor+","
                    + "num_minutos='"+d.Num_minutos+"' where codigo_sim = '"+cc+"';";
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }
    
    public boolean eliminarSim(String cod) throws SQLException{
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Delete from prepago where codigo_sim = '"+cod+"'";
            prepare = con.getConexion().prepareStatement(sql);
            System.out.println(sql);
            return prepare.executeUpdate()>0;
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        con.Desconectar();
        return false;
    }
    
    public boolean registrarPrepago(Prepago pr){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into prepago(numero,codigo_sim,valor,num_minutos) "
                    + "values("
                    + pr.Numero +","
                    + pr.Codigo_sim+","
                    + pr.Valor+","
                    +"'"+ pr.Num_minutos+"');";
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public ArrayList<Prepago> busquedaDatos(Prepago x,String cc) throws SQLException{
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Select numero,valor,num_minutos from prepago where codigo_sim = '"+cc+"';";
                    
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            ArrayList<Prepago> dat;
            if(res!=null){
                dat = new ArrayList<>();
                while(res.next()){
                    x = new Prepago();
                    x.setNumero(res.getString("numero"));
                    x.setValor(res.getDouble("valor"));
                    x.setNum_minutos(res.getString("num_minutos"));
                    dat.add(x);
                }
                return dat;
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        con.Desconectar();
        return null;
    }
    
}
