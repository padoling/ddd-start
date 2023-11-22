package com.example.dddstart.order.domain;

// 찾고 저장하는 단위 : 애그리거트 루트
public interface OrderRepository {
    Order findByNumber(OrderNo number);
    void save(Order order);
    void delete(Order order);
}
