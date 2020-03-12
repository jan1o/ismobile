package model;

/*
 * Meta.java
 *
 * Created on 20 de Abril de 2017, 09:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;

/**
 *
 * @author Marcos
 */
public class Meta implements InterfaceObjeto{
    
    private int qtdTotalItens;
    private int positivacaoCPF;
    private int positivacaoCNPJ;
    private double mediaLiquidaCliSKU;
    private double mediaBrutaCliSKU;
    private int positivacaoMesAnterior;
    private int positivacaoTotal;
    private int mixValor;
    private int industrializado;
    private int margarina;
    private int outros; 
    
    private String periodo;
    private Supervisor supervisor;
    private Vendedor vendedor;
    private Fabricante fabricante;
    private double totalVendas;
    private double totalVendasMes;
    private double mediaTrimestre;
    private double faltaAtingir;
    private double faltaAtingirPercentual; 
    private double metaReal;
    private double metaMes;
    private double metaSemana;
    private double metaDia;
    private int diasUteisMes;
    private int diasUteisTrabalhados;
    private double realizadoValor;
    private double realizadoPercentual;    
    private double tendenciaValor;
    private double tendenciaPercentual;
      
    
    public Meta() {
        setQtdTotalItens(0);
        setPositivacaoCPF(0);
        setPositivacaoCNPJ(0);
        setMediaLiquidaCliSKU(0);
        setMediaBrutaCliSKU(0);
        setPositivacaoMesAnterior(0);
        setPositivacaoTotal(0);
        setMixValor(0);
        setIndustrializado(0);
        setMargarina(0);
        setOutros(0);    
        
        setPeriodo("");
        setSupervisor(new Supervisor());
        setVendedor(new Vendedor());
        setFabricante(new Fabricante());
        setTotalVendas(0);
        setTotalVendasMes(0);
        setMediaTrimestre(0);
        setFaltaAtingir(0);
        setFaltaAtingirPercentual(0);
        setMetaReal(0);
        setMetaMes(0);
        setMetaSemana(0);
        setMetaDia(0);
        setDiasUteisMes(0);
        setDiasUteisTrabalhados(0);
        setRealizadoValor(0);
        setRealizadoPercentual(0);       
        setTendenciaValor(0);
        setTendenciaPercentual(0);
    }

    public int getQtdTotalItens() {
        return qtdTotalItens;
    }

    public void setQtdTotalItens(int qtdTotalItens) {
        this.qtdTotalItens = qtdTotalItens;
    }

    public int getPositivacaoCPF() {
        return positivacaoCPF;
    }

    public void setPositivacaoCPF(int positivacaoCPF) {
        this.positivacaoCPF = positivacaoCPF;
    }

    public int getPositivacaoCNPJ() {
        return positivacaoCNPJ;
    }

    public void setPositivacaoCNPJ(int positivacaoCNPJ) {
        this.positivacaoCNPJ = positivacaoCNPJ;
    }

    public double getMediaLiquidaCliSKU() {
        return mediaLiquidaCliSKU;
    }

    public void setMediaLiquidaCliSKU(double mediaLiquidaCliSKU) {
        this.mediaLiquidaCliSKU = mediaLiquidaCliSKU;
    }

    public double getMediaBrutaCliSKU() {
        return mediaBrutaCliSKU;
    }

    public void setMediaBrutaCliSKU(double mediaBrutaCliSKU) {
        this.mediaBrutaCliSKU = mediaBrutaCliSKU;
    }

    public int getPositivacaoMesAnterior() {
        return positivacaoMesAnterior;
    }

    public void setPositivacaoMesAnterior(int positivacaoMesAnterior) {
        this.positivacaoMesAnterior = positivacaoMesAnterior;
    }

    public int getPositivacaoTotal() {
        return positivacaoTotal;
    }

    public void setPositivacaoTotal(int positivacaoTotal) {
        this.positivacaoTotal = positivacaoTotal;
    }

    public int getMixValor() {
        return mixValor;
    }

    public void setMixValor(int mixValor) {
        this.mixValor = mixValor;
    }

    public int getIndustrializado() {
        return industrializado;
    }

    public void setIndustrializado(int industrializado) {
        this.industrializado = industrializado;
    }

    public int getMargarina() {
        return margarina;
    }

    public void setMargarina(int margarina) {
        this.margarina = margarina;
    }

    public int getOutros() {
        return outros;
    }

