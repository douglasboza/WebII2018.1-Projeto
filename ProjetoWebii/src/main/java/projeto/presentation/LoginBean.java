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
@Named(value = "LoginBean")
@RequestScoped
public class LoginBean implements Serializable{
      boolean is_logged = true;
      int id_pessoa = 28;
      int tipo_pessoa = 2; // 1=médico e 2=pessoa  
//    @Inject MedicoDAO medicodao;
//     @Inject MedicoBean medicodao;
//    @Inject DefaultDAO defaultdao;
//    
//    private String tempEmail;
//    private String tempSenha;
//    
//    private List<Medico> listaMedicos = new ArrayList<>();
//    private List<Paciente> listaPacientes = new ArrayList<>();
//    
    public LoginBean(){
        
    }
    public boolean isIs_logged() {
        return is_logged;
    }

    public void setIs_logged(boolean is_logged) {
        this.is_logged = is_logged;
    }

    public int getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(int tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }
    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    
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
