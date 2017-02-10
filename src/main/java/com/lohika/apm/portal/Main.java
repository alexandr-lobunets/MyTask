package com.lohika.apm.portal;

import com.lohika.apm.portal.entity.Course;
import com.lohika.apm.portal.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
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
    public ApplicationContext getCtx() {
        return ctx;
    }

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }


    //    @Autowired
    public ApplicationContext ctx;



    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    public static void main(String[] args){
//        Main main1 = new Main();
//        main1.go();
        new Main().go();
    }

    private void go()  {
        ctx =  new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
        getMongoDbOperations().dropCollection("students");
        getMongoDbOperations().dropCollection("courses");

        String dateInString = "07-Jun-2013";
        Course course = new Course("mathematics");

        getMongoDbOperations().save(course);
        course = new Course("biology");
        Student student;
        student = new Student("sssF", "sssL", convertStrToDate(dateInString), getCourseId("mathematics"));
        getMongoDbOperations().save(student);

        System.out.println("Created user is: " + student);

        Student student1 = new Student("sssF1", "sssL1", convertStrToDate(dateInString), getCourseId("mathematics"));
        getMongoDbOperations().save(student1);
        System.out.println("Created user is: " + student);

        List<Student> students =  getMongoDbOperations().find(query(where("lastName").is("sssL")), Student.class);
        System.out.println("Find: " + students.get(0));
        students =  getMongoDbOperations().find(query(where("lastName").is("sssL").and("firstName").is("sssF")), Student.class);
        System.out.println("Find: " + students.get(0));
        students =  getMongoDbOperations().findAll(Student.class);
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


    BigInteger getCourseId(String name){
        return getMongoDbOperations().findOne(query(where("title").is(name)), Course.class).getCourseId();
    }

//    public @Bean
    MongoOperations getMongoDbOperations(){
        return (MongoOperations) ctx.getBean("mongoTemplate");
    }

}
