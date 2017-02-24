package com.lohika.apm.portal.tests;


import com.lohika.apm.portal.model.Course;
import com.lohika.apm.portal.services.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeTests {

    @Autowired
    StudentService studentService;

    private static String STUDENTS_COLLECTION_NAME = "students";

    @Before
    public void cleanDb(){
        studentService.dropCollection(STUDENTS_COLLECTION_NAME);
        studentService.dropCollection("courses");
        LocalDate localDate = LocalDate.now().minusYears(5).minusMonths(2);

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("mathematics", 4));
        courses.add(new Course("literature", 5));
        studentService.createNewStudent("Dmitriy", "Butakov", localDate, courses);
        courses.add(new Course("physics", 2));
        studentService.createNewStudent("Dmitriy", "Goryachuk", localDate, courses);
    }

    @Test
    public void checkStudentCollectionLength() {
        Assert.assertNotNull(studentService.findAll(STUDENTS_COLLECTION_NAME));
    }

    @Test
    public void checkUserCreation(){
        String firstName = "fName";
        String lastName = "lName";
        LocalDate birthDate = LocalDate.now();
        studentService.createNewStudent(firstName, lastName, birthDate, null);
        assertThat(studentService.findByLastFirstName(lastName, firstName).get(0).getBirthDate()).isEqualTo(birthDate);
    }
}
