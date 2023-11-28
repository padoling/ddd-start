package com.example.dddstart.catalog.domain.product;

import com.example.dddstart.catalog.domain.category.CategoryId;

import java.util.List;

public interface ProductRepository {
    List<Product> findByCategoryId(CategoryId categoryId, int page, int size);
    int countsByCategoryId(CategoryId categoryId);

    Product save(Product product);
}
