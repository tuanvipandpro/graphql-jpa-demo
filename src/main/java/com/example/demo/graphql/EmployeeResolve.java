package com.example.demo.graphql;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.modal.EmployeeModal;
import com.example.demo.request.CreateEmployeeRequest;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EmployeeResolve {
	
	private EmployeeService service;
	
	@QueryMapping
	public List<EmployeeModal> getAllEmploye() {
		return service.getAllEmployee();
	}
	
	@MutationMapping
	public EmployeeModal createEmployee(@Argument CreateEmployeeRequest input) {
		return service.createEmployee(input);
	}
}
