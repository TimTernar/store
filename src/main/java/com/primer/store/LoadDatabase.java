package com.primer.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    //old JPA data i left behind
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository)
    {
        return args -> {
            log.info("Nalaganje produkta 4" + repository.save(new Product(null, "HP 4500", 1700)));
            log.info("Nalaganje produkta 5" + repository.save(new Product(null, "Huawei Nekaj", 1200)));
            log.info("Nalaganje produkta 6" + repository.save(new Product(null, "Bad Laptop", 8000)));
        };
    }


    public @Bean com.mongodb.client.MongoClient mongoClient() {
        return com.mongodb.client.MongoClients.create("mongodb://localhost:27017");
    }
}
