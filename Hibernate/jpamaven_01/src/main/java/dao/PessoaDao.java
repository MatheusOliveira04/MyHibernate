package dao;

import java.util.List;

import dominio.Pessoa;

public interface PessoaDao {

	Pessoa findById(Integer id);
	void deleteById(Integer id);
	void insert(Pessoa pessoa);
	void update(Pessoa pessoa);
	List<Pessoa> findAll();
	void closeEntityManeger();
}
