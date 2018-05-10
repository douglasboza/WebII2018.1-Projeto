/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.web2.projetoun2.data;

import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import ufrn.web2.projetoun2.dominio.Pessoa;

/**
 *
 * @author douglasboza
 */



@Named
@RequestScoped
public class pessoaDAO {
	@PersistenceContext(unitName = "UsuarioPU")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	public Pessoa addNew(Pessoa Pessoa) {
		try {
			userTransaction.begin();
			entityManager.persist(Pessoa);
			userTransaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return Pessoa;
	}

//	public List<Pessoa> findEmployees() {
//		TypedQuery<Pessoa> query = entityManager.createNamedQuery("findAllUsuarios", Pessoa.class);
//		return query.getResultList();
//	}

}
