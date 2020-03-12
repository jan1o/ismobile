package model;

/*
 * DadosPessoaFisica.java
 *
 * Created on 14 de Setembro de 2006, 12:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Wallace
 */
public class DadosPessoaFisica {
    
    private String cpf;
    private String rg;
    
    /** Creates a new instance of DadosPessoaFisica */
    public DadosPessoaFisica() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
}
