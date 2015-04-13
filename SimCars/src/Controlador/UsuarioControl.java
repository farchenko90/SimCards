
package Controlador;

import Modelos.Usuario;
import Modelos.UsuarioDao;


public class UsuarioControl {
    
    UsuarioDao uDao = new UsuarioDao();
    
    public String IniciarSesion(Usuario u){
        return uDao.inicioSesion(u);
    }
    
}
