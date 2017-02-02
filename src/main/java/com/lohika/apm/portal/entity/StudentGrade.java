package com.lohika.apm.portal.entity;


import org.springframework.data.annotation.Id;

public class StudentGrade {

    @Id
    private String courseId;
    private String studentId;
    private int grade;

    public StudentGrade(String courseId, String studentId, int grade){
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
    }

}
