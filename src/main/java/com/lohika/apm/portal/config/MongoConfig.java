//package com.lohika.apm.portal.config;
//
//
//import com.mongodb.MongoClientURI;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//
//
//@Configuration
//public class MongoConfig {
//
//
//    public @Bean
//    MongoDbFactory mongoDbFactory() throws Exception{
//        return new SimpleMongoDbFactory(new MongoClientURI("mongodb://localhost/portal"));
//    }
//
//    public @Bean(name={"mongoTemplate","mongoOperations"})
//    MongoTemplate mongoTemplate() throws Exception{
//        return new MongoTemplate(mongoDbFactory());
//    }
//
//
//}
