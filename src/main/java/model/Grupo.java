package model;



import biblioteca.InterfaceObjeto;

public class Grupo implements Comparable, InterfaceObjeto{
    
    private int codigo;
    private String nome;
    private int codigoGrupoTabela;
    private double meta;
    private double valor;
    private int metaPosCliente;
    private int posCliente;
    
    public Grupo() {
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
    
     public int getCodigoGrupoTabela() {
        return codigoGrupoTabela;
    }

    public void setCodigoGrupoTabela(int codigoGrupoTabela) {
        this.codigoGrupoTabela = codigoGrupoTabela;
    }
    
     public int compareTo(Object o) {
        Grupo grupo = (Grupo)o;
        return getNome().compareTo(grupo.getNome());
    }
     
    public String toXML(){
        return "<g>" +
                   "<c>" + getCodigo() + "</c>" +
                   "<n>" + getNome().replace('&', 'E') + "</n>" +
                   "<cgt>" + getCodigoGrupoTabela() + "</cgt>" +
                   "<meta>" + getMeta() + "</meta>" +
                   "<valor>" + getValor() + "</valor>" +
                   "<mpc>" + getMetaPosCliente() + "</mpc>" +
                   "<pc>" + getPosCliente() + "</pc>" +
               "</g>";
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getMetaPosCliente() {
        return metaPosCliente;
    }

    public void setMetaPosCliente(int metaPosCliente) {
        this.metaPosCliente = metaPosCliente;
    }

    public int getPosCliente() {
        return posCliente;
    }

    public void setPosCliente(int posCliente) {
        this.posCliente = posCliente;
    }
}
