package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Usuario;

public class UsuarioDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Usuario usuarioPorNome(String login, String senha) {
		try {
			TypedQuery<Usuario> query = (TypedQuery<Usuario>) manager.createQuery("FROM Usuario u WHERE u.nome = :login AND u.senha = :senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			return query.getSingleResult();
		} catch (NoResultException e) {
            return null;
      }
	}
}
