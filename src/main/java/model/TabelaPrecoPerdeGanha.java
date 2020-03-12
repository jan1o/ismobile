package model;

/*
 * TabelaPrecoPerdeGanha.java
 *
 * Created on 10 de Agosto de 2010, 07:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;

/**
 *
 * @author Marcos
 */
public class TabelaPrecoPerdeGanha implements InterfaceObjeto{
    
    private int ordem;
    private double percentual;
    private int tipo;
    private TabelaPreco tabelaPreco;
    
    /** Creates a new instance of TabelaPrecoPerdeGanha */
    public TabelaPrecoPerdeGanha() {
        tabelaPreco = new TabelaPreco();
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public TabelaPreco getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(TabelaPreco tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }
    
    public String toXML() {
         return "<tppg><o>" + getOrdem() + "</o><p>" + getPercentual() + "</p><ctp>" + getTabelaPreco().getCodigo() +"</ctp><t>"+ getTipo() +"</t></tppg>";
    }
}
