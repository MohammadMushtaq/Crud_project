package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
 
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void save(Employee employee) {
		if(employee!=null) {
		employeeRepository.save(employee);
		}
		else {
			System.out.println("invalid data");
		}
	}
	
	public String findByUsername(String username, String password) {
		Employee employee = employeeRepository.findByUserName(username);
		System.out.println("invoked login service");
		if (employee != null) {
			if(username.equals(employee.getUserName()) && password.equals(employee.getPassword())) {
				System.out.println("verified");
				return "Login successfully";
			}else {
				return "Invalid Credential";
			}
		}
		return "User Id Not found";
	}
	
	public List<Employee> FindAllEmp() {
		
		return employeeRepository.findAll();	
	}
	
	public Employee updateById(Employee employee,int id){
	
		Optional<Employee> emp= employeeRepository.findById(employee.getId());
		
		if(emp.equals(employee.getId())) {
			employeeRepository.save(employee);
		}else {
			System.err.println("invalid");
		}
		
		return employeeRepository.save(employee);
	}
	
	public void deleteByid(int id) {
		
		employeeRepository.deleteById(id);
	}
	
	
}
	
