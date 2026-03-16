package com.primer.store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    /*
    @GetMapping("/products")
    public List<String> getProducts() {
        return List.of("Kava", "Čaj", "Mleko");
    }
     */

    @GetMapping("/productsFull")
    public List<Product> getProcutsFull(){
        List<Product> products = List.of(
                new Product(1, "Lenovo legion I5", 1700),
                new Product(2, "Lenovo ThinkPad 5", 1200)
                );
        return products;
    }
}
