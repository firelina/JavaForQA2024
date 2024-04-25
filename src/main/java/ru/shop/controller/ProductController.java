package ru.shop.controller;


import org.springframework.web.bind.annotation.*;
import ru.shop.domain.Domain;
import ru.shop.domain.Product;
import ru.shop.domain.ProductType;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.sevices.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Domain> getAllProducts() {
        return productService.findAll();
    }
    @PostMapping public void save(@RequestBody Product product) {
        productService.save(product);
    }
    @GetMapping("/{id}") public Optional<Product> getById(@PathVariable UUID id) throws EntityNotFoundException {
        return productService.findById(id);
    }
    @GetMapping("/type/{productType}")
    public List<Product> getByProductType(@PathVariable ProductType productType) {
        return productService.findByProductType(productType);
    }
}