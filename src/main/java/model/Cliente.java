package model;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/*
 * Cliente.java
 *
 * Created on 14 de Setembro de 2006, 11:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import biblioteca.InterfaceObjeto;

/**
 *
 * @author Eder
 */

@Entity
@Table(name = "cliente")
public class Cliente implements Comparable, InterfaceObjeto {

	@Id
	@NotNull
	@Column
	private int codigo; // numeric(6,0) NOT NULL,

	@NotNull
	@Column
	private String nome; // character varying(60) NOT NULL,

	@NotNull
	@Column
	private String endereco; // character varying(40) NOT NULL,

	@NotNull
	@Column
	private String numero; // character varying(10) NOT NULL,

	@Column
	private String complemento; // character varying(15),

	@Column
	private String bairro; // character varying(20),

	@NotNull
	@Column
	private int codigo_cidade; // numeric(5,0) NOT NULL,

	@Column
	private String cep; // character(8),

	@Column
	private String ponto_referencia; // character varying(250),

	@Column
	private int limite_credito; // numeric(18,2),

	@NotNull
	@Column
	private int credito; // numeric(18,2) NOT NULL DEFAULT 0,

	@NotNull
	@Column
	private int numero_rota; // numeric(3,0) NOT NULL,

	@NotNull
	@Column
	private int codigo_categoria_cliente; // numeric(3,0) NOT NULL,

	@NotNull
	@Column
	private int codigo_ramo_atividade; // numeric(3,0) NOT NULL,

	@Column
	private Date data_cadastro; // date,

	@Column
	private Date data_nascimento; // date,

	@Column
	private String cpf_cnpj; // character(14),

	@Column
	private String nome_fantasia; // character varying(40),

	@Column
	private String insc_estadual; // character varying(20),

	@Column
	private String rg; // character varying(20),

	@Column
	private String email; // character varying(50),

	@Column
	private String observacao; // character varying(250),

	@Column
	private String licenca_sanitaria; // character varying(20),

	@Column
	private String autorizacao_anvisa; // character varying(20),

	@Column
	private Integer codigo_plano_pagto; // numeric(3,0),

	@NotNull
	@Column
	private String inativo; // character(1) NOT NULL DEFAULT 0,

	@Column
	private Date alterado; // timestamp without time zone,

	@Column
	private String alterado_por; // character varying(30),

	@Column
	private Date incluido; // timestamp without time zone,

	@Column
	private String incluido_por; // character varying(30),

	@Column
	private int na_fonte; // numeric(1,0) DEFAULT 0,

	@Column
	private Double credito_conta_receber; // numeric(12,2) DEFAULT 0,

	@Column
	private int opt_simples; // numeric(1,0) DEFAULT 0,

	@Column
	private double credito_pacote_virtual; // numeric(12,2) DEFAULT 0,

	@Column
	private String nome_pai; // character varying(50),

	@Column
	private String nome_mae; // character varying(50),

	@Column
	private Date cpf_gerado; // timestamp without time zone,

	@Column
	private String cpf_gerado_por; // character varying(30),

	@Column
	private String estado_civil; // character varying(20),

	@Column
	private String naturalidade; // character varying(20),

	@Column
	private String nome_conjuge; // character varying(20),

	@Column
	private int eh_licitacao; // numeric(1,0) DEFAULT 0,

	@Column
	private String referencia; // character varying(20),

	@Column
	private int agregado; // numeric(8,2) DEFAULT 0,

	@Column
	private int tipo_calculo; // numeric(3,0) DEFAULT 0,

	@Column
	private double calcular_agregado; // numeric(1,0) DEFAULT 0,

	@Column
	private int atacado; // numeric(1,0) DEFAULT 0,

	@Column
	private String senha; // character(8),

	@Column
	private double desconto; // numeric(8,2) DEFAULT 0,

	@Column
	private int codigo_empresa; // numeric(3,0),

	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_participante; // numeric(10,0) DEFAULT nextval('codigo_participante'::regclass),

	@Column
	private int eh_funcionario; // numeric(1,0) DEFAULT 0,

	@Column
	private int dia_visita; // numeric(1,0) DEFAULT 0,

	@Column
	private String referencias_comerciais; // character varying(250),

	@Column
	private String local_trabalho; // character varying(100),

	@Column
	private String foto; // character varying(100),

	@Column
	private String sexo; // character(1),

	@Column
	private String tamanho_superior; // character varying(10),

