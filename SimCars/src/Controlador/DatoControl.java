
package Controlador;

import Modelos.Datos;
import Modelos.DatosDao;
import java.util.ArrayList;
import javax.swing.JTable;


public class DatoControl {
    
    DatosDao dDao = new DatosDao();
    
    public boolean RegistrarDatos(Datos d){
        return dDao.registrarDatos(d);
    }
    
    public void estado(String c, JTable t){
        dDao.consultarestado(c, t);
    }
    
    public void ListaDatos(String c,JTable t){
        dDao.listaDatos(c, t);
    }
    
    public ArrayList<Datos> unasimcard(Datos d,String x){
        return dDao.busquedaCliente(d, x);
    }
    
    public boolean eliminardatos(String cod){
        return dDao.eliminarSim(cod);
    }
    
    public boolean modificardatos(Datos d,String cc){
        return dDao.modificadatos(d, cc);
    }
    
    public ArrayList<Datos> unasimcards(Datos d,String x){
        return dDao.busquedaDatos(d, x);
    }
    
}
