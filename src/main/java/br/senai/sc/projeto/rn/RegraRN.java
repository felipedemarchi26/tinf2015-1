package br.senai.sc.projeto.rn;

import java.util.List;

import br.senai.sc.projeto.dao.DAOFactory;
import br.senai.sc.projeto.model.Regra;

public class RegraRN {

	public void salvar(Regra regra) {
		DAOFactory.getRegraDAO().salvar(regra);
	}
	
	public void excluir(Regra regra) {
		DAOFactory.getRegraDAO().excluir(regra);
	}
	
	public Regra buscarPorId(long id) {
		return DAOFactory.getRegraDAO().buscarPorId(id);
	}
	
	public List<Regra> listarRegras() {
		return DAOFactory.getRegraDAO().listarTodos();
	}
	
}
