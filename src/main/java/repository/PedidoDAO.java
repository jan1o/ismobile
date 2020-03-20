package repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import biblioteca.Lista;
import model.Configuracao;
import model.ItemPedido;
import model.Pedido;
import model.PedidoPda;

public class PedidoDAO {
	
	Connection con = null;
	
	public PedidoDAO(Configuracao configuracao) throws Exception{
		try {
            Class.forName(configuracao.getDriverDB());
            con = DriverManager.getConnection(configuracao.getCaminhoDB(), configuracao.getLoginDB(), configuracao.getSenhaDB());

        } catch (Exception ex) {
            throw new Exception("Nao pode abrir conexao para o banco de dados: " +
		ex.getMessage());
        }
	}
	
	public Collection getListaPedidos(int codigo, int idPedido) throws SQLException {
        Lista lista = new Lista();       
	try {                   
            String listarSql = "SELECT p.numero, p.numero_pedido_pda, p.codigo_cliente, c.nome As cliente, " +
                               "       p.codigo_vendedor, v.nome As vendedor, " +
                               "       p.codigo_plano_pagto, pp.nome As plano_pagto, p.data, " +
                               "       ip.numero_pedido, ip.codigo_produto, pr.descricao, ip.valor, " +
                               "       SUM(ip.quantidade  - ip.qtd_devolvida - ip.qtd_falta - ip.qtd_avaria - qtd_estorno) As itens " +
                               "FROM pedido p LEFT OUTER JOIN item_pedido ip ON (ip.numero_pedido = p.numero) " +
                               "        LEFT OUTER JOIN produto pr ON (ip.codigo_produto = pr.codigo) " +
                               "        LEFT OUTER JOIN cliente c ON (p.codigo_cliente = c.codigo) " +
                               "        LEFT OUTER JOIN plano_pagamento pp ON (p.codigo_plano_pagto = pp.codigo) " +
                               "        LEFT OUTER JOIN vendedor v ON (p.codigo_vendedor = v.codigo) " +
                               "WHERE p.codigo_vendedor = ? AND" +
            				   "      ip.numero_pedido IS NOT NULL ";
                               if (idPedido > 0)
                                   listarSql += " AND p.numero = ? ";
                               else
                                    listarSql += " AND p.data BETWEEN CURRENT_DATE -90 AND CURRENT_DATE ";
                  listarSql += "GROUP BY p.numero, p.numero_pedido_pda, p.codigo_cliente, c.nome, " +
                               "         p.codigo_vendedor, v.nome, p.codigo_plano_pagto, pp.nome, p.data, " +
                               "         ip.numero_pedido, ip.codigo_produto, pr.descricao, ip.valor " +
                               "ORDER BY p.numero, ip.numero_pedido, pr.descricao ";  
    
                PreparedStatement listarStatement = con.prepareStatement(listarSql);
                //PreparedStatement listarStatement = con.prepareStatement(listarSql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //PreparedStatement listarStatement = statement.

                listarStatement.setInt(1, codigo);
                if (idPedido > 0)
                    listarStatement.setInt(2, idPedido);

                ResultSet rs = listarStatement.executeQuery();	
                
                boolean EOF = rs.next();  
 
                while (EOF == true) {            
                    Pedido pedido = new Pedido();
                    pedido.setNumero(rs.getInt(1));
                    pedido.setNumeroPedidoPDA(rs.getInt(2));
                    pedido.getCliente().setCodigo(rs.getInt(3));                    
                    pedido.getCliente().setNome(rs.getString(4));                    
                    pedido.getVendedor().setCodigo(rs.getInt(5));
                    pedido.getVendedor().setNome(rs.getString(6));
                    pedido.getCondicaoPagamento().setCodigo(rs.getInt(7));
                    pedido.getCondicaoPagamento().setNome(rs.getString(8));
                    pedido.setData(rs.getDate(9));
                   
                    while ((EOF == true) && (pedido.getNumero() == rs.getInt(10))){
                        ItemPedido ip = new ItemPedido();
                        ip.getProduto().setCodigo(rs.getInt(11));
                        ip.getProduto().setDescricao(rs.getString(12));                        
                        ip.setValor(rs.getDouble(13));
                        ip.setQuantidade(rs.getDouble(14));
                        
                        pedido.getLista().add(ip);                       
                        EOF = rs.next();
                    }
                  
                    lista.add(pedido);
                    //EOF = rs.next();
                    
		} 
		
		rs.close();
		listarStatement.close();
					
	} catch (Exception e) {
		throw new SQLException(e.getMessage());
	}
	Collections.sort(lista);
	return lista;
    }
      
	
	
}
