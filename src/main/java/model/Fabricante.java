package model;

/*
 * Fabricante.java
 *
 * Created on 4 de Setembro de 2006, 15:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


import biblioteca.InterfaceObjeto;

/**
 *
 * @author Eder
 */
public class Fabricante implements Comparable, InterfaceObjeto {
    
    private int codigo;
    private String nome;
    
    /** Creates a new instance of Fabricante */
    public Fabricante() {
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
        Fabricante fabricante = (Fabricante)o;
        return getNome().compareTo(fabricante.getNome());
    }
     
    public String toXML(){
        return "<f><c>" + getCodigo() + "</c><n>" + removerCaracteresEspeciais(getNome()) + "</n></f>";
    }
    
    public String removerCaracteresEspeciais(String passa)
    {   
      if (passa != null) {
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
        passa = passa.replaceAll("['<>\\|/�-]","");
      }      
      return passa.trim();  
   } 
}
