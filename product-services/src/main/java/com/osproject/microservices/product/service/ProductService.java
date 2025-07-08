package com.osproject.microservices.product.service;

import com.osproject.microservices.product.dto.ProductRequest;
import com.osproject.microservices.product.dto.ProductResponse;
import com.osproject.microservices.product.model.Product;
import com.osproject.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Create Product Successfully");
        return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());
    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice()))
                .toList();
    }

    @Transactional
    public void deleteAllProducts(){
        productRepository.deleteAll();
    }

    @Transactional
    public void deleteById(String id){
        productRepository.deleteById(id);
    }
}
