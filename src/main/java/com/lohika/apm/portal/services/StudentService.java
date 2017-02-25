package com.lohika.apm.portal.services;


import com.lohika.apm.portal.model.Course;
import com.lohika.apm.portal.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Service
public class StudentService extends LocalService{

    private final String STUDENTS_COLLECTION = "students";

    /**
     *  Create a new Student with defined parameters
     *
     * @param firstName student's first name
     * @param lastName  student's last name
     * @param birthDate student's first name
     * @param courses   list with student courses
     * @see             Student
     */

    @ModelAttribute("addStudent")
    public void createNewStudent(String firstName, String lastName,
                                 LocalDate birthDate, List<Course> courses){
        Student student = new Student(firstName, lastName, birthDate, courses);
        mongoOperations.save(student);
    }

    /**
     * Drop 'students' collection
     */

    public void dropCollection(){
        mongoOperations.dropCollection(STUDENTS_COLLECTION);
    }

    /**
     * Get all students
     * @return list with all students
     */

    @ModelAttribute("students")
    public List<Student> findAll(){
        return mongoOperations.findAll(Student.class, STUDENTS_COLLECTION);
    }

    /**
     * Return list of Students by request with last name and first name
     *
     * @param lastName   student's first name
     * @param firstName  student's last name
     * @return           list of students
     * @see              Student
     */

    public List<Student> findByLastFirstName(String lastName, String firstName){
        return this.mongoOperations.find(query(where("lastName").is(lastName).and("firstName").is(firstName)), Student.class);
    }

    public List<Student> findByLastName(String lastName){
        return this.mongoOperations.find(query(where("lastName").is(lastName)), Student.class);
    }

}
