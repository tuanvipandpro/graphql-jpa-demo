package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.EmployeeModal;
import com.example.demo.request.CreateEmployeeRequest;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<EmployeeModal>> getAllEmployee() {
		return new ResponseEntity<List<EmployeeModal>>(employeeService.getAllEmployee(), HttpStatus.OK);
	}
	
//	@PostMapping("/create")
	public ResponseEntity<EmployeeModal> createEmployee(@RequestBody CreateEmployeeRequest request) {
		return new ResponseEntity<EmployeeModal>(employeeService.createEmployee(request) ,HttpStatus.OK);
	}
}
