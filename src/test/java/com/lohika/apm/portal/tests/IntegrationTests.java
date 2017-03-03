package com.lohika.apm.portal.tests;


import com.lohika.apm.portal.model.Course;
import com.lohika.apm.portal.services.CourseService;
import com.lohika.apm.portal.services.StudentService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Integration tests for Test Task
 *
 * @author  Alexandr Lobunets
 * @version 1.0
 * @since   2017-02-26
 */

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        "spring.data.mongodb.uri=mongodb://localhost:27017/portal"
})
public class IntegrationTests {

    @Autowired
    private StudentService studentService;


    /*
    should be refactored
     */
    @Before
    public void setUp(){
        cleanDb();
        studentService.dropCollection();
//        courseService.dropCollection();
        LocalDate localDate = LocalDate.now().minusYears(5).minusMonths(2);
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("mathematics", 4));
        courses.add(new Course("literature", 5));
        studentService.createNewStudent("Dmitriy", "Butakov", localDate, courses);
        courses.add(new Course("physics", 2));
        studentService.createNewStudent("Dmitriy", "Goryachuk", localDate, courses);
    }

    @After
    public void tearDown(){
       cleanDb();
    }


    /**
     * High-cost test, must be refactored
     */
    @Test
    public void checkStudentCollectionLength() {
        assertNotNull(studentService.findAll());
    }

    @Test
    public void checkUserCreation(){
        String firstName = "first_name";
        String lastName = "last_name";
        LocalDate birthDate = LocalDate.now();
        studentService.createNewStudent(firstName, lastName, birthDate, null);
        assertThat(studentService.findByLastFirstName(lastName, firstName).getBirthDate()).isEqualTo(birthDate);
    }

    @Test
    public void checkUserDeletion(){
        String firstName = "Dmitriy";
        String lastName = "Butakov";
        BigInteger studentId = studentService.findByLastFirstName(lastName, firstName).getId();
        studentService.deleteStudent(studentId);
        assertNull(studentService.getStudentById(studentId));
    }


    private void cleanDb(){
        studentService.dropCollection();
    }
}
