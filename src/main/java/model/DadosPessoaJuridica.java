package model;

/*
 * DadosPessoaJuridica.java
 *
 * Created on 14 de Setembro de 2006, 12:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Wallace
 */
public class DadosPessoaJuridica {
    
    private String cnpj;
    private String inscricaoEstadual;
    private String nomeFantasia;
    
    /** Creates a new instance of DadosPessoaJuridica */
    public DadosPessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
}
