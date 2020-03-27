package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item_pedido_pda")
public class ItemPedidoPda implements Comparable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	private int numero_pedido_pda; // numeric(6,0) NOT NULL,
	
	@Id
	@NotNull
	private int codigo_vendedor; // numeric(6,0) NOT NULL,
	
	@Id
	@NotNull
	private int codigo_produto; // numeric(10,0) NOT NULL,
	
	@Column
	private int quantidade; // numeric(18,4),
	
	@Column
	private Double valor; // numeric(18,4),
	
	
	public ItemPedidoPda() {
		
	}
	public ItemPedidoPda(int numero_pedido_pda, int codigo_vendedor, int codigo_produto, int quantidade,
			double valor) {
		
		this.numero_pedido_pda = numero_pedido_pda;
		this.codigo_vendedor = codigo_vendedor;
		this.codigo_produto = codigo_produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getNumero_pedido_pda() {
		return numero_pedido_pda;
	}

	public void setNumero_pedido_pda(int numero_pedido_pda) {
		this.numero_pedido_pda = numero_pedido_pda;
	}

	public int getQuantidade() {
		return quantidade;
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
	public int getCodigo_vendedor() {
		return codigo_vendedor;
	}
	public void setCodigo_vendedor(int codigo_vendedor) {
		this.codigo_vendedor = codigo_vendedor;
	}
	public int getCodigo_produto() {
		return codigo_produto;
	}
	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
