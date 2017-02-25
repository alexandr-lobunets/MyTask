package com.lohika.apm.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;


@Component
public class MongoComponent {
    private final MongoDbFactory mongo;

    @Autowired
    public MongoComponent(MongoDbFactory mongo) {
        this.mongo = mongo;
    }
}
