package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Usuarios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Usuarios(EntityManager manager) {
		this.manager = manager;
	}
	
	public Usuario usuarioPorNome(String nome_usuario) {
		try {
		TypedQuery<Usuario> query = (TypedQuery<Usuario>) manager.createQuery(
				"FROM Usuario U WHERE U.nome_usuario = " + "'" + nome_usuario + "'");
		return query.getSingleResult();
		} catch (NoResultException e) {
            return null;
      }
	}

}
