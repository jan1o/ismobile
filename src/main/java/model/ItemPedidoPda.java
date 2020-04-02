package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import primaryKeys.ItemPedidoPdaPK;

@Entity
@Table(name = "item_pedido_pda")
public class ItemPedidoPda implements Comparable, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	@Id
	@NotNull
	private int numero_pedido_pda; // numeric(6,0) NOT NULL,
	
	@Id
	@NotNull
	private int codigo_vendedor; // numeric(6,0) NOT NULL,
	*/
	
	@EmbeddedId
	private ItemPedidoPdaPK pk;
	
	@ManyToOne @JoinColumn(name="codigo_produto", nullable=true, foreignKey = @ForeignKey(name = "item_pedido_pda_c_p_fk"))
	private Produto produto; // numeric(10,0) NOT NULL,
	
	@Column
	private int quantidade; // numeric(18,4),
	
	@Column
	private Double valor; // numeric(18,4),
	
	/*
	@ManyToOne
    @JoinColumn(name = "pk", referencedColumnName = "numero")
    private PedidoPda ppda;
	*/
	
	public ItemPedidoPdaPK getPk() {
		return pk;
	}
	public void setPk(ItemPedidoPdaPK pk) {
		this.pk = pk;
	}
	
	/*
	public PedidoPda getPpda() {
		return ppda;
	}
	public void setPpda(PedidoPda ppda) {
		this.ppda = ppda;
	}
	*/
	
	public ItemPedidoPda() {
		
	}
	public ItemPedidoPda(int numero_pedido_pda, int codigo_vendedor, Produto produto, int quantidade,
			double valor) {
		
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
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
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
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
