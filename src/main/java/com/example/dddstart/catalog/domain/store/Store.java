package com.example.dddstart.catalog.domain.store;

import com.example.dddstart.catalog.StoreBlockedException;
import com.example.dddstart.catalog.domain.category.CategoryId;
import com.example.dddstart.catalog.domain.product.Product;
import com.example.dddstart.catalog.domain.product.ProductId;

public class Store {
    private boolean blocked;

    public Product createProduct(ProductId newProductId, CategoryId categoryId) {
        if (isBlocked()) {
            throw new StoreBlockedException();
        }

        return new Product(newProductId, categoryId);
    }

    private boolean isBlocked() {
        return blocked;
    }
}
