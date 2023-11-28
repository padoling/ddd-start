package com.example.dddstart.catalog.domain.product;

import com.example.dddstart.catalog.domain.category.CategoryId;

public class Product {
    private ProductId productId;
    private CategoryId categoryId;

    public Product(ProductId productId, CategoryId categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }
}
