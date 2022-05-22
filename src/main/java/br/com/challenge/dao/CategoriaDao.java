package br.com.challenge.dao;

import javax.persistence.EntityManager;

import br.com.challenge.modelo.Categoria;

public class CategoriaDao {
	EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
}