package com.lohika.apm.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class LocalService {

    @Autowired
    public MongoOperations mongoOperations;

    public Date convertStrToDate(String str){
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
