package primaryKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.Produto;
import model.Vendedor;

@Embeddable
public class ItemPedidoPdaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "numero_pedido_pda")
	private int numero_pedido_pda;
	
	@ManyToOne @JoinColumn(name="codigo_vendedor", nullable=true, foreignKey = @ForeignKey(name = "item_pedido_pda_c_ve_fk"))
	private Vendedor vendedor;
	
	@ManyToOne @JoinColumn(name="codigo_produto", nullable=true, foreignKey = @ForeignKey(name = "item_pedido_pda_c_p_fk"))
	private Produto produto;

	public int getNumero_pedido_pda() {
		return numero_pedido_pda;
	}

	public void setNumero_pedido_pda(int numero_pedido_pda) {
		this.numero_pedido_pda = numero_pedido_pda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	

}
