/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.DefaultDAO;
import projeto.data.MedicoDAO;
import projeto.dominio.Medico;
import projeto.dominio.Paciente;

/**
 *
 * @author kuro_
 */
@Named(value = "Login")
@RequestScoped
public class LoginBean implements Serializable{
//    @Inject MedicoDAO medicodao;
//    @Inject PacienteBean pacientedao;
//    @Inject DefaultDAO defaultdao;
//    
//    private String tempEmail;
//    private String tempSenha;
//    
//    private List<Medico> listaMedicos = new ArrayList<>();
//    private List<Paciente> listaPacientes = new ArrayList<>();
//    
//    public LoginBean(){
//        
//    }
//
//    public String getTempEmail() {
//        return tempEmail;
//    }
//
//    public void setTempEmail(String tempEmail) {
//        this.tempEmail = tempEmail;
//    }
//
//    public String getTempSenha() {
//        return tempSenha;
//    }
//
//    public void setTempSenha(String tempSenha) {
//        this.tempSenha = tempSenha;
//    }
//    
//    // TODO
//    public void log(){
//        logMedico();
//        logPaciente();
//    }
//    
//    public Medico logMedico(){
//        for(Medico m: listaMedicos){
//            if(tempEmail.equals(m.getEmail()) && tempSenha.equals(m.getSenha()))
//                return m;
//        }
//        
//        return null;
//    }
//    
//    public void logPaciente(){
//        
//    }
}
