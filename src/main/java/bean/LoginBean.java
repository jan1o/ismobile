package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;

import model.Usuario;
import repository.Usuarios;
import sessao.SessionContext;
import util.JpaUtil;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = null;

	private String nome;
	private String senha;
	
	 public Usuario getUser() {
	       return (Usuario) SessionContext.getInstance().getUsuarioLogado();
	    }
	 
	public String envia() {
		EntityManager manager = JpaUtil.getEntityManager();
		Usuarios usuarioDAO = new Usuarios(manager);
		usuario = usuarioDAO.usuarioPorNome(this.nome);
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));

		} else if (usuario != null && usuario.getSenha_usuario().equals(this.senha)) {
			System.out.println("Logado");
			SessionContext.getInstance().setAttribute("usuarioLogado", usuario);
			return "/Principal?faces-redirect=true";
		}
		return null;

	}

	public String logout() {
		SessionContext.getInstance().encerrarSessao();
		return "/Login?faces-redirect=true";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
