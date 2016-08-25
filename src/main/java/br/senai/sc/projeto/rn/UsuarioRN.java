package br.senai.sc.projeto.rn;

import java.util.List;

import br.senai.sc.projeto.dao.DAOFactory;
import br.senai.sc.projeto.model.Usuario;

public class UsuarioRN {

	public void salvar(Usuario usuario) {
		DAOFactory.getUsuarioDAO().salvar(usuario);
	}
	
	public Usuario buscarPorId(long id) {
		return DAOFactory.getUsuarioDAO().buscarPorId(id);
	}
	
	public List<Usuario> listarUsuario() {
		return DAOFactory.getUsuarioDAO().listarTodos();
	}
	
	public void excluir(Usuario usuario) {
		DAOFactory.getUsuarioDAO().excluir(usuario);
	}
	
}
