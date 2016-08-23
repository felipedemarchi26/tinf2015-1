package br.senai.sc.projeto.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.senai.sc.projeto.model.Usuario;
import br.senai.sc.projeto.rn.UsuarioRN;

@ManagedBean
public class UsuarioMB {

	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private String confirmarSenha;

	public UsuarioMB() {
		usuario = new Usuario();
		usuarioRN = new UsuarioRN();
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

	public String salvar() {
		if (usuario.getSenha().equals(confirmarSenha)) {
			usuarioRN.salvar(usuario);
			confirmarSenha = "";
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
	
}
