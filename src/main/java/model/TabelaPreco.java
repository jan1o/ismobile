package model;

/*
 * TabelaPreco.java
 *
 * Created on 18 de Setembro de 2006, 12:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;

/**
 *
 * @author Marcos
 */
public class TabelaPreco implements Comparable, InterfaceObjeto{
    
    private int codigo;
    private String nome;
    private double desconto;
    private double acrescimo;
    private int promocao;
    private double acrescimoPF;
    private double quantidadeDe;
    private double quantidadeAte;
    private int habilitarEscalonamento;
    
    /** Creates a new instance of TabelaPreco */
    public TabelaPreco() {
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

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(double acrescimo) {
        this.acrescimo = acrescimo;
    }
    
    public int getPromocao(){
        return promocao;
    }
    
    public void setPromocao(int promocao) {
        this.promocao = promocao;
    }
    
    public double getAcrescimoPF(){
        return acrescimoPF;
    }
    
    public void setAcrescimoPF(double acrescimoPF){
        this.acrescimoPF = acrescimoPF;
    }
     
     public int compareTo(Object o) {
        TabelaPreco tabela = (TabelaPreco)o;
        return getNome().compareTo(tabela.getNome());
    }
     
     public double getQuantidadeDe() {
        return quantidadeDe;
    }

    public void setQuantidadeDe(double quantidadeDe) {
        this.quantidadeDe = quantidadeDe;
    }

    public double getQuantidadeAte() {
        return quantidadeAte;
    }

    public void setQuantidadeAte(double quantidadeAte) {
        this.quantidadeAte = quantidadeAte;
    }

    public int getHabilitarEscalonamento() {
        return habilitarEscalonamento;
    }

    public void setHabilitarEscalonamento(int habilitarEscalonamento) {
        this.habilitarEscalonamento = habilitarEscalonamento;
    }
     
    public String toXML(){
        return "<tp>" +
                "<c>" + getCodigo() + "</c>" +
                "<n>" + getNome().replace('&', 'E') + "</n>" +
                "<d>" + getDesconto() + "</d>" +
                "<a>" + getAcrescimo() + "</a>" +
                "<p>" + getPromocao() + "</p>" +
                "<apf>" + getAcrescimoPF() + "</apf>" +
                "<he>" + getHabilitarEscalonamento() + "</he>" +           
                "<qd>" + getQuantidadeDe() + "</qd>" +
                "<qa>" + getQuantidadeAte() + "</qa>" +
                "</tp>";
    }
    
}
