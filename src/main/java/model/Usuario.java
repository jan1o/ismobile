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
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_usuario; //numeric(3,0) NOT NULL DEFAULT nextval('codigo_usuario'::regclass),
	
	@NotNull
	@Size(max = 50)
	private String nome_usuario; // character varying(50) NOT NULL,
	
	@NotNull
	@Size(max = 30)
	private String senha_usuario; // character varying(30) NOT NULL,
	
	@NotNull
	private int limitado; // numeric(1,0) DEFAULT 0,
	
	@NotNull
	private int codigo_supervisor; // numeric(3,0),
	
	@NotNull
	private int exclusividade; // numeric(1,0) DEFAULT 0,
	
	@NotNull
	private int bloqueado; // numeric(1,0) DEFAULT 0,
	
	public int getCodigo_usuario() {
		return codigo_usuario;
	}
	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public int getLimitado() {
		return limitado;
	}
	public void setLimitado(int limitado) {
		this.limitado = limitado;
	}
	public int getCodigo_supervisor() {
		return codigo_supervisor;
	}
	public void setCodigo_supervisor(int codigo_supervisor) {
		this.codigo_supervisor = codigo_supervisor;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo_usuario;
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
		Usuario other = (Usuario) obj;
		if (codigo_usuario != other.codigo_usuario)
			return false;
		return true;
	}
	
	
	
	
	
}
