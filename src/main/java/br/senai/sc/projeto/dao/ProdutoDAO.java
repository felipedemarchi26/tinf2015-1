package br.senai.sc.projeto.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.projeto.model.Produto;

public class ProdutoDAO  extends DAO<Produto> {

	public Produto buscarPorId(long id) {
		return getEM().find(Produto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarTodos() {
		Query query = getEM().createQuery("SELECT p FROM Produto p");
		return query.getResultList();
	}
	
}