	@Column
	private String tamanho_inferior; // character varying(10),

	@Column
	private String tamanho_calcado; // character varying(10),

	@Column
	private String latitude; // character varying(20),

	@Column
	private String longitude; // character varying(20),

	@Column
	private String mensagem_adicional_boleto; // character varying(100),

	@Column
	private String nacionalidade; // character varying(15),

	@Column
	private Integer codigo_tipo_residencia; // numeric(3,0),

	@Column
	private String tempo_residencia; // character varying(40),

	@Column
	private Double aluguel_prestacao; // numeric(12,2),

	@Column
	private String endereco_anterior; // character varying(100),

	@Column
	private String emissor; // character varying(10),

	@Column
	private Date data_emissao; // date,

	@Column
	private Integer numero_dependente; // numeric(3,0),

	@Column
	private Date negativado; // timestamp without time zone,

	@Column
	private String negativado_por; // character varying(30),

	@Column
	private Double limite_credito_original; // numeric(18,2),

	@Column
	private int gerar_nfe_preco_tabela; // numeric(1,0) DEFAULT 0,

	@Column
	private String cpf_pai; // character varying(11),

	@Column
	private String cpf_mae; // character varying(11),

	@Column
	private String rg_pai; // character varying(20),

	@Column
	private String rg_mae; // character varying(20),

	@Column
	private Integer codigo_contador; // numeric(3,0),

	@Column
	private int tipo_responsavel; // numeric(1,0) DEFAULT 0,

	@Column
	private int credito_os; // numeric(8,2) DEFAULT 0,

	@Column
	private double desconto_conta_receber; // numeric(8,2) DEFAULT 0,

	@Column
	private int prazo_conta_receber; // numeric(3,0) DEFAULT 0,

	@Column
	private Integer codigo_local_atendimento; // numeric(3,0),

	@Column
	private String profissao; // character varying(50),

	@Column
	private String dn; // character varying(50),

	@Column
	private String escolaridade; // character varying(50),

	@Column
	private String convenio; // character varying(50),

	@Column
	private int cor; // numeric(1,0) DEFAULT 0,

	@Column
	private String cartao_sus; // character varying(30),

	@Column
	private int eh_obeso; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_fumante; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_hipertenso; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_diabetico; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_gestante_risco; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_endocrino_feminino; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_endocrino_masculino; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_obesidade; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_tireoide; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_osso; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_neuroendocrino; // numeric(1,0) DEFAULT 0,

	@Column
	private int eh_clinica; // numeric(1,0) DEFAULT 0,

	@Column
	private Date data_ultimo_pedido; // timestamp without time zone,

	@Column
	private String lembrete; // text,

	@Column
	private int ignorar_dfe; // numeric(1,0) DEFAULT 0,

	@Column
	private String lembrete_destino; // character varying(30),

	@Column
	private String lembrete_usuario; // character varying(30),

	@Column
	private int ordem_atendimento_cidade; // numeric(6,0) DEFAULT (-1),
	
	
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
		Cliente other = (Cliente) obj;
		if (codigo != other.codigo)
			return false;
		return true;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCodigo_cidade() {
		return codigo_cidade;
	}

