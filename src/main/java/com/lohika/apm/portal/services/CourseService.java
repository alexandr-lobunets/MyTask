package com.lohika.apm.portal.services;

import com.lohika.apm.portal.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigInteger;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class CourseService extends LocalService {

    public void createCourse(String courseName){
        mongoOperations.save(new Course(courseName));
    }
}
