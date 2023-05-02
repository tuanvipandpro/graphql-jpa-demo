package com.example.demo.modal;

import java.util.Collection;

import com.example.demo.entity.Department;
import com.example.demo.entity.Skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeModal {
	private int id;
	private String name;
	private String phone;
	private Department department;
	private Collection<Skill> skills;
}
