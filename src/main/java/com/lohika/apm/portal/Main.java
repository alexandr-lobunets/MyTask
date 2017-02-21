package com.lohika.apm.portal;

import com.lohika.apm.portal.config.SpringMongoConfig1;
import com.lohika.apm.portal.model.Student;
import com.lohika.apm.portal.services.CourseService;
import com.lohika.apm.portal.services.StudentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;




@SpringBootApplication
public class Main {

   private ApplicationContext applicationContext;

    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

   private final String STUDENTS_COLLECTION_NAME = "students";
    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public Main(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }



    @Bean
    public AnnotationConfigApplicationContext configApplicationContext(){
        return new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
    }

    @Bean
    public ApplicationRunner go()  {
        return args ->{
        System.out.println("Clean db");
            applicationContext =  new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
        studentService.dropCollection(STUDENTS_COLLECTION_NAME);
        System.out.println("+++++++++++++++++");
        studentService.dropCollection("courses");

        String dateInString = "07-Jun-2013";

        courseService.createCourse("mathematics");
        courseService.createCourse("biology");

        studentService.createNewStudent("Dmitriy", "Butakov", dateInString, "biology");
        studentService.createNewStudent("Dmitriy", "Goryachuk", dateInString, "mathematics");

        List<Student> students = studentService.findByLastFirstName("Butakov");
        System.out.println("Find: " + students.get(0));
        students =  studentService.findByLastFirstName("Butakov", "Dmitriy");
        System.out.println("Find: " + students.get(0));

        System.out.println("=========================");

        System.out.println(studentService.findAll(STUDENTS_COLLECTION_NAME).get(0));};

    }

//    @Deprecated
//    MongoOperations mongoOperations(){
//        return (MongoOperations) applicationContext.getBean("mongoTemplate");
//    }

}
