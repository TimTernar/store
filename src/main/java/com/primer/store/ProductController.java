package com.primer.store;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    /*
    @GetMapping("/products")
    public List<String> getProducts() {
        return List.of("Kava", "Čaj", "Mleko");
    }
     */

    private final ProductRepository repository;

    ProductController(ProductRepository repository)
    {
        this.repository = repository;
    }


    @GetMapping("/productsFull")
    public List<Product> getProcutsFull(){
        return repository.findAll();
    }

    /*
    @GetMapping("/productsOne/{id}")
    public Product getProducts()
    {
        return prod
    };
     */
}
