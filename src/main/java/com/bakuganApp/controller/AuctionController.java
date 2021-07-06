package com.bakuganApp.controller;

import com.bakuganApp.model.Auction;
import com.bakuganApp.service.AuctionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AuctionController {

    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/product/{series}/{type}/auction/{id}")
    ResponseEntity<Auction> getProduct(@PathVariable Long id, @PathVariable String series, @PathVariable String type){
        return ResponseEntity.ok(auctionService.getAuction(id, series, type));
    }

    @GetMapping("/product/{series}/{type}/auction")
    ResponseEntity<Page<Auction>> getListProduct(@PathVariable String series, @PathVariable String type, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        return ResponseEntity.ok(auctionService.getProductListByTypeAndSeries(type, series, page.orElse(0), size.orElse(20)));
    }
}
