package com.lohika.apm.portal.controller;

import com.lohika.apm.portal.model.Student;
import com.lohika.apm.portal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WebServiceController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/webservice/students")
    public List<Student> students(){
        return studentService.findAll();
    }
}
