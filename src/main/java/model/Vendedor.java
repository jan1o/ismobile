package model;



/**
 *
 * @author Eder
 */
public class Vendedor {
    
    private int codigo;
    private String nome;
    private int numeroPedido;
    private Supervisor supervisor;
    private double flex;
    private double saldoFlex;
    
    /** Creates a new instance of Vendedor */
    public Vendedor() {
        supervisor = new Supervisor();
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

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
    
    public double getFlex(){
        return flex;
    }
    
    public void setFlex(double flex){
        this.flex = flex;
    }
    
    public double getSaldoFlex(){
        return saldoFlex;
    }
    
    public void setSaldoFlex(double saldoFlex){
        this.saldoFlex = saldoFlex;
    }

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
    
}
