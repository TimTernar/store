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

    private final ProductRepository repository;

    ProductController(ProductRepository repository)
    {
        this.repository = repository;
    }

    //od kad me ne ljubiš više
    //u meni liju kiše
    //i kad je sunčan dan
    //all
    @GetMapping("/productsFull")
    public List<Product> getProcutsFull(){
        return repository.findAll();
    }


    //get one by id
    @GetMapping("/productsOne/{id}")
    Product One(@PathVariable Long id)
    {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    };

    //get by name
    @GetMapping("/productsName/{name}")
    Product oneName(@PathVariable String name) {
        return repository.findByName(name).orElseThrow(() ->  new RuntimeException("Product not found"));
    }
}
