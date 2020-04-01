package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.CondicaoPagamento;
import model.Configuracao;
import model.Produto;

public class PlanoPagamentoDAO {
	
	private EntityManager manager;

	public PlanoPagamentoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<CondicaoPagamento> listarCondicoesPagamento(){
		Query query = manager.createQuery("from plano_pagamento ");
		List<CondicaoPagamento> cds = query.getResultList();

		return cds;
	}
	
	//##### Código sem hibernate #####
	/*
	Connection con = null;

	public PlanoPagamentoDAO(Configuracao configuracao) throws Exception{
		try {
            Class.forName(configuracao.getDriverDB());
            con = DriverManager.getConnection(configuracao.getCaminhoDB(), configuracao.getLoginDB(), configuracao.getSenhaDB());

        } catch (Exception ex) {
            throw new Exception("Nao pode abrir conexao para o banco de dados: " +
		ex.getMessage());
        }
	}
	
	public String FormaPagamento(int codigoPlanoPagamento) throws SQLException {
		String formaPagto;
		try {
		String listarSql;
		listarSql = "SELECT p.nome "+
				 	"FROM plano_pagamento p "+
			     	"WHERE p.codigo = ? ";
		
		PreparedStatement listarStatement = con.prepareStatement(listarSql);
		
		listarStatement.setInt(1, codigoPlanoPagamento);	

		ResultSet rs = listarStatement.executeQuery();
		
		formaPagto = rs.getString(1);
		
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		return formaPagto;
	}
	*/
}
