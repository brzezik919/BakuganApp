package com.bakuganApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository {
    Page<Product> findBySeriesAndTypeOrderByName(String series, String type, Pageable pageable);
    Product findByIdAndSeriesAndType(int id, String series, String type);
}
