package com.lohika.apm.portal.repository;

import com.lohika.apm.portal.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
//    List<Student>  findByLastName(String lastName);
//    List<Student> findByFirstLastName(String lastName, String firstName);
//    List<Student> findByCourseName(String courseName);
    Student findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findAll();
//



}
