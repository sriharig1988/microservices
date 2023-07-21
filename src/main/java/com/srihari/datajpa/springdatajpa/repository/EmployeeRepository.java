package com.srihari.datajpa.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.srihari.datajpa.springdatajpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByEmpIdAndSalary(int id, Double salary);
	
	@Query( "FROM Employee E WHERE E.id = :employee_id")
	public List<Employee> getAllEmployee();
	
	
	
	

}
