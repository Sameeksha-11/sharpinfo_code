package com.studenttracker.cruddemo;

import com.studenttracker.cruddemo.Dao.StudentDAO;
import com.studenttracker.cruddemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudentDAO(studentDAO);

			createMultipleStudentDAO(studentDAO);

			// readStudent(studentDAO);

			//queryForAllStudents(studentDAO);

			//queryForLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteALLStudent(studentDAO);

		};
	}

	private void deleteALLStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int k = studentDAO.deleteAll();
		System.out.println("Number of students deleted: "+k);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.deleteById(studentId);
		System.out.println("Student deleted with id: "+studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		//find student by id
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		//Change first name
		System.out.println("Updating student");
		student.setFirstName("Scooby");

		//Update student
		studentDAO.updateFirstName(student);

		//Display student
		System.out.println("Student: "+student);

	}

	private void queryForLastName(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findByLastName("Doe");
		for(Student st: students)
			System.out.println(st);
	}

	private void queryForAllStudents(StudentDAO studentDAO) {

		//find all students
		System.out.println("Finding all students");
		List<Student> students = studentDAO.findAll();
		for(Student st: students)
			System.out.println(st);
		//display students
		// for(Student student: students){
		// 	System.out.println(student);
		//
	}

	private void createMultipleStudentDAO(StudentDAO studentDAO) {
		//create multiple student object
		System.out.println("Creating multiple student objects");
		Student temp1 = new Student("Sammy", "jimmy", "Jimmy@equi.com");
		Student temp2 = new Student("Botinca", "Boomer", "Boom@gmail.com");
		Student temp3 = new Student("Blake", "Ryan", "ryan@gmail.com");
		//save the student objects
		System.out.println("Saving multiple student objects");
		studentDAO.save(temp1);
		studentDAO.save(temp2);
		studentDAO.save(temp3);

		//display student id
	}

	private void createStudentDAO(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating student object");
		Student temp = new Student("Jane", "Doe", "jane@gmail.com");
		//save the student object
		System.out.println("Saving student object");
		studentDAO.save(temp);
		//display student id
		System.out.println("Student id: "+temp.getId());

	}

	private void readStudent(StudentDAO studentDAO) {
		//find student by id
		System.out.println("Finding student by id");
		Student student = studentDAO.findById(1);
		System.out.println("Student: "+student);
	}
}
