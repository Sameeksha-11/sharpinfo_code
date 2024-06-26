package com.studenttracker.cruddemo.Dao;


import com.studenttracker.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Specialized annotation for repository,
// Supports component scanning,
// Transulates JDBC expection - checked to unchecked
@Repository
public class StudentDAOImpt implements  StudentDAO{
    //define  field for entity manager
    private EntityManager entityManager;

    //Inject entity manger
    @Autowired
    public StudentDAOImpt(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // Implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by firstName desc", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //Finading by lastName using JPQL Named Parameter(=:)
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName =: theData", Student.class);
        query.setParameter("theData", lastName);
        return query.getResultList();

    }

    @Override
    @Transactional
    public void updateFirstName(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student student = entityManager.find(Student.class, id);;
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return rowsDeleted;
    }


}
