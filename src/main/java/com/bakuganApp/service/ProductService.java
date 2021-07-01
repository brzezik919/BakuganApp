package com.bakuganApp.service;

import com.bakuganApp.model.AuctionRepository;
import com.bakuganApp.model.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final AuctionRepository auctionRepository;

    public ProductService(ProductRepository productRepository, AuctionRepository auctionRepository) {
        this.productRepository = productRepository;
        this.auctionRepository = auctionRepository;
    }
}
