package com.osproject.microservices.product.controller;

import com.osproject.microservices.product.dto.ProductRequest;
import com.osproject.microservices.product.dto.ProductResponse;
import com.osproject.microservices.product.model.Product;
import com.osproject.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllProduct(){
        productService.deleteAllProducts();
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductById(@PathVariable String id){
        productService.deleteById(id);
    }
}
