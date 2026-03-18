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
    //methods "findByName" and "findByPrice" are added in ProductRepository
    @GetMapping("/productsName/{name}")
    Product oneName(@PathVariable String name) {
        return repository.findByName(name).orElseThrow(() ->  new RuntimeException("Product not found"));
    }

    //get by price
    @GetMapping("/pdocutsPrice/{price}")
    Product Price(@PathVariable double price)
    {
        return repository.findByPrice(price).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @PostMapping("/ProductsAdd")
    Product newProduct(@RequestBody Product newProduct)
    {
        return repository.save(newProduct);
    }

    @PutMapping("/productsEdit/{id}")
    Product replaceProcut(@RequestBody Product newProduct, @PathVariable Long id)
    {
        return repository.findById(id)
                .map(product -> {
                    product.setId(newProduct.getId());
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    return repository.save(product);
                }).orElseGet(() -> {
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
