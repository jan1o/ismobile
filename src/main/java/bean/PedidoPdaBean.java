package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;

import org.primefaces.context.RequestContext;

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

	private PedidoPda pedidoPdaSelecionado = new PedidoPda();
	private float total = 0; 

	private List<PedidoPda> pedidosPda;
	private List<ItemPedidoPda> itemPedidoPda;


	

	public void listaPedidoPda() throws Exception {
		
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO pedidoPdaDao = new PedidoPdaDAO(manager);
		
		pedidosPda = pedidoPdaDao.listarTodos(3);
		
		manager.close();
		
	}
	
	public void listaItemPedidoPda() {
		
		itemPedidoPda = pedidoPdaSelecionado.getItens();
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);
		
		RequestContext.getCurrentInstance().openDialog("itemPedidoPda", opcoes, null);
	}

	

	public void excluirItemPedidoPda() {
		
		EntityManager manager2 = JpaUtil.getEntityManager();
		PedidoPdaDAO pedidoPdaDao2 = new PedidoPdaDAO(manager2);
		
		pedidoPdaDao2.deletar(pedidoPdaSelecionado);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido excluido com sucesso", null));
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
	public List<ItemPedidoPda> getItemPedidoPda() {
		return itemPedidoPda;
	}

	public void setItemPedidoPda(List<ItemPedidoPda> itemPedidoPda) {
		this.itemPedidoPda = itemPedidoPda;
	}
}


