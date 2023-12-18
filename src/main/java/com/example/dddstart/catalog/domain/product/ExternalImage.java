package com.example.dddstart.catalog.domain.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EI")
public class ExternalImage extends Image {
    protected ExternalImage() {
    }

    public ExternalImage(String path) {
        super(path);
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public boolean hasThumbnail() {
        return false;
    }

    @Override
    public String getThumbnailUrl() {
        return null;
    }
}
