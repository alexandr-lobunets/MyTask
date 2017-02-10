package com.lohika.apm.portal;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;


//@Configuration
public class SpringMongoConfig1 {



    private final String MONGO_DB_HOST = "myd-vm20378.hpeswlab.net";
//    private final String MONGO_DB_HOST = "spring-demo-mongo";
    private final String MONGO_DB_NAME = "test";
    private final int MONGO_DB_PORT = 27017;



    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception{
//        return new SimpleMongoDbFactory(new MongoClient(), "test");
        return new SimpleMongoDbFactory(new MongoClient(MONGO_DB_HOST, MONGO_DB_PORT), MONGO_DB_NAME);
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongoDbFactory());
    }





}
