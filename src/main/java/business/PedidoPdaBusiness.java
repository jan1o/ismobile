package business;

import java.util.List;

import javax.persistence.EntityManager;

import model.Cliente;
import model.ItemPedidoPda;
import model.PedidoPda;
import model.Usuario;
import model.Vendedor;
import repository.ClienteDAO;
import repository.PedidoPdaDAO;
import repository.PlanoPagamentoDAO;
import repository.ProdutoDAO;
import repository.UsuarioPermissaoDAO;
import sessao.SessionContext;
import util.JpaUtil;
import util.Utilitarios;

public class PedidoPdaBusiness {
	
	// Soma o total do valor dos itens de um pedido
	public Double getSomaTotal(List<ItemPedidoPda> itens) {
		Double total = 0.0;
		
		for(ItemPedidoPda i : itens) {
			total += (i.getValor() * i.getQuantidade());
		}
		
		/*
		for(ItemPedidoPda i : itens) {
			total += i.getValor();
		} */
		
		return total;
	}
	
	// Retorna o nome do cliente a partir do seu codigo
	public String getNomeCliente(int codigo) throws Exception {
		
		ClienteDAO dao = new ClienteDAO(new Utilitarios().configuracaoPostgres());
		
		return dao.GetNomeCliente(codigo);
		
	}
	
	// Retorna a forma de pagamento a partir do seu codigo
	public String getFormaPagto(int codigo) throws Exception {
		
		PlanoPagamentoDAO dao = new PlanoPagamentoDAO(new Utilitarios().configuracaoPostgres());
		
		return dao.FormaPagamento(codigo);
	}
	
	public List<PedidoPda> listaPedidoPda(){
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO dao = new PedidoPdaDAO(manager);
		
		
		List<PedidoPda> lista = dao.listarTodos(SessionContext.getInstance().getUsuarioLogado().getCodigo_usuario());
		manager.close();
		
		return lista;
	}
	
	// retorna o nome do produto a partir do seu codigo
	public String getNomeProduto(int codigo) throws Exception {
		
		ProdutoDAO dao = new ProdutoDAO(new Utilitarios().configuracaoPostgres());
		
		return dao.getNomeProduto(codigo);
		
	}
	
	//Prepara os atributos para cadastro de um novo pedido
	public List<Cliente> preparaCadastro() throws Exception{
		ClienteDAO dao = new ClienteDAO(new Utilitarios().configuracaoPostgres());
		return dao.listaNomeCodigoClientes();
	}
	
	public void cadastrarPedidoPda(PedidoPda pedido) throws Exception {
		//DAO de pedidoPda
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO pdao = new PedidoPdaDAO(manager);
		
		//Usuario logado
		Usuario usu = SessionContext.getInstance().getUsuarioLogado();
				
		//DAO de usuario permissao para pegar e alterar o numero do pedido pda
		UsuarioPermissaoDAO udao = new UsuarioPermissaoDAO(new Utilitarios().configuracaoPostgres());
		Vendedor v = udao.getDadosVendedor(usu.getNome_usuario());
		
		//Setar numero do pedido pda e codigo do vendedor ao pedido e aos itens
		pedido.setNumero(v.getSequencia_pedido_pda() + 1);
		pedido.setCodigo_vendedor(v.getCodigo());
		for(ItemPedidoPda i : pedido.getItens()) {
			i.setNumero_pedido_pda(pedido.getNumero());
			i.setCodigo_vendedor(pedido.getCodigo_vendedor());
		}
		
		//Adicionar o novo pedido pda
		pdao.inserir(pedido);
		
		//Incrementar a sequencia_pedido_pda do vendedor
		udao.updateSequenciaPedidoPda(v);
		
		manager.close();
	}
	
	public void alterarPedidoPda(PedidoPda pedido) {
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO dao = new PedidoPdaDAO(manager);
		
		dao.alterar(pedido);
	}
	
	public void excluirPedidoPda(PedidoPda pedido) {
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO dao = new PedidoPdaDAO(manager);
		
		dao.deletar(pedido);
		
		manager.close();
	}
}
