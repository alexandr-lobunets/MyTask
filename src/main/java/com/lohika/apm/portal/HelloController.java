package com.lohika.apm.portal;

import com.lohika.apm.portal.model.Student;
import com.lohika.apm.portal.services.CourseService;
import com.lohika.apm.portal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
//@ResponseBody
public class HelloController {

    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "index";
    }

    @RequestMapping("/greeting")
    @ResponseBody
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "templates/greeting";
    }

    @RequestMapping("/studentmng")
    public String showAllStudents(Model model) {
//        List<Student> ff = studentService.findAll("students");
//        System.out.println("Size = " + ff.size());
        model.addAttribute("students", studentService.findAll("students"));
        model.addAttribute(courseService);
        return "studentmng";
    }
}
