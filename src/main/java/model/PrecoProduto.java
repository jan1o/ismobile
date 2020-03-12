package model;

/*
 * PrecoProduto.java
 *
 * Created on 18 de Setembro de 2006, 12:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;

/**
 *
 * @author Eder
 */
public class PrecoProduto implements InterfaceObjeto{
    
    private TabelaPreco tabelaPreco;
    private Produto produto;
    private double valor;
    
    
    /** Creates a new instance of PrecoProduto */
    public PrecoProduto() {
        tabelaPreco = new TabelaPreco();
        produto = new Produto();
    }

    public TabelaPreco getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(TabelaPreco tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String toXML(){
        return "<pp><ctp>" + getTabelaPreco().getCodigo() + "</ctp><cp>" + getProduto().getCodigo() + "</cp>" +
                "<v>" + getValor() + "</v></pp>";
    }
    
}
