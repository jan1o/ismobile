package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "pedido_pda")
public class PedidoPda implements Comparable, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private int numero; //numeric(6,0) NOT NULL,
	
	@Column
	private Date data; //date,
	 
	@NotNull
	private int codigo_cliente; // numeric(6,0) NOT NULL,
	
	@Id
	@NotNull
	private int codigo_vendedor; // numeric(6,0) NOT NULL,
	
	@NotNull
	@Column
	private int codigo_plano_pagamento; // numeric(3,0) NOT NULL,
	
	@Column
	private int frios; // numeric(1,0),
	
	@Column
	private int retirado; // numeric(1,0),
	
	@Column
	private Date enviado; // date,
	
	@Column
	private Date processado; // timestamp without time zone,
	
	@Column
	private int numero_pedido; // numeric(10,0),
	
	@Column
	@Size(max = 150)
	private String observacao; // character varying(150),
	
	@Column
	private int negociacao; // numeric(1,0) DEFAULT 0,
	
	@Column
	private int latitude; // numeric,
	
	@Column
	private int longitude; // numeric,
	
	@Column
	@Size(max = 8)
	private String inicio_atendimento; // character(8),
	
	@Column
	@Size(max = 8)
	private String fim_atendimento; // character(8),
	
	@Column
	@Size(max = 30)
	private String versao_app; // character varying(30),
	
	@Column
	private int consignado; // numeric(1,0) DEFAULT 0,
	
	@Column
	private int tipo_dfe; // numeric(1,0) DEFAULT 0,
	
	@Column
	private int qtd_pedidos_lote; // numeric(3,0),
	
	@Column
	private Integer numero_negociacao; // numeric(10,0),
	
	/*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@Fetch(FetchMode.SUBSELECT)
		@JoinTable(
			name = "pedido_pda_item_pedido_pda",
			joinColumns = {
				@JoinColumn(name = "pedido_pda_numero", insertable = false, updatable = false),
				@JoinColumn(name = "pedido_pda_codigo_vendedor", insertable = false, updatable = false),
				@JoinColumn(name = "itens_codigo_produto", insertable = false, updatable = false)
			},
			inverseJoinColumns = @JoinColumn(name = "itens_numero_pedido_pda")
		)*/
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ItemPedidoPda> itens; 
    
    /** Creates a new instance of Pedido */
    public PedidoPda() {
    	this.setQtd_pedidos_lote(0);
    }
    
    // Construtor que povoa todo um pedidoPda
    public PedidoPda(int numero, Date data, int codCliente, int codVendedor, int codPlanoPag, int frios,
    		int retirado, String obs, int negociacao, int latitude, int longitude, String inicioAtendimento,
    		String fimAtendimento, String versaoApp, int consignado, int tipoDFe, int qtdPedidoLote) {
    	
    	this.setQtd_pedidos_lote(0);
    	
        this.numero = numero;
        this.data = data;
        this.codigo_cliente = codCliente;
        this.codigo_vendedor = codVendedor;
        this.codigo_plano_pagamento = codPlanoPag;
        this.frios = frios;
        this.retirado = retirado;
        this.observacao = obs;
        this.negociacao = negociacao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.inicio_atendimento = inicioAtendimento;
        this.fim_atendimento = fimAtendimento;
        this.versao_app= versaoApp;
        this.consignado = consignado;
        this.tipo_dfe = tipoDFe;
        this.qtd_pedidos_lote = qtdPedidoLote;
    }
    
    // Construtor que ja adiciona numero e vendedor ao pedidoPda (usar esse)
    public PedidoPda(int numeroPedido, int codVendedor) {
        this.setQtd_pedidos_lote(0);
        
        this.numero = numeroPedido;
        this.codigo_vendedor = codVendedor;
       
    }
    
    
    public List<ItemPedidoPda> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoPda> itens) {
		this.itens = itens;
	}

	public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getFrios() {
        return frios;
    }

    public void setFrios(int frios) {
        this.frios = frios;
    }

    public int getRetirado() {
        return retirado;
    }

    public void setRetirado(int retirado) {
        this.retirado = retirado;
    }
    
    
    public int getNegociacao() {
        return negociacao;
    }

    public void setNegociacao(int negociacao) {
        this.negociacao = negociacao;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getConsignado() {
        return consignado;
    }

    public void setConsignado(int consignado) {
        this.consignado = consignado;
    }


	public int getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public int getCodigo_vendedor() {
		return codigo_vendedor;
	}

	public void setCodigo_vendedor(int codigo_vendedor) {
		this.codigo_vendedor = codigo_vendedor;
	}

	public int getCodigo_plano_pagamento() {
		return codigo_plano_pagamento;
	}

	public void setCodigo_plano_pagamento(int codigo_plano_pagamento) {
		this.codigo_plano_pagamento = codigo_plano_pagamento;
	}

	public Date getEnviado() {
		return enviado;
	}

	public void setEnviado(Date enviado) {
		this.enviado = enviado;
	}

	public Date getProcessado() {
		return processado;
	}

	public void setProcessado(Date processado) {
		this.processado = processado;
	}

	public int getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(int numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getInicio_atendimento() {
		return inicio_atendimento;
	}

	public void setInicio_atendimento(String inicio_atendimento) {
		this.inicio_atendimento = inicio_atendimento;
	}

	public String getFim_atendimento() {
		return fim_atendimento;
	}

	public void setFim_atendimento(String fim_atendimento) {
		this.fim_atendimento = fim_atendimento;
	}

	public String getVersao_app() {
		return versao_app;
	}

	public void setVersao_app(String versao_app) {
		this.versao_app = versao_app;
	}

	public int getTipo_dfe() {
		return tipo_dfe;
	}

	public void setTipo_dfe(int tipo_dfe) {
		this.tipo_dfe = tipo_dfe;
	}

	public int getQtd_pedidos_lote() {
		return qtd_pedidos_lote;
	}

	public void setQtd_pedidos_lote(int qtd_pedidos_lote) {
		this.qtd_pedidos_lote = qtd_pedidos_lote;
	}

	public int getNumero_negociacao() {
		return numero_negociacao;
	}

	public void setNumero_negociacao(int numero_negociacao) {
		this.numero_negociacao = numero_negociacao;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
