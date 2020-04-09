package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

import primaryKeys.PedidoPdaPK;

@Entity
@Table(name = "pedido_pda")
public class PedidoPda implements Comparable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numero")
	private int numero;
	@Id
    @ManyToOne @JoinColumn(name="codigo_vendedor", nullable=true, foreignKey = @ForeignKey(name = "pedido_pda_c_ve_fk"))
    private Vendedor vendedor;
	
	@ManyToOne @JoinColumn(name="codigo_cliente", nullable=true, foreignKey = @ForeignKey(name = "pedido_pda_c_cli_fk"))
	private Cliente cliente;
	@Column(name="data", nullable=false)
    private Date data;
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
    
    /*
    @OneToMany(fetch=FetchType.EAGER, mappedBy="pk", cascade=CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<ItemPedidoPda> lista;
    */
    @OneToMany(targetEntity= ItemPedidoPda.class, cascade = CascadeType.ALL) //= FetchType.LAZY, mappedBy = "pedido_pda"
	@Fetch(FetchMode.SUBSELECT)
	private List<ItemPedidoPda> lista;
    
    @Column
    private int numero_pedido; // numeric(10,0),
    @Column
	private String inicio_atendimento; // character(8),
    @Column
	private String fim_atendimento; // character(8),
    @Column
	private String versao_app; // character varying(30),
    @Column
	private Integer consignado; // numeric(1,0) DEFAULT 0,
    @Column
	private Integer tipo_dfe; // numeric(1,0) DEFAULT 0,
    @Column
	private Integer qtd_pedidos_lote; // numeric(3,0),
    @Column
	private Integer numero_negociacao; // numeric(10,0),
    
    public PedidoPda() {
    	
    }
    
    public Double ValorTotalItens() {
    	Double total = 0.0;
    	for(ItemPedidoPda i : this.lista) {
    		total += (i.getQuantidade() * i.getValor());
    	}
    	return total;
    }
    /*
	public PedidoPdaPK getPk() {
		return pk;
	}


	public void setPk(PedidoPdaPK pk) {
		this.pk = pk;
	}
	*/

	public Date getData() {
		return data;
	}


	public int getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(int numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public String getInicio_atendimento() {
		return inicio_atendimento;
	}

	public void setInicio_atendimento(String inicio_atendimento) {
		this.inicio_atendimento = inicio_atendimento;
	}

	public String getFim_atendimento() {
		return fim_atendimento;
	}

	public void setFim_atendimento(String fim_atendimento) {
		this.fim_atendimento = fim_atendimento;
	}

	public String getVersao_app() {
		return versao_app;
	}

	public void setVersao_app(String versao_app) {
		this.versao_app = versao_app;
	}

	public Integer getConsignado() {
		return consignado;
	}

	public void setConsignado(Integer consignado) {
		this.consignado = consignado;
	}

	public Integer getTipo_dfe() {
		return tipo_dfe;
	}

	public void setTipo_dfe(Integer tipo_dfe) {
		this.tipo_dfe = tipo_dfe;
	}

	public Integer getQtd_pedidos_lote() {
		return qtd_pedidos_lote;
	}

	public void setQtd_pedidos_lote(Integer qtd_pedidos_lote) {
		this.qtd_pedidos_lote = qtd_pedidos_lote;
	}

	public Integer getNumero_negociacao() {
		return numero_negociacao;
	}

	public void setNumero_negociacao(Integer numero_negociacao) {
		this.numero_negociacao = numero_negociacao;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
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

	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}
	*/

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
