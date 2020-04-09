package business;

import java.util.List;

import javax.persistence.EntityManager;

import model.Cliente;
import model.CondicaoPagamento;
import model.ItemPedidoPda;
import model.PedidoPda;
import model.Produto;
import model.Usuario;
import model.Vendedor;
import primaryKeys.ItemPedidoPdaPK;
import repository.ClienteDAO;
import repository.PedidoPdaDAO;
import repository.PlanoPagamentoDAO;
import repository.ProdutoDAO;
import repository.UsuarioPermissaoDAO;
import repository.VendedorDAO;
import sessao.SessionContext;
import util.JpaUtil;
import util.Utilitarios;

public class PedidoPdaBusiness {
	
	public List<Produto> listaProduto(){
		EntityManager manager = JpaUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(manager);
		
		List<Produto> lista = dao.listarProdutos();
		return lista;
	}
	
	public List<CondicaoPagamento> listaCondicaoPagamento(){
		EntityManager manager = JpaUtil.getEntityManager();
		PlanoPagamentoDAO dao = new PlanoPagamentoDAO(manager);
		
		List<CondicaoPagamento> lista = dao.listarCondicoesPagamento();
		return lista;
	}
	
	public List<Cliente> listaClientes() throws Exception{
		EntityManager manager = JpaUtil.getEntityManager();
		ClienteDAO dao = new ClienteDAO(manager);
		
		List<Cliente> lista = dao.listarClientes();
		return lista;
	}
	
	public List<PedidoPda> listaPedidoPda(){
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO dao = new PedidoPdaDAO(manager);
		
		
		List<PedidoPda> lista = dao.listarTodos(SessionContext.getInstance().getUsuarioLogado().getId());
		manager.close();
		
		return lista;
	}
	
	
	public void cadastrarPedidoPda(PedidoPda pedido) throws Exception {
		//DAO de pedidoPda
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO pdao = new PedidoPdaDAO(manager);
		
		//Usuario logado
		Usuario usu = SessionContext.getInstance().getUsuarioLogado();
				
		//DAO de usuario permissao para pegar e alterar o numero do pedido pda
		UsuarioPermissaoDAO udao = new UsuarioPermissaoDAO(new Utilitarios().configuracaoPostgres());
		Vendedor v = udao.getDadosVendedor(usu.getNome());
		
		//DAO de Vendedor
		EntityManager manager2 = JpaUtil.getEntityManager();
		VendedorDAO vdao = new VendedorDAO(manager2);
		
		//Setar numero do pedido pda e codigo do vendedor ao pedido e aos itens
		pedido.setNumero(v.getSequencia_pedido_pda() + 1);
		pedido.setVendedor(vdao.getVendedorPorId(v.getCodigo()));
		for(ItemPedidoPda i : pedido.getLista()) {
			i.setNumero_pedido_pda(pedido.getNumero());
			i.getVendedor().setCodigo(pedido.getVendedor().getCodigo());
			//ItemPedidoPdaPK pk = new ItemPedidoPdaPK(pedido.getNumero(), pedido.getVendedor().getCodigo());
			//i.setPk(pk);
		}
		
		//Adicionar o novo pedido pda
		pdao.salvar(pedido);
		
		//Incrementar a sequencia_pedido_pda do vendedor
		udao.updateSequenciaPedidoPda(v);
		
		manager.close();
	}
	
	public void alterarPedidoPda(PedidoPda pedido) {
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO dao = new PedidoPdaDAO(manager);
		
		dao.salvar(pedido);
	}
	
	public void excluirPedidoPda(PedidoPda pedido) {
		EntityManager manager = JpaUtil.getEntityManager();
		PedidoPdaDAO dao = new PedidoPdaDAO(manager);
		
		dao.deletar(pedido);
		
		manager.close();
	}
}
