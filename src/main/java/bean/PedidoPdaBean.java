package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;

import model.ItemPedido;
import model.ItemPedidoPda;
import model.Pedido;
import model.PedidoPda;
import repository.PedidoDAO;
import repository.PedidoPdaDAO;
import util.JpaUtil;
import util.Utilitarios;

@ManagedBean
@SessionScoped
public class PedidoPdaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private PedidoPda pedidoPdaSelecionado = new PedidoPda();;
	private float total = 0; 


	private List<PedidoPda> pedidosPda;
	private List<ItemPedidoPda> itensPedidoPda; 


	

	public void listaPedidoPda() throws Exception {
		
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO pedidoPdaDao = new PedidoPdaDAO(manager);
		
		pedidosPda = pedidoPdaDao.listarTodos(3);
		
		manager.close();
		
	}

	public void listaItemPedidoPda() {
		
		itensPedidoPda = pedidoPdaSelecionado.getItens();
		
	
	}
	


	public void excluir() {
		System.out.println("excluiu!!");
	}



	public PedidoPda getPedidoPdaSelecionado() {
		return pedidoPdaSelecionado;
	}

	public void setPedidoPdaSelecionado(PedidoPda pedidoPdaSelecionado) {
		this.pedidoPdaSelecionado = pedidoPdaSelecionado;
	}

	public List<PedidoPda> getPedidosPda() {
		return pedidosPda;
	}

	public void setPedidosPda(List<PedidoPda> pedidosPda) {
		this.pedidosPda = pedidosPda;
	}
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	public List<ItemPedidoPda> getItensPedidoPda() {
		return itensPedidoPda;
	}

	public void setItensPedidoPda(List<ItemPedidoPda> itensPedidoPda) {
		this.itensPedidoPda = itensPedidoPda;
	}

}
