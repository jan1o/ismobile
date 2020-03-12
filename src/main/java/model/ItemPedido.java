package model;

/*
 * ItemPedido.java
 *
 * Created on 14 de Setembro de 2006, 19:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;

/**
 *
 * @author Wallace
 */
public class ItemPedido implements Comparable, InterfaceObjeto{
    
    private Produto produto;
    private double quantidade;
    private double valor;
    
    /** Creates a new instance of ItemPedido */
    public ItemPedido() {
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int compareTo(Object o) {
        return 0;
    }

    public String toXML() {
        return "<ip>" +
                "<c>" + getProduto().getCodigo() + "</c>" +
                "<d>" + removerCaracteresEspeciais(getProduto().getDescricao()) + "</d>" +
                "<q>" + getQuantidade() + "</q>" +
                "<v>" + getValor() + "</v>" +
               "</ip>";
    }
    
    
    private String removerCaracteresEspeciais(String passa)
    {   
      if (passa != null) {
        passa = passa.trim();
        passa = passa.replaceAll("[�����]","A");   
        passa = passa.replaceAll("[�����]","a");   
        passa = passa.replaceAll("[����&]","E");   
        passa = passa.replaceAll("[����]","e");   
        passa = passa.replaceAll("����","I");   
        passa = passa.replaceAll("����","i");   
        passa = passa.replaceAll("[�����]","O");   
        passa = passa.replaceAll("[�����]","o");   
        passa = passa.replaceAll("[����]","U");   
        passa = passa.replaceAll("[����]","u");   
        passa = passa.replaceAll("�","C");   
        passa = passa.replaceAll("�","c");    
        passa = passa.replaceAll("[��]","y");   
        passa = passa.replaceAll("�","Y");   
        passa = passa.replaceAll("�","n");   
        passa = passa.replaceAll("�","N");
        passa = passa.replaceAll("@","");
         passa = passa.replaceAll("_","");
        passa = passa.replaceAll("['<>\\|/�-]","");
      }      
      return passa;
   } 
}
