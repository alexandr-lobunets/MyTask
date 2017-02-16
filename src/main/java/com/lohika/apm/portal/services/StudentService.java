package com.lohika.apm.portal.services;


import com.lohika.apm.portal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Service
public class StudentService extends LocalService{

    @Autowired CourseService courseService;

    public void createNewStudent(String firstName, String lastName, String date, String courseName){
        Student student = new Student(firstName, lastName, convertStrToDate(date),
                courseService.getCourseId(courseName));
        mongoOperations.save(student);
    }


    public void dropCollection(String collectionName){
        mongoOperations.dropCollection(collectionName);
    }

    public List<Student> findAll(String collectionName){
        return mongoOperations.findAll(Student.class, collectionName);
    }

    public List<Student> findByLastFirstName(String lastName, String firstName){
        return mongoOperations.find(query(where("lastName").is(lastName).and("firstName").is(firstName)), Student.class);
    }

    public List<Student> findByLastFirstName(String lastName){
        return mongoOperations.find(query(where("lastName").is(lastName)), Student.class);
    }

}
