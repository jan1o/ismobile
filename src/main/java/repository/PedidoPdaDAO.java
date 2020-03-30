package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import biblioteca.Lista;
import model.Configuracao;
import model.ItemPedido;
import model.ItemPedidoPda;
import model.Pedido;
import model.PedidoPda;
import util.JpaUtil;

public class PedidoPdaDAO {
	
	private EntityManager manager;
	
	public PedidoPdaDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	
	
	//########## codigo sem mapeamento completo no hibernate #########
	
	//falta o ... AND processado = null
	public List<PedidoPda> listarTodos(int idVendedor){
		Query query = manager.createQuery("from PedidoPda p where p.codigo_vendedor = :id and p.processado is null");
		query.setParameter("id", idVendedor);
		List<PedidoPda> pedidos= query.getResultList();
		
		for(PedidoPda p : pedidos) {
			ItemPedidoPdaDAO dao = new ItemPedidoPdaDAO(manager);
			p.setItens(dao.listarPorPedidoPda(p));
		}
		
		return query.getResultList();
	}
	
	public PedidoPda listarPorId(PedidoPda pedido) {
		Query query = manager.createQuery("from PedidoPda p where p.numero = :id ");
		query.setParameter("id", pedido.getNumero());
		PedidoPda p = (PedidoPda) query.getSingleResult();
		ItemPedidoPdaDAO dao = new ItemPedidoPdaDAO(manager);
		p.setItens(dao.listarPorPedidoPda(pedido));
		return p;
	}
	
	public void inserir(PedidoPda pedido) {
		manager.getTransaction().begin();
		manager.merge(pedido);
		manager.getTransaction().commit();
		
		EntityManager man = JpaUtil.getEntityManager();
		ItemPedidoPdaDAO dao = new ItemPedidoPdaDAO(man);
		dao.inserirItens(pedido.getItens());
	}

	public void alterar(PedidoPda pedido) {
		manager.getTransaction().begin();
		this.manager.merge(pedido);
		manager.getTransaction().commit();
		
		EntityManager man = JpaUtil.getEntityManager();
		ItemPedidoPdaDAO dao = new ItemPedidoPdaDAO(man);
		dao.alterarItensPedido(pedido);
		
	}
	
	public void deletar(PedidoPda pedido) {
		
		EntityManager man = JpaUtil.getEntityManager();
		ItemPedidoPdaDAO dao = new ItemPedidoPdaDAO(man);
		dao.deletarItensPedido(pedido);
		
		manager.getTransaction().begin();
		manager.remove(manager.getReference(PedidoPda.class, pedido));
		
		manager.getTransaction().commit();
	}
	
