package model;



import biblioteca.InterfaceObjeto;


public class MetaPedido implements InterfaceObjeto{
    private Vendedor vendedor;
    private int semana;
    private int posPedido;
    private int posCliente;
    private double pontuacao;  
        
    public MetaPedido(){
        setVendedor(new Vendedor());
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public int getPosPedido() {
        return posPedido;
    }

    public void setPosPedido(int posPedido) {
        this.posPedido = posPedido;
    }

    public int getPosCliente() {
        return posCliente;
    }

    public void setPosCliente(int posCliente) {
        this.posCliente = posCliente;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String toXML() {
        return "<mp>" +
                    "<cv>" + getVendedor().getCodigo() + "</cv>" +
                    "<v>" + getVendedor().getNome() + "</v>" +
                    "<s>" + getSemana() + "</s>" +
                    "<pp>" + getPosPedido() + "</pp>" +
                    "<pc>" + getPosCliente() + "</pc>" +
                    "<p>" + getPontuacao() + "</p>" +
                "</mp>";
    }
    
}
