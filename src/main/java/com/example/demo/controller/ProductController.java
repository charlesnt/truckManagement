package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;


  @GetMapping("/products")
  public List<Product> getAllProduct(){

    return productRepository.findAll();
  }


  @GetMapping("/products/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
    return ResponseEntity.ok(product);
  }

  @PostMapping("/product")
  public Product saveProduct(@RequestBody Product product){
    Product product1=productRepository.save(product);
    return product1;
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Product> UpdateProductById(@PathVariable Long id, @RequestBody Product productUpdated) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));

    product.setId(productUpdated.getId());
    product.setName(productUpdated.getName());
    product.setPrice(productUpdated.getPrice());
    product.setQuantity(productUpdated.getQuantity());
    Product productNew=productRepository.save(product);
    return ResponseEntity.ok(productNew);
  }

  // delete product rest api
  @DeleteMapping("/products/{id}")
  public String deleteProduct(@PathVariable("id") Long id) {
    productRepository.deleteById(id);
    return "product deleted";
  }



}

