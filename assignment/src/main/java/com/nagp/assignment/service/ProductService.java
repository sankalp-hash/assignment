package com.nagp.assignment.service;

import com.nagp.assignment.entity.Product;
import com.nagp.assignment.exception.ResourceNotFoundException;
import com.nagp.assignment.repository.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private final ProductRespository repository;

  public ProductService(ProductRespository repository) {
    this.repository = repository;
  }

  public List<Product> getAllProducts() {
    return repository.findAll();
  }

  public Product getProduct(Long id) {
    return repository.findById(id)
        .orElseThrow(() ->
            new ResourceNotFoundException(
                "Product not found: " + id));
  }

  public Product createProduct(Product product) {
    return repository.save(product);
  }

  public Product updateProduct(Long id, Product updatedProduct) {

    Product existing = getProduct(id);

    existing.setName(updatedProduct.getName());
    existing.setCategory(updatedProduct.getCategory());
    existing.setPrice(updatedProduct.getPrice());
    existing.setQuantity(updatedProduct.getQuantity());
    existing.setDescription(updatedProduct.getDescription());

    return repository.save(existing);
  }

  public String deleteProduct(Long id) {
    Product product = getProduct(id);
    repository.delete(product);
    return "Product deleted successfully";
  }
}
