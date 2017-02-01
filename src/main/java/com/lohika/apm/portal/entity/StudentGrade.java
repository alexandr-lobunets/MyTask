package com.lohika.apm.portal.entity;


public class StudentGrade {

    private int courseId;
    private int studentId;
    private int grade;

    public StudentGrade(int courseId, int studentId, int grade){
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
    }

}
