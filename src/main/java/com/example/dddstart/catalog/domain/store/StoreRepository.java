package com.example.dddstart.catalog.domain.store;

public interface StoreRepository {
    Store findById(StoreId id);
}
