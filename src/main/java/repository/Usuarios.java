package repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Usuarios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Usuarios(EntityManager manager) {
		this.manager = manager;
	}
	
	public Usuario usuarioPorNome(String nome_usuario) {
		TypedQuery<Usuario> query = (TypedQuery<Usuario>) manager.createQuery(
				"FROM usuario U WHERE U.nome_usuario = " + nome_usuario);
		return query.getSingleResult();
	}

}
