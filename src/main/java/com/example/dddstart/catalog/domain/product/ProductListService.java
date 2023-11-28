package com.example.dddstart.catalog.domain.product;

import com.example.dddstart.catalog.domain.category.Category;
import com.example.dddstart.catalog.domain.category.CategoryId;
import com.example.dddstart.catalog.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductListService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Page<Product> getProductInCategory(CategoryId categoryId, int page, int size) {
        Category category = categoryRepository.findById(categoryId);
        checkCategory(category);
        List<Product> products = productRepository.findByCategoryId(categoryId, page, size);
        int totalCount = productRepository.countsByCategoryId(category.getId());
        return new Page(page, size, totalCount, products);
    }
}
