package com.srihari.datajpa.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.srihari.datajpa.springdatajpa.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
