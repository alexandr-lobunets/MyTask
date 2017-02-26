package com.lohika.apm.portal;

import com.lohika.apm.portal.services.CourseService;
import com.lohika.apm.portal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;


@Controller
public class MainController {

    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/")
//    @ResponseBody
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

//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//    }
}