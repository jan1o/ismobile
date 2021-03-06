package converter;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import model.Cliente;
import model.Produto;
import repository.ClienteDAO;
import util.JpaUtil;
import util.Utilitarios;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {


	//***** MÉTODO INACABADO, ESPERANDO ATUALIZAÇÂO DO DAO ***!!!!
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Cliente retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			if (value != null && !"".equals(value)) {
				//ClienteDAO clienteDao = new ClienteDAO(manager);
				ClienteDAO clienteDao = new ClienteDAO(manager);
				retorno = clienteDao.listarPorId(Integer.parseInt(value));
			}
		} finally {
			manager.close();
		}
		return retorno;
	}

	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		// TODO Auto-generated method stub
		if(objeto != null) {
			return Integer.toString(((Cliente) objeto).getCodigo());
		}
		return null;
	}

}
