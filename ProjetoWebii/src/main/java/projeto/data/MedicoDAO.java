/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.data;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import projeto.dominio.Consulta;
import projeto.dominio.Medico;
import projeto.dominio.Paciente;
import projeto.dominio.Pessoa;

/**
 *
 * @author douglasboza
 */

@Named
@RequestScoped

public class MedicoDAO implements Serializable{
        @PersistenceContext(unitName = "ProjetoPU")
	private EntityManager entityManager;

	@Resource  
	private UserTransaction userTransaction;
            
        

//	public Medico addNew(Medico medico) {
//            System.out.println("id do medico="+medico.getId_pessoa());
//            try {
//                userTransaction.begin();
//                entityManager.persist(medico);
//                userTransaction.commit();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            
//            return medico;
//	}
//  
      
       
        
	public List<Medico> findMedicos() {
            TypedQuery<Medico> query = entityManager.createNamedQuery("findAllMedicos", Medico.class);
            return query.getResultList();
	}
        public List<Medico> getMedico(Long id_pessoa) {
            TypedQuery<Medico> query = entityManager.createQuery("SELECT e FROM Medico e where id_pessoa = "+id_pessoa, Medico.class);
            return query.getResultList();
	}
        
        public List<Consulta> findConsultasMedico(Long id_medico) {
            TypedQuery<Consulta> query = entityManager.createQuery("SELECT e FROM Consulta e where id_medico = "+id_medico, Consulta.class);
            return query.getResultList();
	}
//        
//        @Transactional
//        public int removerMedico(Long id_medico) {
//           int isSuccessful = entityManager.createQuery("delete from Medico p where p.id_pessoa=:id_medico")
//                    .setParameter("id_medico", id_medico)
//                    .executeUpdate();
//            if (isSuccessful == 0) {
//                return 0;
//            }else{
//                return 1;
//            }
//        }
//        
//        public Medico editarMedico(Medico medico) {
//                try {
//			userTransaction.begin();
//			entityManager.merge(medico);
//			userTransaction.commit();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		return medico;
//        }
//           
           
}
