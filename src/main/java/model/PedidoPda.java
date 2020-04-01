package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "pedido_pda")
public class PedidoPda implements Comparable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="numero")
	private int numero;
	@Column(name="data", nullable=false)
    private Date data;
    @ManyToOne @JoinColumn(name="codigo_cliente", nullable=true, foreignKey = @ForeignKey(name = "pedido_pda_c_cli_fk"))
    private Cliente cliente;
    @ManyToOne @JoinColumn(name="codigo_vendedor", nullable=true, foreignKey = @ForeignKey(name = "pedido_pda_c_ve_fk"))
    private Vendedor vendedor;
    @ManyToOne @JoinColumn(name="codigo_plano_pagamento", nullable=true, foreignKey = @ForeignKey(name = "pedido_pda_c_pp_fk"))
    private CondicaoPagamento condicaoPagamento;
    @Column(name="frios")
    private int frios;
    @Column(name="retirado")
    private int retirado;
    @Column(name="negociacao")
    private int negociacao;
    @Column(name="enviado")
    private Date enviado;
    @Column(name="processado")
    private Date processado;
    @Column(name="latitude")
    private int latitude;
    @Column(name="longitude")
    private int longitude;
    @Column(name="observacao")
    private String observacao;
    @OneToMany(fetch=FetchType.EAGER, mappedBy="pedido_pda, codigo_vendedor", cascade=CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<ItemPedidoPda> lista;
    
    public PedidoPda() {
    	
    }
    
    
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}


	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}


	public int getFrios() {
		return frios;
	}


	public void setFrios(int frios) {
		this.frios = frios;
	}


	public int getRetirado() {
		return retirado;
	}


	public void setRetirado(int retirado) {
		this.retirado = retirado;
	}


	public int getNegociacao() {
		return negociacao;
	}


	public void setNegociacao(int negociacao) {
		this.negociacao = negociacao;
	}


	public Date getEnviado() {
		return enviado;
	}


	public void setEnviado(Date enviado) {
		this.enviado = enviado;
	}


	public Date getProcessado() {
		return processado;
	}


	public void setProcessado(Date processado) {
		this.processado = processado;
	}


	public int getLatitude() {
		return latitude;
	}


	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}


	public int getLongitude() {
		return longitude;
	}


	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public List<ItemPedidoPda> getLista() {
		return lista;
	}


	public void setLista(List<ItemPedidoPda> lista) {
		this.lista = lista;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
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
		PedidoPda other = (PedidoPda) obj;
		if (numero != other.numero)
			return false;
		return true;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
