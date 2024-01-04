package com.example.dddstart.catalog.domain.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
public class ProductId implements Serializable {
    @Getter
    @Column(name = "product_id")
    private String id;

    protected ProductId() {
    }

    public ProductId(String id) {
        this.id = id;
    }
}
