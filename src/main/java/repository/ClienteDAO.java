package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Configuracao;
import model.PedidoPda;
import model.Cliente;

public class ClienteDAO {
	
	//###### Código com hibernate ######
	/*
	private EntityManager manager;

	public ClienteDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Cliente> listarClientes(){
		Query query = manager.createQuery("FROM Cliente ");
		List<Cliente> clientes = query.getResultList();

		return clientes;
	}
	
	public Cliente listarPorId(int codigo) {
		Query query = manager.createQuery("from Cliente c where c.codigo = :id ");
		query.setParameter("id", codigo);
		Cliente c = (Cliente) query.getSingleResult();
		return c;
	}
	*/
	
	//###### Código sem hibernate ######
	
	Connection con = null;

	public ClienteDAO(Configuracao configuracao) throws Exception {
		try {
			Class.forName(configuracao.getDriverDB());
			con = DriverManager.getConnection(configuracao.getCaminhoDB(), configuracao.getLoginDB(),
					configuracao.getSenhaDB());

		} catch (Exception ex) {
			throw new Exception("Nao pode abrir conexao para o banco de dados: " + ex.getMessage());
		}
	}

	public String GetNomeCliente(int codigo) throws SQLException {
		String nome;
		try {
			String listarSql;
			listarSql = "SELECT c.nome " + "FROM cliente c " + "WHERE c.codigo = ? ";

			PreparedStatement listarStatement = con.prepareStatement(listarSql);

			listarStatement.setInt(1, codigo);

			ResultSet rs = listarStatement.executeQuery();

			nome = rs.getString(1);

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		return nome;
	}
	
	public Cliente listarPorId(int codigo) throws SQLException {
		
		Cliente c = new Cliente();
		try {
			String sql = "SELECT c.codigo, c.nome FROM cliente c WHERE c.codigo = ? ";
			PreparedStatement listarStatement = con.prepareStatement(sql);

			listarStatement.setInt(1, codigo);
			ResultSet rs = listarStatement.executeQuery();
			c.setCodigo(rs.getInt(1));
			c.setNome(rs.getString(2));
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		return c;
	}
	public List<Cliente> listaNomeCodigoClientes() throws SQLException{
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String sql;
			sql = "SELECT c.nome, c.codigo from cliente c ";
			
			PreparedStatement listarStatement = con.prepareStatement(sql);
			ResultSet rs = listarStatement.executeQuery();
			
			boolean EOF = rs.next();
			while(EOF == true) {
				Cliente c = new Cliente();
				c.setNome(rs.getString(1));
				c.setCodigo(rs.getInt(2));
				clientes.add(c);
				EOF = rs.next();
			}
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		return clientes;
	}
	
	
}
