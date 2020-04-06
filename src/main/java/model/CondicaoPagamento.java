package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * CondicaoPagamento.java
 *
 * Created on 6 de Setembro de 2006, 09:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import biblioteca.InterfaceObjeto;

/**
 *
 * @author Wallace
 */

@Entity
@Table(name="plano_pagamento")
public class CondicaoPagamento implements Comparable, InterfaceObjeto {

	@Id
	@NotNull
	@Column(name = "codigo")
	private int codigo; // numeric(3,0) NOT NULL,
	
	@NotNull
	@Column(name = "nome")
	private String nome; // character varying(30) NOT NULL,
	
	@NotNull
	@Column(name = "codigo_tabela_preco")
	private int codigo_tabela_preco; // numeric(3,0) NOT NULL,

	@Column(name = "desconto")
	private double desconto; // numeric(5,2)

	@Column(name = "valor_minimo")
	private double valor_minimo; // numeric(18,2),

	@Column(name = "desconto_max")
	private double desconto_max; // numeric(5,2),

	@Column(name = "max_parcela")
	private double max_parcela; // numeric(3,0),

	@Column(name = "enviar_para_pda")
	private int enviar_para_pda; // numeric(1,0) DEFAULT 1,

	@Column(name = "taxa_cartao")
	private double taxa_cartao; // numeric(5,2) DEFAULT 0,

	@Column(name = "baixa_automatica")
	private int baixa_automatica; // numeric(1,0) DEFAULT 0,

	@Column(name = "enviar_para_pacote_virtual")
	private int enviar_para_pacote_virtual; // numeric(1,0) DEFAULT 0,

	@Column(name = "imutavel")
	private int imutavel; // numeric(1,0) DEFAULT 0,

	@Column(name = "negociacao_pda")
	private int negociacao_pda; // numeric(1,0) DEFAULT 0,

	@Column(name = "retirado_pda")
	private int retirado_pda; // numeric(1,0) DEFAULT 0,

	@Column(name = "acrescimo_venda_balcao")
	private double acrescimo_venda_balcao; // numeric(8,2) DEFAULT 0,

	@Column(name = "pedir_senha")
	private int pedir_senha; // numeric(1,0) DEFAULT 0,

	@Column(name = "desconto_maximo")
	private Double desconto_maximo; // numeric(12,2),

	@Column(name = "codigo_financeira")
	private Integer codigo_financeira; // numeric(3,0),

	@Column(name = "prazo_fim_mes")
	private int prazo_fim_mes; // numeric(1,0) DEFAULT 0,

	@Column(name = "comissao")
	private double comissao; // numeric(8,2),

	@Column(name = "cartao_credito")
	private int cartao_credito; // numeric(1,0) DEFAULT 0,

	@Column(name = "inativo")
	private int inativo; // numeric(1,0) DEFAULT 0,

	@Column(name = "ignorar_bloqueio_atraso_pda")
	private int ignorar_bloqueio_atraso_pda; // numeric(1,0) DEFAULT 0,

	@Override
	public String toXML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo_tabela_preco() {
		return codigo_tabela_preco;
	}

	public void setCodigo_tabela_preco(int codigo_tabela_preco) {
		this.codigo_tabela_preco = codigo_tabela_preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValor_minimo() {
		return valor_minimo;
	}

	public void setValor_minimo(double valor_minimo) {
		this.valor_minimo = valor_minimo;
	}

	public double getDesconto_max() {
		return desconto_max;
	}

	public void setDesconto_max(double desconto_max) {
		this.desconto_max = desconto_max;
	}

	public double getMax_parcela() {
		return max_parcela;
	}

	public void setMax_parcela(double max_parcela) {
		this.max_parcela = max_parcela;
	}

	public int getEnviar_para_pda() {
		return enviar_para_pda;
	}

	public void setEnviar_para_pda(int enviar_para_pda) {
		this.enviar_para_pda = enviar_para_pda;
	}

	public double getTaxa_cartao() {
		return taxa_cartao;
	}

	public void setTaxa_cartao(double taxa_cartao) {
		this.taxa_cartao = taxa_cartao;
	}

	public int getBaixa_automatica() {
		return baixa_automatica;
	}

	public void setBaixa_automatica(int baixa_automatica) {
		this.baixa_automatica = baixa_automatica;
	}

	public int getEnviar_para_pacote_virtual() {
		return enviar_para_pacote_virtual;
	}

	public void setEnviar_para_pacote_virtual(int enviar_para_pacote_virtual) {
		this.enviar_para_pacote_virtual = enviar_para_pacote_virtual;
	}

	public int getImutavel() {
		return imutavel;
	}

	public void setImutavel(int imutavel) {
		this.imutavel = imutavel;
	}

	public int getNegociacao_pda() {
		return negociacao_pda;
	}

	public void setNegociacao_pda(int negociacao_pda) {
		this.negociacao_pda = negociacao_pda;
	}

	public int getRetirado_pda() {
		return retirado_pda;
	}

	public void setRetirado_pda(int retirado_pda) {
		this.retirado_pda = retirado_pda;
	}

	public double getAcrescimo_venda_balcao() {
		return acrescimo_venda_balcao;
	}

	public void setAcrescimo_venda_balcao(double acrescimo_venda_balcao) {
		this.acrescimo_venda_balcao = acrescimo_venda_balcao;
	}

	public int getPedir_senha() {
		return pedir_senha;
	}

	public void setPedir_senha(int pedir_senha) {
		this.pedir_senha = pedir_senha;
	}

	public Double getDesconto_maximo() {
		return desconto_maximo;
	}

	public void setDesconto_maximo(Double desconto_maximo) {
		this.desconto_maximo = desconto_maximo;
	}

	public Integer getCodigo_financeira() {
		return codigo_financeira;
	}

	public void setCodigo_financeira(Integer codigo_financeira) {
		this.codigo_financeira = codigo_financeira;
	}

	public int getPrazo_fim_mes() {
		return prazo_fim_mes;
	}

	public void setPrazo_fim_mes(int prazo_fim_mes) {
		this.prazo_fim_mes = prazo_fim_mes;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public int getCartao_credito() {
		return cartao_credito;
	}

	public void setCartao_credito(int cartao_credito) {
		this.cartao_credito = cartao_credito;
	}

	public int getInativo() {
		return inativo;
	}

	public void setInativo(int inativo) {
		this.inativo = inativo;
	}

	public int getIgnorar_bloqueio_atraso_pda() {
		return ignorar_bloqueio_atraso_pda;
	}

	public void setIgnorar_bloqueio_atraso_pda(int ignorar_bloqueio_atraso_pda) {
		this.ignorar_bloqueio_atraso_pda = ignorar_bloqueio_atraso_pda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		CondicaoPagamento other = (CondicaoPagamento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	

}
