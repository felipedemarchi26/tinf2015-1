package br.senai.sc.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.senai.sc.projeto.commons.JpaUtil;

public abstract class DAO<T> {

	protected EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}
	
	public abstract T buscarPorId(long id);
	public abstract List<T> listarTodos();
	
	public void salvar(T object) {
		getEM().merge(object);
	}
	
	public void excluir(T object) {
		getEM().remove(object);
	}

}