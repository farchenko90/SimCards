
package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SimDao {
    
    Conexion con;
    String sql;
    public PreparedStatement prepare;
    public ResultSet res;
    Sim s;
    
    public boolean modificarestado(int id){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Update sim set estado= 'vendido' "
                    + "where id = '"+id+"';";
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }
    
    public int id_sim(String id) throws SQLException{
        try {
            con = new Conexion();
            con.Conectar();
            s = new Sim();
            sql = "Select id from sim where codigo_sim_pre ='"+id+"' or codigo_sim_dato = '"+id+"'";
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            ResultSet sentencia = prepare.executeQuery();
            while (sentencia.next()) { 
                s.Id = sentencia.getInt("id");
            }
            return s.Id;
        } catch (SQLException | ClassNotFoundException e) {
           
        }
        con.Desconectar();
        
        return -1;
    }
    
    public boolean guardarSim(Sim s){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into sim(id,codigo_sim_pre,codigo_sim_dato,estado) values("
                    + "NULL,"
                    + ""+s.Id_prepago+","
                    + ""+s.Id_datos+","
                    + "'sin vender');";
                    
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean eliminarSim(int cod){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Delete from sim where id = "+cod+"";
            //System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public ArrayList<Sim> consulta(Sim s,String x) throws SQLException{
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Select id from sim where codigo_sim_pre = '"+x+"' "
                    + "union "
                    + "Select id from sim where codigo_sim_dato = '"+x+"'";
                    
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            ArrayList<Sim> dat;
            if(res!=null){
                dat = new ArrayList<>();
                while(res.next()){
                    s = new Sim();
                    s.setId(res.getInt("id"));
                    dat.add(s);
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
