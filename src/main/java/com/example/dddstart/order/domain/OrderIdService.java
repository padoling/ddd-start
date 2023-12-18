package com.example.dddstart.order.domain;

// 식별자 생성 기능을 위한 도메인 서비스(예시)
public class OrderIdService {
    public OrderNo createId() {
        return OrderNo.of(timeStamp());
    }

    private String timeStamp() {
        return Long.toString(System.currentTimeMillis());
    }
}
