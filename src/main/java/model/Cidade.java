package model;

/*
 * Cidade.java
 *
 * Created on 29 de Março de 2006, 22:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;


/**
 *
 * @author Eder
 */
public class Cidade implements Comparable, InterfaceObjeto {
    
    private int     codigo;
    private String  nome;
    private Estado  estado;
    private String  cep;

    /** Creates a new instance of Cidade */
    public Cidade() {
        estado = new Estado();
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    //order by na memoria
    public int compareTo(Object o) {
        Cidade cidade = (Cidade)o;
        return nome.compareTo(cidade.getNome());
    }
    // este replace poderia ser um metodo recebendo o getNome e tratando todos os caracteres
    public String toXML(){
         return "<cid><c>" + getCodigo() + "</c><n>" + removerCaracteresEspeciais(getNome()) + "</n><s>"+ getEstado().getSigla() +"</s>" +
                 "<cep>"+ getCep() +"</cep></cid>";
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
      return passa;   
   } 
}
