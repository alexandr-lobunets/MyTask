package com.lohika.apm.portal.services;

import com.lohika.apm.portal.model.Course;
import org.springframework.stereotype.Service;




@Service
public class CourseService extends LocalService {

    public void createCourse(String courseName){
        mongoOperations.save(new Course(courseName));
    }

}
