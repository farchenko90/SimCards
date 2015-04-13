package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteDao {
    
    Conexion con;
    String sql;
    Cliente cl;
    public PreparedStatement prepare;
    public ResultSet res;
    
    public boolean eliminarCliente(String cc){
        try {
            String cod = String.valueOf(cc);
            con = new Conexion();
            con.Conectar();
            sql = "Delete from cliente where cedula ="+cod;
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public ArrayList<Cliente> busquedaCliente(Cliente x,String cc){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Select *from cliente where cedula = '"+cc+"'";
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            ArrayList<Cliente> cli;
            if(res!=null){
                cli = new ArrayList<>();
                while(res.next()){
                    x = new Cliente();
                    x.setNombres(res.getString("nombres"));
                    x.setApellidos(res.getString("apellidos"));
                    x.setDireccion(res.getString("direccion"));
                    x.setTelefono(res.getString("telefono"));
                    x.setBarrio(res.getString("barrio"));
                    x.setCiudad(res.getString("ciudad"));
                    cli.add(x);
                }
                return cli;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public boolean registrarCliente(Cliente cl){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into cliente(cedula,nombres,apellidos,telefono,direccion,ciudad,barrio) "
                    + "values("
                    +"'"+ cl.Cedula +"',"
                    + "'"+cl.Nombres+"',"
                    + "'"+cl.Apellidos+"',"
                    + cl.Telefono+","
                    + "'"+cl.Direccion+"',"
                    + "'"+cl.Ciudad+"',"
                    + "'"+cl.Barrio+"');";
            //System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean modificarCliente(String cc,Cliente c){
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Update cliente set nombres='"+c.Nombres+"',apellidos='"+c.Apellidos+"',"
                    + "telefono="+c.Telefono+",direccion='"+c.Direccion+"',ciudad='"+c.Ciudad+"',"
                    + "barrio='"+c.Barrio+"' where cedula = '"+cc+"';";
            prepare = con.getConexion().prepareStatement(sql);
            return prepare.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }
    
    
    public void ListaClientes(String c,JTable t){
        try {
            con = new Conexion();
            con.Conectar();
            int cont = 0;
            cl = new Cliente();
            DefaultTableModel d = (DefaultTableModel)t.getModel();
            
            //Object object[] = {cl.Cedula,cl.Nombres,cl.Apellidos,cl.Direccion,cl.Barrio,cl.Telefono};
            sql = "Select cedula,nombres,apellidos,telefono,direccion,barrio from cliente where "
                    + "nombres LIKE '%"+c+"%' or apellidos LIKE '%"+c+"%' "
                    + "or cedula LIKE '%"+c+"%' or telefono LIKE '%"+c+"%'";
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            if(res!=null){  
                d.setRowCount(0);
                while(res.next()){
                    //d.addRow(object);
                    d.setRowCount(cont+1);
                    t.setValueAt(""+res.getString("cedula"), cont, 0);
                    t.setValueAt(""+res.getString("nombres"), cont, 1);
                    t.setValueAt(""+res.getString("apellidos"), cont, 2);
                    t.setValueAt(""+res.getString("direccion"), cont, 3);
                    t.setValueAt(""+res.getString("barrio"), cont, 4);
                    t.setValueAt(""+res.getString("telefono"), cont, 5);
                    cont++;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public void ListaClientestabla(String c,JTable t){
        try {
            con = new Conexion();
            con.Conectar();
            int cont = 0;
            cl = new Cliente();
            DefaultTableModel d = (DefaultTableModel)t.getModel();
            
            //Object object[] = {cl.Cedula,cl.Nombres,cl.Apellidos,cl.Direccion,cl.Barrio,cl.Telefono};
            sql = "Select cedula,nombres,apellidos,telefono,direccion,barrio from cliente where "
                    + "nombres LIKE '%"+c+"%' or apellidos LIKE '%"+c+"%' "
                    + "or cedula LIKE '%"+c+"%' or telefono LIKE '%"+c+"%'";
            System.out.println(sql);
            prepare = con.getConexion().prepareStatement(sql);
            res = prepare.executeQuery();
            if(res!=null){  
                d.setRowCount(0);
                while(res.next()){
                    //d.addRow(object);
                    d.setRowCount(cont+1);
                    t.setValueAt(""+res.getString("cedula"), cont, 0);
                    t.setValueAt(""+res.getString("nombres"), cont, 1);
                    t.setValueAt(""+res.getString("apellidos"), cont, 2);
                    t.setValueAt(""+res.getString("telefono"), cont, 3);
                    cont++;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
}
