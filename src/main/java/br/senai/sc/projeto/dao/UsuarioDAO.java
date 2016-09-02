package br.senai.sc.projeto.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.projeto.model.Usuario;

public class UsuarioDAO extends DAO<Usuario> {
	
	public Usuario buscarPorId(long id) {
		return getEM().find(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() {
		Query query = getEM().createQuery("SELECT u FROM Usuario u", Usuario.class);
		return query.getResultList();
	}
	
	public Usuario buscarPorEmail(String email) {
		Query query = getEM().createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
		query.setParameter("email", email);
		return (Usuario) query.getSingleResult();
	}
	
}
