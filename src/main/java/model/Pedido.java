package model;



import biblioteca.InterfaceObjeto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


/**
 *
 * @author Wallace
 */
public class Pedido implements Comparable, InterfaceObjeto{
    
    private int numero;
    private Date data;
    private Cliente cliente;
    private Vendedor vendedor;
    private CondicaoPagamento condicaoPagamento;
    private ArrayList lista;
    private int numeroPedidoPDA;
    
    /** Creates a new instance of Pedido */
    public Pedido() {
        cliente = new Cliente();
        vendedor = new Vendedor();
        lista   = new ArrayList();
        condicaoPagamento = new CondicaoPagamento();
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

    public int getNumeroPedidoPDA() {
        return numeroPedidoPDA;
    }

    public void setNumeroPedidoPDA(int numeroPedidoPDA) {
        this.numeroPedidoPDA = numeroPedidoPDA;
    }

    public int compareTo(Object o) {
        return 0;
    }

    public String toXML() {
        return "<p>" +
                "<id>" + getNumero() + "</id>" +
                "<pda>" + getNumeroPedidoPDA() + "</pda>" +
                "<vc>" + getVendedor().getCodigo() + "</vc>" +
                "<vn>" + removerCaracteresEspeciais(getVendedor().getNome()) + "</vn>" +
                "<cp>" + getCondicaoPagamento().getCodigo() + "</cp>" +
                "<cpn>" + removerCaracteresEspeciais(getCondicaoPagamento().getNome()) + "</cpn>" +
                "<cl>" + getCliente().getCodigo() + "</cl>" +
                "<cln>" + removerCaracteresEspeciais(getCliente().getNome()) + "</cln>" +
                "<dt>" + getData() + "</dt>" +
                    processarItens() +
                "</p>";
    }
   
    private String processarItens(){
        String retorno = "<lst>";
        Iterator it = getLista().iterator();
        while (it.hasNext()){        
            ItemPedido item = (ItemPedido)it.next();
            retorno += item.toXML();
        }
        retorno += "</lst>";
        
        return retorno;
    }
    
    private String removerCaracteresEspeciais(String passa)
    {   
      if (passa != null) {
        passa = passa.trim();
        passa = passa.replaceAll("[�����]","A");   
        passa = passa.replaceAll("[�����]","a");   
        passa = passa.replaceAll("[����&]","E");   
        passa = passa.replaceAll("[����]","e");   
        passa = passa.replaceAll("����","I");   
        passa = passa.replaceAll("����","i");   
        passa = passa.replaceAll("[�����]","O");   
        passa = passa.replaceAll("[�����]","o");   
        passa = passa.replaceAll("[����]","U");   
        passa = passa.replaceAll("[����]","u");   
        passa = passa.replaceAll("�","C");   
        passa = passa.replaceAll("�","c");    
        passa = passa.replaceAll("[��]","y");   
        passa = passa.replaceAll("�","Y");   
        passa = passa.replaceAll("�","n");   
        passa = passa.replaceAll("�","N");
        passa = passa.replaceAll("@","");
         passa = passa.replaceAll("_","");
        passa = passa.replaceAll("['<>\\|/�-]","");
      }      
      return passa;
   } 
}
