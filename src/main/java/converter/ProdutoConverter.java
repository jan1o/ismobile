package converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import model.Produto;
import repository.ProdutoDAO;
import util.JpaUtil;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	//***** MÉTODO INACABADO, ESPERANDO ATUALIZAÇÂO DO DAO ***!!!!
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {

		Produto retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			if (codigo != null && !"".equals(codigo)) {
				//ClienteDAO clienteDao = new ClienteDAO(manager);
				//retorno = clienteDao.porId(new Long(value));
				ProdutoDAO dao = new ProdutoDAO(manager);
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
