package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_usuario", nullable = false, length = 3)
	private int id; // numeric(3,0) NOT NULL DEFAULT nextval('codigo_usuario'::regclass),

	@Column(name = "nome_usuario", nullable = false, length = 50)
	private String nome; // character varying(50) NOT NULL,

	@Column(name = "senha_usuario", nullable = false, length = 30)
	private String senha; // character varying(30) NOT NULL,

	private int limitado; // numeric(1,0) DEFAULT 0,

	@Column(name = "codigo_supervisor", length = 3)
	private int idSupervisor; // numeric(3,0),

	private int exclusividade; // numeric(1,0) DEFAULT 0,

	private int bloqueado; // numeric(1,0) DEFAULT 0,

	@Column(name = "codigo_cliente", length = 6)
	private Integer idCliente;

	@Column(name = "codigo_vendedor", length = 6)
	private Integer idVendedor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getLimitado() {
		return limitado;
	}

	public void setLimitado(int limitado) {
		this.limitado = limitado;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public int getExclusividade() {
		return exclusividade;
	}

	public void setExclusividade(int exclusividade) {
		this.exclusividade = exclusividade;
	}

	public int getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(int bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	// Saber que tipo de usuario esta logado
	public boolean getUsuarioCliente() {
		return getIdCliente() > 0;
	}

	public boolean getUsuarioVendedor() {
		return getIdVendedor() > 0;
	}

	public boolean getUsuarioSupervisor() {
		return getIdSupervisor() > 0;
	}
}
