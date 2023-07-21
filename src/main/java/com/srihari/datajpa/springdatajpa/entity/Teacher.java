package com.srihari.datajpa.springdatajpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int teacherId;
	private String firstName;
	private String lastName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacherId" , referencedColumnName = "teacherId")
	private List<Course> course;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			  name = "teacher_department", 
			  joinColumns = @JoinColumn(name = "teacher_id"), 
			  inverseJoinColumns = @JoinColumn(name = "department_id"))
	List<Department> departmentList; 

}
