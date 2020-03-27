package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import model.Configuracao;
import model.Produto;
import model.Vendedor;

public class UsuarioPermissaoDAO {
	
	Connection con = null;
	
	public UsuarioPermissaoDAO(Configuracao configuracao) throws Exception{
		try {
            Class.forName(configuracao.getDriverDB());
            con = DriverManager.getConnection(configuracao.getCaminhoDB(), configuracao.getLoginDB(), configuracao.getSenhaDB());

        } catch (Exception ex) {
            throw new Exception("Nao pode abrir conexao para o banco de dados: " +
		ex.getMessage());
        }
	}
	
	//Metodo para verificar os dados do vendedor pelo seu login de usuario passados pela secao
	public Vendedor getDadosVendedor(String login) throws SQLException {
		Vendedor v;
		try { 
			
			String listarSql;
			listarSql = "SELECT u.codigo_vendedor, v.nome, v.sequencia_pedido_pda "+
					 	"FROM permissao_usuario u LEFT OUTER JOIN vendedor v "+
				     	"ON (u.codigo_vendedor = v.codigo) "+
				     	"WHERE u.nome = ? AND "+
				     	"bloqueado = 0";
			

			PreparedStatement listarStatement = con.prepareStatement(listarSql);
			
			listarStatement.setString(1, login);	

			ResultSet rs = listarStatement.executeQuery();
			
			v = new Vendedor();
			v.setCodigo(rs.getInt(1));
			v.setNome(rs.getString(2));
			v.setSequencia_pedido_pda(rs.getInt(3));

			rs.close();
			listarStatement.close();

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		return v;
	}
	
	public void updateSequenciaPedidoPda(Vendedor v) throws SQLException {
		try {
			String listarSql;
			listarSql = "UPDATE vendedor SET sequencia_pedido_pda = sequencia_pedido_pda + 1 WHERE codigo = ? ";

			PreparedStatement listarStatement = con.prepareStatement(listarSql);

			listarStatement.setInt(1, v.getCodigo());

			ResultSet rs = listarStatement.executeQuery();
			
		}  catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
	}

}

