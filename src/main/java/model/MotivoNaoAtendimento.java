package model;



import biblioteca.InterfaceObjeto;

public class MotivoNaoAtendimento  implements Comparable, InterfaceObjeto  {
    
    private int codigo;
    private String nome;
    
    public MotivoNaoAtendimento() {        
        setCodigo(999);
        setNome("INDEFINIDO");
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
    
    public int compareTo(Object o) {
        MotivoNaoAtendimento motivo = (MotivoNaoAtendimento)o;
        return getNome().compareTo(motivo.getNome());
    }
     
    public String toXML(){
        return "<m>" +
                "<c>" + getCodigo() + "</c>" +
                "<n>" + getNome().replace('&', 'E') + "</n>" +
                "</m>";
    }
    
}
