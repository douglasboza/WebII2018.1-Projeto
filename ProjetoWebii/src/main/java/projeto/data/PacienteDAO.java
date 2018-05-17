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
import projeto.dominio.Paciente;

/**
 *
 * @author Victor
 */
@Named
@RequestScoped

public class PacienteDAO implements Serializable{
	@PersistenceContext(unitName = "ProjetoPU")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;
        

//	public Paciente addNew(Paciente paciente) {
//            System.out.println("id do paciente="+paciente.getId_pessoa());
//            System.out.println("chegou 1");
//            try {
//                userTransaction.begin();
//                entityManager.persist(paciente);
//                userTransaction.commit();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            
//            return paciente;
//	}
  
        
	public List<Paciente> findPacientes() {
            TypedQuery<Paciente> query = entityManager.createNamedQuery("findAllPacientes", Paciente.class);
            return query.getResultList();
	}
        
        
//        @Transactional
//        public int removerPaciente(Long id_paciente) {
//           int isSuccessful = entityManager.createQuery("delete from Paciente p where p.id_pessoa=:id_paciente")
//                    .setParameter("id_paciente", id_paciente)
//                    .executeUpdate();
//            if (isSuccessful == 0) {
//                return 0;
//            }else{
//                return 1;
//            }
//        }
//        
//        public Paciente editarPaciente(Paciente paciente) {
//                try {
//			userTransaction.begin();
//			entityManager.merge(paciente);
//			userTransaction.commit();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		return paciente;
//        }
//           
           
           
}
