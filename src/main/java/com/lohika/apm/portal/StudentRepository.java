package com.lohika.apm.portal;

import com.lohika.apm.portal.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;


public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student>  findByLastName(String lastName);
    List<Student> findByFirstLastName(String lastName, String firstName);
    List<Student> findByCourseName(String courseName);


}
