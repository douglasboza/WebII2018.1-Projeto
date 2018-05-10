/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;


import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ufrn.web2.projetoun2.data.pessoaDAO;
import ufrn.web2.projetoun2.dominio.Pessoa;


/**
 *
 * @author douglasboza
 */


@Named(value = "usuarioBean")
@RequestScoped


public class usuarioBean {
    

//	@Inject usuarioDAO dao;

    pessoaDAO dao = new pessoaDAO();
    
    private Pessoa pessoa = new Pessoa();
    private String nome;
    private String telefone;
    private String cpf;
    private String email;

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
//	
//    public String addNewEmployee() {
//            dao.addNew(this.pessoa);
//            System.out.print( dao.findEmployees() );
//            return "employeelist";
//    }

            
        
        
        
        
//        
//       public List<Employee> getEmployeeList() {
//                employeeList = dao.findEmployees();
//		return employeeList;
//	}
//
//	public void setEmployeeList(List<Employee> employeeList) {
//		this.employeeList = employeeList;
//	}
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
