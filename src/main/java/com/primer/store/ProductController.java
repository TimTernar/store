package com.primer.store;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    //najdi posebej
    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    @PostMapping
    public Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable String id) {
        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable String id)
    {
        repository.deleteById(id);
    }
}