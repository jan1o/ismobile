package model;

import java.util.ArrayList;
import java.util.Date;

public class PedidoPda {
	private int numero;
    private Date data;
    private Cliente cliente;
    private Vendedor vendedor;
    private CondicaoPagamento condicaoPagamento;
    private ArrayList lista;
    private int frios;
    private int retirado;
    private String obs;
    private int negociacao;
    private double latitude = 0;
    private double longitude = 0;
    private String inicioAtendimento;
    private String fimAtendimento;
    private String versaoApp;
    private int consignado;
    private int tipoDFe;
    private int qtdPedidoLote;
    private String logErro;
    
    /** Creates a new instance of Pedido */
    public PedidoPda() {
        setCliente(new Cliente());
        setVendedor(new Vendedor());
        setLista(new ArrayList());
        setCondicaoPagamento(new CondicaoPagamento());
        setQtdPedidoLote(0);
        setLogErro("");
    }
    
    // Construtor que povoa todo um pedidoPda
    public PedidoPda(int numero, Date data, int codCliente, int codVendedor, int codPlanoPag, int frios,
    		int retirado, String obs, int negociacao, double latitude, double longitude, String inicioAtendimento,
    		String fimAtendimento, String versaoApp, int consignado, int tipoDFe, int qtdPedidoLote) {
    	setCliente(new Cliente());
        setVendedor(new Vendedor());
        setLista(new ArrayList());
        setCondicaoPagamento(new CondicaoPagamento());
        setQtdPedidoLote(0);
        setLogErro("");
        
        this.numero = numero;
        this.data = data;
        this.cliente.setCodigo(codCliente);
        this.vendedor.setCodigo(codVendedor);
        this.condicaoPagamento.setCodigo(codPlanoPag);
        this.frios = frios;
        this.retirado = retirado;
        this.obs = obs;
        this.negociacao = negociacao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.inicioAtendimento = inicioAtendimento;
        this.fimAtendimento = fimAtendimento;
        this.versaoApp = versaoApp;
        this.consignado = consignado;
        this.tipoDFe = tipoDFe;
        this.qtdPedidoLote = qtdPedidoLote;
    }
    
    // Construtor que ja adiciona numero e vendedor ao pedidoPda (usar esse)
    public PedidoPda(int numeroPedido, int codVendedor) {
    	setCliente(new Cliente());
        setVendedor(new Vendedor());
        setLista(new ArrayList());
        setCondicaoPagamento(new CondicaoPagamento());
        setQtdPedidoLote(0);
        setLogErro("");
        
        this.numero = numeroPedido;
        this.vendedor.setCodigo(codVendedor);
       
    }
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

     public ArrayList getLista() {
        return lista;
    }

    public void setLista(ArrayList lista) {
        this.lista = lista;
    }

    public int getFrios() {
        return frios;
    }

    public void setFrios(int frios) {
        this.frios = frios;
    }

    public int getRetirado() {
        return retirado;
    }

    public void setRetirado(int retirado) {
        this.retirado = retirado;
    }
    
    public String getObs(){
        return obs;
    }
    
    public void setObs(String obs){
        this.obs = obs;
    }
    
    public int getNegociacao() {
        return negociacao;
    }

    public void setNegociacao(int negociacao) {
        this.negociacao = negociacao;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getInicioAtendimento() {
        return inicioAtendimento;
    }

    public void setInicioAtendimento(String inicioAtendimento) {
        this.inicioAtendimento = inicioAtendimento;
    }

    public String getFimAtendimento() {
        return fimAtendimento;
    }

    public void setFimAtendimento(String fimAtendimento) {
        this.fimAtendimento = fimAtendimento;
    }

    public String getVersaoApp() {
        return versaoApp;
    }

    public void setVersaoApp(String versaoApp) {
        this.versaoApp = versaoApp;
    }

    public int getConsignado() {
        return consignado;
    }

    public void setConsignado(int consignado) {
        this.consignado = consignado;
    }

    public int getTipoDFe() {
        return tipoDFe;
    }

    public void setTipoDFe(int tipoDFe) {
        this.tipoDFe = tipoDFe;
    }

    public int getQtdPedidoLote() {
        return qtdPedidoLote;
    }

    public void setQtdPedidoLote(int qtdPedidoLote) {
        this.qtdPedidoLote = qtdPedidoLote;
    }

    public String getLogErro() {
        return logErro;
    }

    public void setLogErro(String logErro) {
        this.logErro = logErro;
    }
}
