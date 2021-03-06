package com.lohika.apm.portal.controller;

import com.lohika.apm.portal.model.Student;
import com.lohika.apm.portal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@Controller
public class MainController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    String home() {
        return "index";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/studentmng")
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "studentmng";
    }

    @RequestMapping("/student/{id}")
    public String showStudentDetailsById(@PathVariable("id") BigInteger id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student";
    }

    @RequestMapping("/addstudent")
    public String addStudent(@ModelAttribute Student student) {
        return "addstudent";
    }

    @PostMapping(value = "/save")
    public String processForm(Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/" + student.getId() ;
    }

    @DeleteMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable("id") BigInteger id){
        studentService.deleteStudent(id);
        return "redirect:/studentmng";
    }
}
