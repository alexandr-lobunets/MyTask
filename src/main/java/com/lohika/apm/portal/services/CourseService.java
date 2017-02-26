package com.lohika.apm.portal.services;

import com.lohika.apm.portal.model.Course;
import org.springframework.stereotype.Service;


@Service
public class CourseService extends LocalService {
    private final String COURSES_COLLECTION = "courses";

    public void createCourse(String courseName){
        mongoOperations.save(new Course(courseName));
    }

    /**
     * Drop collection with name 'courses'
     */

    public void dropCollection(){
        mongoOperations.dropCollection(COURSES_COLLECTION);
    }
}
