package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import Testes.PedidoTeste;

@ManagedBean
@ViewScoped
public class PedidoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<PedidoTeste> pedidos;
	private PedidoTeste pedido = null;
	private PedidoTeste pedido2 = null;

	public void teste() {
		System.out.println("**************PEDIDO CRIADO**************");
		
		pedido = new PedidoTeste("150", "teste", "15/02/2020", "150");
		pedido2 = new PedidoTeste("1", "teste2", "teste", "teste");
		
		pedidos = new ArrayList<PedidoTeste>();
		this.pedidos.add(pedido);
		this.pedidos.add(pedido2);
		System.out.println(pedidos.get(0).getId());
	}
	
	public void excluir() {
		System.out.println("excluiu!!");
	}

	public List<PedidoTeste> getPedidos() {
		return pedidos;
	}

	public PedidoTeste getPedido() {
		return pedido;
	}

	public void setPedido(PedidoTeste pedido) {
		this.pedido = pedido;
	}

	public void setPedidos(List<PedidoTeste> pedidos) {
		this.pedidos = pedidos;
	}

}
