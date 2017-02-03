package com.lohika.apm.portal;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;


@Component
public class SpringMongoConfig1 {

    private final MongoDbFactory mongo;

    @Autowired
    public SpringMongoConfig1(MongoDbFactory mongo) {
        this.mongo = mongo;
    }
        //  ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        //  MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

}
