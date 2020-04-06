package converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import model.CondicaoPagamento;
import model.Produto;
import repository.PlanoPagamentoDAO;
import repository.ProdutoDAO;
import util.JpaUtil;

@FacesConverter(forClass = CondicaoPagamento.class)
public class PlanoPagamentoConverter implements Converter, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	//***** MÉTODO INACABADO, ESPERANDO ATUALIZAÇÂO DO DAO ***!!!!
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {

		CondicaoPagamento retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			if (codigo != null && !"".equals(codigo)) {
				//ClienteDAO clienteDao = new ClienteDAO(manager);
				//retorno = clienteDao.porId(new Long(value));
				PlanoPagamentoDAO dao = new PlanoPagamentoDAO(manager);
				retorno = dao.listarPorId(Integer.getInteger(codigo));
			}
			return retorno;
		} finally {
			manager.close();
		}
	}

	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		// TODO Auto-generated method stub
		if(objeto != null) {
			return Integer.toString(((Produto) objeto).getCodigo());
		}
		return null;
	}
}
