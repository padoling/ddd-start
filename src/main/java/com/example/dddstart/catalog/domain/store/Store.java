package com.example.dddstart.catalog.domain.store;

import com.example.dddstart.catalog.StoreBlockedException;
import com.example.dddstart.catalog.domain.category.CategoryId;
import com.example.dddstart.catalog.domain.product.Product;
import com.example.dddstart.catalog.domain.product.ProductId;

public class Store {
    private boolean blocked;

    // Product를 생성하는 팩토리 역할을 함
    // Product를 생성할 수 있는 상태인지 확인하는 코드를 포함하고 있다
    // 애그리거트를 팩토리로 사용함으로써 도메인 응집도 높아짐
    public Product createProduct(ProductId newProductId, CategoryId categoryId) {
        if (isBlocked()) {
            throw new StoreBlockedException();
        }

        return new Product();
    }

    private boolean isBlocked() {
        return blocked;
    }
}
