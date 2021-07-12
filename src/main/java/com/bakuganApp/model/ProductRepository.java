package com.bakuganApp.model;

public interface ProductRepository {
    Product findById(int id);
    Product save(Product product);
}
