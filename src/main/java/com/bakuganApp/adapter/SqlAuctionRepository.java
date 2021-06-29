package com.bakuganApp.adapter;

import com.bakuganApp.model.Auction;
import com.bakuganApp.model.AuctionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SqlAuctionRepository extends AuctionRepository, JpaRepository <Auction, Integer> {
}
