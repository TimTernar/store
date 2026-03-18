package com.primer.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository)
    {
        return args -> {
            log.info("Nalaganje produkta 1" + repository.save(new Product(1, "Lenovo Legion I5", 1700)));
            log.info("Nalaganje produkta 2" + repository.save(new Product(2, "Lenovo ThinkPad 5", 1200)));
            log.info("Nalaganje produkta 3" + repository.save(new Product(3, "Bad Laptop", 800)));
        };
    }
}
