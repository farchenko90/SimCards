package Controlador;

import Modelos.Sim;
import Modelos.SimDao;
import java.util.ArrayList;

public class SimControl {
    
    SimDao sim = new SimDao();
    
    public boolean guardarSim(Sim s){
        return sim.guardarSim(s);
    }
    
    public boolean ElimniarSim(int cod){
        return sim.eliminarSim(cod);
    }
    
    public ArrayList<Sim> consultaSim(Sim s,String x){
        return sim.consulta(s, x);
    }
    
    public int Id_sim(String c){
        return sim.id_sim(c);
    }
    
    public boolean modificarEstado(int id){
        return sim.modificarestado(id);
    }
    
}
