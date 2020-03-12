package model;


import java.util.Date;


import biblioteca.InterfaceObjeto;

public class Produto implements Comparable, InterfaceObjeto{
    
	private int codigo;
    private String descricao; 
    private String sigla_unidade;
    private double quantidade;
    private double valor;
    private int codigo_grupo;
    private int codigo_fabricante;
    private int codigo_subgrupo;
    private int qtdEmbalagem;
    private double comissao;
    private int codigo_setor;
    private double valorMinimo;
    private int positivado;
    private String referencia;
    private double pisoNegociacao;
    private double tetoNegociacao;
    private String statusValor;
    private Date ultimaVenda;
    private String infAdicional;
    private Date validade;
    private String stValidade;
    private String fotoWeb;
    private int bloquearAcrescimo;
    private double valorCompra;
    private double valorCusto;
    private double margemLucro;
    
    /** Creates a new instance of Produto */
    public Produto() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getSigla_unidade() {
        return sigla_unidade;
    }

    public void setSigla_unidade(String sigla_unidade) {
        this.sigla_unidade = sigla_unidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo_grupo() {
        return codigo_grupo;
    }

    public void setCodigo_grupo(int codigo_grupo) {
        this.codigo_grupo = codigo_grupo;
    }
    
    public int getCodigo_subgrupo() {
        return codigo_subgrupo;
    }
    
    public void setCodigo_subgrupo(int codigo_subgrupo) {
        this.codigo_subgrupo = codigo_subgrupo;
    }

    public int getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }
    
    public int getQtdEmbalagem() {
        return qtdEmbalagem;
    }

    public void setQtdEmbalagem(int qtdEmbalagem) {
        this.qtdEmbalagem = qtdEmbalagem;
    }

    
    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
     public int getCodigo_setor() {
        return codigo_setor;
    }

    public void setCodigo_setor(int codigo_setor) {
        this.codigo_setor = codigo_setor;
    }
    
    public double getValorMinimo() {
        return valorMinimo;
    }
    
    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }
    
    public int compareTo(Object o) {
        Produto produto = (Produto)o;
        return getDescricao().compareTo(produto.getDescricao());
    }
     
    public String toXML(){
        return "<p>" +
                "<c>" + getCodigo() + "</c>" +
                "<d>" + removerCaracteresEspeciais(getDescricao()) + "</d>" +
                "<u>" + getSigla_unidade() + "</u>" +
                "<q>" + getQuantidade() + "</q>" +
                "<v>" + getValor() + "</v>" +
                "<cg>" + getCodigo_grupo() + "</cg>" +
                "<cs>" + getCodigo_subgrupo() + "</cs>" +
                "<cf>" + getCodigo_fabricante() + "</cf>" +
                "<qe>" + getQtdEmbalagem() + "</qe>" +
                "<co>" + getComissao() + "</co>" +
                "<csetor>" + getCodigo_setor() + "</csetor>" +
                "<vm>" + getValorMinimo() + "</vm>" +
                "<posit>" + getPositivado() + "</posit>" +
                "<ref>" + getReferencia() + "</ref>" +
                "<pneg>" + getPisoNegociacao() + "</pneg>" +
                "<tneg>" + getTetoNegociacao() + "</tneg>" +
                "<status>" + getStatusValor() + "</status>" +
                "<ultVenda>" + getUltimaVenda() + "</ultVenda>" +
                "<infad>" + getInfAdicional() + "</infad>" +
                "<valid>" + getValidade() + "</valid>" +
                "<stvalid>" + getStValidade() + "</stvalid>" +
                "<fotoweb>" + getFotoWeb() + "</fotoweb>" +
                "<bloqAcr>" + getBloquearAcrescimo() + "</bloqAcr>" +
                "<compra>" + getValorCompra() + "</compra>" +
                "<custo>" + getValorCusto() + "</custo>" +
                "<margem>" + getMargemLucro() + "</margem>" +
                "</p>";
        
    }
    
      public String removerCaracteresEspeciais(String passa)
    {   
        if (passa != null) {
        passa = passa.replaceAll("[ÂÀÁÄÃ]","A");   
        passa = passa.replaceAll("[âãàáä]","a");   
        passa = passa.replaceAll("[ÊÈÉË&]","E");   
        passa = passa.replaceAll("[êèéë]","e");   
        passa = passa.replaceAll("ÎÍÌÏ","I");   
        passa = passa.replaceAll("îíìï","i");   
        passa = passa.replaceAll("[ÔÕÒÓÖ]","O");   
        passa = passa.replaceAll("[ôõòóö]","o");   
        passa = passa.replaceAll("[ÛÙÚÜ]","U");   
        passa = passa.replaceAll("[ûúùü]","u");   
        passa = passa.replaceAll("Ç","C");   
        passa = passa.replaceAll("ç","c");    
        passa = passa.replaceAll("[ýÿ]","y");   
        passa = passa.replaceAll("Ý","Y");   
        passa = passa.replaceAll("ñ","n");   
        passa = passa.replaceAll("Ñ","N"); 
        passa = passa.replaceAll("['<>\\|/°-]","");
      }      
      return passa.trim();
   } 

    public int getPositivado() {
        return positivado;
    }

    public void setPositivado(int positivado) {
        this.positivado = positivado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPisoNegociacao() {
        return pisoNegociacao;
    }

    public void setPisoNegociacao(double pisoNegociacao) {
        this.pisoNegociacao = pisoNegociacao;
    }

    public double getTetoNegociacao() {
        return tetoNegociacao;
    }

    public void setTetoNegociacao(double tetoNegociacao) {
        this.tetoNegociacao = tetoNegociacao;
    }

    public String getStatusValor() {
        return statusValor;
    }

    public void setStatusValor(String statusValor) {
        this.statusValor = statusValor;
    }

    public Date getUltimaVenda() {
        return ultimaVenda;
    }

    public void setUltimaVenda(Date ultimaVenda) {
        this.ultimaVenda = ultimaVenda;
    }

    public String getInfAdicional() {
        return infAdicional;
    }

    public void setInfAdicional(String infAdicional) {
        this.infAdicional = infAdicional;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getStValidade() {
        return stValidade;
    }

    public void setStValidade(String stValidade) {
        this.stValidade = stValidade;
    }

    public String getFotoWeb() {
        return fotoWeb;
    }

    public void setFotoWeb(String fotoWeb) {
        this.fotoWeb =  fotoWeb;
    }

    public int getBloquearAcrescimo() {
        return bloquearAcrescimo;
    }

    public void setBloquearAcrescimo(int bloquearAcrescimo) {
        this.bloquearAcrescimo = bloquearAcrescimo;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }
}
