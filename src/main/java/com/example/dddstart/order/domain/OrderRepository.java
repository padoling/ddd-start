package com.example.dddstart.order.domain;

import org.springframework.data.repository.Repository;

import java.util.Optional;

// 찾고 저장하는 단위 : 애그리거트 루트
public interface OrderRepository extends Repository<Order, OrderNo> {
    Optional<Order> findById(OrderNo id);
    void save(Order order);
    void delete(Order order);
}