	//########## codigo com mapeamento completo no hibernate #########
	/*
	
	public List<PedidoPda> listarTodos(int idVendedor){
		Query query = manager.createQuery("from PedidoPda p where p.codigo_vendedor = :id ");
		query.setParameter("id", idVendedor);
		List<PedidoPda> pedidos= query.getResultList();
		
		return query.getResultList();
	}
	
	public PedidoPda listarPorId(PedidoPda pedido) {
		Query query = manager.createQuery("from PedidoPda p where p.numero = :id ");
		query.setParameter("id", pedido.getNumero());
		PedidoPda p = (PedidoPda) query.getSingleResult();
		return p;
	}
	
	public void inserir(PedidoPda pedido) {
		manager.getTransaction().begin();
		manager.merge(pedido);
		manager.getTransaction().commit();
		
	}
	//Esse método serve tanto para inserir quanto para alterar os pedidoPda.
	public void alterar(PedidoPda pedido) {
		manager.getTransaction().begin();
		this.manager.merge(pedido);
		manager.getTransaction().commit();
		
	}
	
	public void deletar(PedidoPda pedido) {
		
		manager.getTransaction().begin();
		manager.remove(manager.getReference(PedidoPda.class, pedido));
		
		manager.getTransaction().commit();
	}
	
	
	//########## A partir daqui foi utilizado outro tipo de conexao com o banco que não o Hibernate #########
	
	/*Connection con = null;

	public PedidoPdaDAO(Configuracao configuracao) throws Exception {
		try {
			Class.forName(configuracao.getDriverDB());
			con = DriverManager.getConnection(configuracao.getCaminhoDB(), configuracao.getLoginDB(),
					configuracao.getSenhaDB());

		} catch (Exception ex) {
			throw new Exception("Nao pode abrir conexao para o banco de dados: " + ex.getMessage());
		}
	}
	
	public Collection getListaPedidos(int codigo, int idPedido) throws SQLException {
		Lista lista = new Lista();
		try {
			String listarSql = "SELECT * FROM pedido_pda WHERE processado = '' AND codigo_vendedor = ?";
			
			PreparedStatement listarStatement = con.prepareStatement(listarSql);
			listarStatement.setInt(1, codigo);
			
			ResultSet rs = listarStatement.executeQuery();
			
								
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		Collections.sort(lista);
		return lista;
		
	}
	//Essa era funcao que eu adaptei, mas pablo disse q nao era assim. Me orgulho dela entao vou deixar aqui kkk
	public Collection getListaPedidos(int codigo, int idPedido) throws SQLException {
		Lista lista = new Lista();
		
		try {
			String listarSql = "SELECT p.numero, p.codigo_cliente, c.nome As cliente, "
					+ " p.codigo_vendedor, v.nome As vendedor, "
					+ " p.codigo_plano_pagamento, pp.nome As plano_pagto, p.data, "
					+ " ip.numero_pedido_pda, ip.codigo_produto, pr.descricao, ip.valor, " + " ip.quantidade As itens"
					+ " FROM pedido_pda p LEFT OUTER JOIN item_pedido_pda ip ON (ip.numero_pedido_pda = p.numero) "
					+ " LEFT OUTER JOIN produto pr ON (ip.codigo_produto = pr.codigo) "
					+ " LEFT OUTER JOIN cliente c ON (p.codigo_cliente = c.codigo) "
					+ " LEFT OUTER JOIN plano_pagamento pp ON (p.codigo_plano_pagamento = pp.codigo) "
					+ " LEFT OUTER JOIN vendedor v ON (p.codigo_vendedor = v.codigo) "
					+ " WHERE p.codigo_vendedor = ? AND " + " ip.numero_pedido_pda IS NOT NULL ";

			if (idPedido > 0)
				listarSql += " AND p.numero = ? ";
			else {
				listarSql += " AND p.data BETWEEN CURRENT_DATE -90 AND CURRENT_DATE ";
			}

			listarSql += "GROUP BY p.numero, p.codigo_cliente, c.nome, "
					+ "         p.codigo_vendedor, v.nome, p.codigo_plano_pagamento, pp.nome, p.data, "
					+ "         ip.numero_pedido_pda, ip.codigo_produto, pr.descricao, ip.valor, ip.quantidade "
					+ "ORDER BY p.numero, ip.numero_pedido_pda, pr.descricao ";

			PreparedStatement listarStatement = con.prepareStatement(listarSql);
			// PreparedStatement listarStatement = con.prepareStatement(listarSql,
			// ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			// ResultSet.CONCUR_UPDATABLE);
			// PreparedStatement listarStatement = statement.

			listarStatement.setInt(1, codigo);
			if (idPedido > 0)
				listarStatement.setInt(2, idPedido);

			ResultSet rs = listarStatement.executeQuery();

			boolean EOF = rs.next();

			while (EOF == true) {
				PedidoPda pedido = new PedidoPda();
				pedido.setNumero(rs.getInt(1));
				pedido.getCliente().setCodigo(rs.getInt(2));
				pedido.getCliente().setNome(rs.getString(3));
				pedido.getVendedor().setCodigo(rs.getInt(4));
				pedido.getVendedor().setNome(rs.getString(5));
				pedido.getCondicaoPagamento().setCodigo(rs.getInt(6));
				pedido.getCondicaoPagamento().setNome(rs.getString(7));
				pedido.setData(rs.getDate(8));

				while ((EOF == true) && (pedido.getNumero() == rs.getInt(9))) {
					ItemPedidoPda ip = new ItemPedidoPda();
					ip.getProduto().setCodigo(rs.getInt(10));
					ip.getProduto().setDescricao(rs.getString(11));
					ip.setValor(rs.getDouble(12));
					ip.setQuantidade(rs.getInt(13));

					pedido.getLista().add(ip);
					EOF = rs.next();
				}

				lista.add(pedido);
				// EOF = rs.next();

			}

			rs.close();
			listarStatement.close();

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		Collections.sort(lista);
		return lista;
	}
	*/
	
