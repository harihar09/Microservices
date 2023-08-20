package com.microService.ProductService.service;

import com.microService.ProductService.Exception.ProductNotFound;
import com.microService.ProductService.entity.Product;
import com.microService.ProductService.DTO.ProductRequest;
import com.microService.ProductService.DTO.ProductResponse;
import com.microService.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2   // we can directly use the log. methods
public class
ProductServiceImpl implements ProductService {

    //need object of repository layer
    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("adding product to db..");
        // convert model to entity and save it in db and return product Id
        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("deleting product from db");
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        log.info("fetching product with id {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("product not found", "PRODUCT_NOT_FOUND"));
        // prepare the model (DTO) object from entity using BeanUtil copyProperties method
        ProductResponse response = new ProductResponse();
        copyProperties(product, response);
        return response;
    }
}
