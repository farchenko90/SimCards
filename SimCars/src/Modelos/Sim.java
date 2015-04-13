package Modelos;

public class Sim {
    
    public int Id;
    public String Id_prepago;
    public String Id_datos;
    public String estado;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getId_prepago() {
        return Id_prepago;
    }

    public void setId_prepago(String Id_prepago) {
        this.Id_prepago = Id_prepago;
    }

    public String getId_datos() {
        return Id_datos;
    }

    public void setId_datos(String Id_datos) {
        this.Id_datos = Id_datos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void mapear(Sim s){
        this.Id = s.Id;
        this.Id_datos = s.Id_datos;
        this.Id_prepago = s.Id_prepago;
        this.estado = s.estado;
    }
    
}
