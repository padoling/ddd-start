package com.example.dddstart.order.domain;

import com.example.dddstart.common.event.Event;
import lombok.Getter;

@Getter
public class OrderCanceledEvent extends Event {
    private String orderNumber;

    public OrderCanceledEvent(String orderNumber) {
        super();
        this.orderNumber = orderNumber;
    }
}
