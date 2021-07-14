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

    @GetMapping("/api/product/{series}/{type}/auction/{id}")
    ResponseEntity<Auction> getAuction(@PathVariable Long id, @PathVariable String series, @PathVariable String type){
        return ResponseEntity.ok(auctionService.getAuction(id, series, type));
    }

    @GetMapping("/api/product/{series}/{type}/auction")
    ResponseEntity<Page<Auction>> getListAuction(@PathVariable String series, @PathVariable String type, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        return ResponseEntity.ok(auctionService.getProductListByTypeAndSeries(type, series, page.orElse(0), size.orElse(20)));
    }

    @PutMapping("/api/auction/{id}/buy_it")
    ResponseEntity<?> auctionBuyIt(@PathVariable Long id, @RequestParam("id_buyer") int idBuyer){
        return auctionService.buyProductAuction(id, idBuyer) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/api/auction/create")
    ResponseEntity<?> createAuction(@RequestBody Auction auctionToSave){
        return auctionService.createAuction(auctionToSave) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
