package com.lohika.apm.portal.model;


public class Course {

    private String courseName;

    private int courseGrade;

    public Course(){}

    public Course(String courseName){
        this.courseName = courseName;
    }

    public Course(String courseName, int courseGrade){
        this.courseName = courseName;
        this.courseGrade = courseGrade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
    }



}
