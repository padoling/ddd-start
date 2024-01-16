package com.example.dddstart.order.application;

import com.example.dddstart.member.domain.MemberId;
import com.example.dddstart.order.domain.ShippingInfo;
import lombok.Getter;

@Getter
public class OrderRequest {
    private MemberId ordererId;
    private ShippingInfo shippingInfo;
}
