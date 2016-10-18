package br.senai.sc.projeto.rn;

import java.util.ArrayList;
import java.util.List;

import br.senai.sc.projeto.dao.DAOFactory;
import br.senai.sc.projeto.json.UsuarioJson;
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
	
	public Usuario buscarPorEmail(String email) {
		return DAOFactory.getUsuarioDAO().buscarPorEmail(email);
	}
	
	public List<UsuarioJson> listarUsuariosParaJson() {
		List<UsuarioJson> usuariosJson = new ArrayList<UsuarioJson>();
		List<Usuario> usuariosCarregados = DAOFactory.getUsuarioDAO().listarTodos();
		for (Usuario u : usuariosCarregados) {
			UsuarioJson uj = new UsuarioJson();
			uj.setBairro(u.getEndereco().getBairro());
			uj.setCidade(u.getEndereco().getCidade());
			uj.setCpf(u.getCpf());
			uj.setEmail(u.getEmail());
			uj.setNome(u.getNome());
			usuariosJson.add(uj);
		}
		return usuariosJson;
	}
	
	public Usuario loginParaJson(String email, String senha) {
		return DAOFactory.getUsuarioDAO().loginParaJson(email, senha);
	}
	
}
