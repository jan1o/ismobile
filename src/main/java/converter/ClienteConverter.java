package converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import model.Cliente;
import repository.ClienteDAO;
import util.JpaUtil;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//***** MÉTODO INACABADO, ESPERANDO ATUALIZAÇÂO DO DAO ***!!!!
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {

		Cliente retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			if (codigo != null && !"".equals(codigo)) {
				//ClienteDAO clienteDao = new ClienteDAO(manager);
				//retorno = clienteDao.porId(new Long(value));
			}
			return retorno;
		} finally {
			manager.close();
		}
	}

	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
