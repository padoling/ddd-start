package com.example.dddstart.order.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Embeddable
public class ShippingInfo {
    @Embedded
    private Receiver receiver;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zipcode")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_address1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_address2"))
    })
    private Address address;

    @Column(name = "shipping_message")
    private String message;

    protected ShippingInfo() {
    }

    public ShippingInfo(Receiver receiver, Address address, String message) {
        this.receiver = receiver;
        this.address = address;
        this.message = message;
    }
}
