package com.example.dddstart.order.application;

import lombok.Getter;

@Getter
public class StartShippingRequest {

    private String orderNumber;
    private long version;

    public StartShippingRequest(String orderNumber, long version) {
        this.orderNumber = orderNumber;
        this.version = version;
    }
}
