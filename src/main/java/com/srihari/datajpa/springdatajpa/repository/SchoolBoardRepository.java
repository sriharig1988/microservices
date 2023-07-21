package com.srihari.datajpa.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.srihari.datajpa.springdatajpa.entity.SchoolBoard;

public interface SchoolBoardRepository extends CrudRepository<SchoolBoard, Integer>{

}
