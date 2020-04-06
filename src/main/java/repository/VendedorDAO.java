package repository;

import javax.persistence.EntityManager;

import model.Vendedor;

public class VendedorDAO {
	
	private EntityManager manager;

	public VendedorDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Vendedor getVendedorPorId(int codigo) {
		Vendedor v = manager.find(Vendedor.class, codigo);
		return v;
	}
}
