package com.lohika.apm.portal.config;


import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@Configuration
public class SpringMongoConfig1 {

    private final String MONGO_DB_HOST = "mongod";
    private final String MONGO_DB_NAME = "portal";
    private final int MONGO_DB_PORT = 27017;

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception{
//        return new SimpleMongoDbFactory(new MongoClient(), MONGO_DB_NAME);
        return new SimpleMongoDbFactory(new MongoClientURI("mongodb://localhost/portal"));
    }

    public @Bean(name={"mongoTemplate","mongoOperations"})
    MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongoDbFactory());
    }


}
