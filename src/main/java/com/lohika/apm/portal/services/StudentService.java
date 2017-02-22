package com.lohika.apm.portal.services;


import com.lohika.apm.portal.model.Course;
import com.lohika.apm.portal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Service
public class StudentService extends LocalService{


    @ModelAttribute("addStudent")
    public void createNewStudent(String firstName, String lastName, LocalDate date, List<Course> courses){
        Student student = new Student(firstName, lastName, date, courses);
        mongoOperations.save(student);
    }


    public void dropCollection(String collectionName){
        mongoOperations.dropCollection(collectionName);
    }

    @ModelAttribute("students")
    public List<Student> findAll(String collectionName){
        return mongoOperations.findAll(Student.class, collectionName);
    }


    public List<Student> findByLastFirstName(String lastName, String firstName){
        return this.mongoOperations.find(query(where("lastName").is(lastName).and("firstName").is(firstName)), Student.class);
    }

    public List<Student> findByLastFirstName(String lastName){
        return this.mongoOperations.find(query(where("lastName").is(lastName)), Student.class);
    }
}
