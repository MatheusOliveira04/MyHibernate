package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.DaoFactory;
import dao.PessoaDao;
import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p100 = new Pessoa(4, "Aladin","Aladin@gmail.com");
		DaoFactory.createPessoaDao().update(p100);
		System.out.println("---UPDATE---");
		
		List<Pessoa> list = DaoFactory.createPessoaDao().findAll();
		System.out.println("---FIND ALL---");
		list.forEach(System.out::println);
		
		Pessoa p101 = new Pessoa(null, "Joelma", "Joelma@gmail.com");
		DaoFactory.createPessoaDao().insert(p101);
		System.out.println("---INSERT---");
		
		PessoaDao p = DaoFactory.createPessoaDao();
		System.out.println("---FIND BY ID---");
		System.out.println(p.findById(6));
		
		DaoFactory.createPessoaDao().deleteById(4);
		
		List<Pessoa> list1 = DaoFactory.createPessoaDao().findAll();
		System.out.println("---FIND ALL---");
		list1.forEach(System.out::println);
		
		DaoFactory.createPessoaDao().closeEntityManeger();
		
		
	}
}
