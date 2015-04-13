package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FacturaDao {

    Conexion con;
    String sql;
    public PreparedStatement prepare;
    public ResultSet res;
    Factura fac;
    
    public double sumatotal(String finicial,String ffinal){
        try {
            con = new Conexion();
            con.Conectar();
            fac = new Factura();
            sql = "Select sum(total) as total from factura where fecha >= '"+finicial+"' and fecha <= '"+ffinal+"'";
            prepare = con.getConexion().prepareStatement(sql);
            ResultSet sentencia = prepare.executeQuery();
            while (sentencia.next()) { 
                fac.total = sentencia.getDouble("total");
            }
            return fac.total;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public boolean guardarfatura(Factura f){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into factura(id_cliente,fecha,total) values("
                    + f.Id_cliente + ","
                    +"'"+ f.fecha + "',"
                    + f.total+ ");";
                    
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    
    
    public int maxId(){
        try {
            con = new Conexion();
            con.Conectar();
            fac = new Factura();
            sql = "Select max(id) as idfactura from factura";
            prepare = con.getConexion().prepareStatement(sql);
            ResultSet sentencia = prepare.executeQuery();
            while (sentencia.next()) { 
                fac.id = sentencia.getInt("idfactura");
            }
            return fac.id;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
