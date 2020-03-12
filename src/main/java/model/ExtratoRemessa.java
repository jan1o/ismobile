package model;



import biblioteca.InterfaceObjeto;

/**
 *
 * @author marcos
 */
public class ExtratoRemessa implements Comparable, InterfaceObjeto{
    
    private int numeroDFe;
    private String chaveAcesso;
    private double qtdTotal;
    private double valorTotal;
    private double quantidadeDFe;
    private double valorDFe;
    private String tipoDFe;
    
    /** Creates a new instance of ExtratoRemessa */
    public ExtratoRemessa() {
        
    }

    public int compareTo(Object o) {
        ExtratoRemessa extratoRemessa = (ExtratoRemessa)o;
        return getChaveAcesso().compareTo(extratoRemessa.getChaveAcesso());
    }

    public String toXML() {
        return "<er>" +
                "<dfe>" + getNumeroDFe() + "</dfe>" +
                "<ch>" + getChaveAcesso() + "</ch>" +
                "<qt>" + getQtdTotal() + "</qt>" +
                "<vt>" + getValorTotal() + "</vt>" +
                "<q>" + getQuantidadeDFe() + "</q>" +
                "<v>" + getValorDFe() + "</v>" +
                "<tp>" + getTipoDFe() + "</tp>" +
                "</er>";
    }

    public int getNumeroDFe() {
        return numeroDFe;
    }

    public void setNumeroDFe(int numeroDFe) {
        this.numeroDFe = numeroDFe;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public double getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(double qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getQuantidadeDFe() {
        return quantidadeDFe;
    }

    public void setQuantidadeDFe(double quantidadeDFe) {
        this.quantidadeDFe = quantidadeDFe;
    }

    public double getValorDFe() {
        return valorDFe;
    }

    public void setValorDFe(double valorDFe) {
        this.valorDFe = valorDFe;
    }

    public String getTipoDFe() {
        return tipoDFe;
    }

    public void setTipoDFe(String tipoDFe) {
        this.tipoDFe = tipoDFe;
    }
    
}
