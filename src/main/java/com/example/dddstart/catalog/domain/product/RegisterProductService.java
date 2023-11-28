package com.example.dddstart.catalog.domain.product;

import com.example.dddstart.catalog.domain.store.Store;
import com.example.dddstart.catalog.domain.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProductService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    public ProductId registerNewProduct(NewProductRequest req) {
        Store store = storeRepository.findById(req.getStoreId());
        checkNull(store);
        ProductId id = productRepository.nextId();
        Product product = store.createProduct(id, req.getCategoryId());
        productRepository.save(product);
        return id;
    }
}