	public void setCodigo_cidade(int codigo_cidade) {
		this.codigo_cidade = codigo_cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPonto_referencia() {
		return ponto_referencia;
	}

	public void setPonto_referencia(String ponto_referencia) {
		this.ponto_referencia = ponto_referencia;
	}

	public int getLimite_credito() {
		return limite_credito;
	}

	public void setLimite_credito(int limite_credito) {
		this.limite_credito = limite_credito;
	}

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

	public int getNumero_rota() {
		return numero_rota;
	}

	public void setNumero_rota(int numero_rota) {
		this.numero_rota = numero_rota;
	}

	public int getCodigo_categoria_cliente() {
		return codigo_categoria_cliente;
	}

	public void setCodigo_categoria_cliente(int codigo_categoria_cliente) {
		this.codigo_categoria_cliente = codigo_categoria_cliente;
	}

	public int getCodigo_ramo_atividade() {
		return codigo_ramo_atividade;
	}

	public void setCodigo_ramo_atividade(int codigo_ramo_atividade) {
		this.codigo_ramo_atividade = codigo_ramo_atividade;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getInsc_estadual() {
		return insc_estadual;
	}

	public void setInsc_estadual(String insc_estadual) {
		this.insc_estadual = insc_estadual;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getLicenca_sanitaria() {
		return licenca_sanitaria;
	}

	public void setLicenca_sanitaria(String licenca_sanitaria) {
		this.licenca_sanitaria = licenca_sanitaria;
	}

	public String getAutorizacao_anvisa() {
		return autorizacao_anvisa;
	}

	public void setAutorizacao_anvisa(String autorizacao_anvisa) {
		this.autorizacao_anvisa = autorizacao_anvisa;
	}

	public Integer getCodigo_plano_pagto() {
		return codigo_plano_pagto;
	}

	public void setCodigo_plano_pagto(Integer codigo_plano_pagto) {
		this.codigo_plano_pagto = codigo_plano_pagto;
	}

	public String getInativo() {
		return inativo;
	}

	public void setInativo(String inativo) {
		this.inativo = inativo;
	}

	public Date getAlterado() {
		return alterado;
	}

	public void setAlterado(Date alterado) {
		this.alterado = alterado;
	}

	public String getAlterado_por() {
		return alterado_por;
	}

	public void setAlterado_por(String alterado_por) {
		this.alterado_por = alterado_por;
	}

	public Date getIncluido() {
		return incluido;
	}

	public void setIncluido(Date incluido) {
		this.incluido = incluido;
	}

	public String getIncluido_por() {
		return incluido_por;
	}

	public void setIncluido_por(String incluido_por) {
		this.incluido_por = incluido_por;
	}

	public int getNa_fonte() {
		return na_fonte;
	}

	public void setNa_fonte(int na_fonte) {
		this.na_fonte = na_fonte;
	}

	public Double getCredito_conta_receber() {
		return credito_conta_receber;
	}

	public void setCredito_conta_receber(Double credito_conta_receber) {
		this.credito_conta_receber = credito_conta_receber;
	}

	public int getOpt_simples() {
		return opt_simples;
	}

	public void setOpt_simples(int opt_simples) {
		this.opt_simples = opt_simples;
	}

	public double getCredito_pacote_virtual() {
		return credito_pacote_virtual;
	}

	public void setCredito_pacote_virtual(double credito_pacote_virtual) {
		this.credito_pacote_virtual = credito_pacote_virtual;
	}

	public String getNome_pai() {
		return nome_pai;
	}

	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}

	public String getNome_mae() {
		return nome_mae;
	}

	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}

	public Date getCpf_gerado() {
		return cpf_gerado;
	}

	public void setCpf_gerado(Date cpf_gerado) {
		this.cpf_gerado = cpf_gerado;
	}

	public String getCpf_gerado_por() {
		return cpf_gerado_por;
	}

	public void setCpf_gerado_por(String cpf_gerado_por) {
		this.cpf_gerado_por = cpf_gerado_por;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNome_conjuge() {
		return nome_conjuge;
	}

	public void setNome_conjuge(String nome_conjuge) {
		this.nome_conjuge = nome_conjuge;
	}

	public int getEh_licitacao() {
		return eh_licitacao;
	}

	public void setEh_licitacao(int eh_licitacao) {
		this.eh_licitacao = eh_licitacao;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getAgregado() {
		return agregado;
	}

	public void setAgregado(int agregado) {
		this.agregado = agregado;
	}

	public int getTipo_calculo() {
		return tipo_calculo;
	}

	public void setTipo_calculo(int tipo_calculo) {
		this.tipo_calculo = tipo_calculo;
	}

	public double getCalcular_agregado() {
		return calcular_agregado;
	}

	public void setCalcular_agregado(double calcular_agregado) {
		this.calcular_agregado = calcular_agregado;
	}

	public int getAtacado() {
		return atacado;
	}

	public void setAtacado(int atacado) {
		this.atacado = atacado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getCodigo_empresa() {
		return codigo_empresa;
	}

	public void setCodigo_empresa(int codigo_empresa) {
		this.codigo_empresa = codigo_empresa;
	}

	public int getCodigo_participante() {
		return codigo_participante;
	}

	public void setCodigo_participante(int codigo_participante) {
		this.codigo_participante = codigo_participante;
	}

	public int getEh_funcionario() {
		return eh_funcionario;
	}

	public void setEh_funcionario(int eh_funcionario) {
		this.eh_funcionario = eh_funcionario;
	}

	public int getDia_visita() {
		return dia_visita;
	}

	public void setDia_visita(int dia_visita) {
		this.dia_visita = dia_visita;
	}

	public String getReferencias_comerciais() {
		return referencias_comerciais;
	}

	public void setReferencias_comerciais(String referencias_comerciais) {
		this.referencias_comerciais = referencias_comerciais;
	}

	public String getLocal_trabalho() {
		return local_trabalho;
	}

	public void setLocal_trabalho(String local_trabalho) {
		this.local_trabalho = local_trabalho;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTamanho_superior() {
		return tamanho_superior;
	}

	public void setTamanho_superior(String tamanho_superior) {
		this.tamanho_superior = tamanho_superior;
	}

	public String getTamanho_inferior() {
		return tamanho_inferior;
	}

	public void setTamanho_inferior(String tamanho_inferior) {
		this.tamanho_inferior = tamanho_inferior;
	}

	public String getTamanho_calcado() {
		return tamanho_calcado;
	}

	public void setTamanho_calcado(String tamanho_calcado) {
		this.tamanho_calcado = tamanho_calcado;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMensagem_adicional_boleto() {
		return mensagem_adicional_boleto;
	}

	public void setMensagem_adicional_boleto(String mensagem_adicional_boleto) {
		this.mensagem_adicional_boleto = mensagem_adicional_boleto;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Integer getCodigo_tipo_residencia() {
		return codigo_tipo_residencia;
	}

	public void setCodigo_tipo_residencia(Integer codigo_tipo_residencia) {
		this.codigo_tipo_residencia = codigo_tipo_residencia;
	}

	public String getTempo_residencia() {
		return tempo_residencia;
	}

	public void setTempo_residencia(String tempo_residencia) {
		this.tempo_residencia = tempo_residencia;
	}

	public Double getAluguel_prestacao() {
		return aluguel_prestacao;
	}

	public void setAluguel_prestacao(Double aluguel_prestacao) {
		this.aluguel_prestacao = aluguel_prestacao;
	}

	public String getEndereco_anterior() {
		return endereco_anterior;
	}

	public void setEndereco_anterior(String endereco_anterior) {
		this.endereco_anterior = endereco_anterior;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public Date getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}

	public Integer getNumero_dependente() {
		return numero_dependente;
	}

	public void setNumero_dependente(Integer numero_dependente) {
		this.numero_dependente = numero_dependente;
	}

	public Date getNegativado() {
		return negativado;
	}

	public void setNegativado(Date negativado) {
		this.negativado = negativado;
	}

	public String getNegativado_por() {
		return negativado_por;
	}

	public void setNegativado_por(String negativado_por) {
		this.negativado_por = negativado_por;
	}

	public Double getLimite_credito_original() {
		return limite_credito_original;
	}

	public void setLimite_credito_original(Double limite_credito_original) {
		this.limite_credito_original = limite_credito_original;
	}

	public int getGerar_nfe_preco_tabela() {
		return gerar_nfe_preco_tabela;
	}

	public void setGerar_nfe_preco_tabela(int gerar_nfe_preco_tabela) {
		this.gerar_nfe_preco_tabela = gerar_nfe_preco_tabela;
	}

	public String getCpf_pai() {
		return cpf_pai;
	}

	public void setCpf_pai(String cpf_pai) {
		this.cpf_pai = cpf_pai;
	}

	public String getCpf_mae() {
		return cpf_mae;
	}

	public void setCpf_mae(String cpf_mae) {
		this.cpf_mae = cpf_mae;
	}

	public String getRg_pai() {
		return rg_pai;
	}

	public void setRg_pai(String rg_pai) {
		this.rg_pai = rg_pai;
	}

	public String getRg_mae() {
		return rg_mae;
	}

	public void setRg_mae(String rg_mae) {
		this.rg_mae = rg_mae;
	}

	public Integer getCodigo_contador() {
		return codigo_contador;
	}

	public void setCodigo_contador(Integer codigo_contador) {
		this.codigo_contador = codigo_contador;
	}

	public int getTipo_responsavel() {
		return tipo_responsavel;
	}

	public void setTipo_responsavel(int tipo_responsavel) {
		this.tipo_responsavel = tipo_responsavel;
	}

	public int getCredito_os() {
		return credito_os;
	}

	public void setCredito_os(int credito_os) {
		this.credito_os = credito_os;
	}

	public double getDesconto_conta_receber() {
		return desconto_conta_receber;
	}

	public void setDesconto_conta_receber(double desconto_conta_receber) {
		this.desconto_conta_receber = desconto_conta_receber;
	}

	public int getPrazo_conta_receber() {
		return prazo_conta_receber;
	}

	public void setPrazo_conta_receber(int prazo_conta_receber) {
		this.prazo_conta_receber = prazo_conta_receber;
	}

	public Integer getCodigo_local_atendimento() {
		return codigo_local_atendimento;
	}

	public void setCodigo_local_atendimento(Integer codigo_local_atendimento) {
		this.codigo_local_atendimento = codigo_local_atendimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}

	public String getCartao_sus() {
		return cartao_sus;
	}

	public void setCartao_sus(String cartao_sus) {
		this.cartao_sus = cartao_sus;
	}

	public int getEh_obeso() {
		return eh_obeso;
	}

	public void setEh_obeso(int eh_obeso) {
		this.eh_obeso = eh_obeso;
	}

	public int getEh_fumante() {
		return eh_fumante;
	}

	public void setEh_fumante(int eh_fumante) {
		this.eh_fumante = eh_fumante;
	}

	public int getEh_hipertenso() {
		return eh_hipertenso;
	}

	public void setEh_hipertenso(int eh_hipertenso) {
		this.eh_hipertenso = eh_hipertenso;
	}

	public int getEh_diabetico() {
		return eh_diabetico;
	}

	public void setEh_diabetico(int eh_diabetico) {
		this.eh_diabetico = eh_diabetico;
	}

	public int getEh_gestante_risco() {
		return eh_gestante_risco;
	}

	public void setEh_gestante_risco(int eh_gestante_risco) {
		this.eh_gestante_risco = eh_gestante_risco;
	}

	public int getEh_endocrino_feminino() {
		return eh_endocrino_feminino;
	}

	public void setEh_endocrino_feminino(int eh_endocrino_feminino) {
		this.eh_endocrino_feminino = eh_endocrino_feminino;
	}

	public int getEh_endocrino_masculino() {
		return eh_endocrino_masculino;
	}

	public void setEh_endocrino_masculino(int eh_endocrino_masculino) {
		this.eh_endocrino_masculino = eh_endocrino_masculino;
	}

	public int getEh_obesidade() {
		return eh_obesidade;
	}

	public void setEh_obesidade(int eh_obesidade) {
		this.eh_obesidade = eh_obesidade;
	}

	public int getEh_tireoide() {
		return eh_tireoide;
	}

	public void setEh_tireoide(int eh_tireoide) {
		this.eh_tireoide = eh_tireoide;
	}

	public int getEh_osso() {
		return eh_osso;
	}

	public void setEh_osso(int eh_osso) {
		this.eh_osso = eh_osso;
	}

	public int getEh_neuroendocrino() {
		return eh_neuroendocrino;
	}

	public void setEh_neuroendocrino(int eh_neuroendocrino) {
		this.eh_neuroendocrino = eh_neuroendocrino;
	}

	public int getEh_clinica() {
		return eh_clinica;
	}

	public void setEh_clinica(int eh_clinica) {
		this.eh_clinica = eh_clinica;
	}

	public Date getData_ultimo_pedido() {
		return data_ultimo_pedido;
	}

	public void setData_ultimo_pedido(Date data_ultimo_pedido) {
		this.data_ultimo_pedido = data_ultimo_pedido;
	}

	public String getLembrete() {
		return lembrete;
	}

	public void setLembrete(String lembrete) {
		this.lembrete = lembrete;
	}

	public int getIgnorar_dfe() {
		return ignorar_dfe;
	}

	public void setIgnorar_dfe(int ignorar_dfe) {
		this.ignorar_dfe = ignorar_dfe;
	}

	public String getLembrete_destino() {
		return lembrete_destino;
	}

	public void setLembrete_destino(String lembrete_destino) {
		this.lembrete_destino = lembrete_destino;
	}

	public String getLembrete_usuario() {
		return lembrete_usuario;
	}

	public void setLembrete_usuario(String lembrete_usuario) {
		this.lembrete_usuario = lembrete_usuario;
	}

	public int getOrdem_atendimento_cidade() {
		return ordem_atendimento_cidade;
	}

	public void setOrdem_atendimento_cidade(int ordem_atendimento_cidade) {
		this.ordem_atendimento_cidade = ordem_atendimento_cidade;
	}

	@Override
	public String toXML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
