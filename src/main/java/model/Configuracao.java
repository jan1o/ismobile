package model;

/*
 * Configuracao.java
 *
 * Created on 23 de Janeiro de 2007, 13:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Wallace
 */
public class Configuracao {
    
    private String driverDB;
    private String caminhoDB;
    private String loginDB;
    private String senhaDB;
    private int codigoVendedor;
    
    /** Creates a new instance of Configuracao */
    public Configuracao() {
        this.codigoVendedor = 0;
    }
    
    public String getCaminhoDB() {
        return caminhoDB;
    }

    public void setCaminhoDB(String caminhoDB) {
        this.caminhoDB = caminhoDB;
    }

    public String getLoginDB() {
        return loginDB;
    }

    public void setLoginDB(String loginDB) {
        this.loginDB = loginDB;
    }

    public String getSenhaDB() {
        return senhaDB;
    }

    public void setSenhaDB(String senhaDB) {
        this.senhaDB = senhaDB;
    }

    public String getDriverDB() {
        return driverDB;
    }

    public void setDriverDB(String driverDB) {
        this.driverDB = driverDB;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

 }
