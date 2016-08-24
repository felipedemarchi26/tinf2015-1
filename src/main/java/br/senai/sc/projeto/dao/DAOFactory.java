package br.senai.sc.projeto.dao;

public class DAOFactory {

	private static UsuarioDAO usuarioDAO;
	private static CategoriaDAO categoriaDAO;
	private static ProdutoDAO produtoDAO;
	
	public static UsuarioDAO getUsuarioDAO() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();
		}
		return usuarioDAO;
	}
	
	public static CategoriaDAO getCategoriaDAO() {
		if (categoriaDAO == null) {
			categoriaDAO = new CategoriaDAO();
		}
		return categoriaDAO;
	}

	public static ProdutoDAO getProdutoDAO() {
		if (produtoDAO == null) {
			produtoDAO = new ProdutoDAO();
		}
		return produtoDAO;
	}
	
	
}
