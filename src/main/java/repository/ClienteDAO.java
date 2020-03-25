package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Configuracao;

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
}
