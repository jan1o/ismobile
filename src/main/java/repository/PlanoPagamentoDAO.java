package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Configuracao;

public class PlanoPagamentoDAO {

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
}
