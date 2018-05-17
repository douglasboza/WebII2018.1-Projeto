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
    private long id_pessoa;
    private int teste_editar;
    private String telefone;
    
//    Endereco enderecoPac = new Endereco();
    ArrayList<String> planosPac = new ArrayList<String>();
    ArrayList<Consulta> consultasPac = new ArrayList<Consulta>();
    
    private List<Paciente> pacienteList = new ArrayList<>();

    public void addPaciente() {
        pacientedao.addNew(paciente);
    }
    
     public Long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(Long id_pessoa) {
        this.id_pessoa = id_pessoa;
        this.paciente.setId_pessoa(id_pessoa);
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
    public int getTeste_editar() {
        return teste_editar;
    }

    public void setTeste_editar(int teste_editar) {
        this.teste_editar = teste_editar;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        paciente.setTelefone(telefone);
    }
//
//    public Endereco getEnderecoPac() {
//        return enderecoPac;
//    }
//
////  TODO Recebendo como string no JSF
//    public void setEnderecoPac(Endereco enderecoPac) {
//        this.enderecoPac = enderecoPac;
//        paciente.setEnderecoPac(enderecoPac);
//    }

    public ArrayList<Consulta> getConsultasPac() {
        return consultasPac;
    }

    public void setConsultasPac(ArrayList<Consulta> consultasPac) {
        this.consultasPac = consultasPac;
        paciente.setConsultasPac(consultasPac);
    }

    public List<Paciente> getPacienteList() {
        this.pacienteList = pacientedao.findPacientes();
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
        this.pacienteList = pacientedao.findPacientes();
    }

    public ArrayList<String> getPlanosPac() {
        return planosPac;
    }

    public void setPlanosPac(ArrayList<String> planosPac) {
        this.planosPac = planosPac;
    }    
        
    
//    public Paciente getPaciente() {
//        return paciente;
//    }
//
//    public void setPaciente(Paciente paciente) {
//        this.paciente = paciente;
//    };
        
        public void excluirPaciente(int id_rem1){
        Long id_rem = Long.valueOf(id_rem1);
        System.out.println("igual aaaa " +id_rem);
        pacientedao.removerPaciente(id_rem);
    }
        
    public void editarPaciente(Paciente pac_editar){
        this.setPaciente(pac_editar);
        this.setTeste_editar(1);
        System.out.println("igual bbbb " +this.getPaciente());
//      
    }   

    public void addPaciente(int teste_editar) {
        System.out.println("igual nome="+this.getPaciente());
        
        if(teste_editar == 1){
            pacientedao.editarPaciente(paciente);
            System.out.println("igual iii "+paciente.getId_pessoa());
        }else{
            pacientedao.addNew(this.paciente);
            System.out.println("igual uuu "+this.paciente.getId_pessoa());
        }
      
    }
    
        
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente pac_editar) {
        this.setNome(pac_editar.getNome());
        this.setCpf(pac_editar.getCpf());
        this.setEmail(pac_editar.getEmail());
        this.setTelefone(pac_editar.getTelefone());
        this.setId_pessoa(pac_editar.getId_pessoa());
        this.paciente = pac_editar;
    }
    
    
}