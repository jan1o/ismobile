package business;

import java.util.List;

import javax.persistence.EntityManager;

import model.Configuracao;
import model.ItemPedidoPda;
import model.PedidoPda;
import repository.ClienteDAO;
import repository.PedidoPdaDAO;
import repository.PlanoPagamentoDAO;
import repository.ProdutoDAO;
import sessao.SessionContext;
import util.JpaUtil;
import util.Utilitarios;

public class PedidoPdaBusiness {
	
	// Soma o total do valor dos itens de um pedido
	public Double somaTotal(List<ItemPedidoPda> itens) {
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
	public String NomeCliente(int codigo) throws Exception {
		
		ClienteDAO dao = new ClienteDAO(new Utilitarios().configuracaoPostgres());
		
		return dao.GetNomeCliente(codigo);
		
	}
	
	// Retorna a forma de pagamento a partir do seu codigo
	public String FormaPagto(int codigo) throws Exception {
		
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
	public String NomeProduto(int codigo) throws Exception {
		ProdutoDAO dao = new ProdutoDAO(new Utilitarios().configuracaoPostgres());
		
		return dao.getNomeProduto(codigo);
		
	}
}
