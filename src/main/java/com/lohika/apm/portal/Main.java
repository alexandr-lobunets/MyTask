package com.lohika.apm.portal;

import com.lohika.apm.portal.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;


public class Main {
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    public static void main(String[] args) {
//        SpringApplication.run(D.class, args);
        ApplicationContext ctx = new GenericXmlApplicationContext("Beans.xml");
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

        Student student = new Student("sssF", "sssL");
        mongoOperation.save(student);

        System.out.println("Created user is: " + student);

        student = new Student("sssF1", "sssL1");
        mongoOperation.save(student);
        System.out.println("Created user is: " + student);

//        mongoOperation.findAll()
    }
}
