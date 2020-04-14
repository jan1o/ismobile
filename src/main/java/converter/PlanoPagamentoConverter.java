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
public class PlanoPagamentoConverter implements Converter {
	



	//***** MÉTODO INACABADO, ESPERANDO ATUALIZAÇÂO DO DAO ***!!!!
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		CondicaoPagamento retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			if (value != null && !"".equals(value)) {
				//ClienteDAO clienteDao = new ClienteDAO(manager);
				//retorno = clienteDao.porId(new Long(value));
				PlanoPagamentoDAO dao = new PlanoPagamentoDAO(manager);
				retorno = dao.listarPorId(Integer.parseInt(value));
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
			return Integer.toString(((CondicaoPagamento) objeto).getCodigo());
		}
		return null;
	}
}
