package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.modal.EmployeeModal;
import com.example.demo.request.CreateEmployeeRequest;

public interface EmployeeService {
	
	List<EmployeeModal> getAllEmployee();
	
	List<Employee> getAll();
	
	EmployeeModal createEmployee(CreateEmployeeRequest employee);
}
