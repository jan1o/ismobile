package model;

/*
 * Estado.java
 *
 * Created on 17 de Março de 2006, 14:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author Eder
 */
public class Estado implements Comparable{
    
    private String sigla;
    private String nome;
    private String regiao;
    
    /** Creates a new instance of Estado */
    public Estado() {
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    
    public boolean equals(Object obj) {
        return sigla.equals(((Estado) obj).getSigla());
    }

    public int compareTo(Object o) {
        Estado estado = (Estado)o;
        return nome.compareTo(estado.getNome());
    }
   
}
