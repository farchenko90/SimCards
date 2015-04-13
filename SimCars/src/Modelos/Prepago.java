package Modelos;

public class Prepago {
    
    
    public String Num_minutos;
    public String Numero;
    public String Codigo_sim;
    public double Valor;

    
    public String getNum_minutos() {
        return Num_minutos;
    }

    public void setNum_minutos(String Num_minutos) {
        this.Num_minutos = Num_minutos;
    }

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

        public void mapear(Prepago p){
            this.Num_minutos = p.Num_minutos;
            this.Numero = p.Numero;
            this.Codigo_sim = p.Codigo_sim;
            this.Valor = p.Valor;
        }
    
}
