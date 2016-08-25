package br.senai.sc.projeto.rn;

import java.util.List;

import br.senai.sc.projeto.dao.DAOFactory;
import br.senai.sc.projeto.model.Produto;

public class ProdutoRN {

	public void salvar(Produto produto) {
		DAOFactory.getProdutoDAO().salvar(produto);
	}
	
	public void excluir(Produto produto) {
		DAOFactory.getProdutoDAO().excluir(produto);
	}
	
	public Produto buscarPorId(long id) {
		return DAOFactory.getProdutoDAO().buscarPorId(id);
	}
	
	public List<Produto> listarProdutos() {
		return DAOFactory.getProdutoDAO().listarTodos();
	}
	
}
