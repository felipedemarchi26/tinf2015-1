package br.senai.sc.projeto.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.projeto.model.Regra;

public class RegraDAO extends DAO<Regra>{

	@Override
	public Regra buscarPorId(long id) {
		return getEM().find(Regra.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Regra> listarTodos() {
		Query query = getEM().createQuery("SELECT r FROM Regra r", Regra.class);
		return query.getResultList();
	}

}
