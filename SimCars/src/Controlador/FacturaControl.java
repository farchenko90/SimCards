package Controlador;

import Modelos.Factura;
import Modelos.FacturaDao;

public class FacturaControl {

    FacturaDao fDao = new FacturaDao();
    
    public int MaxFactura(){
        return fDao.maxId();
    }
    
    public boolean guardarFactura(Factura f){
        return fDao.guardarfatura(f);
    }
    
    public double SumTotal(String finicial,String ffinal){
        return fDao.sumatotal(finicial,ffinal);
    }
    
}
