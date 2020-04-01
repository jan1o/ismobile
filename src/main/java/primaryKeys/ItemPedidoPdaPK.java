package primaryKeys;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ItemPedidoPdaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int numero_pedido_pda;
	private int codigo_vendedor;
	
	public int getNumero_pedido_pda() {
		return numero_pedido_pda;
	}
	public void setNumero_pedido_pda(int numero_pedido_pda) {
		this.numero_pedido_pda = numero_pedido_pda;
	}
	public int getCodigo_vendedor() {
		return codigo_vendedor;
	}
	public void setCodigo_vendedor(int codigo_vendedor) {
		this.codigo_vendedor = codigo_vendedor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo_vendedor;
		result = prime * result + numero_pedido_pda;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPdaPK other = (ItemPedidoPdaPK) obj;
		if (codigo_vendedor != other.codigo_vendedor)
			return false;
		if (numero_pedido_pda != other.numero_pedido_pda)
			return false;
		return true;
	}
	
	

}
