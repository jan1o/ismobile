package model;

/*
 * Relatorio.java
 *
 * Created on 10 de Agosto de 2010, 09:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;


/**
 *
 * @author Marcos
 */
public class Relatorio implements Comparable, InterfaceObjeto{
    
    private Vendedor vendedor; 
    private double valorTotalPedido;
    private int qtdPedido;
    private double valorComissao;
    private int positivacaoCliente;
    private int carteiraCliente;
    private int positivacaoProduto;
    private double qtdVendida;
    private double qtdEmbalagem;
    private int qtdOutrosPedidos;
    private double outrosPedidos;
    private double valorTotalBruto;
    private double valorMeta;
    private Meta meta;
    
    /** Creates a new instance of Relatorio */
    public Relatorio() {
        setVendedor(new Vendedor());
        setMeta(new Meta());
    }
  
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public int getQtdPedido() {
        return qtdPedido;
    }

    public void setQtdPedido(int qtdPedido) {
        this.qtdPedido = qtdPedido;
    }

    public double getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(double valorComissao) {
        this.valorComissao = valorComissao;
    }

    public int getPositivacaoCliente() {
        return positivacaoCliente;
    }

    public void setPositivacaoCliente(int positivacaoCliente) {
        this.positivacaoCliente = positivacaoCliente;
    }

    public int getCarteiraCliente() {
        return carteiraCliente;
    }

    public void setCarteiraCliente(int carteiraCliente) {
        this.carteiraCliente = carteiraCliente;
    }

    public int getPositivacaoProduto() {
        return positivacaoProduto;
    }

    public void setPositivacaoProduto(int positivacaoProduto) {
        this.positivacaoProduto = positivacaoProduto;
    }

    public double getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(double qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    public double getQtdEmbalagem() {
        return qtdEmbalagem;
    }

    public void setQtdEmbalagem(double qtdEmbalagem) {
        this.qtdEmbalagem = qtdEmbalagem;
    }
    
    public int compareTo(Object o) {
        Vendedor vendedor = (Vendedor)o;
        return getVendedor().getNome().compareTo(vendedor.getNome());
    }

    public String toXML() {
        return "<rel>" +
                "<cv>" + getVendedor().getCodigo() + "</cv>" +
                "<v>" + getVendedor().getNome() + "</v>" +
                "<vt>" + getValorTotalPedido() + "</vt>" +
                "<qp>" + getQtdPedido() + "</qp>" +
                "<c>" + getValorComissao() + "</c>" +
                "<pc>" + getPositivacaoCliente() + "</pc>" +
                "<cc>" + getCarteiraCliente() + "</cc>" +
                "<pp>" + getPositivacaoProduto() + "</pp>" +
                "<qv>" + getQtdVendida() + "</qv>" +
                "<qe>" + getQtdEmbalagem() + "</qe>" +
                "<fl>" + getVendedor().getFlex() + "</fl>" +
                "<sf>" + getVendedor().getSaldoFlex() + "</sf>" + 
                "<qo>" + getQtdOutrosPedidos() + "</qo>" +
                "<vo>" + getOutrosPedidos() + "</vo>" +
                "<vb>" + getValorTotalBruto() + "</vb>" +
                "<meta>" + getValorMeta() + "</meta>" +
                    getMeta().toString() +
                "</rel>";

    }

    public int getQtdOutrosPedidos() {
        return qtdOutrosPedidos;
    }

    public void setQtdOutrosPedidos(int qtdOutrosPedidos) {
        this.qtdOutrosPedidos = qtdOutrosPedidos;
    }

    public double getOutrosPedidos() {
        return outrosPedidos;
    }

    public void setOutrosPedidos(double outrosPedidos) {
        this.outrosPedidos = outrosPedidos;
    }

    public double getValorTotalBruto() {
        return valorTotalBruto;
    }

    public void setValorTotalBruto(double valorTotalBruto) {
        this.valorTotalBruto = valorTotalBruto;
    }

    public double getValorMeta() {
        return valorMeta;
    }

    public void setValorMeta(double valorMeta) {
        this.valorMeta = valorMeta;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}