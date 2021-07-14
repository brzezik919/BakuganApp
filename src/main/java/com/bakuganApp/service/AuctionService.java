package com.bakuganApp.service;

import com.bakuganApp.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final UserRepository userRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;

    public AuctionService(AuctionRepository auctionRepository, UserRepository userRepository, ProductService productService, ProductRepository productRepository) {
        this.auctionRepository = auctionRepository;
        this.userRepository = userRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    public Auction getAuction(Long id, String series, String type){
        return auctionRepository.findByIdAndProduct_SeriesAndProduct_TypeOrderByProduct_Name(id, series, type);
    }

    public boolean createAuction(Auction auctionToSave){
        try{
            Product productAuction = productRepository.findById(auctionToSave.getProduct().getId());
            auctionToSave.setState(AuctionState.ONGOING.toString());
            auctionToSave.setUserSeller(productAuction.getOwner());
            auctionToSave.setProduct(productAuction);
            auctionRepository.save(auctionToSave);
            return true;
        }
        catch (NullPointerException e){
            return false;
        }

    }

    public Auction getAuction(Long id){
        return auctionRepository.findById(id);
    }

    public Page<Auction> getProductListByTypeAndSeries(String type, String series, int currentPage, int pageSize){
        Pageable page = PageRequest.of(currentPage, pageSize);
        return auctionRepository.findByStateAndProduct_SeriesAndProduct_TypeOrderByProduct_Name(StateAuction.ONGOING.toString(),series, type, page);
    }

    public boolean buyProductAuction(Long id, int idBuyer){
        try{
            Auction auctionToSave = getAuction(id);
            User userBuyer = userRepository.findById(idBuyer);
            auctionToSave.setUserBuyer(userBuyer);
            auctionToSave.setState(AuctionState.PENDING.toString());
            productService.changeCurrencyUserProduct(auctionToSave.getProduct().getId(), userBuyer.getId());
            auctionRepository.save(auctionToSave);
            return true;
        }
        catch (NullPointerException e){
            return false;
        }

    }
}