	/*
	public void InserirPedido(PedidoPda pedido) throws SQLException {

		try {
			String insertSqlPedido = "INSERT "
					+ "INTO pedido_pda(numero, data, codigo_cliente, codigo_vendedor, codigo_plano_pagamento, "
					+ " frios, retirado, observacao, negociacao, latitude, longitude, inicio_atendimento, "
					+ " fim_atendimento, versao_app, consignado, tipo_dfe, qtd_pedidos_lote) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insertStatement = con.prepareStatement(insertSqlPedido);

			insertStatement.setInt(1, pedido.getNumero());

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datetext = sdf.format(pedido.getData());
			insertStatement.setTimestamp(2, Timestamp.valueOf(datetext));

			insertStatement.setInt(3, pedido.getCliente().getCodigo());
			insertStatement.setInt(4, pedido.getVendedor().getCodigo());
			insertStatement.setInt(5, pedido.getCondicaoPagamento().getCodigo());
			insertStatement.setInt(6, pedido.getFrios());
			insertStatement.setInt(7, pedido.getRetirado());
			insertStatement.setString(8, pedido.getObs());
			insertStatement.setInt(9, pedido.getNegociacao());
			insertStatement.setDouble(10, pedido.getLatitude());
			insertStatement.setDouble(11, pedido.getLongitude());
			insertStatement.setString(12, pedido.getInicioAtendimento());
			insertStatement.setString(13, pedido.getFimAtendimento());
			insertStatement.setString(14, pedido.getVersaoApp());
			insertStatement.setInt(15, pedido.getConsignado());
			insertStatement.setInt(16, pedido.getTipoDFe());
			insertStatement.setInt(17, pedido.getQtdPedidoLote());

			insertStatement.executeUpdate();

			String insertSqlItemPedido = "insert into item_pedido_pda(numero_pedido_pda, codigo_vendedor, codigo_produto, quantidade, valor) values(?, ?, ?, ?, ?)";
			PreparedStatement insertStatementItem = con.prepareStatement(insertSqlItemPedido);

			Iterator it = pedido.getLista().iterator();
			while (it.hasNext()) {
				ItemPedido ip = (ItemPedido) it.next();
				insertStatementItem.setInt(1, pedido.getNumero());
				insertStatementItem.setInt(2, pedido.getVendedor().getCodigo());
				insertStatementItem.setInt(3, ip.getProduto().getCodigo());
				insertStatementItem.setDouble(4, ip.getQuantidade());
				insertStatementItem.setDouble(5, ip.getValor());

				insertStatementItem.executeUpdate();
			}
			con.commit();

			insertStatement.close();
			insertStatementItem.close();

			String update = "UPDATE pedido_pda SET ENVIADO = CURRENT_TIMESTAMP WHERE NUMERO = " + pedido.getNumero()
					+ " AND CODIGO_VENDEDOR = " + pedido.getVendedor().getCodigo();
			PreparedStatement updateStatement = con.prepareStatement(update);
			updateStatement.executeUpdate();
			con.commit();
			updateStatement.close();
			pedido.setLogErro("");
			// CallableStatement stat = con.prepareCall("{call processar_pedido_pda_pr}");
			// stat.execute();
			// con.commit();

		} catch (Exception e) {
			pedido.setLogErro("Erro: " + e.toString());
			System.out.println("Erro: " + e.toString());
		}
	}
	*/
}
