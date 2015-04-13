package Controlador;

import Modelos.Cliente;
import Modelos.ClienteDao;
import java.util.ArrayList;
import javax.swing.JTable;

public class ClienteControl {
    
    ClienteDao cDao = new ClienteDao();
    
    public boolean GuardarClientes(Cliente c){
        return cDao.registrarCliente(c);
    }
    
    public void ListaClientes(String c,JTable t){
        cDao.ListaClientes(c,t);
    }
    
    public boolean ModificarCliente(String cc,Cliente c){
        return cDao.modificarCliente(cc, c);
    }
    
    public ArrayList<Cliente> ListaUnCliente(Cliente x,String cc){
        return cDao.busquedaCliente(x, cc);
    }
    
    public boolean EliminarCliente(String cc){
        return cDao.eliminarCliente(cc);
    }
    
    public void listatabla(String c,JTable t){
        cDao.ListaClientestabla(c, t);
    }
    
}
