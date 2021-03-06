package br.senai.sc.projeto.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.projeto.model.Categoria;

public class CategoriaDAO extends DAO<Categoria> {

	public Categoria buscarPorId(long id) {
		return getEM().find(Categoria.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarTodos() {
		Query query = getEM().createQuery("SELECT c FROM Categoria c", Categoria.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarParaAutoComplete(String busca) {
		Query query = getEM().createQuery("SELECT c FROM Categoria c WHERE c.descricao LIKE :descricao");
		query.setParameter("descricao", "%"+busca+"%");
		return query.getResultList();
	}
	
}
