package br.senai.sc.projeto.rn;

import java.util.List;

import br.senai.sc.projeto.dao.DAOFactory;
import br.senai.sc.projeto.model.Categoria;

public class CategoriaRN {

	public void salvar(Categoria categoria) {
		DAOFactory.getCategoriaDAO().salvar(categoria);
	}
	
	public Categoria buscarPorId(long id) {
		return DAOFactory.getCategoriaDAO().buscarPorId(id);
	}
	
	public List<Categoria> listarCategorias() {
		return DAOFactory.getCategoriaDAO().listarTodos();
	}
	
	public void excluir(Categoria categoria) {
		DAOFactory.getCategoriaDAO().excluir(categoria);
	}
	
	public List<Categoria> listarParaAutoComplete(String busca) {
		return DAOFactory.getCategoriaDAO().listarParaAutoComplete(busca);
	}
	
}
