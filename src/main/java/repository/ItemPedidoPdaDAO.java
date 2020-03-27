package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.PedidoPda;
import model.ItemPedidoPda;

public class ItemPedidoPdaDAO {
	
	private EntityManager manager;
	
	public ItemPedidoPdaDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<ItemPedidoPda> listarPorPedidoPda(PedidoPda pedido){
		Query query = manager.createQuery(
				"from ItemPedidoPda i where i.numero_pedido_pda = :num and i.codigo_vendedor = :ven ");
		query.setParameter("num", pedido.getNumero());
		query.setParameter("ven", pedido.getCodigo_vendedor());
		return query.getResultList();
	}
	
	public void inserirItens(List<ItemPedidoPda> itens) {
		
		manager.getTransaction().begin();
		for(ItemPedidoPda i : itens) {
			manager.merge(i);
		}
		manager.getTransaction().commit();
	}
	
	public void deletarItensPedido(PedidoPda pedido) {
		manager.getTransaction().begin();
		for(ItemPedidoPda i : pedido.getItens()) {
			manager.remove(manager.getReference(ItemPedidoPda.class, i));
		}
		manager.getTransaction().commit();
	}
	
	//Isso é uma gambiarra meu consagrado! Pelas caridade, só use se for necessário e preferêncialmente altere!
	public void alterarItensPedido(PedidoPda pedido) {
		
		/* Ói meu fí, esse negocio tá funfando da seguinte forma:
		 * Em vez da funçã sair comparando item por item (o que levaria uma vida e seria demorado e dificil demais),
		 * ela simplesmente deleta todos os itensPedidoPda desse PedidoPda e adiciona os novos. Num disse que era uma gambiarra? 
		*/
		
		deletarItensPedido(pedido);
		inserirItens(pedido.getItens());
	}
	
}
