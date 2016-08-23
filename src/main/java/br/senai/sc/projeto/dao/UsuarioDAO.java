package br.senai.sc.projeto.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.projeto.model.Usuario;

public class UsuarioDAO extends DAO {
	
	public void salvar(Usuario usuario) {
		getEM().merge(usuario);
	}
	
	public Usuario buscarPorId(long id) {
		return getEM().find(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		Query query = getEM().createQuery("SELECT u FROM Usuario u", Usuario.class);
		return query.getResultList();
	}
	
	public void excluir(Long id) {
		Usuario usuario = getEM().getReference(Usuario.class, id);
		getEM().remove(usuario);
	}

}
