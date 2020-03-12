package model;

/*
 * SubGrupo.java
 *
 * Created on 28 de Junho de 2010, 19:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;

/**
 *
 * @author Eder
 */
public class SubGrupo implements Comparable, InterfaceObjeto  {
   
    private int codigo;
    private String nome;
    private int itens;
    private double desconto;
    
    /** Creates a new instance of SubGrupo */
    public SubGrupo() {
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
    
    public int compareTo(Object o) {
        SubGrupo sub = (SubGrupo)o;
        return getNome().compareTo(sub.getNome());
    }
     
    public String toXML(){
        return "<sg>" +
                "<c>" + getCodigo() + "</c>" +
                "<n>" + getNome().replace('&', 'E') + "</n>" +
                "<it>" + getItens() + "</it>" +
                "<de>" + getDesconto() + "</de>" +
                "</sg>";
    }

    public int getItens() {
        return itens;
    }

    public void setItens(int itens) {
        this.itens = itens;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
}
