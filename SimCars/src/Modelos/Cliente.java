
package Modelos;


public class Cliente {
    
    public String Cedula;
    public String Nombres;
    public String Apellidos;
    public String Telefono;
    public String Direccion;
    public String Ciudad;
    public String Barrio;

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }
    
    public void mapear(Cliente c){
        this.Cedula = c.Cedula;
        this.Nombres = c.Nombres;
        this.Apellidos = c.Apellidos;
        this.Telefono = c.Telefono;
        this.Direccion = c.Direccion;
        this.Ciudad = c.Ciudad;
        this.Barrio = c.Barrio;
    }
    
}
