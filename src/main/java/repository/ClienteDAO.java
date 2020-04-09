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
	
	
	//###### Código sem hibernate ######
	/*
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
	public List<Cliente> listarClientes() throws SQLException{
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String sql = "SELECT c.nome, c.codigo from cliente c ";
			
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
	
	
	public List<Cliente> teste() throws SQLException{
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			
			String sql = "SELECT rem_caracter_especial(nome) As nome, codigo, rem_caracter_especial(endereco) as endereco,rem_caracter_especial(numero) as numero, rem_caracter_especial(complemento) as complemento," + 
					"		rem_caracter_especial(bairro) as bairro, rem_caracter_especial(cep) as cep, rem_caracter_especial(ponto_referencia) as ponto_referencia, rem_caracter_especial(cpf_cnpj) as cpf_cnpj," + 
					"		rem_caracter_especial(nome_fantasia) as nome_fantasia, rem_caracter_especial(insc_estadual) as insc_estadual, rem_caracter_especial(rg) as rg, rem_caracter_especial(email) as email, rem_caracter_especial(observacao) as observacao," + 
					"		rem_caracter_especial(licenca_sanitaria) as licenca_sanitaria,rem_caracter_especial(autorizacao_anvisa) as autorizacao_anvisa,rem_caracter_especial(inativo) as inativo,rem_caracter_especial(alterado_por) as alterado_por,rem_caracter_especial(incluido_por) as incluido_por," + 
					"		rem_caracter_especial(nome_pai) as nome_pai,rem_caracter_especial(nome_mae) as nome_mae,rem_caracter_especial(cpf_gerado_por) as cpf_gerado_por,rem_caracter_especial(estado_civil) as estado_civil,rem_caracter_especial(naturalidade) as naturalidade," + 
					"		rem_caracter_especial(nome_conjuge) as nome_conjuge,rem_caracter_especial(referencia) as referencia,rem_caracter_especial(referencias_comerciais) as referencias_comerciais,rem_caracter_especial(local_trabalho) as local_trabalho,rem_caracter_especial(foto) as foto," + 
					"		rem_caracter_especial(tamanho_superior) as tamanho_superior,rem_caracter_especial(tamanho_inferior) as tamanho_inferior,rem_caracter_especial(tamanho_calcado) as tamanho_calcado,rem_caracter_especial(latitude) as latitude,rem_caracter_especial(longitude) as longitude," + 
					"		rem_caracter_especial(mensagem_adicional_boleto) as mensagem_adicional_boleto,rem_caracter_especial(nacionalidade) as nacionalidade,rem_caracter_especial(tempo_residencia) as tempo_residencia,rem_caracter_especial(endereco_anterior) as endereco_anterior,rem_caracter_especial(emissor) as emissor,rem_caracter_especial(negativado_por) as negativado_por," + 
					"		rem_caracter_especial(cpf_pai) as cpf_pai,rem_caracter_especial(cpf_mae) as cpf_mae,rem_caracter_especial(rg_pai) as rg_pai,rem_caracter_especial(rg_mae) as rg_mae,rem_caracter_especial(profissao) as profissao," + 
					"		rem_caracter_especial(dn) as dn,rem_caracter_especial(escolaridade) as escolaridade,rem_caracter_especial(convenio) as convenio,rem_caracter_especial(cartao_sus) as cartao_sus,rem_caracter_especial(lembrete) as lembrete,rem_caracter_especial(lembrete) as lembrete," + 
					"		rem_caracter_especial(lembrete_destino) as lembrete_destino,rem_caracter_especial(lembrete_usuario) as lembrete_usuario" + 
					"	FROM cliente" ;
					
			
			PreparedStatement listarStatement = con.prepareStatement(sql);
			ResultSet rs = listarStatement.executeQuery();
			
			boolean EOF = rs.next();
			while(EOF == true) {
				Cliente c = new Cliente();
				//c.setNome(rs.getInt(1));
				c.setCodigo(rs.getInt(2));
				clientes.add(c);
				EOF = rs.next();
			}
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		return clientes;
	}
	*/
}
