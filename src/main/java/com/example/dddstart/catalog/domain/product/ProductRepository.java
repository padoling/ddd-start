package com.example.dddstart.catalog.domain.product;

import com.example.dddstart.catalog.domain.category.CategoryId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(ProductId productId);
    List<Product> findByCategoryId(CategoryId categoryId, int page, int size);
    int countsByCategoryId(CategoryId categoryId);

    // 식별자 생성 규칙을 구현 클래스에서 알맞게 구현한다.
    ProductId nextId();

    Product save(Product product);
}
