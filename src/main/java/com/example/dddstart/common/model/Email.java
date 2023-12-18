package com.example.dddstart.common.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Email {
    @Getter
    private String address;

    public Email(String address) {
        this.address = address;
    }
}
