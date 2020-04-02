package primaryKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.Vendedor;

@Embeddable
public class PedidoPdaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="numero")
	private int numero;
	
	@ManyToOne @JoinColumn(name="codigo_vendedor", nullable=true, foreignKey = @ForeignKey(name = "pedido_pda_c_ve_fk"))
	private Vendedor vendedor;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoPdaPK other = (PedidoPdaPK) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	
}
