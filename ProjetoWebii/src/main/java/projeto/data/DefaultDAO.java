/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.data;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import projeto.dominio.Medico;

/**
 *
 * @author douglasboza
 */

@Named
@RequestScoped

public class DefaultDAO {
    
        @PersistenceContext(unitName = "ProjetoPU")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;
        

	public Object addNewObj(Object object) {
//            System.out.println("id do medico="+object.getId_pessoa());
            try {
                userTransaction.begin();
                entityManager.persist(object);
                userTransaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return object;
	}
  
     
        
        @Transactional
        public int removerObj(Long id_obj, String tabela, String primare_key) {
           int isSuccessful = entityManager.createQuery("delete from "+tabela+" p where p."+primare_key+"=:id_obj")
                    .setParameter("id_obj", id_obj)
                    .executeUpdate();
            if (isSuccessful == 0) {
                return 0;
            }else{
                return 1;
            }
        }
        
        public Object editarObj(Object obj) {
                try {
			userTransaction.begin();
			entityManager.merge(obj);
			userTransaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return obj;
        }
           
}



