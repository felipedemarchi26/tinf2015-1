package br.senai.sc.projeto.mb;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.senai.sc.projeto.commons.Utils;
import br.senai.sc.projeto.json.LoginJson;
import br.senai.sc.projeto.model.Regra;
import br.senai.sc.projeto.model.Usuario;
import br.senai.sc.projeto.rn.RegraRN;
import br.senai.sc.projeto.rn.UsuarioRN;

@ManagedBean
@SessionScoped
public class UsuarioMB {

	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private RegraRN regraRN;
	private String confirmarSenha;
	private List<Usuario> usuarios;
	private List<Regra> regras;

	public UsuarioMB() {
		usuario = new Usuario();
		usuarioRN = new UsuarioRN();
		regraRN = new RegraRN();
		confirmarSenha = "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioRN getUsuarioRN() {
		return usuarioRN;
	}

	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = usuarioRN.listarUsuario();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Regra> getRegras() {
		if (regras == null) {
			regras = regraRN.listarRegras();
		}
		return regras;
	}

	public void setRegras(List<Regra> regras) {
		this.regras = regras;
	}

	public String salvar() {
		if (usuario.getId() != 0 || usuario.getSenha().equals(confirmarSenha)) {
			String hash = Utils.senhaToSha256(usuario.getSenha());
			usuario.setSenha(hash);
			usuarioRN.salvar(usuario);
			confirmarSenha = "";
			usuarios = null;
			usuario = new Usuario();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário registrado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "As senhas não conferem!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}

	public String limpar() {
		usuario = new Usuario();
		confirmarSenha = "";
		return "";
	}
	
	public String novo() {
		usuario = new Usuario();
		return "/cadastroUsuario";
	}
	
	public String editar() {
		return "/cadastroUsuario";
	}
	
	public String excluir() {
		usuarioRN.excluir(usuario);
		usuarios.remove(usuario);
		usuario = new Usuario();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário removido com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
	}
	
	public boolean isConfirmarSenhaRenderer() {
		if (usuario.getId() != 0) {
			return false;
		}
		return true;
	}
	
	public void renderListaUsuariosJson() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		
		String key = externalContext.getRequestParameterMap().get("key");
		
		String json = "";
		if (key != null && key.equals(Utils.KEY)) {
			json = Utils.getGson().toJson(usuarioRN.listarUsuariosParaJson());
		}
		
		externalContext.setResponseContentType("application/json");
		externalContext.setResponseCharacterEncoding("UTF-8");
		externalContext.getResponseOutputWriter().write(json);
		context.responseComplete();
	}
	
	public void renderLoginJson() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		
		String email = externalContext.getRequestParameterMap().get("email");
		String senha = externalContext.getRequestParameterMap().get("senha");
		String key = externalContext.getRequestParameterMap().get("key");
		
		String json = "";
		if (key != null && key.equals(Utils.KEY)) {
			Usuario u = usuarioRN.loginParaJson(email, senha);
			if (u != null) {
				LoginJson lj = new LoginJson();
				lj.setNome(u.getNome());
				lj.setSucesso(true);
				lj.setRegra("ROLE_USER");
				json = Utils.getGson().toJson(lj);
			}
		}
		
		externalContext.setResponseContentType("application/json");
		externalContext.setResponseCharacterEncoding("UTF-8");
		externalContext.getResponseOutputWriter().write(json);
		context.responseComplete();
	}

}
