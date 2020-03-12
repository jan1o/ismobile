package model;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/*
 * Cliente.java
 *
 * Created on 14 de Setembro de 2006, 11:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;


/**
 *
 * @author Eder
 */
public class Cliente  implements Comparable, InterfaceObjeto {
    
    private int codigo;
    private String nome;
    private String email;
    private Endereco endereco;
    private DadosPessoaFisica dadosPessoaFisica;
    private DadosPessoaJuridica dadosPessoaJuridica;
    private double limiteCredito;
    private int codigoPlanoPagto;
    private int positivado;
    private int codigoEmpresaOrigem;
    private int diaVisita;
    private Categoria categoria;
    private ArrayList lstTelefone;
    private Date dataUltimoPedido;
    private String responsavel;
    
    /** Creates a new instance of Cliente */
    public Cliente() {
        endereco = new Endereco();
        dadosPessoaFisica = new DadosPessoaFisica();
        dadosPessoaJuridica = new DadosPessoaJuridica();
        categoria = new Categoria();
        diaVisita = 0;
        setLstTelefone(new ArrayList());
        setDataUltimoPedido(new Date());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public DadosPessoaFisica getDadosPessoaFisica() {
        return dadosPessoaFisica;
    }

    public void setDadosPessoaFisica(DadosPessoaFisica dadosPessoaFisica) {
        this.dadosPessoaFisica = dadosPessoaFisica;
    }
    
    public DadosPessoaJuridica getDadosPessoaJuridica() {
        return dadosPessoaJuridica;
    }

    public void setDadosPessoaJuridica(DadosPessoaJuridica dadosPessoaJuridica) {
        this.dadosPessoaJuridica = dadosPessoaJuridica;
    }
    
    public int compareTo(Object o) {
        Cliente cliente = (Cliente)o;
        return nome.compareTo(cliente.getNome());
    }

      public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    private String processarLstTelefoneToXML(){
        String txt = "";
        int i = 1;
        Iterator it = getLstTelefone().iterator();
        while (it.hasNext()){
            Telefone tel = (Telefone)it.next();
            if (i == 1)
                txt += "<tel>" + removerCaracteresEspeciais(tel.getNumero()) + "</tel>";
            else
                txt += "<tel" + i + ">" + removerCaracteresEspeciais(tel.getNumero()) + "</tel" + i + ">";
            i++;
        }
        
        return txt;
    }
    
    public int getCodigoPlanoPagto(){
        return codigoPlanoPagto;
    }
    
    public void setCodigoPlanoPagto(int codigoPlanoPagto){
        this.codigoPlanoPagto = codigoPlanoPagto;
    }
    
    public String toXML() {        
          String xml = "<cl>" +
                  "<c>" + getCodigo() + "</c>" +
                  "<n>" + removerCaracteresEspeciais(getNome()) + "</n>" +
                  "<email>"+ removerCaracteresEspeciais(getEmail()) +"</email>" + 
                  "<lo>"+ removerCaracteresEspeciais(getEndereco().getLogradouro()) +"</lo>" +
                  "<b>"+ removerCaracteresEspeciais(getEndereco().getBairro()) +"</b>" +
                  "<nu>"+ removerCaracteresEspeciais(getEndereco().getNumero()) +"</nu>" +
                  "<comp>"+ removerCaracteresEspeciais(getEndereco().getComplemento()) +"</comp>" +
                  "<cep>"+ getEndereco().getCep() +"</cep>" +
                  "<pr>"+ removerCaracteresEspeciais(getEndereco().getPontoReferencia()) +"</pr>" +
                  "<codc>"+ getEndereco().getCidade().getCodigo() +"</codc>" +
                  "<cpf>"+ getDadosPessoaFisica().getCpf() +"</cpf>" +
                  "<rg>"+ getDadosPessoaFisica().getRg() +"</rg>" +
                  "<cnpj>"+ getDadosPessoaJuridica().getCnpj() +"</cnpj>" +
                  "<ie>"+ removerCaracteresEspeciais(getDadosPessoaJuridica().getInscricaoEstadual()) +"</ie>" +
                  "<nf>"+ removerCaracteresEspeciais(getDadosPessoaJuridica().getNomeFantasia()) +"</nf>" +
                  "<cr>"+ getLimiteCredito() +"</cr>" +
                  "<cpp>"+ getCodigoPlanoPagto()+"</cpp>" +
                         processarLstTelefoneToXML() +
                  "<posit>" + getPositivado() + "</posit>" +
                  "<dia>" + getDiaVisita() + "</dia>" +
                  "<catCodigo>" + getCategoria().getCodigo() + "</catCodigo>" +
                  "<catNome>" + getCategoria().getNome() + "</catNome>" +
                  "<dtUltPed>" + getDataUltimoPedido() + "</dtUltPed>" +
                  "<resp>" + removerCaracteresEspeciais(getResponsavel()) + "</resp>" +
                  "<lat>" + getEndereco().getLatitude() + "</lat>" +
                  "<lon>" + getEndereco().getLongitude() + "</lon>" +
                "</cl>";
          
          if (Valida(xml)){
            return xml;
          }
          return "";
    }
    

  public String removerCaracteresEspeciais(String passa)
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

    public int getPositivado() {
        return positivado;
    }

    public void setPositivado(int positivado) {
        this.positivado = positivado;
    }

    public int getCodigoEmpresaOrigem() {
        return codigoEmpresaOrigem;
    }

    public void setCodigoEmpresaOrigem(int codigoEmpresaOrigem) {
        this.codigoEmpresaOrigem = codigoEmpresaOrigem;
    }

    public int getDiaVisita() {
        return diaVisita;
    }

    public void setDiaVisita(int diaVisita) {
        this.diaVisita = diaVisita;
    }
       
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
   
    private boolean Valida(String series){   
        try{
            DocumentBuilder db = null;  
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();   
            db = dbf.newDocumentBuilder();  
  
            InputSource is = new InputSource(new ByteArrayInputStream(series.getBytes()));  
            Document doc = db.parse(is);
            return true;
        }catch (Exception e){
            return false;
        }
        
        /*try{                        
            
            // Define o tipo de Schema - vou usar o W3C:  
            String schemaLang = "http://www.w3.org/2001/XMLSchema";
            // Pega o Drive validation:  
            SchemaFactory factory = SchemaFactory.newInstance(schemaLang); 
            // Cria um schema de comparacao apartir de um arquivo XSD:  
            javax.xml.validation.Schema schema = factory.newSchema();  
            Validator validator = schema.newValidator();
            // Vamos chamar o metodo Validate para saber se o arquivo bate com o Schema:  
            validator.validate(new StreamSource(arq));
            return true;            
            
        }catch (Exception e){
            return false;
        }*/
    }

    public ArrayList getLstTelefone() {
        return lstTelefone;
    }

    public void setLstTelefone(ArrayList lstTelefone) {
        this.lstTelefone = lstTelefone;
    }

    public Date getDataUltimoPedido() {
        return dataUltimoPedido;
    }

    public void setDataUltimoPedido(Date dataUltimoPedido) {
        this.dataUltimoPedido = dataUltimoPedido;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
