package com.studenttracker.cruddemo.Dao;

import com.studenttracker.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void updateFirstName(Student student);

    void deleteById(Integer id);

    int deleteAll();
}
