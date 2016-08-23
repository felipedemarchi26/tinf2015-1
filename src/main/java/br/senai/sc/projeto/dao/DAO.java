package br.senai.sc.projeto.dao;

import javax.persistence.EntityManager;

import br.senai.sc.projeto.commons.JpaUtil;

public abstract class DAO {

	protected EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

}