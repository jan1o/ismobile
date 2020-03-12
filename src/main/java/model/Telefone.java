package model;



/**
 *
 * @author Administrador
 */
public class Telefone {
    
    private String numero;
    private String contato;
    private String tipo;
    
    public Telefone() {
        this.numero = "";
        this.contato = "";
        this.tipo = "";
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
