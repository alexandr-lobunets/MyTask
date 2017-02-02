package com.lohika.apm.portal.entity;

import org.springframework.data.annotation.Id;


public class Course {

    @Id
    private String courseId;
    private String title;

    public Course(){}

    public Course(String title){
        this.title = title;
    }
}
