package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Produto;
import model.Vendedor;
import repository.ProdutoDAO;
import repository.VendedorDAO;
import util.JpaUtil;

@FacesConverter(forClass = Vendedor.class)
public class VendedorConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Vendedor retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();
		
		try {
			if (value != null && !"".equals(value)) {
				//ClienteDAO clienteDao = new ClienteDAO(manager);
				//retorno = clienteDao.porId(new Long(value));
				VendedorDAO dao = new VendedorDAO(manager);
				retorno = dao.getVendedorPorId(Integer.parseInt(value));
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
			return Integer.toString(((Vendedor) objeto).getCodigo());
		}
		return null;
	}
}
