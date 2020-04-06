package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import biblioteca.Lista;
import model.Cliente;
import model.Configuracao;
import model.Produto;

public class ProdutoDAO {
	
	private EntityManager manager;

	public ProdutoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Produto> listarProdutos(){
		Query query = manager.createQuery("FROM Produto ");
		List<Produto> produtos = query.getResultList();

		return produtos;
	}
	
	public Produto listarPorId(int codigo) {
		Query query = manager.createQuery("from Produto p where p.codigo = :id ");
		query.setParameter("id", codigo);
		Produto p = (Produto) query.getSingleResult();
		return p;
	}
	//##### Código sem hibernate #####
	/*
	Connection con = null;
	
	
	public ProdutoDAO(Configuracao configuracao) throws Exception {
		try {
			Class.forName(configuracao.getDriverDB());
			con = DriverManager.getConnection(configuracao.getCaminhoDB(), configuracao.getLoginDB(),
					configuracao.getSenhaDB());

		} catch (Exception ex) {
			throw new Exception("Nao pode abrir conexao para o banco de dados: " + ex.getMessage());
		}
	}

	public Collection getListaProduto(int codigo) throws SQLException {

		Lista lista = new Lista();

		try { // codigo_setor
				// String listarSql = "SELECT CODIGO, DESCRICAO, SIGLA_UNIDADE, QUANTIDADE,
				// VALOR, CODIGO_GRUPO, CODIGO_SUBGRUPO, CODIGO_FABRICANTE, QTD_EMBALAGEM,
				// COMISSAO, CODIGO_tipo_produto FROM PRODUTO WHERE QUANTIDADE > 0"; // AND NOT
				// DESCRICAO LIKE '%&%'";
			String listarSql; // REPLACE(p.foto_web, '/', '\')
			if (codigo > 0) {
				listarSql = "SELECT p.codigo, p.descricao, p.sigla_unidade, p.quantidade, p.valor, "
						+ "       p.codigo_grupo, p.codigo_subgrupo, p.codigo_fabricante, "
						+ "       p.qtd_embalagem, CASE WHEN (v.enviar_comissao_pda = 0) THEN 0.00 "
						+ "                             WHEN ((pvc.comissao > 0) AND (pvc.comissao IS NOT NULL)) THEN pvc.comissao "
						+ "                             WHEN (p.comissao > 0) THEN p.comissao "
						+ "                             ELSE COALESCE(v.comissao, 0) END As comissao, "
						+ "       p.codigo_tipo_produto, "
						+ "       CASE WHEN (v.liberar_desconto_pda = 1) THEN p.custo ELSE p.valor_minimo END As valor_minimo, "
						+ "       CASE WHEN (temp.codigo_produto > 0) THEN 1 ELSE 0 END As positivado, "
						+ "       CASE WHEN conf.enviar_codigo_barra_pda = 0 THEN p.referencia ELSE p.codigo_barra END As referencia, "
						+ "       conf.desc_negociacao_piso, conf.desc_negociacao_teto, p.status_alteracao_valor, p.data_ultima_venda, "
						+ "       p.informacao_adicional, p.validade, get_status_validade(p.validade, CURRENT_DATE) As st_vencimento,  "
						+ "       p.foto_web, conf.bloquear_acrescimo_pda, p.custo, p.valor_compra, p.margem_lucro "
						+ "FROM   vendedor v, produto_vendedor_comissao pvc RIGHT OUTER JOIN produto p ON "
						+ "       (pvc.codigo_produto = p.codigo AND pvc.codigo_vendedor = ?) LEFT OUTER JOIN "
						+ "       (SELECT DISTINCT ip.codigo_produto " + "        FROM item_pedido ip, pedido ped "
						+ "        WHERE ip.numero_pedido = ped.numero AND "
						+ "              TO_CHAR(ped.data, 'MM/YYYY') = TO_CHAR(CURRENT_DATE, 'MM/YYYY') AND "
						+ "              ped.codigo_vendedor = ?) temp ON (temp.codigo_produto = p.codigo), configuracao conf "
						+ "WHERE  v.codigo = ? AND p.inativo = '0' AND "
						+ "       p.codigo_grupo IN (SELECT codigo FROM grupo WHERE enviar_pda = 1) AND "
						+ "       CASE WHEN conf.enviar_produto_zerado_pda = 0 THEN "
						+ "       p.quantidade > 0 ELSE p.quantidade IS NOT NULL END AND "
						+ "       CASE WHEN (v.codigo_equipe_venda <> 999) THEN "
						+ "       (p.codigo_grupo IN (SELECT evg.codigo_grupo "
						+ "                           FROM equipe_venda_grupo evg "
						+ "                           WHERE evg.codigo_equipe_venda = v.codigo_equipe_venda)) "
						+ "       ELSE (p.codigo_grupo IS NOT NULL) END " + "ORDER BY p.descricao ";
			} else {
				listarSql = "SELECT p.codigo, p.descricao, p.sigla_unidade, p.quantidade, p.valor, "
						+ "       p.codigo_grupo, p.codigo_subgrupo, p.codigo_fabricante, "
						+ "       p.qtd_embalagem, p.comissao, p.codigo_tipo_produto, " + "       p.valor_minimo, "
						+ "       CASE WHEN (temp.codigo_produto > 0) THEN 1 ELSE 0 END As positivado, "
						+ "       CASE WHEN conf.enviar_codigo_barra_pda = 0 THEN p.referencia ELSE p.codigo_barra END As referencia, "
						+ "       conf.desc_negociacao_piso, conf.desc_negociacao_teto, p.status_alteracao_valor, p.data_ultima_venda,"
						+ "       p.informacao_adicional, p.validade, get_status_validade(p.validade, CURRENT_DATE) As st_vencimento, "
						+ "       p.foto_web, conf.bloquear_acrescimo_pda, p.custo, p.valor_compra, p.margem_lucro "
						+ "FROM  produto p LEFT OUTER JOIN " + "        (SELECT DISTINCT ip.codigo_produto "
						+ " 	  FROM item_pedido ip, pedido ped " + "	  WHERE ip.numero_pedido = ped.numero AND "
						+ "	        TO_CHAR(ped.data, 'MM/YYYY') = TO_CHAR(CURRENT_DATE, 'MM/YYYY')) temp "
						+ " 	ON (temp.codigo_produto = p.codigo), configuracao conf  "
						+ "WHERE  p.inativo = '0' AND "
						+ "       p.codigo_grupo IN (SELECT codigo FROM grupo WHERE enviar_pda = 1) AND "
						+ "       CASE WHEN conf.enviar_produto_zerado_pda = 0 THEN "
						+ "       p.quantidade > 0 ELSE p.quantidade IS NOT NULL END " + "ORDER BY p.descricao ";
			}

			PreparedStatement listarStatement = con.prepareStatement(listarSql);
			if (codigo > 0) {
				listarStatement.setInt(1, codigo);
				listarStatement.setInt(2, codigo);
				listarStatement.setInt(3, codigo);
			}

			ResultSet rs = listarStatement.executeQuery();

			while (rs.next()) {
				try {
					Produto p = new Produto();
					p.setCodigo(rs.getInt(1));
					p.setDescricao(rs.getString(2));
					p.setSigla_unidade(rs.getString(3));
					p.setQuantidade(rs.getInt(4));
					p.setValor(rs.getDouble(5));
					p.setCodigo_grupo(rs.getInt(6));
					p.setCodigo_subgrupo(rs.getInt(7));
					p.setCodigo_fabricante(rs.getInt(8));
					p.setQtdEmbalagem(rs.getInt(9));
					p.setComissao(rs.getDouble(10));
					p.setCodigo_setor(rs.getInt(11));
					p.setValorMinimo(rs.getDouble(12));
					p.setPositivado(rs.getInt(13));
					p.setReferencia(rs.getString(14));
					p.setPisoNegociacao(rs.getDouble(15));
					p.setTetoNegociacao(rs.getDouble(16));
					p.setStatusValor(rs.getString(17));
					p.setUltimaVenda(rs.getDate(18));
					p.setInfAdicional(rs.getString(19));
					p.setValidade(rs.getDate(20));
					p.setStValidade(rs.getString(21));
					p.setFotoWeb(rs.getString(22));
					p.setBloquearAcrescimo(rs.getInt(23));
					if (codigo > 0) {
						p.setValorCusto(0.00);
						p.setValorCompra(0.00);
						p.setMargemLucro(0.00);
					} else {
						p.setValorCusto(rs.getDouble(24));
						p.setValorCompra(rs.getDouble(25));
						p.setMargemLucro(rs.getDouble(26));
					}
					lista.add(p);
				} catch (Exception e) {
					// Para nao parar por causa de produto com cadastro errado
				}
			}

			rs.close();
			listarStatement.close();

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		Collections.sort(lista);
		return lista;
	}

	// funcao para retornar o nome de um produto em vez do código
	public String getNomeProduto(int codigo) throws SQLException {

		String nome;
		try {
			String listarSql;
			listarSql = "SELECT p.descricao " + "FROM produto p " + "WHERE p.codigo = ? ";

			PreparedStatement listarStatement = con.prepareStatement(listarSql);

			listarStatement.setInt(1, codigo);

			ResultSet rs = listarStatement.executeQuery();

			nome = rs.getString(1);

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		return nome;
	}
	*/
}
