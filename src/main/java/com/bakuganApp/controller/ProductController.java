package com.bakuganApp.controller;

import com.bakuganApp.model.Product;
import com.bakuganApp.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{series}/{type}/auction/{id}")
    Product getProduct(@PathVariable Long id, @PathVariable String series, @PathVariable String type){
        return productService.getByAuction(id, series, type);
    }

    @GetMapping("/product/{series}/{type}")
    ResponseEntity<Page<Product>> getListProduct(@PathVariable String series, @PathVariable String type, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        return ResponseEntity.ok(productService.getProductListByTypeAndSeries(type, series, page.orElse(0), size.orElse(20)));
    }

}
