package Modelos;

public class Usuario {
    
    public String Usuario;
    public String Contraseña;
    public int llave; 

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    public void mapear(Usuario u){
        this.Usuario = u.Usuario;
        this.Contraseña = u.Contraseña;
    }
    
}
