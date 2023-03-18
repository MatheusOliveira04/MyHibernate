package dao;

import dao.impl.PessoaDaoJDBC;

public class DaoFactory {

	public static PessoaDao createPessoaDao() {
		return new PessoaDaoJDBC();
	}
}
