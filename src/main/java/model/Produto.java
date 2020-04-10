package model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import biblioteca.InterfaceObjeto;

@Entity
@Table(name = "produto")
public class Produto implements Comparable, InterfaceObjeto {

	@Id
	@NotNull
	@Column
	private int codigo; // numeric(10,0) NOT NULL,

	@NotNull
	@Column
	private String descricao; // character varying(70) NOT NULL,

	@NotNull
	@Column
	private String descricao_fiscal; // character varying(70) NOT NULL,

	@NotNull
	@Column
	private String inativo; // character(1) NOT NULL DEFAULT 0,

	@NotNull
	@Column
	private String sigla_unidade; // character(3) NOT NULL,

	@Column
	private String codigo_barra; // character varying(40),

	@Column
	private Double peso_liquido; // numeric(8,3),

	@Column
	private Double peso_bruto; // numeric(8,3),

	@Column
	private Double qtd_embalagem; // numeric(6,2),

	@NotNull
	@Column
	private Double comissao; // numeric(8,2) NOT NULL DEFAULT 0,

	@NotNull
	@Column
	private Double valor; // numeric(10,4) NOT NULL DEFAULT 0,

	@NotNull
	@Column
	private Double custo; // numeric(10,2) NOT NULL DEFAULT 0,

	@Column
	private Double quantidade; // numeric(13,3) DEFAULT 0,

	@Column
	private Double qtd_deposito2; // numeric(13,3) DEFAULT 0,

	@Column
	private Double qtd_avaria; // numeric(13,3) DEFAULT 0,

	@Column
	private Double qtd_vencida; // numeric(13,3) DEFAULT 0,

	@NotNull
	@Column
	private Double codigo_tipo_produto; // numeric(6,0) NOT NULL,

	@NotNull
	@Column
	private int codigo_grupo; // numeric(3,0) NOT NULL,

	@NotNull
	@Column
	private int codigo_subgrupo; // numeric(3,0) NOT NULL,

	@NotNull
	@Column
	private int codigo_fabricante; // numeric(6,0) NOT NULL,

	@NotNull
	@Column
	private int codigo_aliquota; // numeric(3,0) NOT NULL,

	@NotNull
	@Column
	private int codigo_cor; // numeric(3,0) NOT NULL,

	@NotNull
	@Column
	private int codigo_modelo; // numeric(3,0) NOT NULL,

	@Column
	private Double margem_lucro; // numeric(8,2),

	@Column
	private Double preco_max; // numeric(12,2),

	@Column
	private String psicotropico; // character varying(10),

	@Column
	private String referencia; // character varying(20),

	@Column
	private String codigo_dcb; // character varying(20),

	@Column
	private String licenca; // character varying(20),

	@Column
	private Double valor_compra; // numeric(10,4) DEFAULT 0,

	@Column
	private Double estoque_minimo; // numeric(13,3) DEFAULT 0,

	@Column
	private Date data_ultima_entrada; // timestamp without time zone,

	@Column
	private Date data_zerou; // timestamp without time zone,

	@Column
	private String codigo_ncm; // character(8),

	@Column
	private Date alterado; // timestamp without time zone DEFAULT now(),

	@Column
	private String alterado_por; // character varying(50) DEFAULT "current_user"(),

	@Column
	private Double valor_minimo; // numeric(12,2) DEFAULT 0,

	@Column
	private String informacao_adicional; // character varying(500),

	@Column
	private String pratileira; // character varying(10),

	@Column
	private String bandeja; // character varying(10),

	@Column
	private Double valor_atacado_varejo; // numeric(8,4) DEFAULT 0,

	@Column
	private Double qtd_atacado_varejo; // numeric(13,3) DEFAULT 0,

	@Column
	private Double porcentagem_custo; // numeric(8,2) DEFAULT 0,

	@Column
	private Double porcentagem_valor_minimo; // numeric(8,2) DEFAULT 0,

