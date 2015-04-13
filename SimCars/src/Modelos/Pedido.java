package Modelos;

public class Pedido {
    
    public int Id;
    public int Id_sim;
    public int Id_factura;

    public int getId_factura() {
        return Id_factura;
    }

    public void setId_factura(int Id_factura) {
        this.Id_factura = Id_factura;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId_sim() {
        return Id_sim;
    }

    public void setId_sim(int Id_sim) {
        this.Id_sim = Id_sim;
    }

    
    public void mapear(Pedido p){
        this.Id = p.Id;
        this.Id_sim = p.Id_sim;
    }
    
}
