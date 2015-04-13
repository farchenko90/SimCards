
package Modelos;

public class Datos {
    
    public String Numero;
    public String Codigo_sim;
    public double Valor;
    public String Gb_Mb;

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getCodigo_sim() {
        return Codigo_sim;
    }

    public void setCodigo_sim(String Codigo_sim) {
        this.Codigo_sim = Codigo_sim;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getGb_Mb() {
        return Gb_Mb;
    }

    public void setGb_Mb(String Gb_Mb) {
        this.Gb_Mb = Gb_Mb;
    }

    public void mapear(Datos d){
        this.Gb_Mb = d.Gb_Mb;
        this.Numero = d.Numero;
        this.Codigo_sim = d.Codigo_sim;
        this.Valor = d.Valor;
    }
    
}
