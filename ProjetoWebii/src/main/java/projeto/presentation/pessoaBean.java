/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.pessoaDAO;
import projeto.dominio.Pessoa;



/**
 *
 * @author douglasboza
 */


@Named(value = "pessoaBean")
@RequestScoped
public class pessoaBean {
    
    
    @Inject pessoaDAO dao;

//    pessoaDAO dao = new pessoaDAO();
    
    private Pessoa pessoa = new Pessoa();
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    
    private List<Pessoa> pessoaList = new ArrayList<>();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        pessoa.setNome(nome);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        pessoa.setTelefone(telefone);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        pessoa.setCpf(cpf);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        pessoa.setEmail(email);
    }
	
    public void addPessoa() {

        dao.addNew(pessoa);
           
    }

            
        
        
        
        
//        
       public List<Pessoa> getPessoaList() {
                 this.pessoaList = dao.findPessoas();
		return this.pessoaList;
	}

	public void setEmployeeList(List<Pessoa> pessoaList) {
             this.pessoaList = dao.findPessoas();
	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public String addNewEmployee() {
//		dao.addNew(employee);
//		employeeList = dao.findEmployees();
//		return "employeelist";
//	}

    
    
    
}
