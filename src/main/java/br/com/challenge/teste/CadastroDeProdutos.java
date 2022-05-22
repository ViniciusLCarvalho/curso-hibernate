package br.com.challenge.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.challenge.dao.CategoriaDao;
import br.com.challenge.dao.ProdutoDao;
import br.com.challenge.modelo.Categoria;
import br.com.challenge.modelo.Produto;
import br.com.challenge.util.JPAUtil;

public class CadastroDeProdutos {
	
	public static void main(String[] args) {
		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarPorNomedaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));
	
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Iphone Xs");
		System.out.println("Preco do produto: " +precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Iphone XS", "Otimo", new BigDecimal("5500"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
}