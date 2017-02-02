package com.lohika.apm.portal;

import com.lohika.apm.portal.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student>  findByLastName(String lastName);
    Student findByFirstLastName(String lastName, String firstName);

}