    public void setOutros(int outros) {
        this.outros = outros;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getMediaTrimestre() {
        return mediaTrimestre;
    }

    public void setMediaTrimestre(double mediaTrimestre) {
        this.mediaTrimestre = mediaTrimestre;
    }

    public double getMetaReal() {
        return metaReal;
    }

    public void setMetaReal(double metaReal) {
        this.metaReal = metaReal;
    }

    public double getMetaSemana() {
        return metaSemana;
    }

    public void setMetaSemana(double metaSemana) {
        this.metaSemana = metaSemana;
    }

    public double getMetaDia() {
        return metaDia;
    }

    public void setMetaDia(double metaDia) {
        this.metaDia = metaDia;
    }

    public double getRealizadoValor() {
        return realizadoValor;
    }

    public void setRealizadoValor(double realizadoValor) {
        this.realizadoValor = realizadoValor;
    }

    public double getRealizadoPercentual() {
        return realizadoPercentual;
    }

    public void setRealizadoPercentual(double realizadoPercentual) {
        this.realizadoPercentual = realizadoPercentual;
    }

    public double getFaltaAtingir() {
        return faltaAtingir;
    }

    public void setFaltaAtingir(double faltaAtingir) {
        this.faltaAtingir = faltaAtingir;
    }

    public double getTendenciaValor() {
        return tendenciaValor;
    }

    public void setTendenciaValor(double tendenciaValor) {
        this.tendenciaValor = tendenciaValor;
    }

    public double getTendenciaPercentual() {
        return tendenciaPercentual;
    }

    public void setTendenciaPercentual(double tendenciaPercentual) {
        this.tendenciaPercentual = tendenciaPercentual;
    }
    
    public String toXML() {
        return "<mt>" +
                    "<qti>" + getQtdTotalItens() + "</qti>" +
                    "<pcpf>" + getPositivacaoCPF() + "</pcpf>" +
                    "<pcnpj>" + getPositivacaoCNPJ() + "</pcnpj>" +
                    "<mlcsku>" + getMediaLiquidaCliSKU() + "</mlcsku>" +
                    "<mbcsku>" + getMediaBrutaCliSKU() + "</mbcsku>" +
                    "<pma>" + getPositivacaoMesAnterior() + "</pma>" +
                    "<ptotal>" + getPositivacaoTotal() + "</ptotal>" +
                    "<mv>" + getMixValor() + "</mv>" +
                    "<ind>" + getIndustrializado() + "</ind>" +
                    "<marg>" + getMargarina() + "</marg>" +
                    "<outros>" + getOutros() + "</outros>" +
                    "<periodo>" + getPeriodo() + "</periodo>" +
                    "<supcod>" + getSupervisor().getCodigo() + "</supcod>" +
                    "<supnome>" + getSupervisor().getNome() + "</supnome>" +
                    "<vendcod>" + getVendedor().getCodigo() + "</vendcod>" +
                    "<vendnome>" + getVendedor().getNome() + "</vendnome>" +
                    "<totalvendas>" + getTotalVendas() + "</totalvendas>" +
                    "<totalvendasmes>" + getTotalVendasMes() + "</totalvendasmes>" +
                    "<medtri>" + getMediaTrimestre() + "</medtri>" +
                    "<metareal>" + getMetaReal() + "</metareal>" +
                    "<metames>" + getMetaMes() + "</metames>" +
                    "<metasemana>" + getMetaSemana() + "</metasemana>" +
                    "<metadia>" + getMetaDia() + "</metadia>" +
                    "<diasuteis>" + getDiasUteisMes() + "</diasuteis>" +
                    "<diasuteistrab>" + getDiasUteisTrabalhados() +"</diasuteistrab>" +
                    "<realval>" + getRealizadoValor() + "</realval>" +
                    "<realperc>" + getRealizadoPercentual() + "</realperc>" +
                    "<falta>" + getFaltaAtingir() + "</falta>" +
                    "<faltaperc>" + getFaltaAtingirPercentual() + "</faltaperc>" +
                    "<tendval>" + getTendenciaValor() + "</tendval>" +
                    "<tendperc>" + getTendenciaPercentual() + "</tendperc>" +
                    "<fabcod>" + getFabricante().getCodigo() + "</fabcod>" +
                    "<fabnome>" + getFabricante().getNome() + "</fabnome>" +
                "</mt>";
    }
    
    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getTotalVendasMes() {
        return totalVendasMes;
    }

    public void setTotalVendasMes(double totalVendasMes) {
        this.totalVendasMes = totalVendasMes;
    }

    public double getFaltaAtingirPercentual() {
        return faltaAtingirPercentual;
    }

    public void setFaltaAtingirPercentual(double faltaAtingirPercentual) {
        this.faltaAtingirPercentual = faltaAtingirPercentual;
    }

    public double getMetaMes() {
        return metaMes;
    }

    public void setMetaMes(double metaMes) {
        this.metaMes = metaMes;
    }

    public int getDiasUteisMes() {
        return diasUteisMes;
    }

    public void setDiasUteisMes(int diasUteisMes) {
        this.diasUteisMes = diasUteisMes;
    }

    public int getDiasUteisTrabalhados() {
        return diasUteisTrabalhados;
    }

    public void setDiasUteisTrabalhados(int diasUteisTrabalhados) {
        this.diasUteisTrabalhados = diasUteisTrabalhados;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
}
