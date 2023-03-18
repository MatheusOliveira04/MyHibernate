package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.PessoaDao;
import dominio.Pessoa;

public class PessoaDaoJDBC implements PessoaDao{

	//FABRICA DE INSTANCIAS EntityManager
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	//INSTANCIAS EntityManager PARA A APLICAÇÃO SE COMUNICAR COM O BD (DATABASE)
	private EntityManager em = emf.createEntityManager();
	
	@Override
	public Pessoa findById(Integer id) {
		
		Pessoa pessoa = em.find(Pessoa.class, id); //BUSCA UM OBJETO NO BD (BANCO DE DADOS)
		return pessoa;
	}

	@Override
	public void deleteById(Integer id) {
		 //UTILIZADO QUANDO NÃO SERÁ REALIZADO APENAS UMA LEITURA DE DADOS(INICIA UMA TRANSAÇÃO COM BD)
		em.getTransaction().begin();
		
		em.createQuery("DELETE FROM Pessoa c WHERE id = :idPessoa")
		.setParameter("idPessoa", id)
		.executeUpdate();
		
		//confirma a alteração
		em.getTransaction().commit();
	}

	@Override
	public void insert(Pessoa pessoa) {
		em.getTransaction().begin();
		
		Pessoa p = new Pessoa();
		p.setId(pessoa.getId());
		p.setName(pessoa.getName());
		p.setEmail(pessoa.getEmail());		
		em.persist(p);	//PEGA O OBJETO E SALVA NO BD 
		
		em.getTransaction().commit();
			
	}

	@Override 
	public void update(Pessoa pessoa) {
		em.getTransaction().begin();
	
		em.createQuery("Update Pessoa c SET name = :nameP , email = :emailP WHERE id = :idPessoa")
		.setParameter("nameP", pessoa.getName())
		.setParameter("emailP", pessoa.getEmail())
		.setParameter("idPessoa", pessoa.getId())
		.executeUpdate();
		
		em.getTransaction().commit();
	}

	@Override
	public List<Pessoa> findAll() {
		String jpql = "SELECT c FROM Pessoa c";
		TypedQuery<Pessoa> tq = em.createQuery(jpql, Pessoa.class);
		List<Pessoa> list = tq.getResultList();
		
		return list;
	}

	public void closeEntityManeger() {  //FECHA A TRANSAÇÃO COM O BD
		em.close();
		emf.close();
	}
}
