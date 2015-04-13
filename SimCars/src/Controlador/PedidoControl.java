
package Controlador;

import Modelos.Pedido;
import Modelos.PedidoDao;


public class PedidoControl {

    PedidoDao pDao = new PedidoDao();
    
    public boolean guardarPedido(Pedido p){
        return pDao.guardarpedido(p);
    }
    
}
