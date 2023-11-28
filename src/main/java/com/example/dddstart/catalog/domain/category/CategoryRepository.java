package com.example.dddstart.catalog.domain.category;

public interface CategoryRepository {
    Category findById(CategoryId id);
}
