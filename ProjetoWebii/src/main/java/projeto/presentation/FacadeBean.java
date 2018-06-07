/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.ConsultaDAO;
import projeto.data.DefaultDAO;
import projeto.data.PacienteDAO;
import projeto.dominio.Consulta;
import projeto.dominio.Paciente;


/**
 *
 * @author douglasboza
 */

@Named(value = "FacadeBean")
@RequestScoped


public class FacadeBean implements Serializable{
//
//    PacienteBean pacientebean = new PacienteBean();
    @Inject PacienteDAO pacientedao;
    @Inject DefaultDAO defaultdao;
    @Inject ConsultaDAO consultadao;
    
    @Inject PacienteBean pacientebean;
    @Inject ConsultaBean consultabean;
    
    private FacadeBean(){
        System.out.println("passou no facade");
    }
    
    
    public void addPaciente(int teste_editar){
        System.out.println("passou no addpaciente facade");
        if(teste_editar == 1){
            defaultdao.editarObj(pacientebean.getPaciente());
        }else{
            defaultdao.addNewObj(pacientebean.getPaciente());
        }
    }
   
    public void excluirPaciente(int id_pessoa){
        Long id_rem = Long.valueOf(id_pessoa);
        defaultdao.removerObj(id_rem, "Paciente", "id_pessoa");
    }
    
    public void editarPaciente(Paciente emp){
        pacientebean.setPaciente(emp);
        pacientebean.setTeste_editar(1);
    }  
   // consulta
    
    public void addConsulta(int teste_editar) {
        
        if(teste_editar == 1){
            defaultdao.editarObj(consultabean.getConsulta());
        }else{
//            this.consulta.setId_medico(this.id_medico);
//            this.consulta.setStatus(this.status);
            defaultdao.addNewObj(consultabean.getConsulta());
        }
      
    }
    public void excluirConsulta(int id_rem1){
        Long id_rem = Long.valueOf(id_rem1);
        defaultdao.removerObj(id_rem,"Consulta", "id_consulta");
    }
    
    public void editarConsulta(Consulta con_editar){
        consultabean.setConsulta(con_editar);
        consultabean.setTeste_editar(1);
    }     
    
    public void resetarConsulta(Consulta consulta){
        consulta.setStatus(1);
        consulta.setId_pessoa(0);
        defaultdao.editarObj(consulta);
    };
    
   // fim consulta
}
