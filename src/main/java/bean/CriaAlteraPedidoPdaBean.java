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
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;

import org.primefaces.context.RequestContext;

import business.PedidoPdaBusiness;
import model.Cliente;
import model.CondicaoPagamento;
import model.ItemPedidoPda;
import model.PedidoPda;
import model.Produto;
import repository.PedidoPdaDAO;
import util.JpaUtil;

@ManagedBean
@SessionScoped
public class CriaAlteraPedidoPdaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private PedidoPda pedido = new PedidoPda();
	private PedidoPdaBusiness pdb = new PedidoPdaBusiness();
	private ItemPedidoPda itemSelecionado = new ItemPedidoPda();

	// **************Testes para a tela NovoPedidoPda**************
	private List<Cliente> clientes;
	private List<CondicaoPagamento> condicoesPg;
	private List<Produto> produtos;

	private List<ItemPedidoPda> itensPedidoPda = new ArrayList<>();

	private ItemPedidoPda item; 

	// ************************************************************

	public void prepara() throws Exception {
		
		item = new ItemPedidoPda();
		clientes = pdb.listaClientes();
		condicoesPg = pdb.listaCondicaoPagamento();
		produtos = pdb.listaProduto();


	}

	public void Salvar() throws Exception {

		pedido.setLista(itensPedidoPda);
		pdb.cadastrarPedidoPda(pedido);

	}

	public void AdicionarProduto() {
		
		System.out.println("teste");
		System.out.println(item.getQuantidade() + " < quantidade");

		itensPedidoPda.add(item);
		item = new ItemPedidoPda();
		
		System.out.println(itensPedidoPda.get(0).getQuantidade());
		RequestContext.getCurrentInstance().closeDialog("DialogAddProduto");

	}

	public void RemoveProduto() {

		itensPedidoPda.remove(itemSelecionado);

	}

	public void DialogQuantidade() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 250);
		opcoes.put("contentWidth", 300);

		RequestContext.getCurrentInstance().openDialog("DialogAddProduto", opcoes, null);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public PedidoPda getPedido() {
		return pedido;
	}

	public void setPedido(PedidoPda pedido) {
		this.pedido = pedido;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public PedidoPdaBusiness getPdb() {
		return pdb;
	}

	public void setPdb(PedidoPdaBusiness pdb) {
		this.pdb = pdb;
	}

	public List<CondicaoPagamento> getCondicoesPg() {
		return condicoesPg;
	}

	public void setCondicoesPg(List<CondicaoPagamento> condicoesPg) {
		this.condicoesPg = condicoesPg;
	}

	public List<ItemPedidoPda> getItensPedidoPda() {
		return itensPedidoPda;
	}

	public void setItensPedidoPda(List<ItemPedidoPda> itensPedidoPda) {
		this.itensPedidoPda = itensPedidoPda;
	}

	public ItemPedidoPda getItem() {
		return item;
	}

	public void setItem(ItemPedidoPda item) {
		this.item = item;
	}

	public ItemPedidoPda getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(ItemPedidoPda itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}


}
