package com.srihari.datajpa.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srihari.datajpa.springdatajpa.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
