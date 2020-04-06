package bean;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.primefaces.context.RequestContext;

import business.PedidoPdaBusiness;
import model.Cliente;
import model.ItemPedidoPda;
import model.PedidoPda;
import model.Produto;
import repository.PedidoPdaDAO;
import util.JpaUtil;

@ManagedBean
@SessionScoped
public class CriaAlteraPedidoPdaBean {
	private static final long serialVersionUID = 1L;
	
	private PedidoPda pedido = new PedidoPda();
	private PedidoPdaBusiness pdb = new PedidoPdaBusiness();
	
	//**************Testes para a tela NovoPedidoPda**************
	private List<Cliente> clientes;
	private Cliente cliente = new Cliente();
	private Date data;
	
	
	private List<Produto> produtos;
	private Produto produto = new Produto();
	//************************************************************
	
	

	public void prepara() {
		
		clientes = pdb.listaClientes();
		
	}
	
	public void Salvar() {
		
	}
	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PedidoPda getPedido() {
		return pedido;
	}

	public void setPedido(PedidoPda pedido) {
		this.pedido = pedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PedidoPdaBusiness getPdb() {
		return pdb;
	}

	public void setPdb(PedidoPdaBusiness pdb) {
		this.pdb = pdb;
	}
	


}
