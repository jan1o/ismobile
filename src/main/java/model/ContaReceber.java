package model;

/*
 * ContaReceber.java
 *
 * Created on 27 de Setembro de 2006, 15:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.util.Date;

/**
 *
 * @author Eder
 */
public class ContaReceber {
    
    private int numero;
    private Pedido pedido;
    private Vendedor vendedor;
    private Date data;
    private Date dataServidor;
    private int tolerancia;
    
    /** Creates a new instance of ContaReceber */
    public ContaReceber() {
        pedido = new Pedido();
        vendedor = new Vendedor();
        setTolerancia(1);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataServidor() {
        return dataServidor;
    }

    public void setDataServidor(Date dataServidor) {
        this.dataServidor = dataServidor;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }
    
}
