package com.microService.ProductService.service;

import com.microService.ProductService.DTO.ProductRequest;
import com.microService.ProductService.DTO.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    void deleteProduct(Long id);

    ProductResponse getProduct(Long id);

    void reduceQuantity(long productId, long quantity);
}
