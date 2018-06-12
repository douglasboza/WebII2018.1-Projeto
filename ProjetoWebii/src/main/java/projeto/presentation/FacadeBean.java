/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.ConsultaDAO;
import projeto.data.DefaultDAO;
import projeto.data.MedicoDAO;
import projeto.data.PacienteDAO;
import projeto.dominio.Consulta;
import projeto.dominio.Medico;
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
    @Inject MedicoDAO medicodao;
    
    @Inject PacienteBean pacientebean;
    @Inject MedicoBean medicobean;
    @Inject ConsultaBean consultabean;
    
    @Inject LoginBean loginbean;
    
    private FacadeBean(){
        System.out.println("passou no facade");
    }
    
    // paciente
    
    public Paciente getPaciente(Long id_pessoa){
        return this.pacientedao.getPaciente(id_pessoa).get(0);
    }
    
    public void addPaciente(int teste_editar){
        System.out.println("passou no addpaciente facade");
        if(teste_editar == 1){
            defaultdao.editarObj(pacientebean.getPaciente());
        }else{
            defaultdao.addNewObj(pacientebean.getPaciente());
        }
    }
   
    public void excluirPaciente(Long id_pessoa){
        Long id_rem = Long.valueOf(id_pessoa);
        defaultdao.removerObj(id_rem, "Paciente", "id_pessoa");
    }
    
    public void editarPaciente(Paciente emp){
        pacientebean.setPaciente(emp);
        pacientebean.setTeste_editar(1);
    }  
   // fim paciente
    
   // consulta
    public void addConsulta(int teste_editar) {
        
        if(teste_editar == 1){
            defaultdao.editarObj(consultabean.getConsulta());
        }else{
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
    
    public void selecionarMedico(Long id_pessoa){
        setConsultaList(id_pessoa);
        System.out.println(id_pessoa);
    }
        

    public List<Consulta> pesquisarPorId(){
        Long id = Long.valueOf(consultabean.getId_medico());
        consultabean.setConsultaList(consultadao.findConsultas(id));
        
        return consultadao.findConsultas(id);
    }
    
    public List<Consulta> mostraTabela(){
        if(consultabean.getConsultaList().equals(null) || consultabean.getId_medico() == 0) {
             System.out.println("aqui1");
             consultabean.setConsultaList(consultadao.findConsultas(null));
            return consultabean.getConsultaList();
        }else{           
             System.out.println("aqui2");
            return pesquisarPorId();
        }
    }
    
    public void setConsultaList(Long id_pessoa) {
        System.out.println("passou aqui 123");
        consultabean.setConsultaList(consultadao.findConsultas(id_pessoa));
    }
    
    
    public void marcarConsulta(Consulta consulta){
        consulta.setStatus(2);
        consulta.setId_pessoa(consultabean.getId_pessoa());

        defaultdao.editarObj(consulta);
//        this.id_pessoa = ; // TODO id_pessoa do paciente que solicitou
    }
    
    public void cancelarConsulta(Consulta consulta){
        consulta.setStatus(3);
        consulta.setId_pessoa(0);
        defaultdao.editarObj(consulta);
    }
    
   // fim consulta
    
    
   // editar perfil
    
    public void setData(){
        Long id_pessoa = Long.valueOf(this.loginbean.id_pessoa);
        if(this.loginbean.tipo_pessoa == 2){
            this.editarPaciente(this.getPaciente(id_pessoa));
        }else{
            this.editarMedico(this.getMedico(id_pessoa));
        }
    }
        
   // fim editar perfil
   
    
    // médico
    public void editarMedico(Medico med_editar){
        medicobean.setMedico(med_editar);
        medicobean.setTeste_editar(1);
        System.out.println("igual bbbb " +medicobean.getMedico());
    }   
    public Medico getMedico(Long id_pessoa){
        return this.medicodao.getMedico(id_pessoa).get(0);
    }
    
    // fim médico
    
    
}
