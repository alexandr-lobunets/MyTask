package com.lohika.apm.portal.tests;


import com.lohika.apm.portal.services.StudentService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.time.LocalDate;


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
@SpringBootTest
        (
        properties = {
        "spring.data.mongodb.uri=mongodb://localhost:27017/portal"}
        )
public class IntegrationTests {

    @Autowired
    private StudentService studentService;

    /**
     * High-cost test, must be refactored
     */
    @Test
    public void checkStudentCollectionLength() {
        System.out.printf("Length = " + studentService.findAll().size());
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

}
