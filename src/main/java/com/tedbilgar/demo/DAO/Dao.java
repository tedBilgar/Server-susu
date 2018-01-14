package com.tedbilgar.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class Dao {
    @Autowired
    private MongoTemplate mongoTemplate;


}
