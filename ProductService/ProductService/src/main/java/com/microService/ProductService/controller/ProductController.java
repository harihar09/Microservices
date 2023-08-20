package com.microService.ProductService.controller;

import com.microService.ProductService.entiry.Product;
import com.microService.ProductService.DTO.ProductRequest;
import com.microService.ProductService.DTO.ProductResponse;
import com.microService.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    // need object of service layer
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    //get  product with id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        ProductResponse response = productService.getProduct(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    // remove product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("removed product ..", HttpStatus.OK);
    }
}
