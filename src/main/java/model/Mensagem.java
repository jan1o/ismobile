package model;

/*
 * Mensagem.java
 *
 * Created on 9 de Agosto de 2010, 20:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class Mensagem implements InterfaceObjeto{

    private String de;
    private Date data;
    private String assunto;
    private String corpo;
    
    /** Creates a new instance of Mensagem */
    public Mensagem() {
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
    
      public String toXML() {
        return "<men><de>" + getDe() + "</de><da>" + getData() + "</da><a>"+ getAssunto() +"</a>" +
               "<c>"+ getCorpo() +"</c></men>";
      }
}
