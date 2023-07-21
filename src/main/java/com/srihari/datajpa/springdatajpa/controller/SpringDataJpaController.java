package com.srihari.datajpa.springdatajpa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srihari.datajpa.springdatajpa.entity.Course;
import com.srihari.datajpa.springdatajpa.entity.CourseMaterial;
import com.srihari.datajpa.springdatajpa.entity.Department;
import com.srihari.datajpa.springdatajpa.entity.Employee;
import com.srihari.datajpa.springdatajpa.entity.School;
import com.srihari.datajpa.springdatajpa.entity.SchoolBoard;
import com.srihari.datajpa.springdatajpa.entity.Teacher;
import com.srihari.datajpa.springdatajpa.repository.CourseMaterialRepository;
import com.srihari.datajpa.springdatajpa.repository.CourseRepository;
import com.srihari.datajpa.springdatajpa.repository.DepartmentRepository;
import com.srihari.datajpa.springdatajpa.repository.EmployeeRepository;
import com.srihari.datajpa.springdatajpa.repository.SchoolRepository;
import com.srihari.datajpa.springdatajpa.repository.TeacherRepository;

@RestController
public class SpringDataJpaController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private DepartmentRepository departmentReporsitory;

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Autowired
	private TeacherRepository teacherRepoTeacher;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/course")
	public List<Course> createCourse(@RequestBody List<Course> course) {

		System.out.println("course method called" + course);

		courseRepository.saveAll(course);
		return course;
	}

	@PostMapping("/courseMaterial")
	public List<CourseMaterial> createCourseMaterials(@RequestBody List<CourseMaterial> courseMaterials) {

		System.out.println("course method called" + courseMaterials);

		courseMaterialRepository.saveAll(courseMaterials);
		return courseMaterials;
	}

	@PostMapping("/createTeacher")
	public List<Teacher> createTeacher(@RequestBody List<Teacher> teacher) {

		// System.out.println("teacher method called" + teacher);

		teacher.forEach(System.out::println);

		teacherRepoTeacher.saveAll(teacher);
		return teacher;
	}

	@GetMapping("/getCourse")
	public List<Course> getCourse() {

		courseRepository.findAll();

		return courseRepository.findAll();
	}

	@GetMapping("/getDetails/{courseId}")
	public Course courseId(@PathVariable Integer courseId) {

		System.out.println("course id method called &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Optional<Course> r = courseRepository.findById(courseId);

		return r.get();
	}

	@GetMapping("/getTeacher/{teacherId}")
	public Teacher getTeacher(@PathVariable Integer teacherId) {

		System.out.println("course id method called &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Optional<Teacher> r = teacherRepoTeacher.findById(teacherId);

		return r.get();
	}

	@GetMapping("/createCourse")
	public Course createCourse() {

		Course course = new Course();

		course.setTitle("PythonJava");
		course.setCredit(100);
		CourseMaterial courseMaterial = new CourseMaterial();

		courseMaterial.setUrl("www.pythonjava.com");

		course.setCourseMaterial(courseMaterial);
		// onetoone
//		Hibernate: insert into course_material (url, course_material_id) values (?, ?)
//		Hibernate: insert into course (course_material_id, credit, title, course_id) values (?, ?, ?, ?)
		courseRepository.save(course);

		return course;
	}

	@GetMapping("/createTeacherByObject")
	public Teacher createTeacherBy() {

		// System.out.println("teacher method called" + teacher);
		Teacher teacher = new Teacher();

		teacher.setFirstName("Sunitha");
		teacher.setLastName("Jadoo");

		List<Course> courseList = new ArrayList<>();
		Course course1 = new Course();

		course1.setTitle("SpringJava");
		course1.setCredit(200);

		CourseMaterial courseMaterial1 = new CourseMaterial();

		courseMaterial1.setUrl("www.springjava.com");
		course1.setCourseMaterial(courseMaterial1);

		// second course

		Course course2 = new Course();

		course2.setTitle("MSJava");
		course2.setCredit(200);

		CourseMaterial courseMaterial2 = new CourseMaterial();

		courseMaterial2.setUrl("www.msjava.com");
		course2.setCourseMaterial(courseMaterial2);

		courseList.add(course1);
		courseList.add(course2);

		teacher.setCourse(courseList);

		teacherRepoTeacher.save(teacher);

		return teacher;
	}

	@GetMapping("/createSchool")
	public School createSchool() {

		School school = new School();
		school.setSchoolName("Bapuji");

		SchoolBoard board = new SchoolBoard();
		board.setSchoolBoardName("ssc");

		school.setBoard(board);

		Teacher teacher = new Teacher();

		List<Teacher> teacherList = new ArrayList<>();

		teacher.setFirstName("Yona");
		teacher.setLastName("Gadapaga");

		List<Course> courseList = new ArrayList<>();

		Course course1 = new Course();
		course1.setTitle("MBA");
		course1.setCredit(100);

		List<Department> departmentList = new ArrayList<>();

		Department department = new Department();

		department.setDepartmentName("Finance Department");
		// department.setTeacherList(teacherList);
		departmentList.add(department);

		CourseMaterial courseMaterial1 = new CourseMaterial();

		courseMaterial1.setUrl("www.MBA.com");
		course1.setCourseMaterial(courseMaterial1);
		// second course

		Course course2 = new Course();

		course2.setTitle("Finanace");
		course2.setCredit(300);

		CourseMaterial courseMaterial2 = new CourseMaterial();

		courseMaterial2.setUrl("www.finance.com");
		course2.setCourseMaterial(courseMaterial2);

		courseList.add(course1);
		courseList.add(course2);

		teacher.setCourse(courseList);
		teacherList.add(teacher);

		school.setTeacherList(teacherList);

		schoolRepository.save(school);
		return school;
	}

	@GetMapping("/createDepartment")
	public Department createDepartment() {

		List<Teacher> teacherList = new ArrayList<>();
		List<Course> courseList1 = new ArrayList<>();
		List<Course> courseList2 = new ArrayList<>();
		List<Department> departmentList = new ArrayList<>();
		
		
		Course course1 = new Course();
		course1.setTitle("MBA");
		course1.setCredit(100);
		
		Course course2 = new Course();
		course1.setTitle("Doctory");
		course1.setCredit(100);

		courseList1.add(course2);
		courseList1.add(course1);
		
		Teacher teacher1 = new Teacher();
		teacher1.setFirstName("Anand");
		teacher1.setLastName("Malikarjuna");
		
		
		teacher1.setCourse(courseList1);

		
		
		Teacher teacher2 = new Teacher();
		teacher2.setFirstName("Ramesh");
		teacher2.setLastName("suresh");
		
		
		
		Course course3 = new Course();
		course3.setTitle("finance");
		course3.setCredit(100);
		
		Course course4 = new Course();
		course4.setTitle("marketing");
		course4.setCredit(100);

		courseList2.add(course3);
		courseList2.add(course4);
		
		teacher2.setCourse(courseList2);
		
		courseList1.add(course1);
		courseList1.add(course1);
		
		teacher2.setCourse(courseList1);

		teacherList.add(teacher2);
		teacherList.add(teacher1);

		Department department = new Department();

		

		department.setDepartmentName("IT Deparment");

		department.setTeacherList(teacherList);
		
		departmentReporsitory.save(department);

		return department;
	}
	
	@GetMapping("/employee")
	public List<Employee> getTeacher() {

		List<Employee> empList = new ArrayList<Employee>();
		
		Employee emp1 = new Employee(1,"srihari",20000.00);
		Employee emp2 = new Employee(2,"amani",30000.00);
		Employee emp3 = new Employee(3,"ramesh",60000.00);
		Employee emp4 = new Employee(4,"suresh",50000.00);
		Employee emp5 = new Employee(5,"pritam",10000.00);
		Employee emp6 = new Employee(6,"kushi",40000.00);
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		empList.add(emp6);
		
		
		//empList.forEach(System.out::println);
		
		
		
		employeeRepository.saveAll(empList);
		
		List<Employee> getALlEmployeeList=employeeRepository.findAll();
		
		getALlEmployeeList.forEach(System.out::println);
		
		//Employee empStudendIdAndSalary = employeeRepository.findByEmpIdAndSalary(5, 15000D);
		
		//System.out.println("**********************8"+empStudendIdAndSalary.getEmpName()+"Salary "+empStudendIdAndSalary.getSalary());

		return empList;
	}
	
	
	// query example
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getALLEMployee(){
		
		return employeeRepository.getAllEmployee();
	}

}
