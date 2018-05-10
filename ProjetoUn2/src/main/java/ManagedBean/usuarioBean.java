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

/**
 *
 * @author douglasboza
 */
public class usuarioBean {
    
}

package employee.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import employee.Employee;
import employee.data.EmployeeDAO;

@Named(value = "employeeManagedBean")
@RequestScoped
public class EmployeeMB {
	@Inject EmployeeDAO dao;
	
	//Auxiliary fields for JSF
	private List<Employee> employeeList = new ArrayList<>();
	private Employee employee = new Employee();
	
        
        
	public List<Employee> getEmployeeList() {
                employeeList = dao.findEmployees();
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String addNewEmployee() {
		dao.addNew(employee);
		employeeList = dao.findEmployees();
		return "employeelist";
	}
	
}
