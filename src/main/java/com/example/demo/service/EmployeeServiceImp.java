package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Skill;
import com.example.demo.modal.EmployeeModal;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.request.CreateEmployeeRequest;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
	
	private SkillRepository skillRepository;
	private EmployeeRepository employeeRepository;
	private DepartmentRepository departmentRepository;

	@Override
	public List<EmployeeModal> getAllEmployee() {
		List<Employee> list = employeeRepository.findAll();
		
		return list.stream().map(i -> {
			return EmployeeModal.builder()
					.id(i.getId()).name(i.getName()).phone(i.getPhone())
					.department(new Department(i.getDepartment().getId(), i.getDepartment().getName(), null))
					.skills(i.getSkills().stream().map(e -> new Skill(e.getId(), e.getName(), null)).toList())
					.build();
		}).toList();
	}

	@Override
	public EmployeeModal createEmployee(CreateEmployeeRequest employee) {
		Employee e =  employeeRepository.save(Employee.builder()
				.name(employee.getName())
				.phone(employee.getPhone())
				.department(departmentRepository.findById(employee.getDepartment_id()).get())
				.skills(employee.getSkills().stream().map(s -> skillRepository.findById(s).get()).collect(Collectors.toList()))
				.build());
		System.out.println(e);
//		employeeRepository.save(e);
//		return new EmployeeModal(e.getId(), e.getName(), e.getPhone(), 
//				new Department(e.getDepartment().getId(), e.getDepartment().getName(), null), 
//				e.getSkills().stream().map(i -> new Skill(i.getId(), i.getName(), null)).toList());
		return null;
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

}
