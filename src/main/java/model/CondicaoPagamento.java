package model;

/*
 * CondicaoPagamento.java
 *
 * Created on 6 de Setembro de 2006, 09:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


import biblioteca.InterfaceObjeto;



/**
 *
 * @author Wallace
 */
public class CondicaoPagamento implements Comparable, InterfaceObjeto {
    
    private int codigo;
    private String nome;
    private double descMaximo;
    private int codigoTabelaPreco;
    private int negocicao;
    private int retirado;
    private double valorMinimoVenda;
    
    /** Creates a new instance of CondicaoPagamento */
    public CondicaoPagamento() {
        negocicao = 0;
        retirado = 0;
        valorMinimoVenda = 0;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDescMaximo() {
        return descMaximo;
    }

    public void setDescMaximo(double descMaximo) {
        this.descMaximo = descMaximo;
    }

    public int getCodigoTabelaPreco() {
        return codigoTabelaPreco;
    }

    public void setCodigoTabelaPreco(int codigoTabelaPreco) {
        this.codigoTabelaPreco = codigoTabelaPreco;
    }
    
        public int getNegocicao() {
        return negocicao;
    }

    public void setNegocicao(int negocicao) {
        this.negocicao = negocicao;
    }

    public int getRetirado() {
        return retirado;
    }

    public void setRetirado(int retirado) {
        this.retirado = retirado;
    }
    
    public int compareTo(Object o) {
        CondicaoPagamento condicao = (CondicaoPagamento)o;
        return getNome().compareTo(condicao.getNome());
    }
     
    public String toXML(){
        return "<cp>" +
                    "<c>" + getCodigo() + "</c>" +
                    "<n>" + getNome().replace('&', 'E') + "</n>" +
                    "<dm>" + getDescMaximo() + "</dm>" +
                    "<ctp>" + getCodigoTabelaPreco() + "</ctp>" +
                    "<neg>" + getNegocicao() + "</neg>" +
                    "<ret>" + getRetirado() + "</ret>" +
                    "<vmv>" + getValorMinimoVenda() + "</vmv>" +
                "</cp>";
    }

    public double getValorMinimoVenda() {
        return valorMinimoVenda;
    }

    public void setValorMinimoVenda(double valorMinimoVenda) {
        this.valorMinimoVenda = valorMinimoVenda;
    }

    
}
