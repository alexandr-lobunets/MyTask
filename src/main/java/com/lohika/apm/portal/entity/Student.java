package com.lohika.apm.portal.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @DateTimeFormat(iso = DateTimeFormat.ISO.NONE)
    private Date birthDate;
    private BigInteger classId;




    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }


    public Student(String firstName, String lastName, Date birthDate, BigInteger classId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.classId = classId;
    }


    @Override
    public String toString() {
        return String.format(
                "Student [id=%s, firstName='%s', lastName='%s', birthDate='%s', classId='%s']",
                id, firstName, lastName,
                new SimpleDateFormat("dd-MMM-yyyy").format(birthDate),
                classId
                );
    }



}
