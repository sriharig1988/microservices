package com.srihari.datajpa.springdatajpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school_board")
public class SchoolBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int schoolBoardId;
	String schoolBoardName;
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "schoolBoardId",referencedColumnName = "schoolBoardId")
//	List<School> schoolList;
	
	

}
