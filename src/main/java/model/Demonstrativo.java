package model;




import biblioteca.InterfaceObjeto;

/**
 *
 * @author Marcos
 */
public class Demonstrativo implements Comparable, InterfaceObjeto{
    
    private String periodo;
    private double vendaTotal;
    private double vendaLiquida;
    private double custoLiquido;
    private double valorCancelamento;
    private double valorAcerto;
    
    /** Creates a new instance of Demonstrativo */
    public Demonstrativo() {
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public double getVendaTotal() {
        return vendaTotal;
    }

    public void setVendaTotal(double vendaTotal) {
        this.vendaTotal = vendaTotal;
    }

    public double getVendaLiquida() {
        return vendaLiquida;
    }

    public void setVendaLiquida(double vendaLiquida) {
        this.vendaLiquida = vendaLiquida;
    }

    public double getCustoLiquido() {
        return custoLiquido;
    }

    public void setCustoLiquido(double custoLiquido) {
        this.custoLiquido = custoLiquido;
    }

    public double getValorCancelamento() {
        return valorCancelamento;
    }

    public void setValorCancelamento(double valorCancelamento) {
        this.valorCancelamento = valorCancelamento;
    }

    public double getValorAcerto() {
        return valorAcerto;
    }

    public void setValorAcerto(double valorAcerto) {
        this.valorAcerto = valorAcerto;
    }

    public int compareTo(Object o) {
        Demonstrativo demonstrativo = (Demonstrativo)o;
        return getPeriodo().compareTo(demonstrativo.getPeriodo());
    }

    public String toXML() {
        return "<d>" +
                "<pe>" + getPeriodo() + "</pe>" +
                "<vt>" + getVendaTotal() + "</vt>" +
                "<vl>" + getVendaLiquida() + "</vl>" +
                "<cl>" + getCustoLiquido() + "</cl>" +
                "<vc>" + getValorCancelamento() + "</vc>" +
                "<va>" + getValorAcerto() + "</va>" +
                "</d>";
    }
    
}
