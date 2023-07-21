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
@Table(name = "course_material")
public class CourseMaterial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseMaterialId;
	private String url;

	
	
}
