package br.senai.sc.projeto.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.projeto.model.Produto;

public class ProdutoDAO  extends DAO {

	public void salvar(Produto produto) {
		getEM().merge(produto);
	}
	
	public void excluir(long id) {
		Produto produto = getEM().getReference(Produto.class, id);
		getEM().remove(produto);
	}
	
	public Produto buscarPorId(long id) {
		return getEM().find(Produto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutos() {
		Query query = getEM().createQuery("SELECT p FROM Produto p");
		return query.getResultList();
	}
	
}
