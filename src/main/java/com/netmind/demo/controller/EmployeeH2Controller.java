package com.netmind.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.dao.EmployeeRepository;
import com.netmind.demo.model.Employee;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeH2Controller {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getH2Employees() {
		return ResponseEntity.ok(employeeRepository.findAll());
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createH2Employee(
		@Valid 
		@RequestBody Employee employee) {
			return ResponseEntity.ok(employeeRepository.save(employee));
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateH2Employee(
		@PathVariable Integer id,
		@RequestBody Employee employee){
			return ResponseEntity.ok(employeeRepository.save(employee));
		}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteH2Employee(
		@PathVariable Integer id){
			employeeRepository.deleteById(id);;
			return ResponseEntity.ok().build();
	}
}