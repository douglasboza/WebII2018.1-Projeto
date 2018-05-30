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
import projeto.dominio.Consulta;
import projeto.dominio.Medico;

/**
 *
 * @author douglasboza
 */

@Named
@RequestScoped
public class ConsultaDAO {
        
        @PersistenceContext(unitName = "ProjetoPU")
	private EntityManager entityManager;

	@Resource  
	private UserTransaction userTransaction;
            
        public List<Consulta> findConsultas(Long id_pessoa) {
            if(id_pessoa == null){
                TypedQuery<Consulta> query = entityManager.createNamedQuery("findAllConsultas", Consulta.class);
                return query.getResultList();            
            }else{
                TypedQuery<Consulta> query = entityManager.createQuery("SELECT e FROM Consulta e where id_medico = "+id_pessoa, Consulta.class);
                return query.getResultList();
            }

	}
        
        
}
