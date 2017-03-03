package com.lohika.apm.portal.model;

public  class Course {


    private String name;
    private int grade;

    public Course(){}

    public Course(final String name){
        this.name = name;
    }

    public Course(final String name, final int grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(final int courseGrade) {
        this.grade = courseGrade;
    }

    @Override
    public String toString() {
        return String.format(
                "Course [name=%s, courseGrade='%s']",
                name, grade);
    }

}
