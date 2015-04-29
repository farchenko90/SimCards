
package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DatosDao {

    Conexion con;
    String sql;
    public PreparedStatement prepare;
    public ResultSet res;
    Datos d;
    
    public boolean modificadatos(Datos d,String cc){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Update datos set numero='"+d.Numero+"',valor="+d.Valor+","
                    + "Gb_Mb='"+d.Gb_Mb+"' where codigo_sim = '"+cc+"';";
            //System.out.println(sql);
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
            sql = "Delete from datos where codigo_sim = '"+cod+"'";
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        con.Desconectar();
        return false;
    }
    
    public boolean registrarDatos(Datos da){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into datos(numero,codigo_sim,valor,Gb_Mb) "
                    + "values("
                    + da.Numero +","
                    + da.Codigo_sim+","
                    + da.Valor+","
                    +"'"+da.Gb_Mb+"');";
            //System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public void consultarestado(String c,JTable t){
        try {
            con = new Conexion();
            con.Conectar();
            d = new Datos();
            int cont = 0;
            DefaultTableModel d = (DefaultTableModel)t.getModel();
                sql =  "Select s.estado,p.numero,p.codigo_sim,p.valor,'Prepago' as tipo,p.num_minutos as cant from sim s inner join prepago p "
                        + "where s.codigo_sim_pre = p.codigo_sim and s.estado = 'sin vender' "
                        + "union "
                        + "Select s.estado,d.numero,d.codigo_sim,d.valor,'Datos' as tipo,d.Gb_Mb as cant from sim s inner join datos d "
                        + "where s.codigo_sim_dato = d.codigo_sim and s.estado = 'sin vender'";
                prepare = con.getConexion().prepareStatement(sql);
                res = prepare.executeQuery();
                if(res!=null){
                    d.setRowCount(0);
                    while(res.next()){
                        //d.setRowCount(cont+1);
                        d.setRowCount(cont+1);
                        t.setValueAt(""+res.getString("codigo_sim"), cont, 0);
                        t.setValueAt(""+res.getString("numero"), cont, 1);
                        t.setValueAt(""+res.getString("valor"), cont, 2);
                        t.setValueAt(""+res.getString("cant"), cont, 3);
                        t.setValueAt(""+res.getString("tipo"), cont, 4);
                        t.setValueAt(""+res.getString("estado"), cont, 5);
                    cont++;
                    }
                }
                con.Desconectar();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public  void listaDatos(String c,JTable t){
        try {
            con = new Conexion();
            con.Conectar();
            d = new Datos();
            int cont = 0;
            DefaultTableModel d = (DefaultTableModel)t.getModel();
                sql = "Select codigo_sim,numero,valor,num_minutos as cant, 'Prepago' as tipo from prepago where codigo_sim LIKE '%"+c+"%'"
                        + " or numero LIKE '%"+c+"%' or 'prepagos' LIKE '%"+c+"%'"
                        + "union Select codigo_sim,numero,valor,Gb_Mb as cant, 'Datos' as tipo from datos where codigo_sim LIKE '%"+c+"%'"
                        + " or numero LIKE '%"+c+"%' or 'datos' LIKE '%"+c+"%'";
//                sql = "Select s.estado,p.numero,p.codigo_sim,p.valor,'Prepago' as tipo,p.num_minutos as cant from sim s "
//                        + "inner join prepago p where s.codigo_sim_pre = p.codigo_sim or s.estado like '%"+c+"%' "
//                        + "or p.codigo_sim like '%"+c+"%' or 'prepago' like '%"+c+"%' group by s.codigo_sim_pre "
//                        + "union "
//                        + "Select s.estado,d.numero,d.codigo_sim,d.valor,'Datos' as tipo,d.Gb_Mb as cant from "
//                        + "sim s inner join datos d where s.codigo_sim_dato = d.codigo_sim or "
//                        + "s.estado like '%"+c+"%' or d.codigo_sim like '%"+c+"%' or 'datos' like '%"+c+"%' "
//                        + "group by s.codigo_sim_dato";
                
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            if(res!=null){
                d.setRowCount(0);
                while(res.next()){
                    d.setRowCount(cont+1);
                    t.setValueAt(""+res.getString("codigo_sim"), cont, 0);
                    t.setValueAt(""+res.getString("numero"), cont, 1);
                    t.setValueAt(""+res.getString("valor"), cont, 2);
                    t.setValueAt(""+res.getString("cant"), cont, 3);
                    t.setValueAt(""+res.getString("tipo"), cont, 4);
                    
                    cont++;
                }
            }
            con.Desconectar();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public ArrayList<Datos> busquedaCliente(Datos x,String cc){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Select codigo_sim from datos where codigo_sim = '"+cc+"' "
                    + "union "
                    + "Select codigo_sim from prepago where codigo_sim = '"+cc+"'";
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            ArrayList<Datos> dat;
            if(res!=null){
                dat = new ArrayList<>();
                while(res.next()){
                    x = new Datos();
                    x.setCodigo_sim(res.getString("codigo_sim"));
                    dat.add(x);
                }
                return dat;
            }
            con.Desconectar();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<Datos> busquedaDatos(Datos x,String cc){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Select numero,valor,Gb_Mb from datos where codigo_sim = '"+cc+"';";
                    
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            ArrayList<Datos> dat;
            if(res!=null){
                dat = new ArrayList<>();
                while(res.next()){
                    x = new Datos();
                    x.setNumero(res.getString("numero"));
                    x.setValor(res.getDouble("valor"));
                    x.setGb_Mb(res.getString("Gb_Mb"));
                    dat.add(x);
                }
                return dat;
            }
            con.Desconectar();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
}
