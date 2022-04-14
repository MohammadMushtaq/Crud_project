package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class EmpController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmp")
	public String saveEmp(@RequestBody Employee employee) {
		System.out.println("invoked requested");
		employeeService.save(employee);
		return " employee data saved";
	}
	
	@GetMapping("/login/{userName}/{password}")
	public String login(@PathVariable String userName,@PathVariable String password) {
		System.out.println("username "+userName);
		System.out.println("password "+password);
		
		return employeeService.findByUsername(userName, password);
		
	}
	@GetMapping("/getAll")
	public List<Employee> getAll(){
		
		return employeeService.FindAllEmp();
		
	}
	
//	@PutMapping("/update/{firstName}")
//	public String update(@RequestBody Employee employee, @PathVariable String firstName) {
//		
//		if(firstName!=null) {
//			employeeService.updateByName(firstName);
//		}
//		
//		return "updated Successfully";
//		
//	}
	
//	@PutMapping("/update/{id}")
//	public String update(@RequestBody Employee employee,@PathVariable int id) {
//		
//		 employeeService.updateById(employee, id);
//		return "update is completed";
//		 
//		}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Employee employee,@PathVariable int id) {	
		 employeeService.updateById(employee, id);
		return "update is completed";
		 
		}
		
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		employeeService.deleteByid(id);
		 return "deleted ";
	}
	
	
}
