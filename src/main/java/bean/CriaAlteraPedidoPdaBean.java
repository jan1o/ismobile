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

	private List<SelectItem> clientesC;
	private List<SelectItem> produtosC;
	private List<SelectItem> condiPagamentoC;

	private List<ItemPedidoPda> itensPedidoPda;

	private ItemPedidoPda item = new ItemPedidoPda();

	// ************************************************************

	public void prepara() throws Exception {

		clientes = pdb.listaClientes();
		condicoesPg = pdb.listaCondicaoPagamento();
		produtos = pdb.listaProduto();

		clientesC = ClientesCombo();
		produtosC = ProdutoCombo();
		condiPagamentoC = CondPagamentoCombo();

	}

	public void Salvar() throws Exception {

		pedido.setLista(itensPedidoPda);
		pdb.cadastrarPedidoPda(pedido);

	}

	public void AdicionarProduto() {

		itensPedidoPda.add(item);
		// item = new ItemPedidoPda();

	}

	public void RemoveProduto() {

		itensPedidoPda.remove(itemSelecionado);

	}

	public void DialogQuantidade() {
		System.out.println("******************* TESTE**********");
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);

		RequestContext.getCurrentInstance().openDialog("DialogAddProduto", opcoes, null);
	}

	public List<SelectItem> ClientesCombo() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Cliente c : this.clientes) {
			// observem que o value do meu SelectItem é a própria entidade
			items.add(new SelectItem(c, c.getNome()));
		}
		return items;
	}

	public List<SelectItem> ProdutoCombo() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Produto p : this.produtos) {
			// observem que o value do meu SelectItem é a própria entidade
			items.add(new SelectItem(p, p.getDescricao()));
		}
		return items;
	}

	public List<SelectItem> CondPagamentoCombo() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (CondicaoPagamento c : this.condicoesPg) {
			// observem que o value do meu SelectItem é a própria entidade
			items.add(new SelectItem(c, c.getNome()));
		}
		return items;
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

	public List<SelectItem> getClientesC() {
		return clientesC;
	}

	public void setClientesC(List<SelectItem> clientesC) {
		this.clientesC = clientesC;
	}

	public List<SelectItem> getProdutosC() {
		return produtosC;
	}

	public void setProdutosC(List<SelectItem> produtosC) {
		this.produtosC = produtosC;
	}

	public List<SelectItem> getCondiPagamentoC() {
		return condiPagamentoC;
	}

	public void setCondiPagamentoC(List<SelectItem> condiPagamentoC) {
		this.condiPagamentoC = condiPagamentoC;
	}
	
	

}
