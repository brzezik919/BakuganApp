package com.bakuganApp.model;

import java.util.List;

public interface ProductRepository {
    Product findById(int id);
    Product save(Product product);
    List<Product> findByOwner_Id(int id);
}
