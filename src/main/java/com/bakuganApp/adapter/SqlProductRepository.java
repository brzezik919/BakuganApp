package com.bakuganApp.adapter;

import com.bakuganApp.model.Product;
import com.bakuganApp.model.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SqlProductRepository extends ProductRepository, JpaRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {
}
