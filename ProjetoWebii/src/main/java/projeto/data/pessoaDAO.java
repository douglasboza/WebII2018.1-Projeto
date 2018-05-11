/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.data;

import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import projeto.dominio.Pessoa;

/**
 *
 * @author douglasboza
 */



@Named
@RequestScoped
public class pessoaDAO {
	@PersistenceContext(unitName = "EmployeePU")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	public Pessoa addNew(Pessoa pessoa) {
		try {
			userTransaction.begin();
			entityManager.persist(pessoa);
			userTransaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return pessoa;
	}

	public List<Pessoa> findPessoas() {
		TypedQuery<Pessoa> query = entityManager.createNamedQuery("findAllPessoas", Pessoa.class);
		return query.getResultList();
	}

}
