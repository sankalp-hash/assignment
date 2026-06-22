package com.nagp.assignment.controller;

import com.nagp.assignment.entity.Product;
import com.nagp.assignment.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @GetMapping
  public List<Product> getAllProducts() {
    return service.getAllProducts();
  }

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable Long id) {
    return service.getProduct(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody Product product) {
    return service.createProduct(product);
  }

  @PutMapping("/{id}")
  public Product updateProduct(
      @PathVariable Long id,
      @RequestBody Product product) {

    return service.updateProduct(id, product);
  }

  @DeleteMapping("/{id}")
  public String deleteProduct(@PathVariable Long id) {
    return service.deleteProduct(id);
  }
}
