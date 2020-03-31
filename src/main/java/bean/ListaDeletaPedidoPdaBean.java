package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.primefaces.context.RequestContext;


import model.ItemPedidoPda;
import model.PedidoPda;
import repository.PedidoPdaDAO;
import util.JpaUtil;

@ManagedBean
@SessionScoped
public class ListaDeletaPedidoPdaBean implements Serializable {
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

	

	public void excluirItemPedidoPda() throws Exception {
		
		EntityManager manager2 = JpaUtil.getEntityManager();
		PedidoPdaDAO pedidoPdaDao2 = new PedidoPdaDAO(manager2);
		
		pedidoPdaDao2.deletar(pedidoPdaSelecionado);
		manager2.close();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido excluido com sucesso", null));
		this.listaPedidoPda();
		
		
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


