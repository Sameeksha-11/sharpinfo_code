package com.restapi.example.demo.rest;

import com.restapi.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> Students;

    @PostConstruct
    public void loadData()
    {
        Students = new ArrayList<>();
        Students.add(new Student("John", "Doe"));
        Students.add(new Student("Mary", "Public"));
        Students.add(new Student("Ajay", "Rao"));
    }
    //define endpoint for students - return all student
    @GetMapping("/students")
    public List<Student>  getStudents(){
        return Students;
    }
    //define endpoint for students/{studentId} - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // Check student id against list size
        if(studentId >= Students.size() || studentId < 0)
            throw new StudentNotfoundException("Student id not found - " + studentId);
        return Students.get(studentId);
    }





}
