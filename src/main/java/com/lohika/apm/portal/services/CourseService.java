package com.lohika.apm.portal.services;

import com.lohika.apm.portal.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigInteger;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class CourseService extends LocalService {


    BigInteger getCourseId(String name){
        return mongoOperations.findOne(query(where("title").is(name)), Course.class).getCourseId();
    }

    String getCourseName(BigInteger id){
        return mongoOperations.findOne(query(where("id").is(id)), Course.class).getTitle();
    }


    public void createCourse(String courseName){
        mongoOperations.save(new Course(courseName));
    }
}
