package com.bakuganApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.parser.Entity;

public interface AuctionRepository {
    Page<Auction> findByStateAndProduct_SeriesAndProduct_TypeOrderByProduct_Name(String state, String series, String type, Pageable pageable);
    Auction findByIdAndProduct_SeriesAndProduct_TypeOrderByProduct_Name(Long id, String series, String type);
    Auction save (Auction entity);
}
