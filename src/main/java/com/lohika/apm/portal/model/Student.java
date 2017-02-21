package com.lohika.apm.portal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document(collection = "students")
public class Student {


    @Id
    private BigInteger id;
    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.NONE)
    private LocalDate birthDate;
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public Student(String firstName, String lastName, LocalDate birthDate, List<Course> courses){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.courses = courses;
    }


    @Override
    public String toString() {
        return String.format(
//                "Student [id=%s, firstName='%s', lastName='%s', birthDate='%s', classId='%s']",
                "Student [id=%s, firstName='%s', lastName='%s', birthDate='%s', courseName='%s', courseGrade='%s']",
                id, firstName, lastName,
//                new SimpleDateFormat("dd-MMM-yyyy").format(birthDate)
                birthDate
                , courses.get(0).getCourseName()
                , courses.get(0).getCourseGrade()
                );
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public LocalDate getBirthDate(){
//        return new SimpleDateFormat("dd-MMM-yyyy").format(this.birthDate);
        return birthDate;
    }



}
