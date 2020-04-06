package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eder
 */
@Entity
@Table(name="vendedor")
public class Vendedor implements Comparable, Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="codigo")
	private int codigo;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="bairro")
	private String bairro;
	
	@NotNull
	@Column(name="codigo_cidade")
	private int codigo_cidade;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="rg")
	private String rg;
	
	@Column(name="email")
	private String email;
	
	@Column(name="observacao")
	private String observacao;
	
	@Column(name="cpf_cnpj")
	private String cpf_cnpj;
	
	@Column(name="insc_estadual")
	private String insc_estadual;
	
	@Column(name="nome_fantasia")
	private String nome_fantasia;
	
	@NotNull
	@Column(name="comissao")
	private int comissao;
	
	@NotNull
	@Column(name="comissao_reais")
	private int comissao_reais;
	
	@NotNull
	@Column(name="comissao_financiamento")
	private int comissao_financiamento;
	
	@Column(name="inativo")
	private int inativo;
	
	@Column(name="login_usuario")
	private String login_usuario;
	
	@Column(name="cpf_gerado")
	private Date cpf_gerado;
	
	@Column(name="cpf_gerado_por")
	private String cpf_gerado_por;
	
	@Column(name="codigo_equipe_venda")
	private int codigo_equipe_venda;
	
	@Column(name="flex")
	private int flex;
	
	@Column(name="saldo_flex")
	private int saldo_flex;
	
	@Column(name="saldo")
	private int saldo;
	
	@Column(name="piso_comissao")
	private int piso_comissao;
	
	@NotNull
	@Column(name="codigo_empresa")
	private int codigo_empresa;
	
	@Column(name="enviar_comissao_pda")
	private int enviar_comissao_pda;
	
	@Column(name="comissao_compra")
	private int comissao_compra;
	
	@Column(name="comissao_reais_compra")
	private int comissao_reais_compra;
	
	@Column(name="venda_externa")
	private int venda_externa;
	
	@Column(name="venda_financeira")
	private int venda_financeira;
	
	@Column(name="venda_terceiros")
	private int venda_terceiros;
	
	@Column(name="incluido")
	private Date incluido;
	
	@Column(name="incluido_por")
	private String incluido_por;
	
	@Column(name="alterado")
	private Date alterado;
	
	@Column(name="alterado_por")
	private String alterado_por;
	
	@Column(name="valor_minimo_venda")
	private int valor_minimo_venda;
	
	@Column(name="liberar_desconto_pda")
	private int liberar_desconto_pda;
	
	@Column(name="alterar_dfe_pda")
	private int alterar_dfe_pda;
	
	@Column(name="destacar_pedido")
	private int destacar_pedido;
	
	@Column(name="numero_pedido")
	private Integer numero_pedido;
	
	@Column(name="sequencia_pedido_pda")
	private int sequencia_pedido_pda;

	@Override
	public int compareTo(Object o) {
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

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getInsc_estadual() {
		return insc_estadual;
	}

	public void setInsc_estadual(String insc_estadual) {
		this.insc_estadual = insc_estadual;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public int getComissao() {
		return comissao;
	}

	public void setComissao(int comissao) {
		this.comissao = comissao;
	}

	public int getComissao_reais() {
		return comissao_reais;
	}

	public void setComissao_reais(int comissao_reais) {
		this.comissao_reais = comissao_reais;
	}

	public int getComissao_financiamento() {
		return comissao_financiamento;
	}

	public void setComissao_financiamento(int comissao_financiamento) {
		this.comissao_financiamento = comissao_financiamento;
	}

	public int getInativo() {
		return inativo;
	}

	public void setInativo(int inativo) {
		this.inativo = inativo;
	}

	public String getLogin_usuario() {
		return login_usuario;
	}

	public void setLogin_usuario(String login_usuario) {
		this.login_usuario = login_usuario;
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

	public int getCodigo_equipe_venda() {
		return codigo_equipe_venda;
	}

	public void setCodigo_equipe_venda(int codigo_equipe_venda) {
		this.codigo_equipe_venda = codigo_equipe_venda;
	}

	public int getFlex() {
		return flex;
	}

	public void setFlex(int flex) {
		this.flex = flex;
	}

	public int getSaldo_flex() {
		return saldo_flex;
	}

	public void setSaldo_flex(int saldo_flex) {
		this.saldo_flex = saldo_flex;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getPiso_comissao() {
		return piso_comissao;
	}

	public void setPiso_comissao(int piso_comissao) {
		this.piso_comissao = piso_comissao;
	}

	public int getCodigo_empresa() {
		return codigo_empresa;
	}

	public void setCodigo_empresa(int codigo_empresa) {
		this.codigo_empresa = codigo_empresa;
	}

	public int getEnviar_comissao_pda() {
		return enviar_comissao_pda;
	}

	public void setEnviar_comissao_pda(int enviar_comissao_pda) {
		this.enviar_comissao_pda = enviar_comissao_pda;
	}

	public int getComissao_compra() {
		return comissao_compra;
	}

	public void setComissao_compra(int comissao_compra) {
		this.comissao_compra = comissao_compra;
	}

	public int getComissao_reais_compra() {
		return comissao_reais_compra;
	}

	public void setComissao_reais_compra(int comissao_reais_compra) {
		this.comissao_reais_compra = comissao_reais_compra;
	}

	public int getVenda_externa() {
		return venda_externa;
	}

	public void setVenda_externa(int venda_externa) {
		this.venda_externa = venda_externa;
	}

	public int getVenda_financeira() {
		return venda_financeira;
	}

	public void setVenda_financeira(int venda_financeira) {
		this.venda_financeira = venda_financeira;
	}

	public int getVenda_terceiros() {
		return venda_terceiros;
	}

	public void setVenda_terceiros(int venda_terceiros) {
		this.venda_terceiros = venda_terceiros;
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

	public int getValor_minimo_venda() {
		return valor_minimo_venda;
	}

	public void setValor_minimo_venda(int valor_minimo_venda) {
		this.valor_minimo_venda = valor_minimo_venda;
	}

	public int getLiberar_desconto_pda() {
		return liberar_desconto_pda;
	}

	public void setLiberar_desconto_pda(int liberar_desconto_pda) {
		this.liberar_desconto_pda = liberar_desconto_pda;
	}

	public int getAlterar_dfe_pda() {
		return alterar_dfe_pda;
	}

	public void setAlterar_dfe_pda(int alterar_dfe_pda) {
		this.alterar_dfe_pda = alterar_dfe_pda;
	}

	public int getDestacar_pedido() {
		return destacar_pedido;
	}

	public void setDestacar_pedido(int destacar_pedido) {
		this.destacar_pedido = destacar_pedido;
	}

	public Integer getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(Integer numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public int getSequencia_pedido_pda() {
		return sequencia_pedido_pda;
	}

	public void setSequencia_pedido_pda(int sequencia_pedido_pda) {
		this.sequencia_pedido_pda = sequencia_pedido_pda;
	}
	
	
}
