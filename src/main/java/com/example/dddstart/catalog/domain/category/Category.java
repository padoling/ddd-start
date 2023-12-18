package com.example.dddstart.catalog.domain.category;

import jakarta.persistence.EmbeddedId;
import lombok.Getter;

@Getter
public class Category {
    @EmbeddedId
    private CategoryId id;
}
