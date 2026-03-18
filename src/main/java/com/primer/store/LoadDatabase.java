package com.primer.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    public @Bean com.mongodb.client.MongoClient mongoClient() {
        return com.mongodb.client.MongoClients.create("mongodb://localhost:27017");
    }
}
