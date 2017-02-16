package com.lohika.apm.portal.repository;

import com.lohika.apm.portal.model.Course;
import com.lohika.apm.portal.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CourseRepository extends MongoRepository<Course, String> {
}
