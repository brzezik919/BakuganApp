package com.bakuganApp.service;

import com.bakuganApp.model.Auction;
import com.bakuganApp.model.AuctionRepository;
import com.bakuganApp.model.Product;
import com.bakuganApp.model.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final AuctionRepository auctionRepository;

    public ProductService(ProductRepository productRepository, AuctionRepository auctionRepository) {
        this.productRepository = productRepository;
        this.auctionRepository = auctionRepository;
    }

    public Product getByAuction(Long id, String series, String type){
        Auction auction = auctionRepository.findById(id);
        return productRepository.findByIdAndSeriesAndType(auction.getProduct().getId(), series, type);
    }

    public Page<Product> getProductListByTypeAndSeries(String type, String series, int currentPage, int pageSize){
        Pageable page = PageRequest.of(currentPage, pageSize);
        return productRepository.findBySeriesAndTypeOrderByName(series, type, page);
    }
}