	@Column
	private String gtin; // character varying(14),

	@Column
	private String iat; // character(1) DEFAULT 'A'::bpchar,

	@Column
	private String ippt; // character(1) DEFAULT 'T'::bpchar,

	@NotNull
	@Column
	private BigInteger codigo_natureza_receita; // numeric(10,0) NOT NULL DEFAULT 9999999999::bigint,

	@Column
	private int consumo_proprio; // numeric(1,0) DEFAULT 0,

	@Column
	private String hash_tripa; // character varying(32),

	@Column
	private Integer hash_incremento; // numeric(10,0),

	@Column
	private String foto; // character varying(100),

	@Column
	private int sem_giro; // numeric(1,0) DEFAULT 0,

	@Column
	private Date validade; // date,

	@Column
	private Double aliquota_nacional_ibpt; // numeric(12,2) DEFAULT 0,

	@Column
	private int kit; // numeric(1,0) DEFAULT 0,

	@Column
	private String status_alteracao_valor; // character(1) DEFAULT '='::bpchar,

	@Column
	private Date data_ultima_venda; // timestamp without time zone,

	@Column
	private String tamanho; // character varying(4) DEFAULT ''::character varying,

	@Column
	private String codigo_anp; // character(9),

	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int codigo_mercadoria; // numeric(10,0) NOT NULL DEFAULT nextval('codigo_mercadoria'::regclass),

	@Column
	private Date cadastrado; // timestamp without time zone,

	@Column
	private String cadastrado_por; // character varying(30),

	@Column
	private Double quantidade_deposito; // numeric(13,3) DEFAULT 0,

	@Column
	private String cest; // character(7),

	@Column
	private int controlar_estoque; // numeric(1,0) DEFAULT 1,

	@Column
	private int pesagem; // numeric(1,0) DEFAULT 0,

	@Column
	private Double valor_bonificacao; // numeric(18,2) DEFAULT 0,

	@Column
	private String foto_web; // text DEFAULT 'http://www.intechsistemas.com.br/images/produto.jpg'::text,

	@Column
	private Double pontos; // numeric(8,2) DEFAULT 0,

	@Column
	private Double meta; // numeric(10,3),

	@Column
	private Date data_zerou_dep2; // timestamp without time zone,

	@Column
	private Double dados_frete_entrada; // numeric(8,2) DEFAULT 0,

	@Column
	private Double dados_icms_entrada; // numeric(8,2) DEFAULT 0,

	@Column
	private Double dados_ipi_entrada; // numeric(8,2) DEFAULT 0,

	@Column
	private int id_aliquota_diferenciada; // numeric(3,0) DEFAULT 0,

	@Column
	private Double qtd_falta; // numeric(13,3) DEFAULT 0,

	@Column
	private Double valor_compra_dolar; // numeric(8,2),

	@Column
	private Double valor_frete; // numeric(8,2),

	@Column
	private String und_tributavel; // character(3),

	@Column
	private Double qtd_tributavel; // numeric(8,2) DEFAULT 1,

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao_fiscal() {
		return descricao_fiscal;
	}

	public void setDescricao_fiscal(String descricao_fiscal) {
		this.descricao_fiscal = descricao_fiscal;
	}

	public String getInativo() {
		return inativo;
	}

	public void setInativo(String inativo) {
		this.inativo = inativo;
	}

	public String getSigla_unidade() {
		return sigla_unidade;
	}

	public void setSigla_unidade(String sigla_unidade) {
		this.sigla_unidade = sigla_unidade;
	}

