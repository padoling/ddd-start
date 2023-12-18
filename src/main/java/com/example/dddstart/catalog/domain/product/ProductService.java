package com.example.dddstart.catalog.domain.product;

import com.example.dddstart.catalog.domain.category.CategoryId;
import com.example.dddstart.catalog.domain.store.Store;
import com.example.dddstart.catalog.domain.store.StoreId;
import com.example.dddstart.catalog.domain.store.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    // TODO: 전달받는 인자들 Request DTO로 래핑 필요
    public ProductId registerNewProduct(StoreId storeId, CategoryId categoryId) {
        Store store = storeRepository.findById(storeId);
        checkNull(store);
        ProductId id = productRepository.nextId();
        Product product = store.createProduct(id, categoryId);
        productRepository.save(product);
        return id;
    }

    @Transactional
    public void removeOptions(ProductId id, int optIdxToBeDeleted) {
        // List<Option> 컬렉션을 지연로딩으로 설정했다면, Option은 로딩하지 않음
        Product product = productRepository.findById(id)
                .orElseThrow();
        // 트랜잭션 범위 내에선 지연 로딩으로 설정한 연관 로딩 가능
        product.removeOption(optIdxToBeDeleted);
    }

    private void checkNull(Store store) {
        // TODO
    }
}
