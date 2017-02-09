package com.lohika.apm.portal;

import com.lohika.apm.portal.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@SpringBootApplication

//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class Main {
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    public static void main(String[] args){
//        SpringApplication.run(Main.class, args);
//        ApplicationContext ctx = new GenericXmlApplicationContext("Beans.xml");
//        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");


        Main main1 = new Main();
        main1.go();

//        mongoOperation.findAll()
    }

    private void go()  {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        String dateInString = "07-Jun-2013";

//        ApplicationContext ctx = new GenericXmlApplicationContext("Beans.xml");
//        MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

        Student student;
        student = new Student("sssF", "sssL", convertStrToDate(dateInString));
        mongoOperation.save(student);

        System.out.println("Created user is: " + student);

        student = new Student("sssF1", "sssL1", convertStrToDate(dateInString));
        mongoOperation.save(student);
        System.out.println("Created user is: " + student);

        List<Student> students =  mongoOperation.find(query(where("lastName").is("sssL")), Student.class);
        System.out.println("Find: " + students.get(0));
        students =  mongoOperation.find(query(where("lastName").is("sssL").and("firstName").is("sssF")), Student.class);
        System.out.println("Find: " + students.get(0));
        students =  mongoOperation.findAll(Student.class);
        for(Student i: students) System.out.println(i);


//        List<Student> students =  mongoOperation.findAll(Student.class);
    }


    Date convertStrToDate(String str){
        Date date = null;
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");


        try {
            date = formatter.parse(str);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        return date;
    }
}
