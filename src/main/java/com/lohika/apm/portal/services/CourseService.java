package com.lohika.apm.portal.services;

import com.lohika.apm.portal.model.Course;
import com.lohika.apm.portal.model.Student;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class CourseService extends LocalService {


    BigInteger getCourseId(String name){
        return mongoOperations.findOne(query(where("title").is(name)), Course.class).getCourseId();
    }


    public void createCourse(String courseName){
        mongoOperations.save(new Course(courseName));
    }
}
