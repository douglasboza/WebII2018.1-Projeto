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
import projeto.dominio.Paciente;

/**
 *
 * @author Victor
 */
@Named
@RequestScoped
public class pacienteDAO {
    @PersistenceContext(unitName = "ProjetoPU")
    private EntityManager entityManager;
    
    @Resource
    private UserTransaction userTransaction;
    
    public Paciente addNew(Paciente paciente) {
        try {
            userTransaction.begin();
            entityManager.persist(paciente);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }
  
    public List<Paciente> findPacientes() {
        TypedQuery<Paciente> query = entityManager.createNamedQuery("findAllPacientes", Paciente.class);
        return query.getResultList();
    }
}