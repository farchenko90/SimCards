
package Controlador;

import Modelos.Prepago;
import Modelos.PrepagoDao;
import java.util.ArrayList;

public class PrepagoControl {
    
    PrepagoDao pDao = new PrepagoDao();
    
    public boolean RegistrarPrepago(Prepago pr){
        return pDao.registrarPrepago(pr);
    }
    
    public boolean eliminarPrepago(String pr){
        return pDao.eliminarSim(pr);
    }
    
    public boolean ModificarPrepago(Prepago p,String x){
        return pDao.modificadatos(p, x);
    }
    
    public ArrayList<Prepago> unasimcards(Prepago d,String x){
        return pDao.busquedaDatos(d, x);
    }
    
}
