package model;

/*
 * Supervisor.java
 *
 * Created on 27 de Setembro de 2006, 15:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Eder
 */
public class Supervisor {
    
    private int codigo;
    private String nome;
    
    /** Creates a new instance of Supervisor */
    public Supervisor() {
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
    
}
