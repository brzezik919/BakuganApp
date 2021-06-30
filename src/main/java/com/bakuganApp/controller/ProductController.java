package com.bakuganApp.controller;

import com.bakuganApp.model.Product;
import com.bakuganApp.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/auction/{id}")
    Product getModel(@PathVariable Long id){
        return productService.getByAuction(id);
    }
}
