package com.example.dddstart.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

// JPA에서 식별자 타입은 Serializable을 구현해야 한다.
@Embeddable
public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String number;

    public static OrderNo of(String number) {
        return new OrderNo(number);
    }

    protected OrderNo() {
    }

    public OrderNo(String number) {
        this.number = number;
    }

    public boolean is2ndGeneration() {
        return number.startsWith("2");
    }

    // JPA는 내부적으로 엔티티를 비교할 목적으로 equals()와 hashCode() 값을 사용한다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderNo orderNo = (OrderNo) o;
        return Objects.equals(number, orderNo.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
