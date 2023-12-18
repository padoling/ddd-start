package com.example.dddstart.catalog.domain.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Option {
    @Column(name = "option_name")
    private String value;
    @Column(name = "option_title")
    private String title;

    protected Option() {
    }

    public Option(String value, String title) {
        this.value = value;
        this.title = title;
    }
}
