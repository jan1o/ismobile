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
				ClienteDAO clienteDao = new ClienteDAO(new Utilitarios().configuracaoPostgres());
				retorno = clienteDao.listarPorId(Integer.getInteger(codigo));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return retorno;
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
