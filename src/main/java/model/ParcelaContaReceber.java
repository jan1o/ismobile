package model;

/*
 * ParcelaContaReceber.java
 *
 * Created on 27 de Setembro de 2006, 16:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.util.Date;

/**
 *
 * @author Eder
 */
public class ParcelaContaReceber {
    
    private int numero;
    private String numeroDoc;
    private int tipoCobranca;
    private Date vencimento;
    private double valor;
    private double juros;
    private int liberado;
    
    
    /** Creates a new instance of ParcelaContaReceber */
    public ParcelaContaReceber() {
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public int getTipoCobranca() {
        return tipoCobranca;
    }

    public void setTipoCobranca(int tipoCobranca) {
        this.tipoCobranca = tipoCobranca;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public int getLiberado() {
        return liberado;
    }

    public void setLiberado(int liberado) {
        this.liberado = liberado;
    }
    
}
