package com.bakuganApp.controller;

import com.bakuganApp.model.Product;
import com.bakuganApp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getListProductsByUser(@RequestParam ("id_user") int id){
        return ResponseEntity.ok(productService.getListProduct(id));
    }

}
