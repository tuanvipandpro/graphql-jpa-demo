package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	private String name;
	
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Department department;
	
	@ManyToMany // map tới cái biến của skill entity
	@JoinTable(name = "skill_employee", 
	   joinColumns = @JoinColumn(name = "employee_id"), 
	   inverseJoinColumns = @JoinColumn(name = "skill_id"))
	@EqualsAndHashCode.Exclude
	@Exclude
	private List<Skill> skills;
}
