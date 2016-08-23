package br.senai.sc.projeto.dao;

public class DAOFactory {

	private static UsuarioDAO usuarioDAO;
	
	public static UsuarioDAO getUsuarioDAO() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();
		}
		return usuarioDAO;
	}
	
	
}
