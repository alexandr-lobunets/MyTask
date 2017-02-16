package com.lohika.apm.portal.model;


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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


//    @Override
//    public String toString() {
//        return String.format(
//                "[courseId='%s', lastName='%s']",
//                id, courseId, lastName);
//    }


}
