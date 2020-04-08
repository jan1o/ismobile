package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import primaryKeys.ItemPedidoPdaPK;

@Entity
@Table(name = "item_pedido_pda")
@IdClass(ItemPedidoPdaPK.class)
public class ItemPedidoPda implements Comparable, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "numero_pedido_pda")
	private int numero_pedido_pda;
	@Id
	@ManyToOne
	@JoinColumn(name = "codigo_vendedor", nullable = true, foreignKey = @ForeignKey(name = "item_pedido_pda_c_ve_fk"))
	private Vendedor vendedor;

	@Id
	@ManyToOne
	@JoinColumn(name = "codigo_produto", nullable = true, foreignKey = @ForeignKey(name = "item_pedido_pda_c_p_fk"))
	private Produto produto;
	@Column
	private int quantidade; // numeric(18,4),

	@Column
	private Double valor; // numeric(18,4),

	

	public ItemPedidoPda() {

	}

	public ItemPedidoPda(int numero_pedido_pda, int codigo_vendedor, Produto produto, int quantidade, double valor) {

		// this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}

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

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	/*
	 * public Produto getProduto() { return produto; } public void
	 * setProduto(Produto produto) { this.produto = produto; }
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
