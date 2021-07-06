package com.bakuganApp.service;

import com.bakuganApp.model.Auction;
import com.bakuganApp.model.AuctionRepository;
import com.bakuganApp.model.StateAuction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public Auction getAuction(Long id, String series, String type){
        return auctionRepository.findByIdAndProduct_SeriesAndProduct_TypeOrderByProduct_Name(id, series, type);
    }

    public Page<Auction> getProductListByTypeAndSeries(String type, String series, int currentPage, int pageSize){
        Pageable page = PageRequest.of(currentPage, pageSize);
        return auctionRepository.findByStateAndProduct_SeriesAndProduct_TypeOrderByProduct_Name(StateAuction.ONGOING.toString(),series, type, page);
    }
}
