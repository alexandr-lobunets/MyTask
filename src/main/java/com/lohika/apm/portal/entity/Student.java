package com.lohika.apm.portal.entity;

import org.springframework.data.annotation.Id;

public class Student {

    @Id
    private int id;
    private String firstName;
    private String lastName;

    public Student(){}

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Student [id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
    
}
