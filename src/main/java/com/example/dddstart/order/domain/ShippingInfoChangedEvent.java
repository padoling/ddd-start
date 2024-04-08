package com.example.dddstart.order.domain;

import com.example.dddstart.common.event.Event;
import lombok.Getter;

// 배송지 변경 시 발생하는 이벤트
// 현재 기준으로 과거에 벌어진 일이므로 과거 시제 사용
@Getter
public class ShippingInfoChangedEvent extends Event {
    private final OrderNo number;
    private final ShippingInfo newShippingInfo;

    public ShippingInfoChangedEvent(OrderNo number, ShippingInfo newShippingInfo) {
        super();
        this.number = number;
        this.newShippingInfo = newShippingInfo;
    }
}
