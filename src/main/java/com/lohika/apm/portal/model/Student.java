package com.lohika.apm.portal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "students")
public class Student {


    @Id
    private BigInteger id;
    @Field("firstName")
    private String firstName;
    @Field("lastName")
    private String lastName;
    private String gender;
    private LocalDate birthDate;

    private List<Course> courses;

    public Student(){}

    public Student(String firstName, String lastName, LocalDate birthDate, List<Course> courses){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return String.format(
                "Student [id=%s, firstName='%s', lastName='%s', birthDate='%s', cources='%s']",
                id, firstName, lastName,
                birthDate, courses.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Method returns student's last name
     *
     * @return student's last name
     */
    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public BigInteger getId(){
        return id;
    }

    public String getGender(){
        return this.gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
