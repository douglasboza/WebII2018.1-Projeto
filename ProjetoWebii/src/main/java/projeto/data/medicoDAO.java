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
import projeto.dominio.Medico;
import projeto.dominio.Pessoa;

/**
 *
 * @author douglasboza
 */



@Named
@RequestScoped
public class medicoDAO {
	@PersistenceContext(unitName = "ProjetoPU")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	public Medico addNew(Medico medico) {
		try {
			userTransaction.begin();
			entityManager.persist(medico);
			userTransaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return medico;
	}
  
      
       
        
	public List<Medico> findMedicos() {
            TypedQuery<Medico> query = entityManager.createNamedQuery("findAllMedicos", Medico.class);
            return query.getResultList();
	}

}
