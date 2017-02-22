package com.lohika.apm.portal.tests;


import com.lohika.apm.portal.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeTests {

    @Autowired
    StudentService studentService;

    @Test
    public void checkStudentCollectionLength() {
        assertThat(studentService.findAll("students").size()).isBetween(2,3);
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
