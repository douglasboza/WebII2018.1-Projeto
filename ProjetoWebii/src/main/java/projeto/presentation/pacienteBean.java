/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;


import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.pacienteDAO;
import projeto.data.pessoaDAO;
import projeto.dominio.Consulta;
import projeto.dominio.Endereco;
import projeto.dominio.Medico;
import projeto.dominio.Paciente;
import projeto.dominio.Pessoa;
import projeto.dominio.Plano;

/**
 *
 * @author Victor
 */

@Named (value = "pacienteBean")
@RequestScoped
public class pacienteBean {
    @Inject pessoaDAO pessoadao;
    @Inject pacienteDAO pacientedao;
    
    Pessoa pessoa = new Pessoa();
    Paciente paciente = new Paciente();
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    
    Endereco enderecoPac = new Endereco();
    ArrayList<Plano> planosPac = new ArrayList<Plano>();
    ArrayList<Consulta> consultasPac = new ArrayList<Consulta>();
    
    private List<Paciente> pacienteList = new ArrayList<>();

    public void addPaciente() {
        pacientedao.addNew(paciente);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        paciente.setNome(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        paciente.setCpf(cpf);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        paciente.setEmail(email);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        paciente.setTelefone(telefone);
    }

    public Endereco getEnderecoPac() {
        return enderecoPac;
    }

//  TODO Recebendo como string no JSF
    public void setEnderecoPac(Endereco enderecoPac) {
        this.enderecoPac = enderecoPac;
        paciente.setEnderecoPac(enderecoPac);
    }

    public ArrayList<Plano> getPlanosPac() {
        return planosPac;
    }

    public void setPlanosPac(ArrayList<Plano> planosPac) {
        this.planosPac = planosPac;
        paciente.setPlanosPac(planosPac);
    }

    public ArrayList<Consulta> getConsultasPac() {
        return consultasPac;
    }

    public void setConsultasPac(ArrayList<Consulta> consultasPac) {
        this.consultasPac = consultasPac;
        paciente.setConsultasPac(consultasPac);
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }
    
//    public Paciente getPaciente() {
//        return paciente;
//    }
//
//    public void setPaciente(Paciente paciente) {
//        this.paciente = paciente;
//    };
    
}