	public String getCodigo_barra() {
		return codigo_barra;
	}

	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
	}

	public Double getPeso_liquido() {
		return peso_liquido;
	}

	public void setPeso_liquido(Double peso_liquido) {
		this.peso_liquido = peso_liquido;
	}

	public Double getPeso_bruto() {
		return peso_bruto;
	}

	public void setPeso_bruto(Double peso_bruto) {
		this.peso_bruto = peso_bruto;
	}

	public Double getQtd_embalagem() {
		return qtd_embalagem;
	}

	public void setQtd_embalagem(Double qtd_embalagem) {
		this.qtd_embalagem = qtd_embalagem;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getQtd_deposito2() {
		return qtd_deposito2;
	}

	public void setQtd_deposito2(Double qtd_deposito2) {
		this.qtd_deposito2 = qtd_deposito2;
	}

	public Double getQtd_avaria() {
		return qtd_avaria;
	}

	public void setQtd_avaria(Double qtd_avaria) {
		this.qtd_avaria = qtd_avaria;
	}

	public Double getQtd_vencida() {
		return qtd_vencida;
	}

	public void setQtd_vencida(Double qtd_vencida) {
		this.qtd_vencida = qtd_vencida;
	}

	public Double getCodigo_tipo_produto() {
		return codigo_tipo_produto;
	}

	public void setCodigo_tipo_produto(Double codigo_tipo_produto) {
		this.codigo_tipo_produto = codigo_tipo_produto;
	}

	public int getCodigo_grupo() {
		return codigo_grupo;
	}

	public void setCodigo_grupo(int codigo_grupo) {
		this.codigo_grupo = codigo_grupo;
	}

	public int getCodigo_subgrupo() {
		return codigo_subgrupo;
	}

	public void setCodigo_subgrupo(int codigo_subgrupo) {
		this.codigo_subgrupo = codigo_subgrupo;
	}

	public int getCodigo_fabricante() {
		return codigo_fabricante;
	}

	public void setCodigo_fabricante(int codigo_fabricante) {
		this.codigo_fabricante = codigo_fabricante;
	}

	public int getCodigo_aliquota() {
		return codigo_aliquota;
	}

	public void setCodigo_aliquota(int codigo_aliquota) {
		this.codigo_aliquota = codigo_aliquota;
	}

	public int getCodigo_cor() {
		return codigo_cor;
	}

	public void setCodigo_cor(int codigo_cor) {
		this.codigo_cor = codigo_cor;
	}

	public int getCodigo_modelo() {
		return codigo_modelo;
	}

	public void setCodigo_modelo(int codigo_modelo) {
		this.codigo_modelo = codigo_modelo;
	}

	public Double getMargem_lucro() {
		return margem_lucro;
	}

	public void setMargem_lucro(Double margem_lucro) {
		this.margem_lucro = margem_lucro;
	}

	public Double getPreco_max() {
		return preco_max;
	}

	public void setPreco_max(Double preco_max) {
		this.preco_max = preco_max;
	}

	public String getPsicotropico() {
		return psicotropico;
	}

	public void setPsicotropico(String psicotropico) {
		this.psicotropico = psicotropico;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCodigo_dcb() {
		return codigo_dcb;
	}

	public void setCodigo_dcb(String codigo_dcb) {
		this.codigo_dcb = codigo_dcb;
	}

	public String getLicenca() {
		return licenca;
	}

	public void setLicenca(String licenca) {
		this.licenca = licenca;
	}

	public Double getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(Double valor_compra) {
		this.valor_compra = valor_compra;
	}

	public Double getEstoque_minimo() {
		return estoque_minimo;
	}

	public void setEstoque_minimo(Double estoque_minimo) {
		this.estoque_minimo = estoque_minimo;
	}

	public Date getData_ultima_entrada() {
		return data_ultima_entrada;
	}

	public void setData_ultima_entrada(Date data_ultima_entrada) {
		this.data_ultima_entrada = data_ultima_entrada;
	}

	public Date getData_zerou() {
		return data_zerou;
	}

	public void setData_zerou(Date data_zerou) {
		this.data_zerou = data_zerou;
	}

	public String getCodigo_ncm() {
		return codigo_ncm;
	}

	public void setCodigo_ncm(String codigo_ncm) {
		this.codigo_ncm = codigo_ncm;
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

	public Double getValor_minimo() {
		return valor_minimo;
	}

	public void setValor_minimo(Double valor_minimo) {
		this.valor_minimo = valor_minimo;
	}

	public String getInformacao_adicional() {
		return informacao_adicional;
	}

	public void setInformacao_adicional(String informacao_adicional) {
		this.informacao_adicional = informacao_adicional;
	}

	public String getPratileira() {
		return pratileira;
	}

	public void setPratileira(String pratileira) {
		this.pratileira = pratileira;
	}

	public String getBandeja() {
		return bandeja;
	}

	public void setBandeja(String bandeja) {
		this.bandeja = bandeja;
	}

	public Double getValor_atacado_varejo() {
		return valor_atacado_varejo;
	}

	public void setValor_atacado_varejo(Double valor_atacado_varejo) {
		this.valor_atacado_varejo = valor_atacado_varejo;
	}

	public Double getQtd_atacado_varejo() {
		return qtd_atacado_varejo;
	}

	public void setQtd_atacado_varejo(Double qtd_atacado_varejo) {
		this.qtd_atacado_varejo = qtd_atacado_varejo;
	}

	public Double getPorcentagem_custo() {
		return porcentagem_custo;
	}

	public void setPorcentagem_custo(Double porcentagem_custo) {
		this.porcentagem_custo = porcentagem_custo;
	}

	public Double getPorcentagem_valor_minimo() {
		return porcentagem_valor_minimo;
	}

	public void setPorcentagem_valor_minimo(Double porcentagem_valor_minimo) {
		this.porcentagem_valor_minimo = porcentagem_valor_minimo;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public String getIat() {
		return iat;
	}

	public void setIat(String iat) {
		this.iat = iat;
	}

	public String getIppt() {
		return ippt;
	}

	public void setIppt(String ippt) {
		this.ippt = ippt;
	}

	public BigInteger getCodigo_natureza_receita() {
		return codigo_natureza_receita;
	}

	public void setCodigo_natureza_receita(BigInteger codigo_natureza_receita) {
		this.codigo_natureza_receita = codigo_natureza_receita;
	}

	public int getConsumo_proprio() {
		return consumo_proprio;
	}

	public void setConsumo_proprio(int consumo_proprio) {
		this.consumo_proprio = consumo_proprio;
	}

	public String getHash_tripa() {
		return hash_tripa;
	}

	public void setHash_tripa(String hash_tripa) {
		this.hash_tripa = hash_tripa;
	}

	public Integer getHash_incremento() {
		return hash_incremento;
	}

	public void setHash_incremento(Integer hash_incremento) {
		this.hash_incremento = hash_incremento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getSem_giro() {
		return sem_giro;
	}

	public void setSem_giro(int sem_giro) {
		this.sem_giro = sem_giro;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Double getAliquota_nacional_ibpt() {
		return aliquota_nacional_ibpt;
	}

	public void setAliquota_nacional_ibpt(Double aliquota_nacional_ibpt) {
		this.aliquota_nacional_ibpt = aliquota_nacional_ibpt;
	}

	public int getKit() {
		return kit;
	}

	public void setKit(int kit) {
		this.kit = kit;
	}

	public String getStatus_alteracao_valor() {
		return status_alteracao_valor;
	}

	public void setStatus_alteracao_valor(String status_alteracao_valor) {
		this.status_alteracao_valor = status_alteracao_valor;
	}

	public Date getData_ultima_venda() {
		return data_ultima_venda;
	}

	public void setData_ultima_venda(Date data_ultima_venda) {
		this.data_ultima_venda = data_ultima_venda;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCodigo_anp() {
		return codigo_anp;
	}

	public void setCodigo_anp(String codigo_anp) {
		this.codigo_anp = codigo_anp;
	}

	public int getCodigo_mercadoria() {
		return codigo_mercadoria;
	}

	public void setCodigo_mercadoria(int codigo_mercadoria) {
		this.codigo_mercadoria = codigo_mercadoria;
	}

	public Date getCadastrado() {
		return cadastrado;
	}

	public void setCadastrado(Date cadastrado) {
		this.cadastrado = cadastrado;
	}

	public String getCadastrado_por() {
		return cadastrado_por;
	}

	public void setCadastrado_por(String cadastrado_por) {
		this.cadastrado_por = cadastrado_por;
	}

	public Double getQuantidade_deposito() {
		return quantidade_deposito;
	}

	public void setQuantidade_deposito(Double quantidade_deposito) {
		this.quantidade_deposito = quantidade_deposito;
	}

	public String getCest() {
		return cest;
	}

	public void setCest(String cest) {
		this.cest = cest;
	}

	public int getControlar_estoque() {
		return controlar_estoque;
	}

	public void setControlar_estoque(int controlar_estoque) {
		this.controlar_estoque = controlar_estoque;
	}

	public int getPesagem() {
		return pesagem;
	}

	public void setPesagem(int pesagem) {
		this.pesagem = pesagem;
	}

	public Double getValor_bonificacao() {
		return valor_bonificacao;
	}

	public void setValor_bonificacao(Double valor_bonificacao) {
		this.valor_bonificacao = valor_bonificacao;
	}

	public String getFoto_web() {
		return foto_web;
	}

	public void setFoto_web(String foto_web) {
		this.foto_web = foto_web;
	}

	public Double getPontos() {
		return pontos;
	}

	public void setPontos(Double pontos) {
		this.pontos = pontos;
	}

	public Double getMeta() {
		return meta;
	}

	public void setMeta(Double meta) {
		this.meta = meta;
	}

	public Date getData_zerou_dep2() {
		return data_zerou_dep2;
	}

	public void setData_zerou_dep2(Date data_zerou_dep2) {
		this.data_zerou_dep2 = data_zerou_dep2;
	}

	public Double getDados_frete_entrada() {
		return dados_frete_entrada;
	}

	public void setDados_frete_entrada(Double dados_frete_entrada) {
		this.dados_frete_entrada = dados_frete_entrada;
	}

	public Double getDados_icms_entrada() {
		return dados_icms_entrada;
	}

	public void setDados_icms_entrada(Double dados_icms_entrada) {
		this.dados_icms_entrada = dados_icms_entrada;
	}

	public Double getDados_ipi_entrada() {
		return dados_ipi_entrada;
	}

	public void setDados_ipi_entrada(Double dados_ipi_entrada) {
		this.dados_ipi_entrada = dados_ipi_entrada;
	}

	public int getId_aliquota_diferenciada() {
		return id_aliquota_diferenciada;
	}

	public void setId_aliquota_diferenciada(int id_aliquota_diferenciada) {
		this.id_aliquota_diferenciada = id_aliquota_diferenciada;
	}

	public Double getQtd_falta() {
		return qtd_falta;
	}

	public void setQtd_falta(Double qtd_falta) {
		this.qtd_falta = qtd_falta;
	}

	public Double getValor_compra_dolar() {
		return valor_compra_dolar;
	}

	public void setValor_compra_dolar(Double valor_compra_dolar) {
		this.valor_compra_dolar = valor_compra_dolar;
	}

	public Double getValor_frete() {
		return valor_frete;
	}

	public void setValor_frete(Double valor_frete) {
		this.valor_frete = valor_frete;
	}

	public String getUnd_tributavel() {
		return und_tributavel;
	}

	public void setUnd_tributavel(String und_tributavel) {
		this.und_tributavel = und_tributavel;
	}

	public Double getQtd_tributavel() {
		return qtd_tributavel;
	}

	public void setQtd_tributavel(Double qtd_tributavel) {
		this.qtd_tributavel = qtd_tributavel;
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
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
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
