package com.srihari.datajpa.springdatajpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	private String title;
	private Integer credit;

	//this is the right way to map course to coursematerials
	//mapped by name courseId and property name in courseMaterial class should be same
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseMaterialId", referencedColumnName = "courseMaterialId")
	
	
	private CourseMaterial courseMaterial;

}
