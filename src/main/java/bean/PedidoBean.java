package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import model.ItemPedido;
import model.Pedido;
import repository.PedidoDAO;
import util.Utilitarios;

@ManagedBean
@ViewScoped
public class PedidoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Pedido> pedidos;
	private List<ItemPedido> itemPedidos;
	private Pedido pedidoSelecionado = new Pedido();

	private Utilitarios util = new Utilitarios();
	private PedidoDAO pedidoDao;
	

	

	public void listaPedido() throws Exception {
		
		pedidoDao = new PedidoDAO(util.configuracaoPostgres());
	

		pedidos =  (List<Pedido>) pedidoDao.getListaPedidos(3, 0);
		
	}
	
	public void listaItemPedido() {
		System.out.println("teste");
		this.itemPedidos = (List<ItemPedido>) pedidoSelecionado.getLista();
		
		//System.out.println("teste" + itemPedidos.get(0).getQuantidade());
	}
	

	public void excluir() {
		System.out.println("excluiu!!");
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Utilitarios getUtil() {
		return util;
	}

	public void setUtil(Utilitarios util) {
		this.util = util;
	}

	public PedidoDAO getPedidoDao() {
		return pedidoDao;
	}

	public void setPedidoDao(PedidoDAO pedidoDao) {
		this.pedidoDao = pedidoDao;
	}
	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}


	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}


	public Pedido getPedidoSelecionado() {
		return pedidoSelecionado;
	}


	public void setPedidoSelecionado(Pedido pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}

}
