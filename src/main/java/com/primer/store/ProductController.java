package com.primer.store;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    /*
    @GetMapping("/products")
    public List<String> getProducts() {
        return List.of("Kava", "Čaj", "Mleko");
    }
     */

    private List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Lenovo Legion I5", 1700),
            new Product(2, "Lenovo ThinkPad 5", 1200)
    ));


    @GetMapping("/productsFull")
    public List<Product> getProcutsFull(){
        return products;
    }

    /*
    @GetMapping("/productsOne/{id}")
    public Product getProducts()
    {
        return prod
    };
     */

    @PostMapping("/productsAdd")
    public Product add(@RequestBody Product product)
    {
        products.add(product);
        return product;
    };

    @DeleteMapping("/productDelete/{id}")
    public String delete(@PathVariable Integer id)
    {
        products.removeIf(p -> p.getId() == id);
        return "Deleted";
    }
}
