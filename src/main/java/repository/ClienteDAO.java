package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Configuracao;

import model.Cliente;

public class ClienteDAO {

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
